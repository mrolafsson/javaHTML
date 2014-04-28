package twigkit.markup.html;

import twigkit.markup.*;

import java.io.IOException;
import java.io.Writer;

/**
 * @author mr.olafsson
 */
public interface HtmlCapability extends MarkupCapability {

    public Writer getWriter();

    public void setWriter(Writer writer);

    ContainerTag html(Attribute... attr) throws IOException;

    ContainerTag body(Attribute... attr) throws IOException;

    ContainerTag head(Attribute... attr) throws IOException;

    Content meta(Attribute... attr) throws IOException;

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

    Text text(Object text) throws IOException;

    Attribute attr(String name, String... values);

    HtmlAttribute.Class cls(String... values);

    HtmlAttribute.Id id(String id);

    HtmlAttribute.Data data(String name, String value);

    HtmlAttribute.Href href(String value);

    HtmlAttribute.Src src(String value);

    HtmlAttribute.Target target(String value);

    HtmlAttribute.Title title(String value);

    HtmlAttribute.Style style(String value);

    HtmlAttribute.Height height(int value);

    HtmlAttribute.Width width(int value);

    Content component(Component component) throws IOException;
}
