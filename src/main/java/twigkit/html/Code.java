package twigkit.html;

import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.io.Writer;

/**
 * @author mr.olafsson
 */
public abstract class Code extends HtmlCapability {

    public void setWriter(Writer writer) {
        super.setWriter(writer);
    }

    public abstract void run() throws JspException, IOException;
}
