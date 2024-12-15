package JA04StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class L02WriteToFile {

    public static void main(String[] args) throws IOException {

        String pathToRead = "C:\\Users\\todor\\Zoho WorkDrive (Dr Todor Proykov)\\My Folders\\GitHub Repositories\\SoftUniJavaAdvanced\\src\\JA04StreamsFilesDirectories\\resources\\input.txt";
        FileInputStream fileInputStream = new FileInputStream(pathToRead);

        String pathToWrite = "C:\\Users\\todor\\Zoho WorkDrive (Dr Todor Proykov)\\My Folders\\GitHub Repositories\\SoftUniJavaAdvanced\\src\\JA04StreamsFilesDirectories\\resources\\output.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(pathToWrite);

        int oneByte = fileInputStream.read();
        while (oneByte >= 0) {
            char currentChar = (char) oneByte;
            if (currentChar != ',' && currentChar != '.' && currentChar != '!' && currentChar != '?') {
                fileOutputStream.write(oneByte);
            }
            oneByte = fileInputStream.read();
        }

        fileOutputStream.close();
    }
}