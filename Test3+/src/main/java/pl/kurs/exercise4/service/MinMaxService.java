package pl.kurs.exercise4.service;

import pl.kurs.exercise4.models.MinMax;

import java.util.List;

//    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
//        if (elements == null || elements.isEmpty()) {
//            throw new NullPointerException("Lista jest pusta lub zawiera elementy null!");
//        }
//        T min = null;
//        T max = null;
//
//        for (T element : elements) {
//            if (element == null) {
//                continue;
//            }
//
//            if (min == null || element.compareTo(min) < 0) {
//                min = element;
//            }
//            if (max == null || element.compareTo(max) > 0) {
//                max = element;
//            }
//        }
//
//        return new MinMax<>(min, max);
//    }


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


















