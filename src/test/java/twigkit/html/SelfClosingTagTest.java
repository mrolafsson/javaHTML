package twigkit.html;

import org.junit.Test;

/**
 *
 */
public class SelfClosingTagTest extends AbstractHtmlCapabilityTest {

    @Test
    public void testImgTag() throws Exception {
        assertEquals("<img id=\"image\" />", img(id("image")));
    }
}
