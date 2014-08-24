package twigkit.markup.html;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Use the {@link HTML} class to generate HTML without using helpers such as {@link twigkit.markup.html.helper.HtmlHttpServlet}
 * or {@link twigkit.markup.html.helper.HtmlSimpleTagSupport}.
 *
 * @author mr.olafsson
 */
public abstract class HTML extends HtmlCapabilityImpl {

    private Writer writer;

    protected HTML() {
        this(new StringWriter());
    }

    protected HTML(Writer writer) {
        super(writer, HTML.class);
        this.writer = writer;

        try {
            create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implement to get access to {@link HtmlCapabilityImpl} methods. Output will be written to the {@link Writer} implementation
     * provided in the constructor of the {@link HTML} class, or alternatively using a simple {@link StringWriter} used
     * for the {@link #toString()} fallback.
     *
     * @throws IOException
     */
    public abstract void create() throws IOException;

    @Override
    public String toString() {
        if (writer != null) {
            return writer.toString();
        } else {
            return "";
        }
    }
}
