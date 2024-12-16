package JA04StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class E06WordCount {

    public static void main(String[] args) {
        String wordsFile = "src/JA04StreamsFilesDirectories/resources/words.txt";
        String text = "src/JA04StreamsFilesDirectories/resources/text.txt";
        String output = "src/JA04StreamsFilesDirectories/resources/output.txt";

        try (BufferedReader wordReader = Files.newBufferedReader(Path.of(wordsFile));
             BufferedReader textReader = Files.newBufferedReader(Path.of(text));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(output))
        ) {

            List<String> wordList = new ArrayList<>();
            String line = wordReader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                wordList.addAll(Arrays.asList(words));
                line = wordReader.readLine();
            }

            // Create a map to store word frequencies
            Map<String, Integer> wordFrequency = new HashMap<>();
            for (String word : wordList) {
                wordFrequency.put(word.toLowerCase(), 0);
            }

            // Read the text file and count word frequencies
            String textLine = textReader.readLine();
            while (textLine != null) {
                String[] textWords = textLine.split("\\W+"); // Split by non-word characters
                for (String textWord : textWords) {
                    String lowercaseWord = textWord.toLowerCase();
                    if (wordFrequency.containsKey(lowercaseWord)) {
                        wordFrequency.put(lowercaseWord, wordFrequency.get(lowercaseWord) + 1);
                    }
                }
                textLine = textReader.readLine();
            }

            // Sort words by frequency in descending order
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordFrequency.entrySet());
            sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            // Write results to output file
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                bufferedWriter.write(entry.getKey() + " - " + entry.getValue());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}