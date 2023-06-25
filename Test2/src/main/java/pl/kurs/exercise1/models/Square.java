package pl.kurs.exercise1.models;

import pl.kurs.exercise1.services.FigureService;

import java.util.Objects;

public class Square extends Figure {
    private int a;
    private int figureNumber;

    public Square(int a) {
        this.a = a;
        this.figureNumber = FigureService.getNextFigureNumber();
    }


    @Override
    public double calculatePerimeter() {
        return 4 * a;
    }

    @Override
    public double calculateArea() {
        return a * a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.a, a) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public String toString() {
        return "Figura nr " + figureNumber + ": Kwadrat o boku " + a + ".";
    }


}
