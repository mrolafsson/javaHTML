package twigkit.html;

import twigkit.html.attr.Attribute;

import java.io.Writer;

/**
 *
 */
public class Tag {

    public static final String DIV = "div", SPAN = "span", H1 = "h1", H2 = "h2", H3 = "h3", H4 = "h4", P = "p",
            UL = "ul", OL = "ol", LI = "li", DL = "dl", DT = "dt", DD = "dd", A = "a", IMG = "img", FORM = "form",
            INPUT = "input", FIELDSET = "fieldset", LEGEND = "legend", SCRIPT = "script";

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
