package twigkit.markup;

import org.junit.Test;
import twigkit.markup.html.AbstractHtmlCapabilityTest;

/**
 * Unit tests for the {@link twigkit.markup.html.HtmlCapabilityImpl} class.
 *
 * @author mr.olafsson
 */
public class MarkupCapabilityTest extends AbstractMarkupCapabilityTest {

    @Test
    public void testContainerTags() throws Exception {
        assertEquals("<xml></xml>", el("xml").close());
    }

    @Test
    public void testText() throws Exception {
        assertEquals("Hello world!", text("Hello world!"));
    }
}
