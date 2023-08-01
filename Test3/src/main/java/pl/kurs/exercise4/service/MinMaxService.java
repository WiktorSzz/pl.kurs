package pl.kurs.exercise4.service;

import pl.kurs.exercise4.models.MinMax;

import java.util.List;

public class MinMaxService {
    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new NullPointerException("Lista jest pusta lub zawiera elementy null!");
        }
        T min = null;
        T max = null;

        for (T element : elements) {
            if (element == null) {
                continue;
            }

            if (min == null || element.compareTo(min) < 0) {
                min = element;
            }
            if (max == null || element.compareTo(max) > 0) {
                max = element;
            }
        }

        return new MinMax<>(min, max);
    }
}

















