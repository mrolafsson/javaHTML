package twigkit.markup;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author mr.olafsson
 */
public abstract class Loop<T> {

    private Collection<T> list;

    public Loop(Collection<T> list) {
        this.list = list;
    }

    public Loop(T... list) {
        this.list = Arrays.asList(list);
    }

    public void run() {
        for (T item : list) {
            try {
                each(item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void each(T item) throws Exception;
}
