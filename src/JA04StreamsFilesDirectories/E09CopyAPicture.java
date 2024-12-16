package JA04StreamsFilesDirectories;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class E09CopyAPicture {

    public static void main(String[] args) {

        String inputPath = "src/JA04StreamsFilesDirectories/resources/face2.jpg";
        String outputPath = "src/JA04StreamsFilesDirectories/resources/copy-face2.jpg";

        try (InputStream fis = Files.newInputStream(Path.of(inputPath));
             OutputStream ous = Files.newOutputStream(Path.of(outputPath))
        ) {
            byte[] inputBytes = fis.readAllBytes();
            ous.write(inputBytes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}