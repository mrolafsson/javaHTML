package twigkit.html.helper;

import twigkit.html.ContainerTag;
import twigkit.html.SelfClosingTag;
import twigkit.html.Tag;
import twigkit.html.Text;
import twigkit.html.attr.Attribute;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.Writer;

/**
 * @author mr.olafsson
 */
public abstract class SimpleTagSupportWithHtml extends SimpleTagSupport {

    private Writer writer;
    private Class context;

    @Override
    public void doTag() throws JspException, IOException {
        setWriter(getJspContext().getOut());
    }

    public SimpleTagSupportWithHtml() {
        this(SimpleTagSupportWithHtml.class);
    }

    public SimpleTagSupportWithHtml(Class context) {
        this.context = context;
    }

    protected void setWriter(Writer writer) {
        this.writer = writer;
    }

    public ContainerTag div(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DIV, context, attr);
    }

    public ContainerTag span(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.SPAN, context, attr);
    }

    public ContainerTag h1(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H1, context, attr);
    }

    public ContainerTag h2(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H2, context, attr);
    }

    public ContainerTag h3(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H3, context, attr);
    }

    public ContainerTag h4(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H4, context, attr);
    }

    public ContainerTag p(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.P, context, attr);
    }

    public ContainerTag ul(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.UL, context, attr);
    }

    public ContainerTag ol(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.OL, context, attr);
    }

    public ContainerTag li(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.LI, context, attr);
    }

    public ContainerTag dl(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DL, context, attr);
    }

    public ContainerTag dt(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DT, context, attr);
    }

    public ContainerTag dd(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DD, context, attr);
    }

    public ContainerTag a(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.A, context, attr);
    }

    public SelfClosingTag img(Attribute... attr) throws IOException {
        return new SelfClosingTag(writer, Tag.IMG, attr);
    }

    public ContainerTag form(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.FORM, context, attr);
    }

    public ContainerTag input(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.INPUT, context, attr);
    }

    public ContainerTag fieldset(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.FIELDSET, context, attr);
    }

    public ContainerTag legend(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.LEGEND, context, attr);
    }

    public ContainerTag script(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.SCRIPT, context, attr);
    }

    public ContainerTag custom(String name, Attribute... attr) throws IOException {
        return new ContainerTag(writer, name, context, attr);
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

    public Attribute.Href href(String value) {
        return new Attribute.Href(value);
    }

    public Attribute.Src src(String value) {
        return new Attribute.Src(value);
    }

    public Attribute.Target target(String value) {
        return new Attribute.Target(value);
    }

    public Attribute.Title title(String value) {
        return new Attribute.Title(value);
    }
}
