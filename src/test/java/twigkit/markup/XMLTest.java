package twigkit.markup;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static junit.framework.Assert.assertEquals;

/**
 * @author mr.olafsson
 */
public class XMLTest {

    @Test
    public void testToString() throws Exception {
        assertEquals("<html><head><meta charset=\"UTF-8\"></meta></head><body><h1>Hello world!</h1></body></html>",
                new XML() {
                    @Override
                    public void create() throws IOException {
                        el("html").with(
                                el("head").with(
                                        el("meta", attr("charset", "UTF-8")).close()
                                ),
                                el("body").with(
                                        el("h1").with("Hello world!")
                                )
                        ).validate();
                    }
                }.toString());
    }

    @Test
    public void testWithWriter() throws Exception {
        StringWriter writer = new StringWriter();
        new XML(writer) {
            @Override
            public void create() throws IOException {
                el("foo").with("Hello world!");
            }
        };

        assertEquals("<foo>Hello world!</foo>", writer.toString());
    }
}
