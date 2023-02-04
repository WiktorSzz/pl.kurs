package pl.kurs.exercise1.app;

import pl.kurs.exercise1.services.ScannerService;

import java.io.IOException;

public class Scanner {
    public static void main(String[] args) throws IOException {
        System.out.println("Wprowadź proszę swoje liczby oddzielone spacją");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        ScannerService scannerService = new ScannerService(scanner);
        scannerService.findMaxNum();
        scannerService.findMinNum();
        scannerService.findNumWithGreatestNumDivisors();
        scanner.close();
    }
}

