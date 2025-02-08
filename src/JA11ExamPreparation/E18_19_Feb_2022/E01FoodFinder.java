package JA11ExamPreparation.E18_19_Feb_2022;

import java.util.*;

public class E01FoodFinder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Character> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(s -> s.charAt(0))
                .forEach(vowels::offer);

        Deque<Character> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(s -> s.charAt(0))
                .forEach(consonants::push);

        Set<Character> foundCharacters = new HashSet<>();
        String[] words = {"pear", "flour", "pork", "olive"};

        while (!consonants.isEmpty()) {

            char currentVowel = vowels.poll();
            char currentConsonant = consonants.poll();

            findCharacters(words, foundCharacters, currentVowel, currentConsonant);

            vowels.offer(currentVowel);
        }

        List<String> foundWords = new ArrayList<>();
        for (String word : words) {
            boolean foundWord = true;
            for (int i = 0; i < word.length(); i++) {
                char currentCharacter = word.charAt(i);
                if (!foundCharacters.contains(currentCharacter)) {
                    foundWord = false;
                }
            }
            if (foundWord) {
                foundWords.add(word);
            }
        }

        System.out.println("Words found: " + foundWords.size());
        for (String word : foundWords) {
            System.out.println(word);
        }
    }

    private static void findCharacters(String[] words, Set<Character> foundCharacters,
                                       char currentVowel, char currentConsonant) {
        for (String word : words) {
            if (word.contains(currentVowel + "")) {
                foundCharacters.add(currentVowel);
            }
            if (word.contains(currentConsonant + "")) {
                foundCharacters.add(currentConsonant);
            }
        }
    }
}