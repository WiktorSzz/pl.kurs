package pl.kurs.exercise4.models;

public class MinMax<T extends Comparable<T>> {
    private T max;
    private T min;


    public MinMax(T max, T min) {
        this.max = max;
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public T getMin() {
        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Max: ").append(max).append("\n").append("Min: ").append(min);
        return sb.toString();
    }

}
