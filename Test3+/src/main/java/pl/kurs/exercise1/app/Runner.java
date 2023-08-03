package pl.kurs.exercise1.app;

import pl.kurs.exercise1.service.FileFinder;

import java.io.File;


public class Runner {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\Wiktor\\IdeaProjects";

        FileFinder fileFinder = new FileFinder();
        File largestJavaFile = fileFinder.findLargestJavaFile(directoryPath);

        if (largestJavaFile != null) {
            System.out.println("Największy plik Java: " + largestJavaFile.getAbsolutePath());
            System.out.println("Rozmiar: " + largestJavaFile.length() + " bajtów.");
        } else {
            System.out.println("Nie znaleziono plików Java w katalogu: " + directoryPath);
        }
    }
}

//    Największy plik Java: C:\Users\Wiktor\IdeaProjects\OperationOnFiles\src\main\java\pl\kurs\homework\services\PersonService.java
//    Rozmiar: 6435 bajtów.
