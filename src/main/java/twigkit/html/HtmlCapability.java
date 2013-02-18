package twigkit.html;

import twigkit.html.attr.Attribute;

import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.io.Writer;

/**
 * Extend or statically import {@link HtmlCapability} to use the helper methods that create {@link Content}.
 *
 * @author mr.olafsson
 */
public class HtmlCapability {

    private Writer writer;
    private Class context;

    public HtmlCapability() {
        this((Class) null);
    }

    public HtmlCapability(Class context) {
        this(null, context);
    }

    public HtmlCapability(Writer writer) {
        this(writer, HtmlCapability.class);
    }

    public HtmlCapability(Writer writer, Class context) {
        this.writer = writer;
        this.context = context;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    /**
     * Start conditional output.
     *
     * @param test
     * @return
     */
    public ConditionalWrapper when(boolean test) {
        if (!test) {
            this.writer = new DummyWriter(this);
        }
        return new ConditionalWrapper.Use(this);
    }

    /**
     * Execute code inline by passing in and implementing an instance of {@link Code}.
     *
     * @param code
     * @return
     * @throws JspException
     * @throws IOException
     */
    public Content exec(Code code) throws JspException, IOException {
        code.setWriter(writer);
        code.run();
        return new Content(writer);
    }

    /**
     * Create a 'div' element.
     *
     * @param attr
     * @return
     * @throws IOException
     */
    public ContainerTag div(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.DIV, context, attr);
    }

    /**
     * Create a 'span' element.
     *
     * @param attr
     * @return
     * @throws IOException
     */
    public ContainerTag span(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.SPAN, context, attr);
    }

    /**
     * Create an 'h1' element.
     * @param attr
     * @return
     * @throws IOException
     */
    public ContainerTag h1(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H1, context, attr);
    }

    /**
     * Create an 'h2' element.
     *
     * @param attr
     * @return
     * @throws IOException
     */
    public ContainerTag h2(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H2, context, attr);
    }

    /**
     * Create an 'h3' element.
     *
     * @param attr
     * @return
     * @throws IOException
     */
    public ContainerTag h3(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H3, context, attr);
    }

    /**
     * Create an 'h4' element.
     *
     * @param attr
     * @return
     * @throws IOException
     */
    public ContainerTag h4(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H4, context, attr);
    }

    /**
     * Create an 'h5' element.
     *
     * @param attr
     * @return
     * @throws IOException
     */
    public ContainerTag h5(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H5, context, attr);
    }

    /**
     * Create an 'h6' element.
     *
     * @param attr
     * @return
     * @throws IOException
     */
    public ContainerTag h6(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.H6, context, attr);
    }

    /**
     * Create a paragraph element.
     *
     * @param attr
     * @return
     * @throws IOException
     */
    public ContainerTag p(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.P, context, attr);
    }

    /**
     * Create an unordered list.
     *
     * @param attr
     * @return
     * @throws IOException
     */
    public ContainerTag ul(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.UL, context, attr);
    }

    /**
     * Create an ordered list.
     *
     * @param attr
     * @return
     * @throws IOException
     */
    public ContainerTag ol(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.OL, context, attr);
    }

    /**
     * Create a list item element.
     *
     * @param attr
     * @return
     * @throws IOException
     */
    public ContainerTag li(Attribute... attr) throws IOException {
        return new ContainerTag(writer, Tag.LI, context, attr);
    }

    /**
     * Create a definition list element.
     *
     * @param attr
     * @return
     * @throws IOException
     */
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

    public SelfClosingTag checkbox(Attribute... attr) throws IOException {
        return new SelfClosingTag(writer, Tag.INPUT, attr("type", "checkbox"), attr);
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

    // Attributes

    public Attribute when(boolean test, Attribute attr) {
        if (test) {
            return attr;
        }
        return null;
    }

    public Attribute attr(String name, String... values) {
        return new Attribute(name, values);
    }

    public Attribute.Class cls(String... values) {
        return new Attribute.Class(values);
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

    public Attribute.Style style(String value) {
        return new Attribute.Style(value);
    }

    public Attribute.Height height(int value) {
        return new Attribute.Height(value);
    }

    public Attribute.Width width(int value) {
        return new Attribute.Width(value);
    }

    public Content iterate(Loop iterate) {
        iterate.run();
        return new Content(writer);
    }
}
