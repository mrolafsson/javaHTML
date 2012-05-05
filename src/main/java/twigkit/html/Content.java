package twigkit.html;

import java.io.Writer;

/**
 *
 */
public class Content {

    protected Writer writer;

    public Content(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        if (writer != null) {
            return writer.toString();
        } else {
            return "";
        }
    }
}
