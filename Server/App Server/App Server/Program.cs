using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Collections;
using System.Threading;
using MySql.Data.MySqlClient;

namespace Program
{
    class Program
    {
        static void Main(string[] args)
        {
            using (MySqlConnection connection = new MySqlConnection("Server=127.0.0.1; Port=3306; Database=mydb; Uid=root; Pwd=nhj960509!!")) // 127.0.0.1 ,3306, mydb, nhj960509!!
            {
                string insertQuery = "INSERT INTO testserver(id,sex,name) VALUES(20171102,'woman','jisoon')"; //INSERT INTO testserver(id,sex,name) VALUES(20171100,'man','jisoo') 
                try//예외 처리
                {
                    connection.Open();
                    MySqlCommand command = new MySqlCommand(insertQuery, connection);
                    
                    if (command.ExecuteNonQuery() == 1)
                    {
                        Console.WriteLine("DataBase로 Data 전달 성공!!");
                    }
                    else
                    {
                        Console.WriteLine("DataBase에 Data 전달 실패...");
                    }

                }
                catch (Exception ex)
                {
                    Console.WriteLine("실패");
                    Console.WriteLine(ex.ToString());
                }

            }

            if (args.Length < 1)
            {
                Console.WriteLine("사용법 : {0} <BindIP>", Process.GetCurrentProcess().ProcessName);
                return;
            }

            string bindIp = args[0];
            const int bindPort = 25000;
            TcpListener server = null;
            try
            {
                IPEndPoint localAddress = new IPEndPoint(IPAddress.Parse(bindIp), bindPort);

                server = new TcpListener(IPAddress.Any, 25000); // IP주소를 아무나 들어올 수 있게 허용하고, 포트번호를 25000으로 제한
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
