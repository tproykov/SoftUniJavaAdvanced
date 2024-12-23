package JA04StreamsFilesDirectories;

import java.io.File;

public class L07ListFiles {

    public static void main(String[] args) {

        File folder = new File("src/JA04StreamsFilesDirectories/resources");

        File[] files = folder.listFiles();
        for (File file : files) {
            if (!file.isDirectory()) {
                System.out.printf("%s: [%d]\n", file.getName(), file.length());
            }
        }
    }
}