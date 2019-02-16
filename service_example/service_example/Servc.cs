using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Timers;

namespace service_example
{
    public class Servc
    {
        private readonly Timer timer;
        public Servc() {
            timer = new Timer(1000) { AutoReset = true };
            timer.Elapsed += TimerElapsed;
        }

        private void TimerElapsed(object sender, ElapsedEventArgs e)
        {
            string[] lines = new string[] { DateTime.Now.ToString() };
            File.AppendAllLines("time.txt",lines);
        }
        public void Start() {
            timer.Start();
        }
        public void Stop() {
            timer.Stop();
        }
    }
}
