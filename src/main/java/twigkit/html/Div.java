package twigkit.html;

import twigkit.html.attr.Attribute;

import java.io.IOException;
import java.io.Writer;

/**
 *
 */
public class Div extends Tag {

    private static final String DIV = "div";

    public Div(Writer writer, Attribute... attr) throws IOException {
        super(writer);
        open(attr);
    }

    public Div empty() throws IOException {
        close();
        return this;
    }

    public Div body(Tag... html) throws IOException {
        close();
        return this;
    }

    private void open(Attribute... attr) throws IOException {
        writer.write(LT);
        writer.write(DIV);
        Attribute.write(writer, attr);
        writer.write(GT);
    }

    private void close() throws IOException {
        writer.write(LT);
        writer.write(SLASH);
        writer.write(DIV);
        writer.write(GT);
    }
}
