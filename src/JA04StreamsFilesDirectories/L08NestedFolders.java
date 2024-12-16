package JA04StreamsFilesDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class L08NestedFolders {
    public static void main(String[] args) {
        File folder = new File("src/JA04StreamsFilesDirectories/resources");

        int folderCount = 0;
        Queue<File> folders = new ArrayDeque<>();
        folders.offer(folder);

        while (!folders.isEmpty()) {
            File currentFolder = folders.poll();
            if (currentFolder.isDirectory()) {
                System.out.println(currentFolder.getName());
                folderCount++;

                File[] nestedFolders = currentFolder.listFiles();
                if (nestedFolders != null) {
                    for (File file : nestedFolders) {
                        if (file.isDirectory()) {
                            folders.offer(file);
                        }
                    }
                }
            }
        }

        System.out.println(folderCount + " folders");
    }
}