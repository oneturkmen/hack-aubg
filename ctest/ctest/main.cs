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
            Random rnd = new Random();
        public Main(ref Form w) {
            Random rnd = new Random();
            xp = new Xmlparse("qanda.xml");
            int qnum = xp.questions.Count();
            int rnum = rnd.Next(0, qnum);
            q = new Label();
            q.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            q.Width = 2000;
            q.Height = 50;
            //q.Height = 200;
            w.Controls.Add(q);
            q.Location = new Point(100, 0);
            q.Text = xp.questions[rnum];
            for(int i = 0; i < 4; i++)
            {
                Buttons[i] = new Button();
                if (i == 0)
                {
                    Buttons[i].Text = xp.answers[rnum * 4];
                    Buttons[i].Click += Corr;
                }
                else {
                    Buttons[i].Click += Err;
                }
                Buttons[i].Text = xp.answers[rnum * 4+i];
                Buttons[i].Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
                Buttons[i].Width = 400;
                Buttons[i].Height = 50;
                Buttons[i].Location = new Point(200, i * 100 + 100);

            }
            for (int i = 0; i < 4; i++)
            {
                Ps(ref Buttons[rnd.Next(0,4)],ref Buttons[rnd.Next(0, 4)]);
                w.Controls.Add(Buttons[i]);
            }
        }

        private void Err(object sender, EventArgs e)
        {
            MessageBox.Show("Wrong. Please try again");
        }

        private void Corr(object sender, EventArgs e)
        {
            MessageBox.Show("Correct");
            Application.Exit();
        }
    }
}
