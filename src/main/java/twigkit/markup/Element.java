package twigkit.markup;

import java.io.IOException;
import java.io.Writer;

/**
 * Any type of XML element is represented as a {@link Element}.
 *
 * @author mr.olafsson
 */
public class Element extends Content {

    public static final String LT = "<", GT = ">", SLASH = "/", SPACE = " ";

    protected final String name;
    protected final Attribute[] attributes;

    public Element(Writer writer, String name, Attribute... attributes) throws IOException {
        super(writer);
        this.name = name;
        this.attributes = attributes;
    }
}
