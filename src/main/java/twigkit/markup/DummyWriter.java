package twigkit.markup;

import twigkit.markup.MarkupCapability;

import java.io.IOException;
import java.io.Writer;

/**
 * An implementation of {@link Writer} that does not write anything but has the capability to hand back the
 * real {@link Writer} using {@link #getReal()}. This is used e.g. in the {@link twigkit.markup.ConditionalWrapper}.
 *
 * @author mr.olafsson
 */
public class DummyWriter extends Writer {

    private Writer real;

    public DummyWriter(MarkupCapability real) {
        this.real = real.getWriter();
    }

    public Writer getReal() {
        return real;
    }

    public DummyWriter(Object o) {
        super(o);
    }

    @Override
    public void write(int i) throws IOException {
    }

    @Override
    public void write(char[] chars) throws IOException {
    }

    @Override
    public void write(char[] chars, int i, int i1) throws IOException {
    }

    @Override
    public void write(String s) throws IOException {
    }

    @Override
    public void write(String s, int i, int i1) throws IOException {
    }

    @Override
    public Writer append(CharSequence charSequence) throws IOException {
        return this;
    }

    @Override
    public Writer append(CharSequence charSequence, int i, int i1) throws IOException {
        return this;
    }

    @Override
    public Writer append(char c) throws IOException {
        return this;
    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }
}
