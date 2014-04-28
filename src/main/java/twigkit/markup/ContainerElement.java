package twigkit.markup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twigkit.markup.html.HtmlAttribute;

import java.io.IOException;
import java.io.Writer;

/**
 * Represents HTML elements or {@link Tag}s that can contain other elements or content.
 *
 * @author mr.olafsson
 */
public class ContainerElement extends Tag {

    private static final Logger logger = LoggerFactory.getLogger(ContainerElement.class);

    private Class context;
    private int state;

    public ContainerElement(Writer writer, String name, Attribute... attributes) throws IOException {
        this(writer, name, ContainerElement.class, attributes);
    }

    public ContainerElement(Writer writer, String name, Class context, Attribute... attributes) throws IOException {
        super(writer, name, attributes);
        open();
        this.context = context;
    }

    public ContainerElement with(Content... html) throws IOException {
        close();
        return this;
    }

    public ContainerElement with(String... text) throws IOException {
        append(text);
        close();
        return this;
    }

    public ContainerElement append(Content... html) {
        return this;
    }

    public ContainerElement append(String... text) {
        try {
            for (String s : text) {
                new Text(writer, s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    private ContainerElement open() throws IOException {
        state++;
        writer.write(LT);
        writer.write(name);
        HtmlAttribute.write(writer, attributes);
        writer.write(GT);

        return this;
    }

    public ContainerElement close() throws IOException {
        if (state > 0) {
            state--;
            writer.write(LT);
            writer.write(SLASH);
            writer.write(name);
            writer.write(GT);
        } else {
            logger.warn(String.format("Attempting to close an already closed <%s> tag in %s", name, context));
            throw new MarkupException(MarkupException.Type.TAG_ALREADY_CLOSED, String.format("Attempting to close an already closed <%s> tag in %s", name, context));
        }
        return this;
    }

    public boolean validate() throws MarkupException {
        if (state > 0) {
            logger.warn(String.format("<%s> tag not closed when used in class %s", name, context));
            throw new MarkupException(MarkupException.Type.UNCLOSED_TAG, String.format("<%s> tag not closed when used in %s", name, context));
        }
        return state == 0;
    }

    @Override
    protected void finalize() throws Throwable {
        validate();
    }
}
