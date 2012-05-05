package twigkit.html;

import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: hjortur
 * Date: 05/05/2012
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class DummyWriter extends Writer {

    private Writer real;

    protected DummyWriter(HtmlCapability real) {
        this.real = real.getWriter();
    }

    public Writer getReal() {
        return real;
    }

    protected DummyWriter(Object o) {
        super(o);    //To change body of overridden methods use File | Settings | File Templates.
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
