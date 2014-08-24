package twigkit.markup.html;

import twigkit.markup.*;

import java.io.IOException;

/**
 * Implement a {@link Component} to encapsulate or reuse more complex patterns.
 *
 * @author mr.olafsson
 */
public abstract class Component {

    private HtmlCapability htmlCapability;

    public void render(HtmlCapability htmlCapability) throws IOException {
        this.htmlCapability = htmlCapability;
        markup();
    }

    /**
     * Generate markup here with access to any objects passed in via the constructor.
     *
     * @throws IOException
     */
    protected abstract void markup() throws IOException;

    /**
     * Delegate methods
     */

    protected ContainerElement html(HtmlAttribute... attr) throws IOException {
        return htmlCapability.html(attr);
    }

    protected ContainerElement body(HtmlAttribute... attr) throws IOException {
        return htmlCapability.body(attr);
    }

    protected ContainerElement head(HtmlAttribute... attr) throws IOException {
        return htmlCapability.head(attr);
    }

    protected Content meta(HtmlAttribute... attr) throws IOException {
        return htmlCapability.meta(attr);
    }

    protected ConditionalWrapper when(boolean test) {
        return htmlCapability.when(test);
    }

    protected Content exec(twigkit.markup.Code code) throws IOException {
        return htmlCapability.exec(code);
    }

    protected ContainerElement div(HtmlAttribute... attr) throws IOException {
        return htmlCapability.div(attr);
    }

    protected ContainerElement span(HtmlAttribute... attr) throws IOException {
        return htmlCapability.span(attr);
    }

    protected ContainerElement em(HtmlAttribute... attr) throws IOException {
        return htmlCapability.em(attr);
    }

    protected ContainerElement h1(HtmlAttribute... attr) throws IOException {
        return htmlCapability.h1(attr);
    }

    protected ContainerElement h2(HtmlAttribute... attr) throws IOException {
        return htmlCapability.h2(attr);
    }

    protected ContainerElement h3(HtmlAttribute... attr) throws IOException {
        return htmlCapability.h3(attr);
    }

    protected ContainerElement h4(HtmlAttribute... attr) throws IOException {
        return htmlCapability.h4(attr);
    }

    protected ContainerElement h5(HtmlAttribute... attr) throws IOException {
        return htmlCapability.h5(attr);
    }

    protected ContainerElement h6(HtmlAttribute... attr) throws IOException {
        return htmlCapability.h6(attr);
    }

    protected ContainerElement p(HtmlAttribute... attr) throws IOException {
        return htmlCapability.p(attr);
    }

    protected ContainerElement ul(HtmlAttribute... attr) throws IOException {
        return htmlCapability.ul(attr);
    }

    protected ContainerElement ol(HtmlAttribute... attr) throws IOException {
        return htmlCapability.ol(attr);
    }

    protected ContainerElement li(HtmlAttribute... attr) throws IOException {
        return htmlCapability.li(attr);
    }

    protected ContainerElement dl(HtmlAttribute... attr) throws IOException {
        return htmlCapability.dl(attr);
    }

    protected ContainerElement dt(HtmlAttribute... attr) throws IOException {
        return htmlCapability.dt(attr);
    }

    protected ContainerElement dd(HtmlAttribute... attr) throws IOException {
        return htmlCapability.dd(attr);
    }

    protected ContainerElement a(HtmlAttribute... attr) throws IOException {
        return htmlCapability.a(attr);
    }

    protected SelfClosingElement img(HtmlAttribute... attr) throws IOException {
        return htmlCapability.img(attr);
    }

    protected ContainerElement form(HtmlAttribute... attr) throws IOException {
        return htmlCapability.form(attr);
    }

    protected ContainerElement input(HtmlAttribute... attr) throws IOException {
        return htmlCapability.input(attr);
    }

    protected SelfClosingElement textarea(String value, HtmlAttribute... attr) throws IOException {
        return htmlCapability.textarea(value, attr);
    }

    protected SelfClosingElement checkbox(HtmlAttribute... attr) throws IOException {
        return htmlCapability.checkbox(attr);
    }

    protected ContainerElement fieldset(HtmlAttribute... attr) throws IOException {
        return htmlCapability.fieldset(attr);
    }

    protected ContainerElement legend(HtmlAttribute... attr) throws IOException {
        return htmlCapability.legend(attr);
    }

    protected ContainerElement script(HtmlAttribute... attr) throws IOException {
        return htmlCapability.script(attr);
    }

    protected ContainerElement el(String name, Attribute... attr) throws IOException {
        return htmlCapability.el(name, attr);
    }

    protected Text text(Object text) throws IOException {
        return htmlCapability.text(text);
    }

    protected Attribute when(boolean test, Attribute attr) {
        return htmlCapability.when(test, attr);
    }

    protected Attribute attr(String name, Object... values) {
        return htmlCapability.attr(name, values);
    }

    protected HtmlAttribute.Class cls(String... values) {
        return htmlCapability.cls(values);
    }

    protected HtmlAttribute.Id id(String id) {
        return htmlCapability.id(id);
    }

    protected HtmlAttribute.Data data(String name, String value) {
        return htmlCapability.data(name, value);
    }

    protected HtmlAttribute.Href href(String value) {
        return htmlCapability.href(value);
    }

    protected HtmlAttribute.Src src(String value) {
        return htmlCapability.src(value);
    }

    protected HtmlAttribute.Target target(String value) {
        return htmlCapability.target(value);
    }

    protected HtmlAttribute.Title title(String value) {
        return htmlCapability.title(value);
    }

    protected HtmlAttribute.Style style(String value) {
        return htmlCapability.style(value);
    }

    protected HtmlAttribute.Height height(int value) {
        return htmlCapability.height(value);
    }

    protected HtmlAttribute.Width width(int value) {
        return htmlCapability.width(value);
    }

    protected Content iterate(Loop iterate) {
        return htmlCapability.iterate(iterate);
    }

    protected Content component(Component component) throws IOException {
        return htmlCapability.component(component);
    }
}
