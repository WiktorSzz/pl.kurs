package pl.kurs.exercise4.app;

import pl.kurs.exercise4.models.MinMax;
import pl.kurs.exercise4.service.MinMaxService;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> stringList = List.of("Car", "Bike", "Boat", "Amfibia");
        MinMax<String> stringMinMax = MinMaxService.getMinAndMax(stringList);
        System.out.println("Min string: " + stringMinMax.getMin());
        System.out.println("Max string: " + stringMinMax.getMax());

        List<Integer> integerList = List.of(5, -2, 9, 1, 7);
        MinMax<Integer> integerMinMax = MinMaxService.getMinAndMax(integerList);
        System.out.println("Min integer: " + integerMinMax.getMin());
        System.out.println("Max integer: " + integerMinMax.getMax());

        List<Double> doubleList = List.of(5.4, 2.3, 9.2, 1.2, 7.8);
        MinMax<Double> doubleMinMax = MinMaxService.getMinAndMax(doubleList);
        System.out.println("Min double: " + doubleMinMax.getMin());
        System.out.println("Max double: " + doubleMinMax.getMax());

        List<Character> characterList = List.of('e', 'h', 'f', 'y', 't');
        MinMax<Character> characterMinMax = MinMaxService.getMinAndMax(characterList);
        System.out.println("Min char: " + characterMinMax.getMin());
        System.out.println("Max char: " + characterMinMax.getMax());

    }

}
