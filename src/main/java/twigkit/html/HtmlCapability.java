package twigkit.html;

import twigkit.html.attr.Attribute;

import java.io.IOException;
import java.io.Writer;

/**
 * @author mr.olafsson
 */
public class HtmlCapability {

    private Writer writer;

    public HtmlCapability(Writer writer) {
        this.writer = writer;
    }

    protected void setWriter(Writer writer) {
        this.writer = writer;
    }

    public ContainerTag div(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DIV, attr);
    }

    public ContainerTag span(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.SPAN, attr);
    }

    public ContainerTag h1(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H1, attr);
    }

    public ContainerTag h2(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H2, attr);
    }

    public ContainerTag h3(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H3, attr);
    }

    public ContainerTag h4(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H4, attr);
    }

    public ContainerTag p(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.P, attr);
    }

    public ContainerTag ul(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.UL, attr);
    }

    public ContainerTag ol(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.OL, attr);
    }

    public ContainerTag li(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.LI, attr);
    }

    public ContainerTag dl(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DL, attr);
    }


    public ContainerTag dt(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DT, attr);
    }

    public ContainerTag dd(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DD, attr);
    }

    public ContainerTag a(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.A, attr);
    }

    public SelfClosingTag img(Attribute... attr) throws IOException {
        return new SelfClosingTag(writer, Tag.IMG, attr);
    }

    public ContainerTag form(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.FORM, attr);
    }

    public ContainerTag input(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.INPUT, attr);
    }

    public ContainerTag fieldset(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.FIELDSET, attr);
    }

    public ContainerTag legend(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.LEGEND, attr);
    }

    public ContainerTag script(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.SCRIPT, attr);
    }

    public ContainerTag custom(String name, Attribute... attr) throws IOException {
        return new ContainerTag(writer, name, attr);
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
