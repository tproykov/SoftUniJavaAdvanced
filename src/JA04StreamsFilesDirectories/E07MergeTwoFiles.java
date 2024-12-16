package JA04StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class E07MergeTwoFiles {

    public static void main(String[] args) {

        String inputOne = "src/JA04StreamsFilesDirectories/resources/inputOne.txt";
        String inputTwo = "src/JA04StreamsFilesDirectories/resources/inputTwo.txt";
        String output = "src/JA04StreamsFilesDirectories/resources/output.txt";

        try (BufferedReader reader1 = Files.newBufferedReader(Path.of(inputOne));
             BufferedReader reader2 = Files.newBufferedReader(Path.of(inputTwo));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(output))) {

            String line = reader1.readLine();

            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = reader1.readLine();
            }

            line = reader2.readLine();

            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = reader2.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}