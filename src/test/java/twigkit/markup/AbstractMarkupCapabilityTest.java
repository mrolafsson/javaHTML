package twigkit.markup;

import twigkit.markup.html.HtmlCapabilityImpl;

import java.io.StringWriter;

/**
 * Abstract class to make it easier to test {@link twigkit.markup.html.HtmlCapabilityImpl}.
 *
 * @author mr.olafsson
 */
public class AbstractMarkupCapabilityTest extends HtmlCapabilityImpl {

    public AbstractMarkupCapabilityTest() {
        super(new StringWriter(), AbstractMarkupCapabilityTest.class);
    }

    protected void assertEquals(String expected, Content actual) {
        setWriter(new StringWriter());
        junit.framework.Assert.assertEquals(expected, actual.toString());
    }
}
