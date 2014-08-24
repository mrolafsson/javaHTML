package twigkit.markup;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Use the {@link XML} class to generate XML without using helpers.
 *
 * @author mr.olafsson
 */
public abstract class XML extends MarkupCapabilityImpl {

    private Writer writer;

    protected XML() {
        this(new StringWriter());
    }

    protected XML(Writer writer) {
        super(writer, XML.class);
        this.writer = writer;

        try {
            create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implement to get access to {@link twigkit.markup.MarkupCapability} methods. Output will be written to the {@link java.io.Writer} implementation
     * provided in the constructor of the {@link XML} class, or alternatively using a simple {@link java.io.StringWriter} used
     * for the {@link #toString()} fallback.
     *
     * @throws java.io.IOException
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
