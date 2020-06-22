using System;
using System.Linq;
using System.Text;
using System.Net;
using System.Net.Sockets;

namespace App_Server
{
    class CommManager
    {
        //접근제한자 자료형 변수명 { get; set; }
        //a = mServerIP
        //mServerIP = 182.130.13.12
        private string mServerIP { get; set; } // 속성 : 클래스 변수
        private int mPort { get; set; }
        
        //prop + tab키 두번

        // 생성자
        public CommManager(string serverIP, int port)
        {
            mServerIP = serverIP;
            mPort = port;
        }

        public void serverOpenAndListening()
        {
            TcpListener server = null;

            try
            {
                IPEndPoint localAddress = new IPEndPoint(IPAddress.Parse(mServerIP), mPort);

                server = new TcpListener(IPAddress.Any, mPort); // IP주소를 아무나 들어올 수 있게 허용하고, 포트번호를 25000으로 제한
                server.Start();
                Console.WriteLine("클라이언트 접속 대기중...");

                while (true)
                {
                    TcpClient client = server.AcceptTcpClient();
                    Console.Write("클라이언트 접속", ((IPEndPoint)client.Client.RemoteEndPoint).ToString());

                    NetworkStream stream = client.GetStream();

                    int length;
                    string data = null;
                    byte[] bytes = new byte[256];



                    while ((length = stream.Read(bytes, 0, bytes.Length)) != 0)
                    {
                        data = Encoding.Default.GetString(bytes, 0, length);
                        Console.WriteLine(String.Format("수신 내용 : {0}", data));

                        byte[] msg = Encoding.Default.GetBytes(data);

                        stream.Write(msg, 0, msg.Length);
                        Console.WriteLine(String.Format("송신 내용 : {0}", data));

                        //string[] getdata = data.Split(new string[] { "ㅩ" }, StringSplitOptions.None);

                        //DBManager 메소드 호출
                        DBManager dbManager = new DBManager(data, stream);
                        dbManager.AppAndDBComm();
                    }

                    stream.Close();
                    client.Close();
                }
            }
            catch (SocketException e)
            {
                Console.WriteLine(e);
            }
            finally
            {
                server.Stop();
            }
            Console.WriteLine("서버 통신 종료");
        }
        
    }
}
