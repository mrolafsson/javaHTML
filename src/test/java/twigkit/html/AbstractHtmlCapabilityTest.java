package twigkit.html;

import org.junit.Before;

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
        setWriter(new StringWriter());
        junit.framework.Assert.assertEquals(expected, actual.toString());
    }
}
