package twigkit.html;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twigkit.html.attr.Attribute;

import java.io.IOException;
import java.io.Writer;

/**
 *
 */
public class ContainerTag extends Tag {

    private static final Logger logger = LoggerFactory.getLogger(ContainerTag.class);

    private int state;

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
            logger.warn(String.format("Attempting to close an already closed <%s> tag", name));
            throw new HtmlException(HtmlException.Type.TAG_ALREADY_CLOSED, String.format("Attempting to close an already closed <%s> tag", name));
        }
        return this;
    }

    public boolean validate() throws HtmlException {
        if (state > 0) {
            logger.warn(String.format("<%s> tag not closed", name));
            throw new HtmlException(HtmlException.Type.UNCLOSED_TAG, String.format("<%s> tag not closed", name));
        }
        return state == 0;
    }

    @Override
    protected void finalize() throws Throwable {
        validate();
    }
}
