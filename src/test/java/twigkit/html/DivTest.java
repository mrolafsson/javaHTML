package twigkit.html;

import org.junit.Test;

/**
 * @author mr.olafsson
 */
public class DivTest extends AbstractHtmlCapabilityTest {

    @Test
    public void testEmptyDiv() throws Exception {
        assertEquals("<div></div>", div().close());
    }

    @Test
    public void testEmptyDivWithAttributes() throws Exception {
        Div div = div(css("class1", "class2"), id("something")).close();
        assertEquals("<div class=\"class1 class2\" id=\"something\"></div>", div);
    }

    @Test
    public void testWithBody() throws Exception {
        Div div = div().body(div().close(), div().close());
        assertEquals("<div><div></div><div></div></div>", div);
    }

    @Test
    public void testAppend() throws Exception {
        Div div = div().append(
                text("Hello"),
                text(" ")
        );
        div.append(
                text("world!")
        ).close();
        assertEquals("<div>Hello world!</div>", div);
    }
}
