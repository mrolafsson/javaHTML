package twigkit.markup;

import twigkit.markup.html.*;

import java.io.IOException;
import java.io.Writer;

/**
 * @author hjortur
 */
public abstract class MarkupCapabilityImpl implements MarkupCapability {

    protected Writer writer;

    private Class context;

    public MarkupCapabilityImpl() {
        this((Class) null);
    }

    public MarkupCapabilityImpl(Class context) {
        this(null, context);
    }

    public MarkupCapabilityImpl(Writer writer) {
        this(writer, MarkupCapabilityImpl.class);
    }

    public MarkupCapabilityImpl(Writer writer, Class context) {
        this.writer = writer;
        this.context = context;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public ConditionalWrapper when(boolean test) {
        if (!test) {
            this.writer = new DummyWriter(this);
        }
        return new ConditionalWrapper.Use(this);
    }

    @Override
    public Attribute when(boolean test, Attribute attr) {
        if (test) {
            return attr;
        }
        return null;
    }

    @Override
    public Content exec(Code code) throws IOException {
        code.setWriter(writer);
        if (writer != null && !(writer instanceof DummyWriter)) {
            code.run();
        }
        return new Content(writer);
    }

    @Override
    public Content iterate(Loop iterate) {
        iterate.run();
        return new Content(writer);
    }

    @Override
    public ContainerElement el(String name, Attribute... attr) throws IOException {
        return new ContainerElement(writer, name, context, attr);
    }

    @Override
    public HtmlAttribute attr(String name, String... values) {
        return new HtmlAttribute(name, values);
    }
}
