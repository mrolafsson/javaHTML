package twigkit.markup;

import org.junit.Test;

import java.io.IOException;

/**
 * Testing component creation and use.
 *
 * @author mr.olafsson
 */
public class ComponentTest extends AbstractMarkupCapabilityTest {

    @Test
    public void testComponent() throws Exception {
        assertEquals("<greetings><elaborate>Hello world!</elaborate><simple>Take me to your leader!</simple></greetings>", el("greetings").with(
                component(new Greeting("world")),
                el("simple").with("Take me to your leader!")
        ));
    }

    public static class Greeting extends Component {

        private String name;

        public Greeting(String name) {
            this.name = name;
        }

        @Override
        public void markup() throws IOException {
            el("elaborate").with("Hello " + name + "!");
        }
    }
}
