package twigkit.html;

/**
 * Use it to conditionally add {@link Content} inline based on a boolean test using {@link Use} and {@link Otherwise}
 * wrappers.
 *
 * Important: Irrespective of which conditional wrapper is executed, all code in the body WILL STILL BE EXECUTED the only
 * difference is that {@link Content} tags will not write anything to the stream because they will be passed
 * a {@link DummyWriter}. As a workaround, if you use the {@link HtmlCapabilityImpl#exec(Code)} method and pass it a {@link Code} instance then
 * that code will only be run if the condition is met.
 *
 * Important: You must terminate a {@link Use} or {@link twigkit.html.HtmlCapability#when(boolean)} with at least an empty {@link twigkit.html.ConditionalWrapper#otherwise(Content...)}.
 *
 * @author mr.olafsson
 */
public abstract class ConditionalWrapper extends Content {

    // True if this conditional is nested within another that evaluated to false
    private final boolean nestedFalse;

    private HtmlCapabilityImpl htmlCapability;

    public ConditionalWrapper(HtmlCapabilityImpl htmlCapability) {
        this(htmlCapability, false);
    }

    public ConditionalWrapper(HtmlCapabilityImpl htmlCapability, boolean nestedFalse) {
        super(htmlCapability.getWriter());
        this.htmlCapability = htmlCapability;
        this.nestedFalse = nestedFalse;
    }

    public Otherwise use(Content... html) {
        return new Otherwise(htmlCapability);
    }

    public Content otherwise(Content... html) {
        return this;
    }

    protected HtmlCapabilityImpl getHtmlCapability() {
        return htmlCapability;
    }

    public static class Use extends ConditionalWrapper {
        public Use(HtmlCapabilityImpl htmlCapability) {
            this(htmlCapability, false);
        }

        public Use(HtmlCapabilityImpl htmlCapability, boolean nestedFalse) {
            super(htmlCapability, nestedFalse);
        }

        public Otherwise use(Content... html) {
            if (writer instanceof DummyWriter && !super.nestedFalse) {
                getHtmlCapability().setWriter(((DummyWriter) writer).getReal());
            } else {
                getHtmlCapability().setWriter(new DummyWriter(getHtmlCapability()));
            }
            return new Otherwise(getHtmlCapability());
        }
    }

    public static class Otherwise extends ConditionalWrapper {
        public Otherwise(HtmlCapabilityImpl htmlCapability) {
            super(htmlCapability);
        }

        @Override
        public Content otherwise(Content... html) {
            if (writer instanceof DummyWriter && !super.nestedFalse) {
                getHtmlCapability().setWriter(((DummyWriter) writer).getReal());
            }
            return this;
        }
    }
}
