package twigkit.html;

import org.junit.Test;

import java.io.IOException;

/**
 * Testing component creation and use.
 *
 * @author mr.olafsson
 */
public class ComponentTest extends AbstractHtmlCapabilityTest {

    @Test
    public void testComponent() throws Exception {
        assertEquals("<div><h1>Hello world!</h1><h2>Take me to your leader!</h2></div>", div().with(
                component(new Greeting("world")),
                h2().with("Take me to your leader!")
        ));
    }

    public static class Greeting extends Component {

        private String name;

        public Greeting(String name) {
            this.name = name;
        }

        @Override
        public void markup() throws IOException {
            h1().with("Hello " + name + "!");
        }
    }
}
