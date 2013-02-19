package twigkit.html;

import org.junit.Test;

import java.io.IOException;

/**
 * Unit tests for the {@link Code} class and the {@link #exec(Code)} method.
 *
 * @author mr.olafsson
 */
public class CodeTest extends AbstractHtmlCapabilityTest {

    @Test
    public void testCodeWrapper() throws Exception {
        final String[] message = {"foo"};

        ContainerTag div = div().with(
                span().with(
                        text(message[0])
                ),

                exec(new Code() {
                    @Override
                    public void run() throws IOException {
                        message[0] = "bar";
                    }
                }),

                span().with(
                        text(message[0])
                )
        );
        assertEquals("<div><span>foo</span><span>bar</span></div>", div);
    }

    @Test
    public void testCodeWrapperWithHTML() throws Exception {
        ContainerTag div = div().with(
                span().with(
                        text("foo")
                ),
                exec(new Code() {
                    @Override
                    public void run() throws IOException {
                        text("&nbsp;");
                    }
                }),
                span().with(
                        text("bar")
                )
        );
        assertEquals("<div><span>foo</span>&nbsp;<span>bar</span></div>", div);
    }
}
