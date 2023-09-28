package leetcode;

public class ArrayString {
    public int removeDuplicates(int[] a) {
        //from sorted list
        //space 1 time n
        //check if length of array is <=1 then return length of array
        //then loop from 1 to end and checking if a[i]!=a[j] i++,a[i]=a[j]
        //ans i+1
        int i=0;
        if(a.length <= 1) return a.length;
        for(int j=1;j<a.length;j++){
            if(a[i] != a[j]){
                i++;
                a[i] = a[j];
            }
        }
        //	Arrays.fill(a, i+1, a.length, 0);
        return (i+1);
    }

    public int strStr(String haystack, String needle) {
        //find index of first occurance in string
        //for i for j without condition
        //three condition
        //one is ans j==needle.length then return i
        //one is -1 i+j==haystack.length then return -1
        // last one is break needle.charAt(i)!=haystack.charAt(i+j) breaj\k
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
                System.out.println(i+""+j);
            }
        }
    }

}
