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

namespace App_Server
{
    class Program
    {
        static void Main(string[] args)
        {
            CommManager commManager = new CommManager("192.168.0.14", 25000);
            commManager.serverOpenAndListening();

        }

    }
}
