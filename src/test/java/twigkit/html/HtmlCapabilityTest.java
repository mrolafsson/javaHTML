package twigkit.html;

import org.junit.Test;

/**
 * @author mr.olafsson
 */
public class HtmlCapabilityTest extends AbstractHtmlCapabilityTest {

    @Test
    public void testContainerTags() throws Exception {
        assertEquals("<div></div>", div().close());
        assertEquals("<span></span>", span().close());
        assertEquals("<h1></h1>", h1().close());
        assertEquals("<h2></h2>", h2().close());
        assertEquals("<h3></h3>", h3().close());
        assertEquals("<h4></h4>", h4().close());
        assertEquals("<p></p>", p().close());
        assertEquals("<ol></ol>", ol().close());
        assertEquals("<ul></ul>", ul().close());
        assertEquals("<li></li>", li().close());
        assertEquals("<dl></dl>", dl().close());
        assertEquals("<dt></dt>", dt().close());
        assertEquals("<dd></dd>", dd().close());
        assertEquals("<a></a>", a().close());
        assertEquals("<form></form>", form().close());
        assertEquals("<input></input>", input().close());
        assertEquals("<fieldset></fieldset>", fieldset().close());
        assertEquals("<legend></legend>", legend().close());
        assertEquals("<script></script>", script().close());
        assertEquals("<blink></blink>", custom("blink").close());
    }

    @Test
    public void testText() throws Exception {
        assertEquals("Hello world!", text("Hello world!"));
    }

    @Test
    public void testSelfClosingTags() throws Exception {
        assertEquals("<img id=\"image\" src=\"pic.png\" />", img(id("image"), src("pic.png")));
    }

    @Test
    public void testA() throws Exception {
        assertEquals("<a href=\"http://\" target=\"_blank\" title=\"tooltip\">Hello</a>", a(href("http://"), target("_blank"), title("tooltip")).body(text("Hello")));
    }

    @Test
    public void testEmptyDivWithAttributes() throws Exception {
        ContainerTag div = div(cls("class1", "class2"), id("something"), data("base", "sql"), attr("onclick", "alert('hello');")).close();
        assertEquals("<div class=\"class1 class2\" id=\"something\" data-base=\"sql\" onclick=\"alert('hello');\"></div>", div);
    }

    @Test
    public void testWithBody() throws Exception {
        ContainerTag div = div().body(div().close(), div().close());
        assertEquals("<div><div></div><div></div></div>", div);
    }

    @Test
    public void testAppend() throws Exception {
        ContainerTag div = div().append(
                text("Hello"),
                text(" ")
        );
        div.append(
                text("world!")
        ).close();
        assertEquals("<div>Hello world!</div>", div);
    }
}
