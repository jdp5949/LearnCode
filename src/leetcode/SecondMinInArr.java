package leetcode;

public class SecondMinInArr {
    public static int SecondMin(int[] arr) {
        int smallest=Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
            if (arr[i] < secondSmallest && arr[i] > smallest) {
                secondSmallest = arr[i];
            }
//            System.out.println(smallest);
        }

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] < secondSmallest && arr[i] > smallest) {
//                secondSmallest = arr[i];
//            }
//        }
        System.out.println(secondSmallest);
        return secondSmallest;
    }
}
