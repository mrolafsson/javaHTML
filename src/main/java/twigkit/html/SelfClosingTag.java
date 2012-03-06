package twigkit.html;

import twigkit.html.attr.Attribute;

import java.io.IOException;
import java.io.Writer;

/**
 *
 */
public class SelfClosingTag extends Tag {

    public SelfClosingTag(Writer writer, String name, Attribute... attributes) throws IOException {
        super(writer, name, attributes);
        writer.write(LT);
        writer.write(name);
        Attribute.write(writer, attributes);
        writer.write(SPACE);
        writer.write(SLASH);
        writer.write(GT);
    }
}
