package JA04StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class E04CountCharacterTypes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = "src/JA04StreamsFilesDirectories/resources/input1.txt";

        String output = "src/JA04StreamsFilesDirectories/resources/output.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(input));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(output))
        ) {

            int vowels = 0;
            int punctuation = 0;
            int others = 0;

            String line = bufferedReader.readLine();
            while (line != null) {

                for (int i = 0; i < line.length(); i++) {

                    char character = line.charAt(i);

                    if (character == 'a' || character == 'e' || character == 'i' || character == 'o'
                            || character == 'u') {
                        vowels++;
                    }
                    else if (character == '!' || character == ',' || character == '.' || character == '?') {
                        punctuation++;
                    }
                    else {
                        if (character != ' ') {
                            others++;
                        }
                    }
                }

                line = bufferedReader.readLine();
            }

            bufferedWriter.write("Vowels: " + vowels + "\n");
            bufferedWriter.write("Others: " + others + "\n");
            bufferedWriter.write("Punctuation: " + punctuation + "\n");
            bufferedWriter.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}