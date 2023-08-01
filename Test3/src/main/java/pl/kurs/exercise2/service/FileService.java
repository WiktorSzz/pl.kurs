package pl.kurs.exercise2.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public void processFiles() {
        String directoryPath = "C:\\Users\\Wiktor\\IdeaProjects";

        List<File> myJavaFiles = new ArrayList<>();
        findJavaFiles(new File(directoryPath), myJavaFiles);

        int[] fileCountArray = new int[DayOfWeek.values().length];

        for (File file : myJavaFiles) {
            DayOfWeek fileDayOfWeek = getDayOfWeekFromFile(file);
            int fileDayOfWeekValue = fileDayOfWeek.ordinal();
            fileCountArray[fileDayOfWeekValue]++;
        }

        DayOfWeek[] daysOfWeek = DayOfWeek.values();
        for (int i = 0; i < daysOfWeek.length; i++) {
            DayOfWeek dayOfWeek = daysOfWeek[i];
            int fileCount = fileCountArray[i];
            switch (dayOfWeek) {
                case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY ->
                        System.out.println(dayOfWeek + "=" + fileCount);
            }
        }
    }

    public void findJavaFiles(File dir, List<File> fileList) {
        if (!dir.isDirectory()) {
            throw new RuntimeException("Dir powinien być folderem!");
        }
        File[] filesArray = dir.listFiles();
        for (File file : filesArray) {
            if (file.isDirectory()) {
                findJavaFiles(file, fileList);
            } else if (file.getName().endsWith(".java")) {
                fileList.add(file);
            }
        }
    }

    public static DayOfWeek getDayOfWeekFromFile(File file) {
        try {
            BasicFileAttributes bfa = Files.readAttributes(Path.of(file.getAbsolutePath()), BasicFileAttributes.class);

            if (bfa != null) {
                Instant instant = bfa.creationTime().toInstant();
                LocalDate ld = LocalDate.ofInstant(instant, ZoneOffset.UTC);
                return ld.getDayOfWeek();
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }

}
