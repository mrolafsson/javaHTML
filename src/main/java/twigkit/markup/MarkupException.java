package twigkit.markup;

import java.io.IOException;

/**
 * Thrown when invalid markup is being output or when validation of output fails.
 *
 * @author mr.olafsson
 */
public class MarkupException extends IOException {

    private Type type;

    public static enum Type { UNCLOSED_TAG, TAG_ALREADY_CLOSED }

    public MarkupException(Type type) {
        this.type = type;
    }

    public MarkupException(Type type, String message) {
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
