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
                x.Service<Servc>(s =>
                {
                s.ConstructUsing(Servc => new Servc());
                s.WhenStarted(Servc => Servc.Start());
                s.WhenStopped(Servc => Servc.Stop());

                });
                x.RunAsLocalSystem();
                x.SetServiceName("Procrast");
                x.SetDisplayName("Antiproc");
                x.SetDescription("Simple description");
            });
            int exit = (int)Convert.ChangeType(exitCode, exitCode.GetTypeCode());
            Environment.ExitCode = exit;
        }
    }
}
