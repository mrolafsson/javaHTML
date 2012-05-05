package twigkit.html;

import java.io.Writer;

/**
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
