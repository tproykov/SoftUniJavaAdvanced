package JA04StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class L03CopyBytes {

    public static void main(String[] args) throws IOException {

        String pathToRead = "src/JA04StreamsFilesDirectories/resources/input.txt";
        FileInputStream fileInputStream = new FileInputStream(pathToRead);

        String pathToWrite = "src/JA04StreamsFilesDirectories/resources/03.CopyBytesOutput.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(pathToWrite);

        int oneByte = fileInputStream.read();
        while (oneByte >= 0) {
            if (oneByte == 32 || oneByte == 10) {
                fileOutputStream.write(oneByte);
            } else {
                String digits = String.valueOf(oneByte);
                for (int i = 0; i < digits.length(); i++) {
                    fileOutputStream.write(digits.charAt(i));
                }
            }
            oneByte = fileInputStream.read();
        }

        fileOutputStream.close();
    }
}