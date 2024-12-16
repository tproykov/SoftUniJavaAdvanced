package JA04StreamsFilesDirectories;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class E12CreateZipArchive {

    public static void main(String[] args) {

        String input1 = "src/JA04StreamsFilesDirectories/resources/input.txt";
        String input2 = "src/JA04StreamsFilesDirectories/resources/input1.txt";
        String input3 = "src/JA04StreamsFilesDirectories/resources/input2.txt";
        String input4 = "src/JA04StreamsFilesDirectories/resources/inputOne.txt";
        String input5 = "src/JA04StreamsFilesDirectories/resources/inputTwo.txt";
        String input6 = "src/JA04StreamsFilesDirectories/resources/words.txt";
        String input7 = "src/JA04StreamsFilesDirectories/resources/text.txt";
        String output = "src/JA04StreamsFilesDirectories/resources/files.zip";

        List<String> inputPaths = List.of(input1, input2, input3, input4, input5, input6, input7);

        try(
                ZipOutputStream zip = new ZipOutputStream(Files.newOutputStream(Path.of(output)))

        ) {

            for (String path : inputPaths) {
                File fileToZip = new File(path);
                FileInputStream fileInputStream = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zip.putNextEntry(zipEntry);

                int read = fileInputStream.read();
                while (read != -1){
                    zip.write(read);
                    read = fileInputStream.read();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}