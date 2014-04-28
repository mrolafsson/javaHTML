package twigkit.markup;

import twigkit.markup.html.Code;

import java.io.IOException;
import java.io.Writer;

/**
 * @author hjortur
 */
public interface MarkupCapability {

    public Writer getWriter();

    public void setWriter(Writer writer);

    /**
     * Start conditional output.
     *
     * @param test
     * @return
     */
    ConditionalWrapper when(boolean test);

    /**
     * Only add the attribute if the test evaluates to true.
     *
     * @param test
     * @param attr
     * @return
     */
    Attribute when(boolean test, Attribute attr);

    /**
     * Execute code inline by passing in and implementing an instance of {@link twigkit.markup.html.Code}.
     *
     * @param code
     * @return
     * @throws javax.servlet.jsp.JspException
     * @throws java.io.IOException
     */
    Content exec(Code code) throws IOException;

    Content iterate(Loop iterate);

    ContainerTag el(String name, Attribute... attr) throws IOException;

    Attribute attr(String name, String... values);
}
