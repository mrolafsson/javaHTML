package twigkit.html;

import java.io.StringWriter;
import static junit.framework.Assert.assertEquals;

/**
 * @author mr.olafsson
 */
public class AbstractHtmlCapabilityTest extends HtmlCapability {

    public AbstractHtmlCapabilityTest() {
        super(new StringWriter());
    }

    protected void assertEquals(String expected, Tag actual) {
        junit.framework.Assert.assertEquals(expected, actual.toString());
    }
}
