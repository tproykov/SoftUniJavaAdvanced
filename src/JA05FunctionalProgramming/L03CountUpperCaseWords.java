package JA05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L03CountUpperCaseWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(word -> Character.isUpperCase(word.charAt(0)))
                .toList();

        System.out.println(words.size());
        words.forEach(System.out::println);
    }
}