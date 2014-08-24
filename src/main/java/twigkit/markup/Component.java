package twigkit.markup;

import twigkit.markup.html.HtmlAttribute;
import twigkit.markup.html.HtmlCapability;

import java.io.IOException;

/**
 * Implement a {@link twigkit.markup.Component} to encapsulate or reuse more complex patterns.
 *
 * @author mr.olafsson
 */
public abstract class Component {

    private MarkupCapability markupCapability;

    public void render(MarkupCapability markupCapability) throws IOException {
        this.markupCapability = markupCapability;
        markup();
    }

    /**
     * Generate markup here with access to any objects passed in via the constructor.
     *
     * @throws java.io.IOException
     */
    protected abstract void markup() throws IOException;

    /**
     * Delegate methods
     */
    public ConditionalWrapper when(boolean test) {
        return markupCapability.when(test);
    }

    public Attribute when(boolean test, Attribute attr) {
        return markupCapability.when(test, attr);
    }

    public Content exec(Code code) throws IOException {
        return markupCapability.exec(code);
    }

    public Content iterate(Loop iterate) {
        return markupCapability.iterate(iterate);
    }

    public ContainerElement el(String name, Attribute... attr) throws IOException {
        return markupCapability.el(name, attr);
    }

    public Text text(Object text) throws IOException {
        return markupCapability.text(text);
    }

    public Text text(String text, Object... data) throws IOException {
        return markupCapability.text(text, data);
    }

    public Attribute attr(String name, Object... values) {
        return markupCapability.attr(name, values);
    }

    public Content component(Component component) throws IOException {
        return markupCapability.component(component);
    }
}
