package JA04StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class E02SumBytes {

    public static void main(String[] args) {

        String path = "src/JA04StreamsFilesDirectories/resources/input1.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))) {

            String line = bufferedReader.readLine();

            long sum = 0;
            while (line != null) {

                for (char character : line.toCharArray()) {
                    sum += character;
                }

                line = bufferedReader.readLine();
            }

            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}