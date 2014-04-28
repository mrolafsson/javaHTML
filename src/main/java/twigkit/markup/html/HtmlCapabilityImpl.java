package twigkit.markup.html;

import twigkit.markup.*;

import java.io.IOException;
import java.io.Writer;

/**
 * Extend or statically import {@link HtmlCapabilityImpl} to use the helper methods that create {@link twigkit.markup.Content}.
 *
 * @author mr.olafsson
 */
public class HtmlCapabilityImpl extends MarkupCapabilityImpl implements HtmlCapability {

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
        super(writer);
        this.context = context;
    }

    @Override
    public ContainerTag html(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.HTML, context, attr);
    }

    @Override
    public ContainerTag body(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.BODY, context, attr);
    }

    @Override
    public ContainerTag head(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.HEAD, context, attr);
    }

    @Override
    public Content meta(Attribute... attr) throws IOException {
        return new SelfClosingTag(writer, HtmlTag.META, attr);
    }

    @Override
    public ContainerTag div(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.DIV, context, attr);
    }

    @Override
    public ContainerTag span(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.SPAN, context, attr);
    }

    @Override
    public ContainerTag em(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.EM, context, attr);
    }

    @Override
    public ContainerTag h1(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.H1, context, attr);
    }

    @Override
    public ContainerTag h2(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.H2, context, attr);
    }

    @Override
    public ContainerTag h3(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.H3, context, attr);
    }

    @Override
    public ContainerTag h4(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.H4, context, attr);
    }

    @Override
    public ContainerTag h5(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.H5, context, attr);
    }

    @Override
    public ContainerTag h6(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.H6, context, attr);
    }

    @Override
    public ContainerTag p(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.P, context, attr);
    }

    @Override
    public ContainerTag ul(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.UL, context, attr);
    }

    @Override
    public ContainerTag ol(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.OL, context, attr);
    }

    @Override
    public ContainerTag li(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.LI, context, attr);
    }

    @Override
    public ContainerTag dl(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.DL, context, attr);
    }

    @Override
    public ContainerTag dt(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.DT, context, attr);
    }

    @Override
    public ContainerTag dd(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.DD, context, attr);
    }

    @Override
    public ContainerTag a(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.A, context, attr);
    }

    @Override
    public SelfClosingTag img(Attribute... attr) throws IOException {
        return new SelfClosingTag(writer, HtmlTag.IMG, attr);
    }

    @Override
    public ContainerTag form(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.FORM, context, attr);
    }

    @Override
    public ContainerTag input(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.INPUT, context, attr);
    }

    @Override
    public SelfClosingTag textarea(String value, Attribute... attr) throws IOException {
        return new SelfClosingTag(writer, HtmlTag.TEXTAREA, attr("value", value), attr);
    }

    @Override
    public SelfClosingTag checkbox(Attribute... attr) throws IOException {
        return new SelfClosingTag(writer, HtmlTag.INPUT, attr("type", "checkbox"), attr);
    }

    @Override
    public ContainerTag fieldset(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.FIELDSET, context, attr);
    }

    @Override
    public ContainerTag legend(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.LEGEND, context, attr);
    }

    @Override
    public ContainerTag script(Attribute... attr) throws IOException {
        return new ContainerTag(writer, HtmlTag.SCRIPT, context, attr);
    }

    @Override
    public Text text(Object text) throws IOException {
        return new Text(writer, text);
    }

    // Attributes

    @Override
    public HtmlAttribute.Class cls(String... values) {
        return new HtmlAttribute.Class(values);
    }

    @Override
    public HtmlAttribute.Id id(String id) {
        return new HtmlAttribute.Id(id);
    }

    @Override
    public HtmlAttribute.Data data(String name, String value) {
        return new HtmlAttribute.Data(name, value);
    }

    @Override
    public HtmlAttribute.Href href(String value) {
        return new HtmlAttribute.Href(value);
    }

    @Override
    public HtmlAttribute.Src src(String value) {
        return new HtmlAttribute.Src(value);
    }

    @Override
    public HtmlAttribute.Target target(String value) {
        return new HtmlAttribute.Target(value);
    }

    @Override
    public HtmlAttribute.Title title(String value) {
        return new HtmlAttribute.Title(value);
    }

    @Override
    public HtmlAttribute.Style style(String value) {
        return new HtmlAttribute.Style(value);
    }

    @Override
    public HtmlAttribute.Height height(int value) {
        return new HtmlAttribute.Height(value);
    }

    @Override
    public HtmlAttribute.Width width(int value) {
        return new HtmlAttribute.Width(value);
    }

    @Override
    public Content component(Component component) throws IOException {
        component.render(this);
        return new Content(getWriter());
    }
}
