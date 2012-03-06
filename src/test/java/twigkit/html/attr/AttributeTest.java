package twigkit.html.attr;

import org.junit.Test;

import java.io.StringWriter;

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
    public void testWriteAttributes() throws Exception {
        StringWriter writer = new StringWriter();
        Attribute.write(writer, new Attribute.Css("class1", "class2"), new Attribute.Id("something"));
        assertEquals(" class=\"class1 class2\" id=\"something\"", writer.toString());
    }
}
