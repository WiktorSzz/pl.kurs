package pl.kurs.exercise4.app;

import pl.kurs.exercise4.models.MinMax;
import pl.kurs.exercise4.service.MinMaxService;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("Boat", "Amfibia");
        MinMax<String> stringMinMax = MinMaxService.getMinAndMax(stringList);
        System.out.println("Min string: " + stringMinMax.getMin());
        System.out.println("Max string: " + stringMinMax.getMax());

        List<Integer> integerList = Arrays.asList(5, null, 9, 1, 7);
        MinMax<Integer> integerMinMax = MinMaxService.getMinAndMax(integerList);
        System.out.println("Min integer: " + integerMinMax.getMin());
        System.out.println("Max integer: " + integerMinMax.getMax());

        List<Double> doubleList = Arrays.asList(5.4, 2.3, 9.2, 1.2, 7.8);
        MinMax<Double> doubleMinMax = MinMaxService.getMinAndMax(doubleList);
        System.out.println("Min double: " + doubleMinMax.getMin());
        System.out.println("Max double: " + doubleMinMax.getMax());

        List<Character> characterList = Arrays.asList('e', 'h', 'f', 'y', 't');
        MinMax<Character> characterMinMax = MinMaxService.getMinAndMax(characterList);
        System.out.println("Min char: " + characterMinMax.getMin());
        System.out.println("Max char: " + characterMinMax.getMax());
    }

}


