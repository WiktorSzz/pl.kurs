package pl.kurs.exercise3.service;

public class FibonacciService {

    public static int getFibonacciIndex(int number) {
        int previous = 0;
        int current = 1;
        int index = 1;

        while (current < number) {
            int next = current + previous;
            previous = current;
            current = next;
            index++;

            if (current == number) {
                return index;
            }
        }
        return -1;
    }
}








