package com.wxg.mysolution;

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
	
	public static void main(String[] args){
		Problem3 p = new Problem3();
		System.out.println(p.lengthOfLongestSubstring("au"));
	}
	
}
