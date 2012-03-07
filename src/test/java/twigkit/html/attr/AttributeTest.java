package twigkit.html.attr;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import static junit.framework.Assert.assertEquals;

/**
 * @author mr.olafsson
 */
public class AttributeTest {

    @Test
    public void testAttribute() throws Exception {
        Attribute attr = new Attribute("name", "value1", "value2");
        assertEquals("name=\"value1 value2\"", attr.toString());
    }

    @Test(expected = IOException.class)
    public void testNullWriter() throws Exception {
        Attribute attr = new Attribute("name", "value1", "value2");
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
    public void testCss() throws Exception {
        Attribute attr = new Attribute.Css("class1", "class2");
        assertEquals("class=\"class1 class2\"", attr.toString());
    }

    @Test
    public void testId() throws Exception {
        Attribute attr = new Attribute.Id("something");
        assertEquals("id=\"something\"", attr.toString());
    }

    @Test
    public void testData() throws Exception {
        Attribute attr = new Attribute.Data("base", "sql");
        assertEquals("data-base=\"sql\"", attr.toString());
    }

    @Test
    public void testHref() throws Exception {
        Attribute attr = new Attribute.Href("http://host/");
        assertEquals("href=\"http://host/\"", attr.toString());
    }

    @Test
    public void testSrc() throws Exception {
        Attribute attr = new Attribute.Src("http://host/");
        assertEquals("src=\"http://host/\"", attr.toString());
    }

    @Test
    public void testTarget() throws Exception {
        Attribute attr = new Attribute.Target("_blank");
        assertEquals("target=\"_blank\"", attr.toString());
    }

    @Test
    public void testWriteAttributes() throws Exception {
        StringWriter writer = new StringWriter();
        Attribute.write(writer, new Attribute.Css("class1", "class2"), new Attribute.Id("something"));
        assertEquals(" class=\"class1 class2\" id=\"something\"", writer.toString());
    }
}
