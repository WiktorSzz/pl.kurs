package pl.kurs.exercise4.service;

import pl.kurs.exercise4.models.MinMax;

import java.util.List;

public class MinMaxService {
    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            return null;
        }

        T min = elements.get(0);
        T max = elements.get(0);

        for (T element : elements) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return new MinMax<>(max, min);
    }
}
