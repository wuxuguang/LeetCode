package com.wxg.mysolution;

/**
 * Created by wuxuguang on 2017/3/9.
 */
public class Problem7 {
    public int reverse(int x) {
/*        if(x==Integer.MAX_VALUE || x==Integer.MIN_VALUE)
            return 0;
        boolean isNeg=false;
        if(x<0){
           isNeg = true;
           x=Math.abs(x);
        }*/
        long result = 0;
        int temp = x;
        while(temp != 0){
            result=result*10+temp%10;
            if(result>Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
            temp = temp/10;
        }
        int result1 = (int)result;
        // return isNeg?-result1:result1;
        return result1;
    }

}
