package twigkit.html;

import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.io.Writer;

/**
 * Add custom logic to be evaluated inline by implementing {@link #run()} and passing the instance to {@link #exec(Code)}.
 *
 * @author mr.olafsson
 */
public abstract class Code extends HtmlCapability {

    public void setWriter(Writer writer) {
        super.setWriter(writer);
    }

    public abstract void run() throws JspException, IOException;
}
