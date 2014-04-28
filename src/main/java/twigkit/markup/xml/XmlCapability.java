package twigkit.markup.xml;

import twigkit.markup.Attribute;
import twigkit.markup.Component;
import twigkit.markup.MarkupCapability;
import twigkit.markup.ContainerTag;
import twigkit.markup.Content;
import twigkit.markup.Text;

import java.io.IOException;

/**
 * Created by hjortur on 28/04/2014.
 */
public interface XmlCapability extends MarkupCapability {

    ContainerTag el(String name, Attribute... attr) throws IOException;

    Text text(Object text) throws IOException;

    Content component(Component component) throws IOException;

    Attribute attr(String name, String... values);

}
