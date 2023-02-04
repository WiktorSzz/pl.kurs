package pl.kurs.exercise1.services;

import java.util.Scanner;

public class ScannerService {
    Scanner scanner;
    String strings[];
    private int[] numbers;
    private int maxNum = Integer.MIN_VALUE;
    private int minNum = Integer.MAX_VALUE;
    private int primeNum = 0;
    private int divisors = 0;
    private int maxDivisorsNum = 0;


    public ScannerService(Scanner scanner) {
        this.scanner = scanner;
        strings = scanner.nextLine().split(" ");
        numbers = new int[strings.length];
    }

    public int findMaxNum() {
        for (int i = 0; i < strings.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
            if (numbers[i] > maxNum) {
                maxNum = numbers[i];
            }
        }
        System.out.println("Twoja największa liczba to: " + maxNum);
        return maxNum;
    }

    public int findMinNum() {
        for (int i = 0; i < strings.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
            if (numbers[i] < minNum) {
                minNum = numbers[i];
            }
        }
        System.out.println("Twoja najmniejsza liczba to: " + minNum);
        return minNum;
    }

    public int findNumWithGreatestNumDivisors() {
        for (int i = 0; i < strings.length; i++) {
            int divisorsForCurrentNumber = 0;
            for (int j = 1; j <= numbers[i]; j++) {
                if (numbers[i] % j == 0) {
                    divisorsForCurrentNumber++;
                }
                if (divisorsForCurrentNumber > divisors) {
                    divisors = divisorsForCurrentNumber;
                    maxDivisorsNum = numbers[i];
                }
            }
            if (divisorsForCurrentNumber == 2) {
                if (numbers[i] > 1) {
                    primeNum++;
                }
            }
        }
        System.out.println("Liczba, która ma najwiecej dzielników: " + maxDivisorsNum);
        System.out.println("Ilosc liczb pierwszych: " + primeNum);
        return maxDivisorsNum;
    }
}