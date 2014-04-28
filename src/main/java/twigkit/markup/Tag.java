package twigkit.markup;

import java.io.IOException;
import java.io.Writer;

/**
 * Any type of HTML element is represented as a {@link Tag}.
 *
 * @author mr.olafsson
 */
public class Tag extends Content {

    public static final String LT = "<", GT = ">", SLASH = "/", SPACE = " ";

    protected final String name;
    protected final Attribute[] attributes;

    public Tag(Writer writer, String name, Attribute... attributes) throws IOException {
        super(writer);
        this.name = name;
        this.attributes = attributes;
    }
}
