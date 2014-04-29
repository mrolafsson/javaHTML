package twigkit.markup;

import java.io.IOException;
import java.io.Writer;

/**
 * Add a text node with no wrapping elements.
 *
 * @author mr.olafsson
 */
public class Text extends Content {

    public Text(Writer writer, Object text) throws IOException {
        super(writer);
        if (text != null) {
            writer.write(text.toString());
        }
    }

    public Text(Writer writer, String text, Object... data) throws IOException {
        super(writer);
        if (text != null) {
           if (data.length > 0) {
               writer.write(String.format(text, data));
           } else {
               writer.write(text);
           }
        }
    }
}
