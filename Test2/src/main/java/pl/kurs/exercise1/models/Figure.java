package pl.kurs.exercise1.models;

public abstract class Figure {
    double PI_NUMBER = Math.PI;

    public abstract double calculatePerimeter();

    public abstract double calculateArea();


    public Figure() {
    }

    public static Figure createSquare(int a) throws Exception {
        if (a < 0) {
            throw new IllegalArgumentException("Bok figury nie może być ujemny.");
        }
        return new Square(a);
    }

    public static Figure createCircle(int r) {
        if (r < 0) {
            throw new IllegalArgumentException("Promień koła nie może być ujemny.");
        }
        return new Circle(r);
    }

    public static Figure createRectangle(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Bok figury nie może być ujemny.");
        }
        return new Rectangle(a, b);
    }

}
