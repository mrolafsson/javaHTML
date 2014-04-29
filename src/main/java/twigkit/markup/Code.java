package twigkit.markup;

import twigkit.markup.html.HtmlCapabilityImpl;

import java.io.IOException;
import java.io.Writer;

/**
 * Add custom logic to be evaluated inline by implementing {@link #run()} and passing the instance to {@link #exec(twigkit.markup.Code)}.
 *
 * @author mr.olafsson
 */
public interface Code {

    public void setWriter(Writer writer);

    public void run() throws IOException;

}
