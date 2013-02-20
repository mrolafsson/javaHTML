package twigkit.html;

import twigkit.html.attr.Attribute;

import javax.servlet.jsp.JspException;
import java.io.IOException;

/**
 * Implement a {@link Component} to encapsulate or reuse more complex patterns.
 *
 * @author mr.olafsson
 */
public abstract class Component {

    private HtmlCapability htmlCapability;

    protected void render(HtmlCapability htmlCapability) throws IOException {
        this.htmlCapability = htmlCapability;
        markup();
    }

    /**
     * Generate markup here with access to any objects passed in via the constructor.
     *
     * @throws IOException
     */
    public abstract void markup() throws IOException;

    /**
     * Delegate methods
     */

    public Text text(Object text) throws IOException {
        return htmlCapability.text(text);
    }

    public ContainerTag legend(Attribute... attr) throws IOException {
        return htmlCapability.legend(attr);
    }

    public Content exec(Code code) throws JspException, IOException {
        return htmlCapability.exec(code);
    }

    public Attribute.Class cls(String... values) {
        return htmlCapability.cls(values);
    }

    public Attribute.Target target(String value) {
        return htmlCapability.target(value);
    }

    public ContainerTag h3(Attribute... attr) throws IOException {
        return htmlCapability.h3(attr);
    }

    public ContainerTag fieldset(Attribute... attr) throws IOException {
        return htmlCapability.fieldset(attr);
    }

    public ContainerTag p(Attribute... attr) throws IOException {
        return htmlCapability.p(attr);
    }

    public ContainerTag custom(String name, Attribute... attr) throws IOException {
        return htmlCapability.custom(name, attr);
    }

    public ContainerTag a(Attribute... attr) throws IOException {
        return htmlCapability.a(attr);
    }

    public ContainerTag body(Attribute... attr) throws IOException {
        return htmlCapability.body(attr);
    }

    public ContainerTag span(Attribute... attr) throws IOException {
        return htmlCapability.span(attr);
    }

    public ContainerTag ul(Attribute... attr) throws IOException {
        return htmlCapability.ul(attr);
    }

    public ContainerTag h2(Attribute... attr) throws IOException {
        return htmlCapability.h2(attr);
    }

    public ContainerTag dd(Attribute... attr) throws IOException {
        return htmlCapability.dd(attr);
    }

    public ContainerTag h1(Attribute... attr) throws IOException {
        return htmlCapability.h1(attr);
    }

    public ContainerTag dt(Attribute... attr) throws IOException {
        return htmlCapability.dt(attr);
    }

    public Attribute attr(String name, String... values) {
        return htmlCapability.attr(name, values);
    }

    public ConditionalWrapper when(boolean test) {
        return htmlCapability.when(test);
    }

    public ContainerTag script(Attribute... attr) throws IOException {
        return htmlCapability.script(attr);
    }

    public Attribute.Href href(String value) {
        return htmlCapability.href(value);
    }

    public ContainerTag li(Attribute... attr) throws IOException {
        return htmlCapability.li(attr);
    }

    public ContainerTag form(Attribute... attr) throws IOException {
        return htmlCapability.form(attr);
    }

    public SelfClosingTag img(Attribute... attr) throws IOException {
        return htmlCapability.img(attr);
    }

    public Attribute.Height height(int value) {
        return htmlCapability.height(value);
    }

    public Attribute when(boolean test, Attribute attr) {
        return htmlCapability.when(test, attr);
    }

    public ContainerTag em(Attribute... attr) throws IOException {
        return htmlCapability.em(attr);
    }

    public ContainerTag head(Attribute... attr) throws IOException {
        return htmlCapability.head(attr);
    }

    public Attribute.Title title(String value) {
        return htmlCapability.title(value);
    }

    public ContainerTag div(Attribute... attr) throws IOException {
        return htmlCapability.div(attr);
    }

    public ContainerTag h6(Attribute... attr) throws IOException {
        return htmlCapability.h6(attr);
    }

    public Content iterate(Loop iterate) {
        return htmlCapability.iterate(iterate);
    }

    public ContainerTag dl(Attribute... attr) throws IOException {
        return htmlCapability.dl(attr);
    }

    public Attribute.Id id(String id) {
        return htmlCapability.id(id);
    }

    public SelfClosingTag checkbox(Attribute... attr) throws IOException {
        return htmlCapability.checkbox(attr);
    }

    public ContainerTag h5(Attribute... attr) throws IOException {
        return htmlCapability.h5(attr);
    }

    public Attribute.Width width(int value) {
        return htmlCapability.width(value);
    }

    public Attribute.Src src(String value) {
        return htmlCapability.src(value);
    }

    public Attribute.Data data(String name, String value) {
        return htmlCapability.data(name, value);
    }

    public ContainerTag input(Attribute... attr) throws IOException {
        return htmlCapability.input(attr);
    }

    public Content component(Component component) throws IOException {
        return htmlCapability.component(component);
    }

    public Content meta(Attribute... attr) throws IOException {
        return htmlCapability.meta(attr);
    }

    public ContainerTag h4(Attribute... attr) throws IOException {
        return htmlCapability.h4(attr);
    }

    public Attribute.Style style(String value) {
        return htmlCapability.style(value);
    }

    public ContainerTag ol(Attribute... attr) throws IOException {
        return htmlCapability.ol(attr);
    }

    public ContainerTag html(Attribute... attr) throws IOException {
        return htmlCapability.html(attr);
    }
}
