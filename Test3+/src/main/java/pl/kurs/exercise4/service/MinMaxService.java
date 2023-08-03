package pl.kurs.exercise4.service;

import pl.kurs.exercise4.models.MinMax;

import java.util.List;
import java.util.Objects;

public class MinMaxService {
    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new NullPointerException("Lista jest pusta lub zawiera elementy null!");
        }

        T min = elements.stream()
                .filter(Objects::nonNull)
                .min(Comparable::compareTo)
                .orElse(null);

        T max = elements.stream()
                .filter(Objects::nonNull)
                .max(Comparable::compareTo)
                .orElse(null);

        return new MinMax<>(max, min);
    }
}


















