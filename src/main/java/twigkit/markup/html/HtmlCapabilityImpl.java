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
    public ContainerElement html(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.HTML, context, attr);
    }

    @Override
    public ContainerElement body(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.BODY, context, attr);
    }

    @Override
    public ContainerElement head(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.HEAD, context, attr);
    }

    @Override
    public Content meta(Attribute... attr) throws IOException {
        return new SelfClosingElement(writer, HtmlTag.META, attr);
    }

    @Override
    public ContainerElement div(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.DIV, context, attr);
    }

    @Override
    public ContainerElement span(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.SPAN, context, attr);
    }

    @Override
    public ContainerElement em(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.EM, context, attr);
    }

    @Override
    public ContainerElement h1(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.H1, context, attr);
    }

    @Override
    public ContainerElement h2(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.H2, context, attr);
    }

    @Override
    public ContainerElement h3(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.H3, context, attr);
    }

    @Override
    public ContainerElement h4(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.H4, context, attr);
    }

    @Override
    public ContainerElement h5(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.H5, context, attr);
    }

    @Override
    public ContainerElement h6(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.H6, context, attr);
    }

    @Override
    public ContainerElement p(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.P, context, attr);
    }

    @Override
    public ContainerElement ul(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.UL, context, attr);
    }

    @Override
    public ContainerElement ol(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.OL, context, attr);
    }

    @Override
    public ContainerElement li(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.LI, context, attr);
    }

    @Override
    public ContainerElement dl(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.DL, context, attr);
    }

    @Override
    public ContainerElement dt(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.DT, context, attr);
    }

    @Override
    public ContainerElement dd(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.DD, context, attr);
    }

    @Override
    public ContainerElement a(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.A, context, attr);
    }

    @Override
    public SelfClosingElement img(Attribute... attr) throws IOException {
        return new SelfClosingElement(writer, HtmlTag.IMG, attr);
    }

    @Override
    public ContainerElement form(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.FORM, context, attr);
    }

    @Override
    public ContainerElement input(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.INPUT, context, attr);
    }

    @Override
    public SelfClosingElement textarea(String value, Attribute... attr) throws IOException {
        return new SelfClosingElement(writer, HtmlTag.TEXTAREA, attr("value", value), attr);
    }

    @Override
    public SelfClosingElement checkbox(Attribute... attr) throws IOException {
        return new SelfClosingElement(writer, HtmlTag.INPUT, attr("type", "checkbox"), attr);
    }

    @Override
    public ContainerElement fieldset(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.FIELDSET, context, attr);
    }

    @Override
    public ContainerElement legend(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.LEGEND, context, attr);
    }

    @Override
    public ContainerElement script(Attribute... attr) throws IOException {
        return new ContainerElement(writer, HtmlTag.SCRIPT, context, attr);
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
