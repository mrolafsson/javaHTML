package twigkit.markup;

import org.junit.Test;
import twigkit.markup.html.HtmlAttribute;

import java.io.IOException;
import java.io.Writer;

import static junit.framework.Assert.assertEquals;

/**
 * Created by hjortur on 28/04/2014.
 */
public class AttributeTest {

    @Test
    public void testAttribute() throws Exception {
        HtmlAttribute attr = new HtmlAttribute("name", "value1", "value2");
        assertEquals("name=\"value1 value2\"", attr.toString());
    }

    @Test(expected = IOException.class)
    public void testNullWriter() throws Exception {
        HtmlAttribute attr = new HtmlAttribute("name", "value1", "value2");
        attr.write(new Writer() {
            @Override
            public void write(char[] chars, int i, int i1) throws IOException {
                throw new IOException();
            }

            @Override
            public void flush() throws IOException {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void close() throws IOException {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

    @Test
    public void testAddValue() throws Exception {
        Attribute attr = new Attribute("name", "value1", "value2").add("value3");
        assertEquals("name=\"value1 value2 value3\"", attr.toString());
    }

    @Test
    public void testRemoveValue() throws Exception {
        Attribute attr = new Attribute("name", "value1", "value2", "value3").remove("value2");
        assertEquals("name=\"value1 value3\"", attr.toString());
    }

    @Test
    public void testClone() throws Exception {
        Attribute attr = new Attribute("name", "value1", "value2", "value3");
        Attribute clone = attr.clone().add("value4");

        System.out.println(clone.toString());
    }
}
