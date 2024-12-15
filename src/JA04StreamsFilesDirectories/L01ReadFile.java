package JA04StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class L01ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\todor\\Zoho WorkDrive (Dr Todor Proykov)\\My Folders\\GitHub Repositories\\SoftUniJavaAdvanced\\src\\JA04StreamsFilesDirectories\\resources\\input.txt";

        FileInputStream fileStream = new FileInputStream(path);

        int oneByte = fileStream.read();
        while (oneByte >= 0) {
            System.out.print(Integer.toBinaryString(oneByte) + " ");
            oneByte = fileStream.read();
        }
    }
}