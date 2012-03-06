package twigkit.html;

import org.junit.Test;

/**
 * @author mr.olafsson
 */
public class DivTest extends AbstractHtmlCapabilityTest {

    @Test
    public void testEmptyDiv() throws Exception {
        assertEquals("<div></div>", div().empty());
    }

    @Test
    public void testEmptyDivWithAttributes() throws Exception {
        Div div = div(css("class1", "class2"), id("something")).empty();
        assertEquals("<div class=\"class1 class2\" id=\"something\"></div>", div);
    }
}
