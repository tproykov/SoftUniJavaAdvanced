package JA04StreamsFilesDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class L06SortLines {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\todor\\Zoho WorkDrive (Dr Todor Proykov)\\My Folders\\GitHub Repositories\\SoftUniJavaAdvanced\\src\\JA04StreamsFilesDirectories\\resources\\input.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        Collections.sort(lines);

        for (String line : lines) {
            System.out.println(line);
        }
    }
}