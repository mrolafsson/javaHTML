package twigkit.html.helper;

import twigkit.html.Div;
import twigkit.html.Text;
import twigkit.html.attr.Attribute;

import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.io.Writer;

/**
 * @author mr.olafsson
 */
public class BodyTagSupportWithHTML extends BodyTagSupport {

    private Writer writer;

    public BodyTagSupportWithHTML(Writer writer) {
        this.writer = writer;
    }



    public Div div(Attribute... attr) throws IOException {
        return new Div(writer, attr);
    }

    public Text text(String text) throws IOException {
        return new Text(writer, text);
    }



    public Attribute attr(String name, String... values) {
        return new Attribute(name, values);
    }

    public Attribute.Css css(String... values) {
        return new Attribute.Css(values);
    }

    public Attribute.Id id(String id) {
        return new Attribute.Id(id);
    }

    public Attribute.Data data(String name, String value) {
        return new Attribute.Data(name, value);
    }
}
