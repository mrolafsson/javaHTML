package twigkit.markup;

import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.Date;


/**
 * Created by hjortur on 30/04/2014.
 */
public class PerformanceTest extends AbstractMarkupCapabilityTest {

    private static final String[] brothers = new String[]{"Chico", "Harpo", "Groucho", "Zeppo"};

    @Test
    public void testDOM() throws Exception {
        long start = new Date().getTime();
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        for (int i = 0; i < 100; i++) {
            try {
                // root elements
                Document doc = docBuilder.newDocument();
                org.w3c.dom.Element rootElement = doc.createElement("marx");
                doc.appendChild(rootElement);

                for (String name : brothers) {
                    org.w3c.dom.Element brother = doc.createElement("brother");

                    Attr attr = doc.createAttribute("id");
                    attr.setValue(name);
                    brother.setAttributeNode(attr);

                    org.w3c.dom.Element firstname = doc.createElement("first-name");
                    firstname.appendChild(doc.createTextNode(name));
                    brother.appendChild(firstname);

                    org.w3c.dom.Element lastname = doc.createElement("last-name");
                    lastname.appendChild(doc.createTextNode("Marx"));
                    brother.appendChild(lastname);

                    org.w3c.dom.Element nickname = doc.createElement("nickname");
                    nickname.appendChild(doc.createTextNode(name));
                    brother.appendChild(nickname);

                    rootElement.appendChild(brother);
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StringWriter sw = new StringWriter();
                StreamResult result = new StreamResult(sw);

                transformer.transform(source, result);

//                System.out.println(sw.toString());
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }
        }

        System.out.println(new Date().getTime() - start);
    }

    @Test
    public void testJavaHtml() throws Exception {
        long start = new Date().getTime();

        for (int i = 0; i < 100; i++) {
            Element el = el("marx").with(
                    iterate(new Loop<String>(brothers) {
                        @Override
                        public void each(String name) throws Exception {
                            el("brother", attr("id", name)).with(
                                    el("first-name").with(name),
                                    el("last-name").with("Marx"),
                                    el("nickname").with(name)
                            );
                        }
                    })
            );
            el.toString();
        }

        System.out.println(new Date().getTime() - start);
    }
}
