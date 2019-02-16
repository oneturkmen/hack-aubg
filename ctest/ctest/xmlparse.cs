using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace ctest
{
    public class Xmlparse
    {
        private XmlDocument doc;
        public List<string> questions;
        public List<string> answers;
        public Xmlparse(string file) {
            questions = new List<string>();
            answers = new List<string>();
            doc = new XmlDocument();
            doc.Load(file);
            XmlNode qnode = doc.DocumentElement.SelectSingleNode("/questions/question");
            XmlNode anode = qnode.FirstChild;
            while (qnode != null)
            {
                questions.Add(qnode.Attributes["text"]?.InnerText);
                qnode = qnode.NextSibling;
                for (int i = 0; i < 4; i++) {
                    answers.Add(anode.InnerText);
                    anode = anode.NextSibling;
                        }
                if(qnode!=null)
                anode = qnode.FirstChild;
            } 
            /*
            do
            {
                questions.Add(node.Attributes["text"]?.InnerText);
                node = node.NextSibling;
            } while (node != null);
            node = doc.DocumentElement.SelectSingleNode("/questions/question/Answer");
            do
            {
                answers.Add(node.InnerText);
                node = node.NextSibling;
            } while (node != null);
            //text = node.Attributes["text"]?.InnerText;
            */
        }
    }
}
