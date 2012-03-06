package twigkit.html;

import twigkit.html.attr.Attribute;

import java.io.IOException;
import java.io.Writer;

/**
 *
 */
public class ContainerTag extends Tag {

    public ContainerTag(Writer writer, String name, Attribute... attributes) throws IOException {
        super(writer, name, attributes);
        open();
    }

    public ContainerTag body(Content... html) throws IOException {
        close();
        return this;
    }

    public ContainerTag append(Content... html) {
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
