package com.wxg.mysolution;

/**
 * @ClassName Problem3
 * @Description LeetCode Problem3
 * @author wuxuguang
 * @date 2015-6-6 上午12:38:39
 */
public class Problem3 {
	public int lengthOfLongestSubString(String s){
		if(s == null || s.length() == 0)
			return 0;
		int help[] = new int[256];
		int result = 0;
		int tempStart = 0;
		for(int i = 0; i<s.length(); i++){
			char c = s.charAt(i);
			if(help[c] == 0)
				help[c] = i + 1; //每个数组的位置的值是其下标
			else{    //help[c] != 0  cdd
				if(i - tempStart > result)
					result = i - tempStart;
				tempStart = help[c];
				help[c] = i + 1;
			}
		}
		
		if(s.length() - tempStart > result)
			result = s.length() - tempStart;
		
		return result;
	}
	
	public static void main(String[] args){
		String s = "abba";
		System.out.println(new Problem3().lengthOfLongestSubString(s));
	}
	
}
