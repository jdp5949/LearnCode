package exe;

import java.util.HashMap;
import java.util.HashSet;

public class twosum {

    public static void main(String[] args) {
        int[] arr={3,2,1,4,5,6,8};
        int target=11;
        HashSet<Integer> hm=new Hashset();
        for(int i=0;i<arr.length;i++){
            int diff=target-arr[i];
            if(hm.contains(diff)){
                System.out.println(arr[i]+" "+diff);
            }
            hm.add(arr[i]);
//            System.out.println(hm);
        }
    }
}
