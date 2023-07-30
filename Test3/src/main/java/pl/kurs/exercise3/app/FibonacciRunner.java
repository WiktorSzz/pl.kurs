package pl.kurs.exercise3.app;

import pl.kurs.exercise3.service.FibonacciService;

public class FibonacciRunner {
    public static void main(String[] args) {

        int result = FibonacciService.getFibonacciIndex(10);
        int result1 = FibonacciService.getFibonacciIndex(3);
        int result2 = FibonacciService.getFibonacciIndex(7);
        int result3 = FibonacciService.getFibonacciIndex(21);
        int result4 = FibonacciService.getFibonacciIndex(4181);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

}

