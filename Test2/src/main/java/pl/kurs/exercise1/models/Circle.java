package pl.kurs.exercise1.models;

import pl.kurs.exercise1.services.FigureService;

import java.util.Objects;

public class Circle extends Figure {
    public int r;
    private int figureNumber;

    public Circle(int r) {
        this.r = r;
        this.figureNumber = FigureService.getNextFigureNumber();
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI_NUMBER * r;
    }

    @Override
    public double calculateArea() {
        return PI_NUMBER * r * r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return r == circle.r;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r);
    }

    @Override
    public String toString() {
            return "Figura nr " + figureNumber + ": Koło o promieniu " + r + ".";
    }
}