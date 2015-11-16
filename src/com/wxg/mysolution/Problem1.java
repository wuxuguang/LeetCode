package com.wxg.mysolution;

import java.util.Hashtable;

/**
 * @ClassName Problem1
 * @Description Given an array of integers, find two numbers such that they add up to a specific target number.
 * @Description Two Sum problem
 * @author wuxuguang
 * @date 2015-2-14 下午9:38:18
 */
public class Problem1 {
	public static void main(String[] args){
		Problem1 p = new Problem1();
		int[] nums = {3,2,4};
		int target = 6;
		int result[] = p.twoSum(nums, target);
		for(int i : result){
			System.out.println(i);
		}
	}
	
	
    public int[] twoSum1(int[] numbers, int target) {
    	if(numbers.length < 2) 
    		return null;
    	int result[] = new int[2];
    	Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
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
	
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        if(nums == null || nums.length <2)
        	return result;
        int length = nums.length;
        int start = 0, end;
        while(start < length - 1){
        	end  = start++ + 1;
        	while(end < length){
        		if(nums[start] + nums[end] == target){
        			result[0] = start + 1;
        			result[1] = end +1;
        			return result;
        		}
        		end++;
        	}
        	start++;
        }
        return result;
    }
}
