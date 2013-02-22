package twigkit.html;

import twigkit.html.attr.Attribute;

import java.io.IOException;
import java.io.Writer;

/**
 * Any type of HTML element is represented as a {@link Tag}.
 *
 * @author mr.olafsson
 */
public class Tag extends Content {

    public static final String HTML = "html", BODY = "body", HEAD = "head", META = "meta", DIV = "div", SPAN = "span", EM = "em", H1 = "h1", H2 = "h2", H3 = "h3", H4 = "h4", H5 = "h5", H6 = "h6", P = "p",
            UL = "ul", OL = "ol", LI = "li", DL = "dl", DT = "dt", DD = "dd", A = "a", IMG = "img", FORM = "form",
            INPUT = "input", FIELDSET = "fieldset", LEGEND = "legend", SCRIPT = "script", TEXTAREA = "textarea";

    public static final String LT = "<", GT = ">", SLASH = "/", SPACE = " ";

    protected final String name;
    protected final Attribute[] attributes;

    public Tag(Writer writer, String name, Attribute... attributes) throws IOException {
        super(writer);
        this.name = name;
        this.attributes = attributes;
    }
}
