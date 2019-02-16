
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {

    public static void main(String[] args) {
        /************************************/
        /** THIS CLASS IS FOR TESTING ONLY **/
        /************************************/

        XmlParser xmlParser = new XmlParser();
        // xmlParser.parse("1234");
    }

    public List<Question> parse(String path) throws Exception {
        if (path.isEmpty() || path.equals("")) {
            throw new Exception("Path is not specified!");
        }

        // Question container
        List<Question> questions = new ArrayList<Question>();

        try {
            // File to read
            File inputFile = new File(path);

            // Get Document ready
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            // Build the doc
            Document document = builder.parse(inputFile);

            // Get the "children" and start reading data
            NodeList nodeList = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Element of a node
                    Element elem = (Element) node;

                    // Get the question id (integer)
                    Integer id = Integer.parseInt(
                            node.getAttributes().getNamedItem("question_id").getNodeValue()
                    );

                    // Get the question itself (text)
                    String question = node.getAttributes().getNamedItem("text").getNodeValue();

                    // Get the answers (first is correct, the rest is incorrect)
                    String correct_answer = elem.getElementsByTagName("Answer")
                        .item(0).getChildNodes().item(0).getNodeValue();

                    String answer2 = elem.getElementsByTagName("Answer2")
                        .item(0).getChildNodes().item(0).getNodeValue();

                    String answer3 = elem.getElementsByTagName("Answer3")
                        .item(0).getChildNodes().item(0).getNodeValue();

                    String answer4 = elem.getElementsByTagName("Answer4")
                        .item(0).getChildNodes().item(0).getNodeValue();

                    // Append them to the list
                    questions.add(new Question(id, question, correct_answer, answer2, answer3, answer4));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw  e;
        } finally {
            return questions;
        }
    }
}
