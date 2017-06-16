package com.wxg.mysolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Problem3
 * @Description LeetCode Problem3
 * @author wuxuguang
 * @date 2015-6-6 上午12:38:39
 */
public class Problem3 {
	public int lengthOfLongestSubstring(String s) {
		int length = 0;
		if(s == null || s.length() == 0)
			return 0;
		int help[] = new int[256];
		for(int i=0;i<help.length;i++)
			help[i] = 0;
		int i=0,j=1;
		help[s.charAt(i)]++;
		length = 1;
		while(i < j && j<s.length()){
			if(help[s.charAt(j)] == 0 )
				help[s.charAt(j++)]++;
			else{
				if( j - i > length) 
					length = j - i;
				while(help[s.charAt(j)] > 0 )
					help[s.charAt(i++)]--;
				help[s.charAt(j++)]++;
			}
		}
		if(j == s.length() && j -i > length )
			length = j -i ;
		return length;
	}

    /**
     * 用一个Map来存储字符值和字符位置，key是当前位置上的字符，值时当前位置
     * @param s
     * @return
     */
    public int solution2(String s) {
        if (s == null)
            return 0;
        if (s.length() <= 1)
            return s.length();
        int maxLen = 0;
        Map<Character, Integer> help = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (help.containsKey(s.charAt(j))) {
//                i = help.get(s.charAt(j)) + 1;
                i = Math.max(i, help.get(s.charAt(j)) + 1);
            }
            help.put(s.charAt(j), j);
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    public static void main(String[] args){
		Problem3 p = new Problem3();
		System.out.println(p.solution2("abba"));
	}
	
}
