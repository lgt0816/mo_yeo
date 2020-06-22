using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace Client_Code
{
    class ClientComm
    {
        static void Main(string[] args)
        {
            if (args.Length < 3)
            {
                Console.WriteLine("사용법 : ClientCode <Binding IP> <Server IP> <전송할 내용>", Process.GetCurrentProcess().ProcessName);
                return;
            }

            string bindIp = args[0];
            int ANY_PORT = 0;

            string serverIp = args[1];
            const int serverPort = 25000;
            string message = args[2];
            TcpClient client = null;

            try
            {
                IPEndPoint clientAddress = new IPEndPoint(IPAddress.Parse(bindIp), ANY_PORT);
                IPEndPoint serverAddress = new IPEndPoint(IPAddress.Parse(serverIp), serverPort);

                Console.WriteLine("클라이언트 IP 주소 : {0}, 서버 IP 주소: {1}", clientAddress.ToString(), serverAddress.ToString());

                client = new TcpClient(clientAddress);
                client.Connect(serverAddress);

                byte[] data = System.Text.Encoding.Default.GetBytes((string)message);

                NetworkStream stream = client.GetStream();
                stream.Write(data, 0, data.Length);

                Console.WriteLine("송신 내용 : {0}", message);

                data = new byte[256];

                string responseData = "";
                int bytes = stream.Read(data, 0, data.Length);
                responseData = Encoding.Default.GetString(data, 0, bytes);
                Console.WriteLine("수신 내용 : {0}", responseData);
            }
            catch (SocketException e)
            {
                Console.WriteLine(e);
            }
        }
    }
}
