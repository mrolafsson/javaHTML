package twigkit.html;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import static junit.framework.Assert.assertTrue;

/**
 * Unit tests for the {@link Code} class and the {@link #exec(Code)} method.
 *
 * @author mr.olafsson
 */
public class CodeTest extends AbstractHtmlCapabilityTest {

    @Test
    public void testTomAndJerry() throws Exception {
        final Random random = new Random();
        Content statement = h1().with(
                text("Tom "),
                exec(new Code() {
                    @Override
                    public void run() throws IOException {
                        if (random.nextBoolean()) {
                            em().with("hates");
                        } else {
                            span().with("likes");
                        }
                    }
                }),
                text(" Jerry")
        );
        System.out.println(statement);
    }

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

    @Test
    public void testConditionalCode() throws Exception {
        final List<String> list = new ArrayList<String>();

        ContainerTag div = div().with(
                when(true).use(
                        exec(new Code() {
                            @Override
                            public void run() throws IOException {
                                list.add("Groucho");
                            }
                        })
                ).otherwise(
                        exec(new Code() {
                            @Override
                            public void run() throws IOException {
                                list.add("Tom");
                            }
                        })
                ),
                when(false).use(
                        exec(new Code() {
                            @Override
                            public void run() throws IOException {
                                list.add("Zeppo");
                            }
                        })
                ).otherwise(
                        exec(new Code() {
                            @Override
                            public void run() throws IOException {
                                list.add("Jerry");
                            }
                        })
                )
        );
        assertTrue(list.size() == 2);
        assertTrue("Groucho".equals(list.get(0)));
        assertTrue("Jerry".equals(list.get(1)));
    }
}
