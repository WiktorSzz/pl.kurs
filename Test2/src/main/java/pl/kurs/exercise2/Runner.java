package pl.kurs.exercise2;

public class Runner {
    public static void main(String[] args) {
        long startTime1 = System.nanoTime();
        String string = " ";
        for (int i = 0; i < 1234; i++) {
            string += "hej, co tam?";
        }
        long finishTime1 = System.nanoTime();
        long totalTime1 = finishTime1 - startTime1;
        System.out.println("Czas potrzebny na wykonanie konkatenacji Stirngów: " + totalTime1 + " ns");

        long startTime2 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1234; i++) {
            sb.append("hej, co tam?");
        }
        long finishTime2 = System.nanoTime();
        long totalTime2 = finishTime2 - startTime2;
        System.out.println("Czas potrzebny na wykonanie konkatenacji z użyciem StringBuilder: " + totalTime2 + " ns");

        double timeRatio = ((double) totalTime2 / totalTime1);
        System.out.println("timeRatio = " + timeRatio);


    }
}