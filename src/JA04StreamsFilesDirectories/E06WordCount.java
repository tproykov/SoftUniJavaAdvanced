package JA04StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

            for (String word : wordList) {





            }





        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

}
