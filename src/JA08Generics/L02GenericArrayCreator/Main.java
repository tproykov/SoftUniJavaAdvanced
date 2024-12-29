package JA08Generics.L02GenericArrayCreator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] names = ArrayCreator.create(5, "Hello");
        Integer[] numbers = ArrayCreator.create(5, 3);

        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(numbers));
    }
}
