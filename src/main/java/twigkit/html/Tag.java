package twigkit.html;

import twigkit.html.attr.Attribute;

import java.io.Writer;

/**
 *
 */
public class Tag {

    public static final String LT = "<", GT = ">", SLASH = "/", SPACE = " ";

    protected Writer writer;

    public Tag(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return writer.toString();
    }
}
