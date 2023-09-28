package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class finPelindromeFromString {
    public static void main(String[] args) {
        String s="abajsayasva";
        findPalidrome(s);
    }
    public static void findPalidrome(String s){
        int len=s.length();
        if(len<2){
            System.out.println(s);
        }
        char[] charArray=s.toCharArray();
        int max=0;
        String ans = null;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(validPalidrome(charArray,i,j)){
                    int lengths = s.substring(i, j + 1).length();
                    if(max< lengths){
                        max= lengths;
                        ans=s.substring(i, j + 1);
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static boolean validPalidrome(char[] charArray,int left,int right){
        while(left<right){
            if(charArray[left]!=charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
