package twigkit.markup.html;

import org.junit.Test;
import twigkit.markup.Attribute;

import java.io.StringWriter;

import static junit.framework.Assert.assertEquals;

/**
 * @author mr.olafsson
 */
public class HtmlAttributeTest {

    @Test
    public void testCss() throws Exception {
        HtmlAttribute attr = new HtmlAttribute.Class("class1", "class2");
        assertEquals("class=\"class1 class2\"", attr.toString());
    }

    @Test
    public void testId() throws Exception {
        HtmlAttribute attr = new HtmlAttribute.Id("something");
        assertEquals("id=\"something\"", attr.toString());
    }

    @Test
    public void testData() throws Exception {
        HtmlAttribute attr = new HtmlAttribute.Data("base", "sql");
        assertEquals("data-base=\"sql\"", attr.toString());
    }

    @Test
    public void testHref() throws Exception {
        HtmlAttribute attr = new HtmlAttribute.Href("http://host/");
        assertEquals("href=\"http://host/\"", attr.toString());
    }

    @Test
    public void testSrc() throws Exception {
        HtmlAttribute attr = new HtmlAttribute.Src("http://host/");
        assertEquals("src=\"http://host/\"", attr.toString());
    }

    @Test
    public void testTarget() throws Exception {
        HtmlAttribute attr = new HtmlAttribute.Target("_blank");
        assertEquals("target=\"_blank\"", attr.toString());
    }

    @Test
    public void testTitle() throws Exception {
        HtmlAttribute attr = new HtmlAttribute.Title("tooltip");
        assertEquals("title=\"tooltip\"", attr.toString());
    }

    @Test
    public void testWriteAttributes() throws Exception {
        StringWriter writer = new StringWriter();
        HtmlAttribute.write(writer, new HtmlAttribute.Class("class1", "class2"), new HtmlAttribute.Id("something"));
        assertEquals(" class=\"class1 class2\" id=\"something\"", writer.toString());
    }

    @Test
    public void testMultipleClassAttributes() throws Exception {
        Attribute attr1 = new HtmlAttribute.Class().add("one");
        Attribute attr2 = new HtmlAttribute.Class().add("two");
        StringWriter writer = new StringWriter();
        HtmlAttribute.write(writer, attr1, attr2);
        assertEquals(" class=\"one two\"", writer.toString());
    }

    @Test
    public void testWidthAndHeight() throws Exception {
        HtmlAttribute attr = new HtmlAttribute.Height(-1);
        assertEquals("", attr.toString());

        attr = new HtmlAttribute.Height(100);
        assertEquals("height=\"100\"", attr.toString());

        attr = new HtmlAttribute.Width(-1);
        assertEquals("", attr.toString());

        attr = new HtmlAttribute.Width(100);
        assertEquals("width=\"100\"", attr.toString());
    }
}
