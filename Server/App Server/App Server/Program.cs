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
using System.Net.Http;

namespace Program
{
    class Program
    {
        static void Main(string[] args)
        {
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
                    StreamReader sr = new StreamReader(stream, Encoding.UTF8);
                    StreamWriter sw = new StreamWriter(stream, Encoding.UTF8);
                    string GetMessage = string.Empty;
                   
                    while ((length = stream.Read(bytes, 0, bytes.Length)) != 0)
                    {
                        data = Encoding.Default.GetString(bytes, 0, length);
                        Console.WriteLine(String.Format("클라이언트가 보내온 내용 : {0}", data));

                        byte[] msg = Encoding.Default.GetBytes(data);
                        stream.Write(msg, 0, msg.Length);

                        Console.WriteLine(String.Format("서버가 클라이언트로부터 받은 내용 : {0}", data));

                        //in = Socket.getInputStream();

                        MySqlConnection connection = new MySqlConnection("Server=127.0.0.1; Port=3306; Database=mydb; Uid=root; Pwd=nhj960509!!");
                        connection.Open();
                        
                        if (data.StartsWith("INSERT"))
                        {
                            string InsertQuery = "INSERT INTO testserver(id, sex, name) VALUES (@id, @sex, @name)";
                            string str1 = data.Substring(7, 8);
                            string str2 = data.Substring(16, 5);
                            string str3 = data.Substring(22);
                            try//예외 처리
                            {
                                MySqlCommand command = new MySqlCommand(InsertQuery, connection);
                                command.Parameters.AddWithValue("@id", str1);
                                command.Parameters.AddWithValue("@sex", str2);
                                command.Parameters.AddWithValue("@name", str3);
                                
                                if (command.ExecuteNonQuery() == 1)
                                {
                                    Console.WriteLine("DataBase로 Data 삽입 성공!!");
                                }
                                else
                                {
                                    Console.WriteLine("DataBase에 Data 삽입 실패...");
                                }
                            }
                            catch (Exception ex)
                            {
                                Console.WriteLine("DataBase와 연결 실패");
                                Console.WriteLine(ex.ToString());
                            }
                        }
                        else if (data.StartsWith("SELECT"))
                        {
                            string SelectQuery = "SELECT * FROM testserver";
                            
                            MySqlCommand command = new MySqlCommand(SelectQuery, connection);
                          
                            MySqlDataReader table = command.ExecuteReader();

                            while (table.Read())
                            {
                                //GetMessage = sr.ReadLine();
                                Console.WriteLine("{0} {1} {2} \r\n", table["id"], table["sex"], table["name"]);
                                //sw.Flush();
                            }
                            //stream.Write(msg, 0, msg.Length);
                            //GetMessage = sr.ReadLine();
                            sw.WriteLine("{0} {1} {2} \r\n", table["id"], table["sex"], table["name"]);
                            //sw.Flush();
                            table.Close();
                        }
                        else if (data.StartsWith("DELETE"))
                        {
                            string DeleteQuery = "DELETE FROM testserver WHERE id = @id";
                            MySqlCommand command = new MySqlCommand(DeleteQuery, connection);
                            string str1 = data.Substring(7, 8);
                            command.Parameters.AddWithValue("@id", str1);
                            MySqlDataReader table = command.ExecuteReader();
                            
                        }
                       else if (data.StartsWith("UPDATE"))
                        {
                            string UpdateQuery = "UPDATE testserver SET id = @id";
                            MySqlCommand command = new MySqlCommand(UpdateQuery, connection);
                            string str1 = data.Substring(7, 8);
                            command.Parameters.AddWithValue("@id", str1);
                            MySqlDataReader table = command.ExecuteReader();
                        }
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