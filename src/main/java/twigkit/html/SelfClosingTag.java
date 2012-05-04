package twigkit.html;

import twigkit.html.attr.Attribute;

import java.io.IOException;
import java.io.Writer;

/**
 *
 */
public class SelfClosingTag extends Tag {

    public SelfClosingTag(Writer writer, String name, Attribute... attributes) throws IOException {
        this(writer, name, null, attributes);
    }

    /**
     * Accepts a specific attribute in addition to arguments, useful when e.g. creating an 'input' tag with a given
     * type.
     *
     * @param writer
     * @param name
     * @param attribute
     * @param attributes
     * @throws IOException
     */
    public SelfClosingTag(Writer writer, String name, Attribute attribute, Attribute... attributes) throws IOException {
        super(writer, name, attributes);
        writer.write(LT);
        writer.write(name);
        if (attribute != null) {
        Attribute.write(writer, attribute);
            writer.write(SPACE);
        }
        Attribute.write(writer, attributes);
        writer.write(SPACE);
        writer.write(SLASH);
        writer.write(GT);
    }
}
