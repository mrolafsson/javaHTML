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

    ContainerElement html(Attribute... attr) throws IOException;

    ContainerElement body(Attribute... attr) throws IOException;

    ContainerElement head(Attribute... attr) throws IOException;

    Content meta(Attribute... attr) throws IOException;

    /**
     * Create a 'div' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement div(Attribute... attr) throws IOException;

    /**
     * Create a 'span' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement span(Attribute... attr) throws IOException;

    ContainerElement em(Attribute... attr) throws IOException;

    /**
     * Create an 'h1' element.
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement h1(Attribute... attr) throws IOException;

    /**
     * Create an 'h2' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement h2(Attribute... attr) throws IOException;

    /**
     * Create an 'h3' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement h3(Attribute... attr) throws IOException;

    /**
     * Create an 'h4' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement h4(Attribute... attr) throws IOException;

    /**
     * Create an 'h5' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement h5(Attribute... attr) throws IOException;

    /**
     * Create an 'h6' element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement h6(Attribute... attr) throws IOException;

    /**
     * Create a paragraph element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement p(Attribute... attr) throws IOException;

    /**
     * Create an unordered list.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement ul(Attribute... attr) throws IOException;

    /**
     * Create an ordered list.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement ol(Attribute... attr) throws IOException;

    /**
     * Create a list item element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement li(Attribute... attr) throws IOException;

    /**
     * Create a definition list element.
     *
     * @param attr
     * @return
     * @throws java.io.IOException
     */
    ContainerElement dl(Attribute... attr) throws IOException;

    ContainerElement dt(Attribute... attr) throws IOException;

    ContainerElement dd(Attribute... attr) throws IOException;

    ContainerElement a(Attribute... attr) throws IOException;

    SelfClosingElement img(Attribute... attr) throws IOException;

    ContainerElement form(Attribute... attr) throws IOException;

    ContainerElement input(Attribute... attr) throws IOException;

    SelfClosingElement textarea(String value, Attribute... attr) throws IOException;

    SelfClosingElement checkbox(Attribute... attr) throws IOException;

    ContainerElement fieldset(Attribute... attr) throws IOException;

    ContainerElement legend(Attribute... attr) throws IOException;

    ContainerElement script(Attribute... attr) throws IOException;

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
