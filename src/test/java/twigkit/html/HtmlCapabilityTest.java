package twigkit.html;

import org.junit.Test;

/**
 * Unit tests for the {@link HtmlCapabilityImpl} class.
 *
 * @author mr.olafsson
 */
public class HtmlCapabilityTest extends AbstractHtmlCapabilityTest {

    @Test
    public void testContainerTags() throws Exception {
        assertEquals("<html></html>", html().close());
        assertEquals("<body></body>", body().close());
        assertEquals("<head></head>", head().close());
        assertEquals("<div></div>", div().close());
        assertEquals("<span></span>", span().close());
        assertEquals("<h1></h1>", h1().close());
        assertEquals("<h2></h2>", h2().close());
        assertEquals("<h3></h3>", h3().close());
        assertEquals("<h4></h4>", h4().close());
        assertEquals("<h5></h5>", h5().close());
        assertEquals("<h6></h6>", h6().close());
        assertEquals("<p></p>", p().close());
        assertEquals("<em></em>", em().close());
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
        assertEquals("<img id=\"image\" src=\"pic.png\" width=\"100\" height=\"200\" />", img(id("image"), src("pic.png"), width(100), height(200)));
        assertEquals("<input type=\"checkbox\" />", checkbox());
        assertEquals("<meta charset=\"UTF-8\" />", meta(attr("charset", "UTF-8")));
        assertEquals("<textarea value=\"Foo\" />", textarea("Foo"));
    }

    @Test
    public void testA() throws Exception {
        assertEquals("<a href=\"http://\" target=\"_blank\" title=\"tooltip\">Hello</a>", a(href("http://"), target("_blank"), title("tooltip")).with(text("Hello")));
    }

    @Test
    public void testEmptyDivWithAttributes() throws Exception {
        ContainerTag div = div(style("display: none;"), cls("class1", "class2"), id("something"), data("base", "sql"), attr("onclick", "alert('hello');")).close();
        assertEquals("<div style=\"display: none;\" class=\"class1 class2\" id=\"something\" data-base=\"sql\" onclick=\"alert('hello');\"></div>", div);
    }

    @Test
    public void testWithBody() throws Exception {
        ContainerTag div = div().with(div().close(), div().close());
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

    @Test
    public void testBodyWithoutText() throws Exception {
        ContainerTag div = div().with("Hello", " ", "world!");
        assertEquals("<div>Hello world!</div>", div);
    }

    @Test
    public void testConditionalAttribute() throws Exception {
        ContainerTag div = div(when(true, cls("foo")), when(false, id("no-id"))).close();
        assertEquals("<div class=\"foo\"></div>", div);
    }
}
