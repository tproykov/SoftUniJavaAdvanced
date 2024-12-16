package JA04StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class E01SumLInes {

    public static void main(String[] args) {

        String path = "src/JA04StreamsFilesDirectories/resources/input1.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))) {

            String line = bufferedReader.readLine();

            while (line != null) {

                long sum = 0;
                for (char character : line.toCharArray()) {
                    sum += character;
                }

                System.out.println(sum);

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}