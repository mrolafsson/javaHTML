package twigkit.html;

import java.io.IOException;
import java.io.Writer;

/**
 *
 */
public class Text extends Tag {

    public Text(Writer writer, String text) throws IOException {
        super(writer);
        writer.write(text);
    }
}
