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
public abstract class HtmlHttpServlet extends HttpServlet {

    private HtmlCapability htmlCapability;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        htmlCapability = new HtmlCapability(resp.getWriter(), HtmlHttpServlet.class);
        doGetHtml(req, resp);
    }

    protected abstract void doGetHtml(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    /**
     * Delegate methods
     */
    public Attribute.Title title(String value) {
        return htmlCapability.title(value);
    }

    public ConditionalWrapper when(boolean test) {
        return htmlCapability.when(test);
    }

    public Content iterate(Loop iterate) {
        return htmlCapability.iterate(iterate);
    }

    public ContainerTag p(Attribute... attr) throws IOException {
        return htmlCapability.p(attr);
    }

    public ContainerTag h3(Attribute... attr) throws IOException {
        return htmlCapability.h3(attr);
    }

    public Attribute.Src src(String value) {
        return htmlCapability.src(value);
    }

    public ContainerTag li(Attribute... attr) throws IOException {
        return htmlCapability.li(attr);
    }

    public Text text(Object text) throws IOException {
        return htmlCapability.text(text);
    }

    public Content meta(Attribute... attr) throws IOException {
        return htmlCapability.meta(attr);
    }

    public Attribute.Height height(int value) {
        return htmlCapability.height(value);
    }

    public SelfClosingTag img(Attribute... attr) throws IOException {
        return htmlCapability.img(attr);
    }

    public ContainerTag fieldset(Attribute... attr) throws IOException {
        return htmlCapability.fieldset(attr);
    }

    public ContainerTag span(Attribute... attr) throws IOException {
        return htmlCapability.span(attr);
    }

    public ContainerTag ul(Attribute... attr) throws IOException {
        return htmlCapability.ul(attr);
    }

    public ContainerTag dd(Attribute... attr) throws IOException {
        return htmlCapability.dd(attr);
    }

    public ContainerTag script(Attribute... attr) throws IOException {
        return htmlCapability.script(attr);
    }

    public ContainerTag h4(Attribute... attr) throws IOException {
        return htmlCapability.h4(attr);
    }

    public ContainerTag h6(Attribute... attr) throws IOException {
        return htmlCapability.h6(attr);
    }

    public ContainerTag html(Attribute... attr) throws IOException {
        return htmlCapability.html(attr);
    }

    public ContainerTag dl(Attribute... attr) throws IOException {
        return htmlCapability.dl(attr);
    }

    public ContainerTag input(Attribute... attr) throws IOException {
        return htmlCapability.input(attr);
    }

    public ContainerTag h2(Attribute... attr) throws IOException {
        return htmlCapability.h2(attr);
    }

    public ContainerTag h5(Attribute... attr) throws IOException {
        return htmlCapability.h5(attr);
    }

    public ContainerTag a(Attribute... attr) throws IOException {
        return htmlCapability.a(attr);
    }

    public Attribute.Class cls(String... values) {
        return htmlCapability.cls(values);
    }

    public Attribute when(boolean test, Attribute attr) {
        return htmlCapability.when(test, attr);
    }

    public SelfClosingTag checkbox(Attribute... attr) throws IOException {
        return htmlCapability.checkbox(attr);
    }

    public ContainerTag div(Attribute... attr) throws IOException {
        return htmlCapability.div(attr);
    }

    public Attribute.Data data(String name, String value) {
        return htmlCapability.data(name, value);
    }

    public ContainerTag custom(String name, Attribute... attr) throws IOException {
        return htmlCapability.custom(name, attr);
    }

    public ContainerTag dt(Attribute... attr) throws IOException {
        return htmlCapability.dt(attr);
    }

    public Attribute.Target target(String value) {
        return htmlCapability.target(value);
    }

    public ContainerTag h1(Attribute... attr) throws IOException {
        return htmlCapability.h1(attr);
    }

    public Attribute.Href href(String value) {
        return htmlCapability.href(value);
    }

    public Attribute.Id id(String id) {
        return htmlCapability.id(id);
    }

    public Attribute.Style style(String value) {
        return htmlCapability.style(value);
    }

    public Attribute.Width width(int value) {
        return htmlCapability.width(value);
    }

    public ContainerTag em(Attribute... attr) throws IOException {
        return htmlCapability.em(attr);
    }

    public ContainerTag form(Attribute... attr) throws IOException {
        return htmlCapability.form(attr);
    }

    public Content exec(Code code) throws JspException, IOException {
        return htmlCapability.exec(code);
    }

    public Attribute attr(String name, String... values) {
        return htmlCapability.attr(name, values);
    }

    public ContainerTag body(Attribute... attr) throws IOException {
        return htmlCapability.body(attr);
    }

    public ContainerTag legend(Attribute... attr) throws IOException {
        return htmlCapability.legend(attr);
    }

    public ContainerTag ol(Attribute... attr) throws IOException {
        return htmlCapability.ol(attr);
    }

    public ContainerTag head(Attribute... attr) throws IOException {
        return htmlCapability.head(attr);
    }
}
