package JA04StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class L04ExtractIntegers {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\todor\\Zoho WorkDrive (Dr Todor Proykov)\\My Folders\\GitHub Repositories\\SoftUniJavaAdvanced\\src\\JA04StreamsFilesDirectories\\resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNextLine()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}