package twigkit.html;

import twigkit.html.attr.Attribute;

import java.io.IOException;
import java.io.Writer;

/**
 *
 */
public class Div extends Tag {

    private static final String DIV = "div";
    private final Attribute[] attributes;

    public Div(Writer writer, Attribute... attributes) throws IOException {
        super(writer);
        this.attributes = attributes;
        open();
    }

    public Div empty() throws IOException {
        close();
        return this;
    }

    public Div body(Tag... html) throws IOException {
        close();
        return this;
    }

    public Div append(Tag... html) {
        return this;
    }

    private Div open() throws IOException {
        writer.write(LT);
        writer.write(DIV);
        Attribute.write(writer, attributes);
        writer.write(GT);

        return this;
    }

    public Div close() throws IOException {
        writer.write(LT);
        writer.write(SLASH);
        writer.write(DIV);
        writer.write(GT);

        return this;
    }
}
