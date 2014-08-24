package twigkit.markup.html;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static junit.framework.Assert.assertEquals;

/**
 * @author mr.olafsson
 */
public class HTMLTest {

    @Test
    public void testToString() throws Exception {
        assertEquals("<html><head><meta charset=\"UTF-8\" /></head><body><h1>Hello world!</h1></body></html>",
                new HTML() {
                    @Override
                    public void create() throws IOException {
                        html().with(
                                head().with(
                                        meta(attr("charset", "UTF-8"))
                                ),
                                body().with(
                                        h1().with("Hello world!")
                                )
                        ).validate();
                    }
                }.toString());
    }

    @Test
    public void testWithWriter() throws Exception {
        StringWriter writer = new StringWriter();
        new HTML(writer) {
            @Override
            public void create() throws IOException {
                div().with("Hello world!");
            }
        };

        assertEquals("<div>Hello world!</div>", writer.toString());
    }
}
