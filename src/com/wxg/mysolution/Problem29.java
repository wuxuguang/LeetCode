package com.wxg.mysolution;

import java.util.List;

/**
 * @author wuxg
 * @class Divide two integers without using multiplication, division and mod operator.
 *
 */
public class Problem29 {
    public int divide(int dividend, int divisor) {
    	if(dividend == 0)
    		return 0;
    	if(divisor == 0)
    		return Integer.MIN_VALUE;
    	boolean isNeg = false;
    	if(dividend > 0 && divisor < 0){
    		divisor = 0 - divisor;
    		isNeg = true;
    	}
    	if(dividend < 0 && divisor >0){
    		dividend = 0 - dividend;
    		isNeg = true;
    	}
		int result = 0;
		int tmp = divisor,prevTemp=divisor;
		//最初的增量,tempGap用于保存
		int gap = divisor,tempGap=gap;
		int step = 1, tempStep=step;
		while(tmp <= dividend && tmp > 0){
			tmp += gap;
			if(tmp > dividend){
				tmp -= gap + tempGap;
				gap = tempGap;
				step = tempStep;
			}else{
				prevTemp = tmp;
				result += step;
				tempGap = gap;
				tempStep = step; //用于保存最初的变量
				step += step;
				gap += gap;
			}
		}
		
        return isNeg ? (0-result) : result;
    }
    
    public static void main(String[] args){
    	System.out.println(new Problem29().divide(24, 8));
    }
}
