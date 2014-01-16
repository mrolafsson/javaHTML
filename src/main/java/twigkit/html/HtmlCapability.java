package twigkit.html;

import twigkit.html.attr.Attribute;

import java.io.IOException;

/**
 * @author mr.olafsson
 */
public interface HtmlCapability {
    ContainerTag html(Attribute... attr) throws IOException;

    ContainerTag body(Attribute... attr) throws IOException;

    ContainerTag head(Attribute... attr) throws IOException;

    Content meta(Attribute... attr) throws IOException;

    /**
     * Start conditional output.
     *
     * @param test
     * @return
     */
    ConditionalWrapper when(boolean test);

    /**
     * Execute code inline by passing in and implementing an instance of {@link twigkit.html.Code}.
     *
     * @param code
     * @return
     * @throws javax.servlet.jsp.JspException
     * @throws java.io.IOException
     */
    Content exec(Code code) throws IOException;

    /**
     * Create a 'div' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag div(Attribute... attr) throws IOException;

    /**
     * Create a 'span' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag span(Attribute... attr) throws IOException;

    ContainerTag em(Attribute... attr) throws IOException;

    /**
     * Create an 'h1' element.
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag h1(Attribute... attr) throws IOException;

    /**
     * Create an 'h2' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag h2(Attribute... attr) throws IOException;

    /**
     * Create an 'h3' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag h3(Attribute... attr) throws IOException;

    /**
     * Create an 'h4' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag h4(Attribute... attr) throws IOException;

    /**
     * Create an 'h5' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag h5(Attribute... attr) throws IOException;

    /**
     * Create an 'h6' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag h6(Attribute... attr) throws IOException;

    /**
     * Create a paragraph element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag p(Attribute... attr) throws IOException;

    /**
     * Create an unordered list.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag ul(Attribute... attr) throws IOException;

    /**
     * Create an ordered list.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag ol(Attribute... attr) throws IOException;

    /**
     * Create a list item element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag li(Attribute... attr) throws IOException;

    /**
     * Create a definition list element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerTag dl(Attribute... attr) throws IOException;

    ContainerTag dt(Attribute... attr) throws IOException;

    ContainerTag dd(Attribute... attr) throws IOException;

    ContainerTag a(Attribute... attr) throws IOException;

    SelfClosingTag img(Attribute... attr) throws IOException;

    ContainerTag form(Attribute... attr) throws IOException;

    ContainerTag input(Attribute... attr) throws IOException;

    SelfClosingTag textarea(String value, Attribute... attr) throws IOException;

    SelfClosingTag checkbox(Attribute... attr) throws IOException;

    ContainerTag fieldset(Attribute... attr) throws IOException;

    ContainerTag legend(Attribute... attr) throws IOException;

    ContainerTag script(Attribute... attr) throws IOException;

    ContainerTag custom(String name, Attribute... attr) throws IOException;

    Text text(Object text) throws IOException;

    /**
     * Only add the attribute if the test evaluates to true.
     *
     * @param test
     * @param attr
     * @return
     */
    Attribute when(boolean test, Attribute attr);

    Attribute attr(String name, String... values);

    Attribute.Class cls(String... values);

    Attribute.Id id(String id);

    Attribute.Data data(String name, String value);

    Attribute.Href href(String value);

    Attribute.Src src(String value);

    Attribute.Target target(String value);

    Attribute.Title title(String value);

    Attribute.Style style(String value);

    Attribute.Height height(int value);

    Attribute.Width width(int value);

    Content iterate(Loop iterate);

    Content component(Component component) throws IOException;
}
