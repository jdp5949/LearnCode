package interview_practice;
import java.util.ArrayList;
import java.util.List;
public class AllAnsRec {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<List<Double>> ans = new ArrayList<>(50);
        findSolutions(0, 1000,  ans);
        if (ans.isEmpty()) {
            System.out.println("No solutions found.");
        } else {
            System.out.println("All solutions:");
            System.out.println(ans);
            System.out.println(ans.size());
        }
        long endTime = System.nanoTime();
        // Calculate the elapsed time in milliseconds
        long elapsedTimeMillis = (long) ((endTime - startTime)/1_000_00);
        System.out.println("Elapsed Time: " + elapsedTimeMillis + " ms");
    }

    public static void findSolutions(int z, int remaining,List<List<Double>>  solutions) {
        if (remaining < 0 || z > 200) {
            return;
        }
        mathCal(z, solutions);
        findSolutions(z + 1, remaining - 1, solutions);
    }

    static void mathCal(int z, List<List<Double>> solutions) {
        // x+y+z=1000 and 0.05x+0.25y+5z=1000
        // x+y=1000-z
        // 0.05x+0.25y=1000-5z
        // simplify to in terms of z and solve for y and x
        // 0.05(1000-z-y)+0.25y=1000-5z
        // 50-0.05z+0.25y=1000-5z
        // 0.25y=950-4.95z
        // y=(19000 - 99 * z) / 4.0
        // x=1000-y-z
        double y = (19000 - 99 * z) / 4.0;
        double x = 1000 - y - z;
        if ( x%1==0 && y%1==0 &&y >= 0 && x >= 0 && x + y + z == 1000 && (0.05 * x + 0.25 * y + 5 * z) == 1000) {
            solutions.add(new ArrayList(List.of(x,y,z)));
        }
    }
}
