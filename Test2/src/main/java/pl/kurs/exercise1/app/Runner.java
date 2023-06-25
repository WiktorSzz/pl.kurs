package pl.kurs.exercise1.app;

import pl.kurs.exercise1.models.Figure;
import pl.kurs.exercise1.services.FigureService;

public class Runner {
    public static void main(String[] args) throws Exception {
        Figure[] figures = {Figure.createSquare(10), Figure.createCircle(20), Figure.createRectangle(10, 20), Figure.createSquare(15)};

        for (Figure f : figures) {
            System.out.println(f);
        }

        for (Figure f : figures) {
            if (f.equals(Figure.createRectangle(10, 20))) {
                System.out.println("tu powinno wejsc");
            }
        }

        System.out.println(FigureService.getFigureWithLargestArea(figures));
        System.out.println(FigureService.getFigureWithLargestPerimeter(figures));


    }
}




