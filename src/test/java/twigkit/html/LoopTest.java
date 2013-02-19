package twigkit.html;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
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
