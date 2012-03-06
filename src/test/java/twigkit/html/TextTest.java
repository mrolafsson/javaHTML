package twigkit.html;

import org.junit.Test;

/**
 * @author mr.olafsson
 */
public class TextTest extends AbstractHtmlCapabilityTest {

    @Test
    public void testText() throws Exception {
        assertEquals("Hello world!", text("Hello world!"));
    }
}
