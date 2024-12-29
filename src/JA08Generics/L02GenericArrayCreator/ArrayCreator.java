package JA08Generics.L02GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    // {access_modifier} static {<generic_parameter>} {return_type} {name}(){}
    public static <T> T[] create(int length, T item) {

        T[] array = (T[]) Array.newInstance(item.getClass(), length);

        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }

    public static  <T> T[] create(Class<T> cl, int length, T item) {

        T[] array = (T[]) Array.newInstance(cl, length);

        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }
}