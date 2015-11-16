package com.wxg.mysolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Problem1
 * @Description Given an array of integers, find two numbers such that they add up to a specific target number.
 * @Description Two Sum problem
 * @author wuxuguang
 * @date 2015-2-14 下午9:38:18
 */
public class Problem1 {
    public int[] twoSum(int[] numbers, int target) {
    	if(numbers.length < 2) 
    		return null;
    	int result[] = new int[2];
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i =0 ;i < numbers.length; i++){
    		Integer n = map.get(numbers[i]);
    		if(n == null)
    			map.put(numbers[i], i);
    		n = map.get(target - numbers[i]);
    		if(n!= null && n<i){
    			result[0] = n+1;
    			result[1] = i+1; 
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Problem1 problem1 = new Problem1();
		int[] numbers = {4, 4, 5};
		int target = 8;
		int[] result = problem1.twoSum(numbers, target);
		for(int i: result)
			System.out.print(i+" ");
	}
}
