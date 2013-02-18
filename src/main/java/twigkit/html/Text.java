package twigkit.html;

import java.io.IOException;
import java.io.Writer;

/**
 * Add a text node with no wrapping elements.
 *
 * @author mr.olafsson
 */
public class Text extends Content {

    public Text(Writer writer, String text) throws IOException {
        super(writer);
        if (text != null) {
            writer.write(text);
        }
    }
}
