package JA04StreamsFilesDirectories;

import java.io.File;

public class E08GetFolderSize {

    public static void main(String[] args) {

        String path = "src/JA04StreamsFilesDirectories/resources";

        File directory = new File(path);

        int totalSize = 0;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            assert files != null;
            for (File file : files) {
                if (!file.isDirectory()) {
                    totalSize += (int) file.length();
                }
            }
        }

        System.out.println(totalSize);
    }
}