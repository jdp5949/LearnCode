package interview_practice;

import java.util.ArrayList;
import java.util.List;

public class AllAnsFor {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        ArrayList ans = new ArrayList<>(50);
        for (int z = 0; z <= 200; z++) {
            double y = (19000 - 99 * z) / 4.0;
            double x = 1000 - ((19000 - 99 * z) / 4.0) - z;

            if ((x% 1 == 0 && y% 1 == 0) && y >= 0 && x >= 0 && x + y + z == 1000 && (0.05 * x + 0.25 * y + 5 * z) == 1000) {
                ans.add(new ArrayList(List.of(x,y,z)));
            }
        }
        System.out.println("All solutions:");
        System.out.println(ans);
        System.out.println(ans.size());
        long endTime = System.nanoTime();

        // Calculate the elapsed time in milliseconds
        long elapsedTimeMillis = (long) ((endTime - startTime)/1_000_00);
        System.out.println("Elapsed Time: " + elapsedTimeMillis + " ms");
}
}
