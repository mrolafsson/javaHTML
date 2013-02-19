package twigkit.html;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twigkit.html.attr.Attribute;

import java.io.IOException;
import java.io.Writer;

/**
 * Represents HTML elements or {@link Tag}s that can contain other elements or content.
 *
 * @author mr.olafsson
 */
public class ContainerTag extends Tag {

    private static final Logger logger = LoggerFactory.getLogger(ContainerTag.class);

    private Class context;
    private int state;

    public ContainerTag(Writer writer, String name, Attribute... attributes) throws IOException {
        this(writer, name, ContainerTag.class, attributes);
    }

    public ContainerTag(Writer writer, String name, Class context, Attribute... attributes) throws IOException {
        super(writer, name, attributes);
        open();
        this.context = context;
    }

    public ContainerTag with(Content... html) throws IOException {
        close();
        return this;
    }

    public ContainerTag with(String... text) throws IOException {
        append(text);
        close();
        return this;
    }

    public ContainerTag append(Content... html) {
        return this;
    }

    public ContainerTag append(String... text) {
        try {
            for (String s : text) {
                new Text(writer, s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    private ContainerTag open() throws IOException {
        state++;
        writer.write(LT);
        writer.write(name);
        Attribute.write(writer, attributes);
        writer.write(GT);

        return this;
    }

    public ContainerTag close() throws IOException {
        if (state > 0) {
            state--;
            writer.write(LT);
            writer.write(SLASH);
            writer.write(name);
            writer.write(GT);
        } else {
            logger.warn(String.format("Attempting to close an already closed <%s> tag in %s", name, context));
            throw new HtmlException(HtmlException.Type.TAG_ALREADY_CLOSED, String.format("Attempting to close an already closed <%s> tag in %s", name, context));
        }
        return this;
    }

    public boolean validate() throws HtmlException {
        if (state > 0) {
            logger.warn(String.format("<%s> tag not closed when used in class %s", name, context));
            throw new HtmlException(HtmlException.Type.UNCLOSED_TAG, String.format("<%s> tag not closed when used in %s", name, context));
        }
        return state == 0;
    }

    @Override
    protected void finalize() throws Throwable {
        validate();
    }
}
