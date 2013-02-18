package twigkit.html;

import java.io.IOException;

/**
 * Thrown when invalid HTML is being output or when validation of output fails.
 *
 * @author mr.olafsson
 */
public class HtmlException extends IOException {

    private Type type;

    public static enum Type { UNCLOSED_TAG, TAG_ALREADY_CLOSED }

    public HtmlException(Type type) {
        this.type = type;
    }

    public HtmlException(Type type, String message) {
        super(message);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
