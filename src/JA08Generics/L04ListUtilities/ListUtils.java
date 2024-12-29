package JA08Generics.L04ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static <E extends Comparable<E>> E getMin(List<E> list) {

        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        return Collections.min(list);
    }

    public static <E extends Comparable<E>> E getMax(List<E> list) {

        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        return Collections.max(list);
    }
}