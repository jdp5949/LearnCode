package leetcode;

import java.util.Stack;

public class isValidPerenthesis {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
            }
            else if(ch==')' || ch==']' || ch=='}'){
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
//make stack to add bracket as char
//make string to char array and iterate one by one
// check opening brack is comming the puch into stack otherwise check closing bracket is there
// if yes then pop it and check again if char is opening and pop is not closing then false