package twigkit.html;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Use the {@link Create} class to generate HTML without using helpers such as {@link twigkit.html.helper.HtmlHttpServlet}
 * or {@link twigkit.html.helper.HtmlSimpleTagSupport}.
 *
 * @author mr.olafsson
 */
public abstract class Create extends HtmlCapabilityImpl {

    private Writer writer;

    protected Create() {
        this(new StringWriter());
    }

    protected Create(Writer writer) {
        super(writer, Create.class);
        this.writer = writer;

        try {
            markup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implement to get access to {@link HtmlCapabilityImpl} methods. Output will be written to the {@link Writer} implementation
     * provided in the constructor of the {@link Create} class, or alternatively using a simple {@link StringWriter} used
     * for the {@link #toString()} fallback.
     *
     * @throws IOException
     */
    public abstract void markup() throws IOException;

    @Override
    public String toString() {
        if (writer != null) {
            return writer.toString();
        } else {
            return "";
        }
    }
}
