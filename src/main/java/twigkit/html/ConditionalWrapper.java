package twigkit.html;

import java.io.Writer;

/**
 * Use it to conditionally add {@link Content} inline based on a boolean test using {@link Use} and {@link Otherwise}
 * wrappers.
 *
 * Important: Irrespective of which conditional wrapper is executed, all code in the body WILL BE EXECUTED the only
 * difference is that {@link Content} tags will not write anything to the stream because they will be passed
 * a {@link DummyWriter}.
 *
 * @author mr.olafsson
 */
public abstract class ConditionalWrapper extends Content {

    private HtmlCapability htmlCapability;

    public ConditionalWrapper(HtmlCapability htmlCapability) {
        super(htmlCapability.getWriter());
        this.htmlCapability = htmlCapability;
    }

    public Otherwise use(Content... html) {
        return new Otherwise(htmlCapability);
    }

    public Content otherwise(Content... html) {
        return this;
    }

    protected HtmlCapability getHtmlCapability() {
        return htmlCapability;
    }

    public static class Use extends ConditionalWrapper {
        public Use(HtmlCapability htmlCapability) {
            super(htmlCapability);
        }

        public Otherwise use(Content... html) {
            if (writer instanceof DummyWriter) {
                getHtmlCapability().setWriter(((DummyWriter) writer).getReal());
            } else {
                getHtmlCapability().setWriter(new DummyWriter(getHtmlCapability()));
            }
            return new Otherwise(getHtmlCapability());
        }
    }

    public static class Otherwise extends ConditionalWrapper {
        public Otherwise(HtmlCapability htmlCapability) {
            super(htmlCapability);
        }

        @Override
        public Content otherwise(Content... html) {
            if (writer instanceof DummyWriter) {
                getHtmlCapability().setWriter(((DummyWriter) writer).getReal());
            }
            return this;
        }
    }
}
