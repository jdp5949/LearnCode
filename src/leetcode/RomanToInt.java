package leetcode;

import java.util.HashMap;

class RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));
            System.out.println(currentValue);
            if (currentValue >= prevValue) {
                result += currentValue;
            } else {
                result -= currentValue;
            }
            prevValue = currentValue;
        }

        return result;
    }
}
//make hashmap and add all values into it
//reverse iteration and get one by one char from end
//check if cur value is greater than prev value if yes then add cur value into res
// else minus cur value from res
// make prev value as cur value in the end to check for two digit number
//return res