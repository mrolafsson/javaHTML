package twigkit.markup.html;

import twigkit.markup.Attribute;
import twigkit.markup.Element;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by hjortur on 28/04/2014.
 */
public class HtmlTag extends Element {

    public static final String HTML = "html", BODY = "body", HEAD = "head", META = "meta", DIV = "div", SPAN = "span", EM = "em", H1 = "h1", H2 = "h2", H3 = "h3", H4 = "h4", H5 = "h5", H6 = "h6", P = "p",
            UL = "ul", OL = "ol", LI = "li", DL = "dl", DT = "dt", DD = "dd", A = "a", IMG = "img", FORM = "form",
            INPUT = "input", FIELDSET = "fieldset", LEGEND = "legend", SCRIPT = "script", TEXTAREA = "textarea";


    public HtmlTag(Writer writer, String name, Attribute... attributes) throws IOException {
        super(writer, name, attributes);
    }
}
