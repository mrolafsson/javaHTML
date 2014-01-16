package twigkit.html;

import twigkit.html.attr.Attribute;

import java.io.IOException;
import java.io.Writer;

/**
 * Extend or statically import {@link HtmlCapabilityImpl} to use the helper methods that create {@link Content}.
 *
 * @author mr.olafsson
 */
public class HtmlCapabilityImpl implements HtmlCapability {

    private Writer writer;
    private Class context;

    public HtmlCapabilityImpl() {
        this((Class) null);
    }

    public HtmlCapabilityImpl(Class context) {
        this(null, context);
    }

    public HtmlCapabilityImpl(Writer writer) {
        this(writer, HtmlCapabilityImpl.class);
    }

    public HtmlCapabilityImpl(Writer writer, Class context) {
        this.writer = writer;
        this.context = context;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public ContainerTag html(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.HTML, context, attr);
    }

    @Override
    public ContainerTag body(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.BODY, context, attr);
    }

    @Override
    public ContainerTag head(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.HEAD, context, attr);
    }

    @Override
    public Content meta(Attribute... attr) throws IOException {
        return new SelfClosingTag(writer, Tag.META, attr);
    }

    @Override
    public ConditionalWrapper when(boolean test) {
        if (!test) {
            this.writer = new DummyWriter(this);
        }
        return new ConditionalWrapper.Use(this);
    }

    @Override
    public Content exec(Code code) throws IOException {
        code.setWriter(writer);
        if (writer != null && !(writer instanceof DummyWriter)) {
            code.run();
        }
        return new Content(writer);
    }

    @Override
    public ContainerTag div(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DIV, context, attr);
    }

    @Override
    public ContainerTag span(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.SPAN, context, attr);
    }

    @Override
    public ContainerTag em(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.EM, context, attr);
    }

    @Override
    public ContainerTag h1(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H1, context, attr);
    }

    @Override
    public ContainerTag h2(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H2, context, attr);
    }

    @Override
    public ContainerTag h3(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H3, context, attr);
    }

    @Override
    public ContainerTag h4(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H4, context, attr);
    }

    @Override
    public ContainerTag h5(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H5, context, attr);
    }

    @Override
    public ContainerTag h6(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H6, context, attr);
    }

    @Override
    public ContainerTag p(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.P, context, attr);
    }

    @Override
    public ContainerTag ul(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.UL, context, attr);
    }

    @Override
    public ContainerTag ol(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.OL, context, attr);
    }

    @Override
    public ContainerTag li(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.LI, context, attr);
    }

    @Override
    public ContainerTag dl(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DL, context, attr);
    }

    @Override
    public ContainerTag dt(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DT, context, attr);
    }

    @Override
    public ContainerTag dd(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DD, context, attr);
    }

    @Override
    public ContainerTag a(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.A, context, attr);
    }

    @Override
    public SelfClosingTag img(Attribute... attr) throws IOException {
        return new SelfClosingTag(writer, Tag.IMG, attr);
    }

    @Override
    public ContainerTag form(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.FORM, context, attr);
    }

    @Override
    public ContainerTag input(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.INPUT, context, attr);
    }

    @Override
    public SelfClosingTag textarea(String value, Attribute... attr) throws IOException {
        return new SelfClosingTag(writer, Tag.TEXTAREA, attr("value", value), attr);
    }

    @Override
    public SelfClosingTag checkbox(Attribute... attr) throws IOException {
        return new SelfClosingTag(writer, Tag.INPUT, attr("type", "checkbox"), attr);
    }

    @Override
    public ContainerTag fieldset(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.FIELDSET, context, attr);
    }

    @Override
    public ContainerTag legend(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.LEGEND, context, attr);
    }

    @Override
    public ContainerTag script(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.SCRIPT, context, attr);
    }

    @Override
    public ContainerTag custom(String name, Attribute... attr) throws IOException {
        return new ContainerTag(writer, name, context, attr);
    }

    @Override
    public Text text(Object text) throws IOException {
        return new Text(writer, text);
    }

    // Attributes

    @Override
    public Attribute when(boolean test, Attribute attr) {
        if (test) {
            return attr;
        }
        return null;
    }

    @Override
    public Attribute attr(String name, String... values) {
        return new Attribute(name, values);
    }

    @Override
    public Attribute.Class cls(String... values) {
        return new Attribute.Class(values);
    }

    @Override
    public Attribute.Id id(String id) {
        return new Attribute.Id(id);
    }

    @Override
    public Attribute.Data data(String name, String value) {
        return new Attribute.Data(name, value);
    }

    @Override
    public Attribute.Href href(String value) {
        return new Attribute.Href(value);
    }

    @Override
    public Attribute.Src src(String value) {
        return new Attribute.Src(value);
    }

    @Override
    public Attribute.Target target(String value) {
        return new Attribute.Target(value);
    }

    @Override
    public Attribute.Title title(String value) {
        return new Attribute.Title(value);
    }

    @Override
    public Attribute.Style style(String value) {
        return new Attribute.Style(value);
    }

    @Override
    public Attribute.Height height(int value) {
        return new Attribute.Height(value);
    }

    @Override
    public Attribute.Width width(int value) {
        return new Attribute.Width(value);
    }

    @Override
    public Content iterate(Loop iterate) {
        iterate.run();
        return new Content(writer);
    }

    @Override
    public Content component(Component component) throws IOException {
        component.render(this);
        return new Content(getWriter());
    }
}
