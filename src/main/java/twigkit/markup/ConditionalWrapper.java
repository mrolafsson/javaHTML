package twigkit.markup;

/**
 * Use it to conditionally add {@link Content} inline based on a boolean test using {@link Use} and {@link Otherwise}
 * wrappers.
 *
 * Important: Irrespective of which conditional wrapper is executed, all code in the body WILL STILL BE EXECUTED the only
 * difference is that {@link Content} tags will not write anything to the stream because they will be passed
 * a {@link DummyWriter}. As a workaround, if you use the {@link twigkit.markup.MarkupCapability#exec(Code)} method and pass it a {@link twigkit.markup.html.Code} instance then
 * that code will only be run if the condition is met.
 *
 * Important: You must terminate a {@link Use} or {@link twigkit.markup.MarkupCapability#when(boolean)} with at least an empty {@link twigkit.markup.ConditionalWrapper#otherwise(Content...)}.
 *
 * @author mr.olafsson
 */
public abstract class ConditionalWrapper extends Content {

    // True if this conditional is nested within another that evaluated to false
    private final boolean nestedFalse;

    private MarkupCapability markupCapability;

    public ConditionalWrapper(MarkupCapability markupCapability) {
        this(markupCapability, false);
    }

    public ConditionalWrapper(MarkupCapability markupCapability, boolean nestedFalse) {
        super(markupCapability.getWriter());
        this.markupCapability = markupCapability;
        this.nestedFalse = nestedFalse;
    }

    public Otherwise use(Content... html) {
        return new Otherwise(markupCapability);
    }

    public Content otherwise(Content... html) {
        return this;
    }

    protected MarkupCapability getHtmlCapability() {
        return markupCapability;
    }

    public static class Use extends ConditionalWrapper {

        public Use(MarkupCapability markupCapability, boolean nestedFalse) {
            super(markupCapability, nestedFalse);
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
        public Otherwise(MarkupCapability htmlCapability) {
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
