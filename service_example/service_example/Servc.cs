using System;
using System.Collections.Generic;
using System.Diagnostics;
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
        public Servc(double t) {
            timer = new Timer(t) { AutoReset = true };
            timer.Elapsed += TimerElapsed;
        }

        private void TimerElapsed(object sender, ElapsedEventArgs e)
        {
                Process.Start("ctest.exe");
            
        }
        public void Start() {
            timer.Start();
        }
        public void Stop() {
            timer.Stop();
        }
    }
}
