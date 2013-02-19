package twigkit.html;

import org.junit.Test;

/**
 * Unit tests for the {@link ConditionalWrapper} classes.
 *
 * @author mr.olafsson
 */
public class ConditionalWrapperTest extends AbstractHtmlCapabilityTest {

    @Test
    public void testTrue() throws Exception {
        ContainerTag div = div().with(

                when(true).use(
                        span().with(
                                text("Hello"),
                                text(" world!")
                        ),
                        span().with(
                                text("Go go go!")
                        )
                ).otherwise(
                        text("No hello!")
                )

        );
        assertEquals("<div><span>Hello world!</span><span>Go go go!</span></div>", div);
    }

    @Test
    public void testFalse() throws Exception {
        ContainerTag div = div().with(

                when(false).use(
                        text("Hello World!")
                ).otherwise(
                        when(false).use(
                                text("Not this either!")
                        ).otherwise(
                                text("No hello!")
                        )
                )

        );
        assertEquals("<div>No hello!</div>", div);
    }

    @Test
    public void testNoOtherwise() throws Exception {
        ContainerTag div = div().with(
                when(false).use(
                        span().with(
                                text("Hello"),
                                text(" world!")
                        ),
                        span().with(
                                text("Go go go!")
                        )
                ),
                span().with(text("no others"))
        );
        assertEquals("<div><span>no others</span></div>", div);
    }
}
