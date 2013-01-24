package twigkit.html;

import java.io.IOException;
import java.io.Writer;

/**
 *
 */
public class Text extends Content {

    public Text(Writer writer, String text) throws IOException {
        super(writer);
        if (text != null) {
            writer.write(text);
        }
    }
}
