using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace App_Server
{
    class DBManager
    {
        private string mData { get; set; } // 속성 : 클래스 변수
        private NetworkStream mStream { get; set; }

        //prop + tab키 두번

        // 생성자
        public DBManager(string data, NetworkStream stream)
        {
            mData = data;
            mStream = stream;
        }

        public void AppAndDBComm() {
            bool state = false;
            string[] strs1 = null;
            string[] getdata = mData.Split(new string[] { "ㅩ" }, StringSplitOptions.None);

            MySqlConnection connection = new MySqlConnection("Server=220.126.140.61; Port=3306; Database=moyeo_db; Uid=moyeo; Pwd=moyeo");
            connection.Open();

            if (mData.StartsWith("INSERT01")) // 회원가입(student_tb)
            {
                string InsertQuery = "INSERT INTO student_tb(STUDENT_ID, STUDENT_PW, STUDENT_SCHOOLTYPE, STUDENT_MAJOR, STUDENT_NAME, STUDENT_PHONENUM, STUDENT_EMAIL, STUDENT_SEX, STUDENT_GRADE, STUDENT_SCHOOLSTATE, STUDENT_TOTALWARNINGCOUNT) VALUES (@idI01, @pwI01, @typeI01, @majorI01, @nameI01, @phoneI01, @emailI01, @sexI01, @gradeI01, @statusI01, 0)";

                try
                {
                    MySqlCommand command = new MySqlCommand(InsertQuery, connection);
                    char comma = 'ㅩ';
                    string[] str = mData.Split(comma);
                    for (int i = 1; i < str.Length; i++)
                    {
                        Console.WriteLine(str[i]);
                        if (str[i] == str[1])
                        {
                            command.Parameters.AddWithValue("@idI01", str[1]);
                        }
                        else if (str[i] == str[2])
                        {
                            command.Parameters.AddWithValue("@pwI01", str[2]);
                        }
                        else if (str[i] == str[3])
                        {
                            command.Parameters.AddWithValue("@nameI01", str[3]);
                        }
                        else if (str[i] == str[4])
                        {
                            command.Parameters.AddWithValue("@sexI01", str[4]);
                        }
                        else if (str[i] == str[5])
                        {
                            command.Parameters.AddWithValue("@phoneI01", str[5]);
                        }
                        else if (str[i] == str[6])
                        {
                            command.Parameters.AddWithValue("@emailI01", str[6]);
                        }
                        else if (str[i] == str[7])
                        {
                            command.Parameters.AddWithValue("@typeI01", str[7]);
                        }
                        else if (str[i] == str[8])
                        {
                            command.Parameters.AddWithValue("@majorI01", str[8]);
                        }
                        else if (str[i] == str[9])
                        {
                            command.Parameters.AddWithValue("@gradeI01", str[9]);
                        }
                        else if (str[i] == str[10])
                        {
                            command.Parameters.AddWithValue("@statusI01", str[10]);
                        }
                        else if (str[i] == str[11])
                        {
                            command.Parameters.AddWithValue("@countI01", str[11]);
                        }
                    }

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


            if (mData.StartsWith("INSERT02")) // activity_tb
            {
                string InsertQuery = "INSERT INTO activity_tb(ACT_TITLE, ACT_STITLE, ACT_CONT,ACT_RULE,ACT_DATE,STUDENT_ID,ACT_TYPENAME) VALUES (@titleI02, @subtitleI02, @contentsI02, @ruleI02, @dateI02, @studentI02, @typeI02)";

                try
                {
                    MySqlCommand command = new MySqlCommand(InsertQuery, connection);
                    char comma = 'ㅩ';
                    string[] str = mData.Split(comma);
                    for (int i = 1; i < str.Length; i++)
                    {
                        Console.WriteLine(str[i]);
                        if (str[i] == str[1])
                        {
                            command.Parameters.AddWithValue("@titleI02", str[1]);
                        }
                        else if (str[i] == str[2])
                        {
                            command.Parameters.AddWithValue("@subtitleI02", str[2]);
                        }
                        else if (str[i] == str[3])
                        {
                            command.Parameters.AddWithValue("@contentsI02", str[3]);
                        }
                        else if (str[i] == str[4])
                        {
                            command.Parameters.AddWithValue("@ruleI02", str[4]);
                        }
                        else if (str[i] == str[5])
                        {
                            command.Parameters.AddWithValue("@dateI02", str[5]);
                        }
                        else if (str[i] == str[6])
                        {
                            command.Parameters.AddWithValue("@studentI02", str[6]);
                        }
                        else if (str[i] == str[7])
                        {
                            command.Parameters.AddWithValue("@typeI02", str[7]);
                        }
                    }

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


            if (mData.StartsWith("INSERT03")) //입력이 안됨
            {
                string InsertQuery = "INSERT INTO portfolio_tb(PORTFOLIO_TITLE, PORTFOLIO_DATE, STUDENT_ID) VALUES (@tit, @date, @s_id)";

                try
                {
                    MySqlCommand command = new MySqlCommand(InsertQuery, connection);
                    char comma = 'ㅩ';
                    string[] str = mData.Split(comma);
                    for (int i = 1; i < str.Length; i++)
                    {
                        Console.WriteLine(str[i]);
                        if (str[i] == str[1])
                        {
                            command.Parameters.AddWithValue("@tit", str[1]);
                        }
                        else if (str[i] == str[2])
                        {
                            command.Parameters.AddWithValue("@date", str[2]);
                        }
                        else if (str[i] == str[3])
                        {
                            command.Parameters.AddWithValue("@s_id", str[3]);
                        }
                    }

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


            if (mData.StartsWith("INSERT04"))
            {
                string InsertQuery = "INSERT INTO portfolio_completed_tb(PORTFOLIO_ID, ACT_ID) VALUES (@pid, @aid)";

                try
                {
                    MySqlCommand command = new MySqlCommand(InsertQuery, connection);
                    char comma = 'ㅩ';
                    string[] str = mData.Split(comma);
                    for (int i = 1; i < str.Length; i++)
                    {
                        Console.WriteLine(str[i]);
                        if (str[i] == str[1])
                        {
                            command.Parameters.AddWithValue("@pid", str[1]);
                        }
                        else if (str[i] == str[2])
                        {
                            command.Parameters.AddWithValue("@aid", str[2]);
                        }
                    }

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


            if (mData.StartsWith("SELECT01")) //로그인
            {
                string SelectQuery = "SELECT STUDENT_ID, STUDENT_PW FROM student_tb";

                MySqlCommand command = new MySqlCommand(SelectQuery, connection);
                MySqlDataReader table = command.ExecuteReader();

                String fullData01 = null;
                String fullgo01 = null;

                while (table.Read() && state == false)
                {
                    String id = table["STUDENT_ID"].ToString();
                    String pw = table["STUDENT_PW"].ToString();

                    Console.WriteLine("{0}ㅩ{1}", id, pw);
                    fullData01 = String.Format("ㅩ{0}ㅩ{1}", id, pw);
                    fullgo01 += fullData01;
                    char comma = 'ㅩ';
                    strs1 = mData.Split(comma);

                    if (strs1[1].Equals(id) && strs1[2].Equals(pw))
                    {
                        state = true;
                    }
                    else
                    {
                    }
                }
                if (state == false)
                {
                    Console.WriteLine("최종적으로 틀렸어 유감이야..");
                    String s = "FALSE\n";
                    byte[] msgS01 = Encoding.Default.GetBytes(s);
                    mStream.Write(msgS01, 0, msgS01.Length);
                }
                table.Close();
            }


            if (mData.StartsWith("SELECT02") || state == true)
            {
                string SelectQuery = "SELECT * FROM student_tb WHERE STUDENT_ID=@passid"; //string SelectQuery = "SELECT * FROM student_tb WHERE STUDENT_ID=@passid";

                MySqlCommand command = new MySqlCommand(SelectQuery, connection);

                command.Parameters.AddWithValue("@passid", strs1[1]);

                MySqlDataReader table = command.ExecuteReader();
                String fullData02 = "";
                String fullgo02 = "";
                while (table.Read())
                {
                    String id = table["STUDENT_ID"].ToString();
                    String pw = table["STUDENT_PW"].ToString();
                    String name = table["STUDENT_NAME"].ToString();
                    String sex = table["STUDENT_SEX"].ToString();
                    String tel = table["STUDENT_PHONENUM"].ToString();
                    String email = table["STUDENT_EMAIL"].ToString();
                    String type = table["STUDENT_SCHOOLTYPE"].ToString();
                    String major = table["STUDENT_MAJOR"].ToString();
                    String grade = table["STUDENT_GRADE"].ToString();
                    String status = table["STUDENT_SCHOOLSTATE"].ToString();
                    String penalty = table["STUDENT_TOTALWARNINGCOUNT"].ToString();

                    Console.WriteLine("{0}ㅩ{1}ㅩ{2}ㅩ{3}ㅩ{4}ㅩ{5}ㅩ{6}ㅩ{7}ㅩ{8}ㅩ{9}ㅩ{10}", id, pw, name, sex, tel, email, type, major, grade, status, penalty);
                    fullData02 = String.Format("ㅩ{0}ㅩ{1}ㅩ{2}ㅩ{3}ㅩ{4}ㅩ{5}ㅩ{6}ㅩ{7}ㅩ{8}ㅩ{9}ㅩ{10}\n", id, pw, name, sex, tel, email, type, major, grade, status, penalty);// 6/16 오전에 해볼 내용
                    fullgo02 += fullData02;
                }

                byte[] msgS02 = Encoding.Default.GetBytes(fullgo02);

                mStream.Write(msgS02, 0, msgS02.Length);

                table.Close();
            }


            if (mData.StartsWith("SELECT03"))
            {
                string SelectQuery = "SELECT ACT_TITLE, ACT_STITLE, ACT_TYPENAME FROM activity_tb ";

                MySqlCommand command = new MySqlCommand(SelectQuery, connection);

                MySqlDataReader table = command.ExecuteReader();
                String fullData03 = "";
                String fullgo03 = "";
                while (table.Read())
                {
                    String title = table["ACT_TITLE"].ToString();
                    String subtitle = table["ACT_STITLE"].ToString();
                    String type = table["ACT_TYPENAME"].ToString();

                    Console.WriteLine("{0}ㅩ{1}ㅩ{2}", title, type, subtitle);
                    fullData03 = String.Format("ㅩ{0}ㅩ{1}ㅩ{2}", title, type, subtitle);
                    fullgo03 += fullData03;
                }

                byte[] msgS03 = Encoding.Default.GetBytes(fullgo03 + '\n');

                mStream.Write(msgS03, 0, msgS03.Length);

                table.Close();
            }


            if (mData.StartsWith("SELECT04"))
            {
                string SelectQuery1 = "SELECT * FROM activity_tb";

                MySqlCommand command = new MySqlCommand(SelectQuery1, connection);

                MySqlDataReader table = command.ExecuteReader();
                string abc = "";

                char comma = 'ㅩ';
                string[] str = mData.Split(comma);
                for (int i = 1; i < str.Length; i++)
                {
                    Console.WriteLine(str[i]);
                    if (str[i] == str[1])
                    {
                        abc = str[1];
                    }
                }

                if (str[1].Equals(abc))
                {
                    string SelectQuery2 = "SELECT * FROM activity_tb WHERE ACT_TITLE=" + abc;

                    MySqlCommand command2 = new MySqlCommand(SelectQuery2, connection);

                    String fullData04 = "";

                    while (table.Read())
                    {
                        String title = table["ACT_TITLE"].ToString();
                        String subtitle = table["ACT_STITLE"].ToString();
                        String contents = table["ACT_CONT"].ToString();
                        String rule = table["ACT_RULE"].ToString();
                        String sid = table["STUDENT_ID"].ToString();
                        String type = table["ACT_TYPENAME"].ToString();

                        if (title.Equals(abc))
                        {
                            Console.WriteLine("{0}ㅩ{1}ㅩ{2}ㅩ{3}ㅩ{4}ㅩ{5}", title, subtitle, contents, rule, sid, type);
                            fullData04 = String.Format("ㅩ{0}ㅩ{1}ㅩ{2}ㅩ{3}ㅩ{4}ㅩ{5}", title, subtitle, contents, rule, sid, type);
                        }

                    }

                    byte[] msgS04 = Encoding.Default.GetBytes(fullData04 + '\n');

                    mStream.Write(msgS04, 0, msgS04.Length);

                    table.Close();
                }
            }


            if (mData.StartsWith("SELECT05"))
            {
                string SelectQuery = "SELECT student_tb.STUDENT_ID AS SID, activity_join_list_tb.ACT_GRADE AS AG, activity_tb.ACT_TITLE AS ATI, activity_tb.ACT_TYPENAME AS ATY, activity_progress_completed_tb.ACT_COMPLETED_SDATE AS ACSD, activity_progress_completed_tb.ACT_COMPLETED_FDATE AS FCSD FROM student_tb, activity_tb, activity_progress_completed_tb, activity_join_list_tb WHERE student_tb.STUDENT_ID = activity_tb.STUDENT_ID and activity_tb.ACT_ID = activity_progress_completed_tb.ACT_ID and activity_tb.ACT_ID = activity_join_list_tb.ACT_ID";
                MySqlCommand command = new MySqlCommand(SelectQuery, connection);

                MySqlDataReader table = command.ExecuteReader();

                String fullData05 = "";
                String fullgo05 = "";
                string abc = "";

                char comma = 'ㅩ';
                string[] str = mData.Split(comma);
                for (int i = 1; i < str.Length; i++)
                {
                    Console.WriteLine(str[i]);
                    if (str[i] == str[1])
                    {
                        abc = str[1];
                    }
                }

                while (table.Read())
                {
                    String grade = table["AG"].ToString();//AG로 변경
                    String id = table["SID"].ToString();
                    String title = table["ATI"].ToString();
                    String type = table["ATY"].ToString();
                    String sdate = table["ACSD"].ToString();
                    String fdate = table["FCSD"].ToString();

                    if (id.Equals(abc))
                    {
                        Console.WriteLine("{0}ㅩ{1}ㅩ{2}ㅩ{3}ㅩ{4}", table["AG"].ToString(), table["ATI"].ToString(), table["ATY"].ToString(), table["ACSD"].ToString(), table["FCSD"].ToString());
                        fullData05 = String.Format("ㅩ{0}ㅩ{1}ㅩ{2}ㅩ{3}ㅩ{4}", grade, title, type, sdate, fdate);
                        fullgo05 += fullData05;
                    }
                }

                byte[] msgS05 = Encoding.Default.GetBytes(fullgo05 + '\n');

                mStream.Write(msgS05, 0, msgS05.Length);

                table.Close();
            }


            if (mData.StartsWith("SELECT06"))
            {

                string SelectQuery1 = "SELECT * FROM portfolio_tb";

                MySqlCommand command = new MySqlCommand(SelectQuery1, connection);

                MySqlDataReader table = command.ExecuteReader();
                string abc = "";

                char comma = 'ㅩ';
                string[] str = mData.Split(comma);
                for (int i = 1; i < str.Length; i++)
                {
                    Console.WriteLine(str[i]);
                    if (str[i] == str[1])
                    {
                        abc = str[1].ToString();
                    }
                }

                string SelectQuery2 = "SELECT PORTFOLIO_ID FROM portfolio_tb WHERE PORTFOLIO_TITLE=" + abc;

                MySqlCommand command2 = new MySqlCommand(SelectQuery2, connection);

                String fullData06 = "";

                while (table.Read())
                {
                    String id = table["PORTFOLIO_ID"].ToString();
                    String title = table["PORTFOLIO_TITLE"].ToString();

                    if (title.Equals(abc))
                    {
                        Console.WriteLine("{0}", table["PORTFOLIO_ID"].ToString());
                        fullData06 = String.Format("{0}", id);
                    }
                }

                byte[] msgS06 = Encoding.Default.GetBytes(fullData06 + '\n');

                mStream.Write(msgS06, 0, msgS06.Length);

                table.Close();

            } // 간소화 가능할듯


            if (mData.StartsWith("SELECT07"))
            {
                string SelectQuery = "SELECT ACT_ID, ACT_TITLE FROM activity_tb";

                MySqlCommand command = new MySqlCommand(SelectQuery, connection);

                MySqlDataReader table = command.ExecuteReader();
                String fullData07 = "";
                String fullgo07 = "";

                while (table.Read())
                {
                    String id = table["ACT_ID"].ToString();
                    String title = table["ACT_TITLE"].ToString();

                    Console.WriteLine("{0}ㅩ{1}", table["ACT_ID"].ToString(), table["ACT_TITLE"].ToString());

                    fullData07 = String.Format("ㅩ{0}ㅩ{1}", id, title);
                    fullgo07 += fullData07;
                }

                byte[] msgS07 = Encoding.Default.GetBytes(fullgo07 + '\n');

                mStream.Write(msgS07, 0, msgS07.Length);

                table.Close();
            }


            if (mData.StartsWith("SELECT08"))
            {
                string abc = "";

                char comma = 'ㅩ';
                string[] str = mData.Split(comma);
                for (int i = 1; i < str.Length; i++)
                {
                    Console.WriteLine(str[i]);
                    if (str[i] == str[1])
                    {
                        abc = str[1].ToString();
                    }
                }

                string SelectQuery = "SELECT PORTFOLIO_TITLE FROM portfolio_tb WHERE STUDENT_ID=" + abc;

                MySqlCommand command = new MySqlCommand(SelectQuery, connection);

                MySqlDataReader table = command.ExecuteReader();

                String fullData08 = "";
                String fullgo08 = "";

                while (table.Read())
                {
                    String title = table["PORTFOLIO_TITLE"].ToString();
                    Console.WriteLine("{0}", table["PORTFOLIO_TITLE"].ToString());
                    fullData08 = String.Format("{0}ㅩ", title);
                    fullgo08 += fullData08;
                }

                byte[] msgS08 = Encoding.Default.GetBytes(fullgo08 + '\n');

                mStream.Write(msgS08, 0, msgS08.Length);

                table.Close();

            }


            if (mData.StartsWith("SELECT09"))
            {
                string SelectQuery1 = "SELECT * FROM portfolio_completed_tb";

                MySqlCommand command = new MySqlCommand(SelectQuery1, connection);

                MySqlDataReader table = command.ExecuteReader();
                string abc = "";

                char comma = 'ㅩ';
                string[] str = mData.Split(comma);
                for (int i = 1; i < str.Length; i++)
                {
                    Console.WriteLine(str[i]);
                    if (str[i] == str[1])
                    {
                        abc = str[1].ToString();
                    }
                }

                string SelectQuery2 = "SELECT ACT_ID,PORTFOLIO_ID FROM portfolio_completed_tb WHERE PORTFOLIO_ID=" + abc;

                MySqlCommand command2 = new MySqlCommand(SelectQuery2, connection);

                String fullData09 = "";
                String fullgo09 = "";

                while (table.Read())
                {
                    String aid = table["ACT_ID"].ToString();
                    String pid = table["PORTFOLIO_ID"].ToString();

                    if (pid.Equals(abc))
                    {
                        Console.WriteLine("{0}ㅩ", table["ACT_ID"].ToString());
                        fullData09 = String.Format("{0}ㅩ", aid);
                        fullgo09 += fullData09;
                    }
                }

                byte[] msgS09 = Encoding.Default.GetBytes(fullgo09 + '\n');

                mStream.Write(msgS09, 0, msgS09.Length);

                table.Close();

            }



            if (mData.StartsWith("SELECT10"))
            {
                string SelectQuery1 = "SELECT * FROM activity_tb";

                MySqlCommand command1 = new MySqlCommand(SelectQuery1, connection);

                MySqlDataReader table = command1.ExecuteReader();
                string abc = "";

                char comma = 'ㅩ';
                string[] str = mData.Split(comma);
                for (int i = 1; i < str.Length; i++)
                {
                    Console.WriteLine(str[i]);
                    if (str[i] == str[1])
                    {
                        abc = str[1].ToString();
                    }
                }

                string SelectQuery2 = "SELECT ACT_TITLE, ACT_STITLE ACT_ID FROM activity_tb WHERE ACT_ID=" + abc;

                MySqlCommand command2 = new MySqlCommand(SelectQuery2, connection);

                String fullData10 = "";
                String fullgo10 = "";

                while (table.Read())
                {
                    String title = table["ACT_TITLE"].ToString();
                    String stitle = table["ACT_STITLE"].ToString();
                    String aid = table["ACT_ID"].ToString();

                    if (aid.Equals(abc))
                    {
                        //Console.WriteLine("{0}ㅩ{1}ㅩ", table["ACT_TITLE"].ToString(), table["ACT_STITLE"].ToString());
                        fullData10 = String.Format("{0}ㅩ{1}ㅩ", title, stitle);
                        fullgo10 += fullData10;
                    }
                }

                byte[] msgS10 = Encoding.Default.GetBytes(fullgo10 + '\n');

                mStream.Write(msgS10, 0, msgS10.Length);

                table.Close();
            }


            if (mData.StartsWith("DELETE"))
            {
                string DeleteQuery = "DELETE FROM starter WHERE id = @id";
                MySqlCommand command = new MySqlCommand(DeleteQuery, connection);
                string str1 = mData.Substring(7, 8);
                command.Parameters.AddWithValue("@id", str1);
                MySqlDataReader table = command.ExecuteReader();

            }
            else if (mData.StartsWith("UPDATE01"))
            {
                string UpdateQuery = "UPDATE student_tb SET id = @id";
                MySqlCommand command = new MySqlCommand(UpdateQuery, connection);
                string str1 = mData.Substring(7, 8);
                command.Parameters.AddWithValue("@id", str1);
                MySqlDataReader table = command.ExecuteReader();
            }
        }
    }
}
