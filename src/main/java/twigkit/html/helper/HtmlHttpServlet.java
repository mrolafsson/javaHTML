package twigkit.html.helper;

import twigkit.html.*;
import twigkit.html.attr.Attribute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import java.io.IOException;

/**
 * @author mr.olafsson
 */
public abstract class HtmlHttpServlet extends HttpServlet implements HtmlCapability {

    private HtmlCapability htmlCapability;

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
    public ContainerTag html(Attribute... attr) throws IOException {
        return htmlCapability.html(attr);
    }

    @Override
    public ContainerTag body(Attribute... attr) throws IOException {
        return htmlCapability.body(attr);
    }

    @Override
    public ContainerTag head(Attribute... attr) throws IOException {
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
    public Content exec(Code code) throws JspException, IOException {
        return htmlCapability.exec(code);
    }

    @Override
    public ContainerTag div(Attribute... attr) throws IOException {
        return htmlCapability.div(attr);
    }

    @Override
    public ContainerTag span(Attribute... attr) throws IOException {
        return htmlCapability.span(attr);
    }

    @Override
    public ContainerTag em(Attribute... attr) throws IOException {
        return htmlCapability.em(attr);
    }

    @Override
    public ContainerTag h1(Attribute... attr) throws IOException {
        return htmlCapability.h1(attr);
    }

    @Override
    public ContainerTag h2(Attribute... attr) throws IOException {
        return htmlCapability.h2(attr);
    }

    @Override
    public ContainerTag h3(Attribute... attr) throws IOException {
        return htmlCapability.h3(attr);
    }

    @Override
    public ContainerTag h4(Attribute... attr) throws IOException {
        return htmlCapability.h4(attr);
    }

    @Override
    public ContainerTag h5(Attribute... attr) throws IOException {
        return htmlCapability.h5(attr);
    }

    @Override
    public ContainerTag h6(Attribute... attr) throws IOException {
        return htmlCapability.h6(attr);
    }

    @Override
    public ContainerTag p(Attribute... attr) throws IOException {
        return htmlCapability.p(attr);
    }

    @Override
    public ContainerTag ul(Attribute... attr) throws IOException {
        return htmlCapability.ul(attr);
    }

    @Override
    public ContainerTag ol(Attribute... attr) throws IOException {
        return htmlCapability.ol(attr);
    }

    @Override
    public ContainerTag li(Attribute... attr) throws IOException {
        return htmlCapability.li(attr);
    }

    @Override
    public ContainerTag dl(Attribute... attr) throws IOException {
        return htmlCapability.dl(attr);
    }

    @Override
    public ContainerTag dt(Attribute... attr) throws IOException {
        return htmlCapability.dt(attr);
    }

    @Override
    public ContainerTag dd(Attribute... attr) throws IOException {
        return htmlCapability.dd(attr);
    }

    @Override
    public ContainerTag a(Attribute... attr) throws IOException {
        return htmlCapability.a(attr);
    }

    @Override
    public SelfClosingTag img(Attribute... attr) throws IOException {
        return htmlCapability.img(attr);
    }

    @Override
    public ContainerTag form(Attribute... attr) throws IOException {
        return htmlCapability.form(attr);
    }

    @Override
    public ContainerTag input(Attribute... attr) throws IOException {
        return htmlCapability.input(attr);
    }

    @Override
    public SelfClosingTag textarea(String value, Attribute... attr) throws IOException {
        return htmlCapability.textarea(value, attr);
    }

    @Override
    public SelfClosingTag checkbox(Attribute... attr) throws IOException {
        return htmlCapability.checkbox(attr);
    }

    @Override
    public ContainerTag fieldset(Attribute... attr) throws IOException {
        return htmlCapability.fieldset(attr);
    }

    @Override
    public ContainerTag legend(Attribute... attr) throws IOException {
        return htmlCapability.legend(attr);
    }

    @Override
    public ContainerTag script(Attribute... attr) throws IOException {
        return htmlCapability.script(attr);
    }

    @Override
    public ContainerTag custom(String name, Attribute... attr) throws IOException {
        return htmlCapability.custom(name, attr);
    }

    @Override
    public Text text(Object text) throws IOException {
        return htmlCapability.text(text);
    }

    @Override
    public Attribute when(boolean test, Attribute attr) {
        return htmlCapability.when(test, attr);
    }

    @Override
    public Attribute attr(String name, String... values) {
        return htmlCapability.attr(name, values);
    }

    @Override
    public Attribute.Class cls(String... values) {
        return htmlCapability.cls(values);
    }

    @Override
    public Attribute.Id id(String id) {
        return htmlCapability.id(id);
    }

    @Override
    public Attribute.Data data(String name, String value) {
        return htmlCapability.data(name, value);
    }

    @Override
    public Attribute.Href href(String value) {
        return htmlCapability.href(value);
    }

    @Override
    public Attribute.Src src(String value) {
        return htmlCapability.src(value);
    }

    @Override
    public Attribute.Target target(String value) {
        return htmlCapability.target(value);
    }

    @Override
    public Attribute.Title title(String value) {
        return htmlCapability.title(value);
    }

    @Override
    public Attribute.Style style(String value) {
        return htmlCapability.style(value);
    }

    @Override
    public Attribute.Height height(int value) {
        return htmlCapability.height(value);
    }

    @Override
    public Attribute.Width width(int value) {
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
}
