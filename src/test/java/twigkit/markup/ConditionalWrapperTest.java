package twigkit.markup;

import org.junit.Test;
import twigkit.markup.html.AbstractHtmlCapabilityTest;

import java.util.Calendar;

/**
 * Unit tests for the {@link twigkit.markup.ConditionalWrapper} classes.
 *
 * @author mr.olafsson
 */
public class ConditionalWrapperTest extends AbstractHtmlCapabilityTest {

    @Test
    public void testUsingComplexExpression() throws Exception {
        Content greeting = div().with(
                when(Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 11).use(
                        h1().with("Good morning!")
                ).otherwise(
                        h2().with("Hello!")
                )
        );
        System.out.println(greeting);
    }

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
