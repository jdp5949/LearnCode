package interview_practice;

public class OneAnsFor {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        for (int z = 0; z <= 1000; z++) {
            double y = (19000 - 99 * z) / 4.0;
            double x = 1000 - ((19000 - 99 * z) / 4.0) - z;

            if (y >= 0 && x >= 0 && x + y + z == 1000 && (0.05 * x + 0.25 * y + 5 * z) == 1000) {
                System.out.println("Solution found:");
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("z = " + z);
                long endTime = System.nanoTime();
                // Calculate the elapsed time in milliseconds
                long elapsedTimeMillis = (long) ((endTime - startTime)/1_000_00);
                System.out.println("Elapsed Time: " + elapsedTimeMillis + " ms");
                return; // Exit when a solution is found
            }
        }

        System.out.println("No solution found.");

    }
}
