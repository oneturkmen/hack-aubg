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
        static public void Ps(ref Button b1,ref Button b2) {
            if (b1.Location != b2.Location)
            {
                Point p = b1.Location;
                b1.Location = b2.Location;
                b2.Location = p;
            }
        }
        private Label q;
        private Button[] Buttons = new Button[4];
        private Xmlparse xp;
        public Main(ref Form w) {
            xp = new Xmlparse("qanda.xml");
            q = new Label();
            w.Controls.Add(q);
            q.Location = new Point(100, 0);
            q.Text = xp.answers[5];
            Random rnd = new Random();
            int qnum = xp.questions.Count();
            qnum = rnd.Next(0, qnum);
            for(int i = 0; i < 4; i++)
            {
                Buttons[i] = new Button();
                if(i==0) Buttons[i].Text = xp.answers[qnum*4];
                Buttons[i].Text = xp.answers[qnum * 4+i];
                Buttons[i].Location = new Point(i * 100,i*100);
                
            }
            
            for (int i = 0; i < 4; i++)
            {
                Ps(ref Buttons[rnd.Next(0,4)],ref Buttons[rnd.Next(0, 4)]);
                w.Controls.Add(Buttons[i]);
            }
        }
    }
}
