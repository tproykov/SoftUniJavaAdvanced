package JA04StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L05WriteEveryThirdLine {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "src/JA04StreamsFilesDirectories/resources/input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(fileInputStream);

        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {

            lines.add(scanner.nextLine());

            // scanner.nextLine();
        }

        for (int i = 0; i < lines.size(); i++) {

            if ((i + 1) % 3 == 0) {
                System.out.println(lines.get(i));
            }
        }
    }
}