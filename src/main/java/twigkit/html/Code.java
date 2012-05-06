package twigkit.html;

import java.io.IOException;
import java.io.Writer;

/**
 * @author mr.olafsson
 */
public abstract class Code extends HtmlCapability {

    public void setWriter(Writer writer) {
        super.setWriter(writer);
    }

    abstract void run() throws IOException;
}
