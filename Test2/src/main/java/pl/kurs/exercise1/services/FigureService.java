package pl.kurs.exercise1.services;

import pl.kurs.exercise1.models.Figure;

public class FigureService {
    private static int figureCounter = 0;

    public FigureService() {
    }

    public static Figure getFigureWithLargestPerimeter(Figure[] figures) {
        Figure figureWithLargestPerimeter = figures[0];
        double largestPerimeter = figureWithLargestPerimeter.calculatePerimeter();

        for (int i = 1; i < figures.length; i++) {
            if (figures[i] == null) {
                throw new NullPointerException("Błedne dane!!!");
            }
            double perimeter = figures[i].calculatePerimeter();
            if (perimeter > largestPerimeter) {
                largestPerimeter = perimeter;
                figureWithLargestPerimeter = figures[i];
            }
        }

        return figureWithLargestPerimeter;
    }

    public static Figure getFigureWithLargestArea(Figure[] figures) {
        Figure figureWithLargestArea = figures[0];
        double largestArea = figureWithLargestArea.calculateArea();

        for (int i = 1; i < figures.length; i++) {
            if (figures[i] == null) {
                throw new NullPointerException("Błedne dane!!!");
            }
            double area = figures[i].calculateArea();
            if (area > largestArea) {
                largestArea = area;
                figureWithLargestArea = figures[i];
            }
        }

        return figureWithLargestArea;
    }

    public static int getNextFigureNumber() {
        return ++figureCounter;
    }
}

