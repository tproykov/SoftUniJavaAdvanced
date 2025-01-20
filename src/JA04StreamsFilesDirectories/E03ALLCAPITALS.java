package JA04StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class E03ALLCAPITALS {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = "src/JA04StreamsFilesDirectories/resources/input1.txt";

        String output = "src/JA04StreamsFilesDirectories/resources/output.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(input));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(output))
        ) {

            String line = bufferedReader.readLine();
            while (line != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);  
        }
    }
}