package twigkit.markup;

import java.io.IOException;
import java.io.Writer;

/**
 * Represents tags that can be self-closing e.g. `<img src="" />`, <br />.
 *
 * @author mr.olafsson
 */
public class SelfClosingElement extends Element {

    public SelfClosingElement(Writer writer, String name, Attribute... attributes) throws IOException {
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
    public SelfClosingElement(Writer writer, String name, Attribute attribute, Attribute... attributes) throws IOException {
        super(writer, name, attributes);
        writer.write(LT);
        writer.write(name);
        if (attribute != null) {
            Attribute.write(writer, attribute);
            writer.write(SPACE);
        }
        Attribute.write(writer, attributes);
        if (attributes != null && attributes.length > 0) {
            writer.write(SPACE);
        }
        writer.write(SLASH);
        writer.write(GT);
    }
}
