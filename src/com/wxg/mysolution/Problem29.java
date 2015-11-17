package com.wxg.mysolution;

import java.util.List;

/**
 * @author wuxg
 * @class Divide two integers without using multiplication, division and mod operator.
 *
 */
public class Problem29 {
    /**
     * This problem can be solved based on the fact that any number can be converted to the format of the following:
     * num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
     */
    public int divide(int dividend, int divisor) {
    	if(divisor == 0)
    		return Integer.MAX_VALUE;
        if(divisor == 1 && dividend == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
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
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);
        while (pDividend >= pDivisor){
            int numShift = 0;
            while (pDividend >= (pDivisor<<numShift))
                numShift++;
            //when pDividend < (pDivisor<<numShift), it means there exists one integer i
            // dividend = i * pDivisor + j, j<pDivisor
            result += 1<<(numShift-1);
            pDividend -= (pDivisor<<(numShift-1));
        }
		
        return isNeg ? (0-result) : result;
    }
    
    public static void main(String[] args){
    	System.out.println(new Problem29().divide(24, 4));
    }
}
