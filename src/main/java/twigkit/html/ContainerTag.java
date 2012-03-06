package twigkit.html;

import twigkit.html.attr.Attribute;

import java.io.IOException;
import java.io.Writer;

/**
 *
 */
public class ContainerTag extends Tag {

    private final String name;
    private final Attribute[] attributes;

    public ContainerTag(Writer writer, String name, Attribute... attributes) throws IOException {
        super(writer);
        this.name = name;
        this.attributes = attributes;
        open();
    }

    public ContainerTag body(Tag... html) throws IOException {
        close();
        return this;
    }

    public ContainerTag append(Tag... html) {
        return this;
    }

    private ContainerTag open() throws IOException {
        writer.write(LT);
        writer.write(name);
        Attribute.write(writer, attributes);
        writer.write(GT);

        return this;
    }

    public ContainerTag close() throws IOException {
        writer.write(LT);
        writer.write(SLASH);
        writer.write(name);
        writer.write(GT);

        return this;
    }
}
