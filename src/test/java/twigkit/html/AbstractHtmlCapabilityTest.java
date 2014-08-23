package twigkit.html;

import java.io.StringWriter;

/**
 * Abstract class to make it easier to test {@link HtmlCapabilityImpl}.
 *
 * @author mr.olafsson
 */
public class AbstractHtmlCapabilityTest extends HtmlCapabilityImpl {

    public AbstractHtmlCapabilityTest() {
        super(new StringWriter(), AbstractHtmlCapabilityTest.class);
    }

    protected void assertEquals(String expected, Content actual) {
        setWriter(new StringWriter());
        junit.framework.Assert.assertEquals(expected, actual.toString());
    }

    protected void assertNotEquals(String expected, Content actual) {
        setWriter(new StringWriter());
        junit.framework.Assert.assertNotSame(expected, actual.toString());
    }
}
