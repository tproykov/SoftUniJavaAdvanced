package JA04StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class E05LineNumbers {

    public static void main(String[] args) {

        String input = "src/JA04StreamsFilesDirectories/resources/input2.txt";

        String output = "src/JA04StreamsFilesDirectories/resources/output.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(input));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(output))
        ) {

            String line = bufferedReader.readLine();

            int counter = 1;
            while (line != null) {

                bufferedWriter.write(counter + ". " + line + "\n");

                counter++;

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
