package com.wxg.mysolution;

import java.util.Stack;

/**
 * Created by wuxuguang on 2015/11/17.
 */
public class Problem20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> helpStack = new Stack<Character>();
        int length = s.length();
        boolean isLegal = true;
        for (int i =0 ; i < length; i++){
            char c = s.charAt(i);
            if (c=='{' || c == '(' || c=='[')
                helpStack.push(c);
            if (c=='}' || c==')' || c==']') {
                if (helpStack.isEmpty() || (c == '}' && helpStack.peek() != '{')
                        || (c == ')' && helpStack.peek() != '(')
                        || (c == ']' && helpStack.peek() != '[')) {
                    isLegal = false;
                    break;
                }
                helpStack.pop();
            }
        }
        if (!helpStack.isEmpty())
            isLegal = false;
        return isLegal;
    }

    public static void main(String[] args) {
        System.out.println(new Problem20().isValid("([)]"));
    }
}
