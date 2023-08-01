package pl.kurs.exercise2.app;

import pl.kurs.exercise2.service.FileService;

public class Runner {
    public static void main(String[] args) {
        FileService fileServices = new FileService();
        fileServices.processFiles();

//        Wynik z konsoli:
//        MONDAY=52
//        TUESDAY=65
//        WEDNESDAY=109
//        THURSDAY=76
//        FRIDAY=83
//        SATURDAY=98
//        SUNDAY=54

    }

}
