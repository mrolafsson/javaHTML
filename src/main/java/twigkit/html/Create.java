package twigkit.html;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author mr.olafsson
 */
public abstract class Create extends HtmlCapability {

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
