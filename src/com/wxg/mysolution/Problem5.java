package com.wxg.mysolution;

/**
 * Description: Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class Problem5 {

    /**
     * 1.遍历整个字符串，从左往右
     * 2.假设当前得到的最长回文字符串长度为currentLength
     * 3.遍历到当前字符时，以当前字符作为回文串的“尾”，那么所能得到的最长回文字符串的长度必为currentLength+1或者currentLength+2
     */

    /**
     * 证明：反证法
     *     假设有字符串"xxxbcbxxxxxa"，当遍历到字符a时，currentLength = 3
     *     1. 检查xxxxa是否是回文，若是，currentLength = 5
     *     2. 检查xxxa 是否是回文，若是，currentLength = 4
     *     3. xxxxxa不可能是回文，因为若是，那currentLength是回文，不可能
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        int currentLength = 0, i = 0;
        String result = "";
        for (; i < s.length() - 1; i++) {
            if (isPalindromic(s, i - currentLength - 1, i)){
                result = s.substring(i - currentLength - 1, i + 1);
                currentLength += 2 ;
            } else if (isPalindromic(s, i - currentLength, i)) {
                result = s.substring(i - currentLength, i + 1);
                currentLength += 1;
            }
        }

        return result;
    }

    public boolean isPalindromic(String s, int i, int j) {
        if (i < 0)
            return false;
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
