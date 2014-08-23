package twigkit.html;

import org.junit.Test;

import java.util.Calendar;

/**
 * Unit tests for the {@link ConditionalWrapper} classes.
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
                when(true).use(
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
        assertNotEquals("<div><span>Hello world!</span><span>Go go go!</span><span>no others</span></div>", div);
    }

    @Test
    public void testNoOtherwiseFalse() throws Exception {
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

    @Test
    public void testNestedConditionals() throws Exception {
        ContainerTag div = div().with(
                when(false).use(
                        div().with(
                                text("Outside before - do not show"),
                                when(false).use(
                                        span().with("Do not show")
                                ).otherwise(
                                        span().with("Do not show")
                                ),
                                text("Outside after - do not show")
                        )
                ).otherwise(),
                div().with("Show me!")
        ).append(
                div().with("and me!")
        );

        assertEquals("<div><div>Show me!</div></div><div>and me!</div>", div);
    }
}
