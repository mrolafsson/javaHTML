package twigkit.markup;

import org.junit.Test;
import twigkit.markup.html.*;

import java.io.IOException;

/**
 * Unit tests for the {@link twigkit.markup.html.HtmlCapabilityImpl} class.
 *
 * @author mr.olafsson
 */
public class MarkupCapabilityTest extends AbstractMarkupCapabilityTest {

    @Test
    public void testConditionalElement() throws Exception {
        Object number = 10;
        Object value = "foo";
        assertEquals("<numbers><number>10</number><invalid>foo</invalid></numbers>", el("numbers").with(
                when(number instanceof Integer).use(
                        el("number").with(text(number))
                ).otherwise(
                        el("invalid").with(text(number))
                ),
                when(value instanceof Integer).use(
                        el("number").with(text(value))
                ).otherwise(
                        el("invalid").with(text(value))
                )
        ));
    }

    @Test
    public void testConditionalAttribute() throws Exception {
        assertEquals("<number class=\"foo\"></number>", el("number", when(true, cls("foo")), when(false, id("no-id"))).close());

    }

    @Test
    public void testExec() throws Exception {
        final String[] message = {"foo"};

        assertEquals("<code><foo>foo</foo><bar>bar</bar></code>",
                el("code").with(
                el("foo").with(
                        text(message[0])
                ),

                exec(new twigkit.markup.html.Code() {
                    @Override
                    public void run() throws IOException {
                        message[0] = "bar";
                    }
                }),
                el("bar").with(
                        text(message[0])
                )
        ));
    }

    @Test
    public void testIterate() throws Exception {
        assertEquals("<numbers><number>1</number><number>2</number><number>3</number></numbers>", el("numbers").with(
                iterate(new Loop<Integer>(1, 2, 3) {
                    @Override
                    public void each(Integer number) throws Exception {
                        el("number").with(text(number));
                    }
                })
        ));
    }

    @Test
    public void testContainerElements() throws Exception {
        assertEquals("<xml></xml>", el("xml").close());
    }

    @Test
    public void testText() throws Exception {
        assertEquals("Hello world!", text("Hello world!"));
    }
}
