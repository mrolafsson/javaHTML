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
        return writer.toString();
    }
}
