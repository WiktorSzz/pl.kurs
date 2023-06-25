package pl.kurs.exercise1.models;

import pl.kurs.exercise1.services.FigureService;

import java.util.Objects;

public class Rectangle extends Figure {
    private int a;
    private int b;
    private int figureNumber;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
        this.figureNumber = FigureService.getNextFigureNumber();
    }

    @Override
    public double calculatePerimeter() {
        return (2 * a) + (2 * b);
    }

    @Override
    public double calculateArea() {
        return a * b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return a == rectangle.a && b == rectangle.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "Figura nr " + figureNumber + ": Prostokat o bokach " + a + "x" + b + ".";

    }
}
