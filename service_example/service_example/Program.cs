using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Topshelf;

namespace service_example
{
    class Program
    {
        static void Main(string[] args)
        {
            var exitCode = HostFactory.Run(x =>
            {
                //double t = Double.Parse(args[0]);
                double t = 10000;
                x.Service<Servc>(s =>
                {
                s.ConstructUsing(Servc => new Servc(t));
                s.WhenStarted(Servc => Servc.Start());
                s.WhenStopped(Servc => Servc.Stop());

                });
                x.RunAsLocalSystem();
                x.SetServiceName("Procrast");
                x.SetDisplayName("Antiproc");
                x.SetDescription("Simple description");

                x.AddCommandLineDefinition("t",v=>t = Double.Parse(v));
            });
            int exit = (int)Convert.ChangeType(exitCode, exitCode.GetTypeCode());
            Environment.ExitCode = exit;
        }
    }
}
