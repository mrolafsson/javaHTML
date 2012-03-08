package twigkit.html;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mr.olafsson
 */
public class ContainerTagTest extends AbstractHtmlCapabilityTest {

    @Test(expected = HtmlException.class)
    public void testDoubleClosing() throws Exception {
        System.out.println(ol().close().close());
    }

    @Test
    public void testValid() throws Exception {
        assertTrue(ol().close().validate());
    }

    @Test(expected = HtmlException.class)
    public void testInvalid() throws Exception {
        assertFalse(ol().validate());
    }
}
