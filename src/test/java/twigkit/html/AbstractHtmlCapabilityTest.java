package twigkit.html;

import org.junit.Before;
import twigkit.html.helper.SimpleTagSupportWithHtml;

import java.io.StringWriter;
import static junit.framework.Assert.assertEquals;

/**
 * @author mr.olafsson
 */
public class AbstractHtmlCapabilityTest extends SimpleTagSupportWithHtml {

    public AbstractHtmlCapabilityTest() {
        super(new StringWriter(), AbstractHtmlCapabilityTest.class);
    }

    protected void assertEquals(String expected, Content actual) {
        setWriter(new StringWriter());
        junit.framework.Assert.assertEquals(expected, actual.toString());
    }
}
