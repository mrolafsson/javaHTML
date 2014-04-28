package twigkit.markup;

import org.junit.Test;
import twigkit.markup.Loop;
import twigkit.markup.html.AbstractHtmlCapabilityTest;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author mr.olafsson
 */
public class LoopTest extends AbstractHtmlCapabilityTest {

    @Test
    public void testArrayIteration() throws Exception {
        assertEquals("<ol><li>1</li><li>2</li><li>3</li></ol>", ol().with(
                iterate(new Loop<Foo>(new Foo("1"), new Foo("2"), new Foo("3")) {
                    @Override
                    public void each(Foo foo) throws Exception {
                        li().with(foo.bar);
                    }
                })
        ));
    }

    @Test
    public void testIntegerArray() throws Exception {
        assertEquals("<dl><dt>Fibonacci Series</dt><dd>0</dd><dd>1</dd><dd>1</dd><dd>2</dd><dd>3</dd><dd>5</dd><dd>8</dd></dl>", dl().with(
                dt().with(
                        text("Fibonacci Series")
                ),
                iterate(new Loop<Integer>(0, 1, 1, 2, 3, 5, 8) {
                    @Override
                    public void each(Integer fib) throws Exception {
                        dd().with(text(fib));
                    }
                })
        ));
    }

    @Test
    public void testCollectionIteration() throws Exception {
        Collection<Foo> collection = new ArrayList<Foo>();
        collection.add(new Foo("A"));
        collection.add(new Foo("B"));
        collection.add(new Foo("C"));
        assertEquals("<ol><li>A</li><li>B</li><li>C</li></ol>", ol().with(
                iterate(new Loop<Foo>(collection) {
                    @Override
                    public void each(Foo foo) throws Exception {
                        li().with(foo.bar);
                    }
                })
        ));
    }

    public static class Foo {

        public String bar;

        public Foo(String bar) {
            this.bar = bar;
        }
    }
}
