package pl.kurs.exercise1.service;

import java.io.File;

public class FileFinder {

    private File largestFile = null;
    private long largestFileSize = 0;

    public File findLargestJavaFile(String directoryPath) {
        File dir = new File(directoryPath);
        findLargestJavaFile(dir);
        return largestFile;
    }

    private void findLargestJavaFile(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        findLargestJavaFile(file);
                    } else if (file.getName().endsWith(".java")) {
                        long fileSize = file.length();
                        if (fileSize > largestFileSize) {
                            largestFile = file;
                            largestFileSize = fileSize;
                        }
                    }
                }
            }
        }
    }
}