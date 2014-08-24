package twigkit.markup.html.helper;

import twigkit.markup.*;
import twigkit.markup.html.Component;
import twigkit.markup.html.HtmlAttribute;
import twigkit.markup.html.HtmlCapability;
import twigkit.markup.html.HtmlCapabilityImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @author mr.olafsson
 */
public abstract class HtmlHttpServlet extends HttpServlet implements HtmlCapability {

    private HtmlCapability htmlCapability;

    @Override
    public Writer getWriter() {
        return null;
    }

    @Override
    public void setWriter(Writer writer) {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        htmlCapability = new HtmlCapabilityImpl(resp.getWriter(), HtmlHttpServlet.class);
        doGetHtml(req, resp);
    }

    protected abstract void doGetHtml(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    /**
     * Delegate methods
     */

    @Override
    public ContainerElement html(Attribute... attr) throws IOException {
        return htmlCapability.html(attr);
    }

    @Override
    public ContainerElement body(Attribute... attr) throws IOException {
        return htmlCapability.body(attr);
    }

    @Override
    public ContainerElement head(Attribute... attr) throws IOException {
        return htmlCapability.head(attr);
    }

    @Override
    public Content meta(Attribute... attr) throws IOException {
        return htmlCapability.meta(attr);
    }

    @Override
    public ConditionalWrapper when(boolean test) {
        return htmlCapability.when(test);
    }

    @Override
    public Content exec(Code code) throws IOException {
        return htmlCapability.exec(code);
    }

    @Override
    public ContainerElement div(Attribute... attr) throws IOException {
        return htmlCapability.div(attr);
    }

    @Override
    public ContainerElement span(Attribute... attr) throws IOException {
        return htmlCapability.span(attr);
    }

    @Override
    public ContainerElement em(Attribute... attr) throws IOException {
        return htmlCapability.em(attr);
    }

    @Override
    public ContainerElement h1(Attribute... attr) throws IOException {
        return htmlCapability.h1(attr);
    }

    @Override
    public ContainerElement h2(Attribute... attr) throws IOException {
        return htmlCapability.h2(attr);
    }

    @Override
    public ContainerElement h3(Attribute... attr) throws IOException {
        return htmlCapability.h3(attr);
    }

    @Override
    public ContainerElement h4(Attribute... attr) throws IOException {
        return htmlCapability.h4(attr);
    }

    @Override
    public ContainerElement h5(Attribute... attr) throws IOException {
        return htmlCapability.h5(attr);
    }

    @Override
    public ContainerElement h6(Attribute... attr) throws IOException {
        return htmlCapability.h6(attr);
    }

    @Override
    public ContainerElement p(Attribute... attr) throws IOException {
        return htmlCapability.p(attr);
    }

    @Override
    public ContainerElement ul(Attribute... attr) throws IOException {
        return htmlCapability.ul(attr);
    }

    @Override
    public ContainerElement ol(Attribute... attr) throws IOException {
        return htmlCapability.ol(attr);
    }

    @Override
    public ContainerElement li(Attribute... attr) throws IOException {
        return htmlCapability.li(attr);
    }

    @Override
    public ContainerElement dl(Attribute... attr) throws IOException {
        return htmlCapability.dl(attr);
    }

    @Override
    public ContainerElement dt(Attribute... attr) throws IOException {
        return htmlCapability.dt(attr);
    }

    @Override
    public ContainerElement dd(Attribute... attr) throws IOException {
        return htmlCapability.dd(attr);
    }

    @Override
    public ContainerElement a(Attribute... attr) throws IOException {
        return htmlCapability.a(attr);
    }

    @Override
    public SelfClosingElement img(Attribute... attr) throws IOException {
        return htmlCapability.img(attr);
    }

    @Override
    public ContainerElement form(Attribute... attr) throws IOException {
        return htmlCapability.form(attr);
    }

    @Override
    public ContainerElement input(Attribute... attr) throws IOException {
        return htmlCapability.input(attr);
    }

    @Override
    public SelfClosingElement textarea(String value, Attribute... attr) throws IOException {
        return htmlCapability.textarea(value, attr);
    }

    @Override
    public SelfClosingElement checkbox(Attribute... attr) throws IOException {
        return htmlCapability.checkbox(attr);
    }

    @Override
    public ContainerElement fieldset(Attribute... attr) throws IOException {
        return htmlCapability.fieldset(attr);
    }

    @Override
    public ContainerElement legend(Attribute... attr) throws IOException {
        return htmlCapability.legend(attr);
    }

    @Override
    public ContainerElement script(Attribute... attr) throws IOException {
        return htmlCapability.script(attr);
    }

    @Override
    public ContainerElement el(String name, Attribute... attr) throws IOException {
        return htmlCapability.el(name, attr);
    }

    @Override
    public Text text(Object text) throws IOException {
        return htmlCapability.text(text);
    }

    @Override
    public Text text(String text, Object... data) throws IOException {
        return htmlCapability.text(text, data);
    }

    @Override
    public Attribute when(boolean test, Attribute attr) {
        return htmlCapability.when(test, attr);
    }

    @Override
    public Attribute attr(String name, Object... values) {
        return htmlCapability.attr(name, values);
    }

    @Override
    public HtmlAttribute.Class cls(String... values) {
        return htmlCapability.cls(values);
    }

    @Override
    public HtmlAttribute.Id id(String id) {
        return htmlCapability.id(id);
    }

    @Override
    public HtmlAttribute.Data data(String name, String value) {
        return htmlCapability.data(name, value);
    }

    @Override
    public HtmlAttribute.Href href(String value) {
        return htmlCapability.href(value);
    }

    @Override
    public HtmlAttribute.Src src(String value) {
        return htmlCapability.src(value);
    }

    @Override
    public HtmlAttribute.Target target(String value) {
        return htmlCapability.target(value);
    }

    @Override
    public HtmlAttribute.Title title(String value) {
        return htmlCapability.title(value);
    }

    @Override
    public HtmlAttribute.Style style(String value) {
        return htmlCapability.style(value);
    }

    @Override
    public HtmlAttribute.Height height(int value) {
        return htmlCapability.height(value);
    }

    @Override
    public HtmlAttribute.Width width(int value) {
        return htmlCapability.width(value);
    }

    @Override
    public Content iterate(Loop iterate) {
        return htmlCapability.iterate(iterate);
    }

    @Override
    public Content component(Component component) throws IOException {
        return htmlCapability.component(component);
    }

    @Override
    public Content component(twigkit.markup.Component component) throws IOException {
        return htmlCapability.component(component);
    }
}
