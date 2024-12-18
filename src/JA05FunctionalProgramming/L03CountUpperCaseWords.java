package JA05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class L03CountUpperCaseWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .filter(word -> Character.isUpperCase(word.charAt(0)))
                .toArray(String[]::new);

        System.out.println(words.length);
        for (String word : words) {
            System.out.println(word);
        }



    }

}
