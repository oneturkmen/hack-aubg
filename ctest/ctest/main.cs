using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ctest
{

    public class Main
    {
        private Button[] Buttons = new Button[4];
        public static void Display(ref Form w, params Control[] objects)
        {
            foreach (Control c in objects)
                w.Controls.Add(c);
        }
        public Main(ref Form w) {
            Random rnd = new Random();
            int correct = rnd.Next(0,4);
            for(int i = 0; i < 4; i++)
            {
                Buttons[i] = new Button();
                if (i == correct)
                {
                    /*temp, xml parsing needed*/
                    Buttons[correct].Text = "Correct";
                }
                else {
                    /*object that has a xml parsed*/
                    Buttons[i].Text = "Incorrect";
                }
                Buttons[i].Location = new Point(i * 100,i*100);
                w.Controls.Add(Buttons[i]);
            }

        }
    }
}
