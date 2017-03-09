package com.wxg.mysolution;

public class Problem6 {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows <= 1)
            return s;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<numRows;i++){
            int j=i;
            if(i==0 || i==numRows-1){
                while(j<s.length()){
                    sb.append(s.charAt(j));
                    j=j + 2*(numRows-1);
                }
            }else{
                boolean isDown = true;
                while(j<s.length()){
                    sb.append(s.charAt(j));
                    if(isDown)
                        j = j + 2*(numRows-1-i);
                    else
                        j = j + 2*i;
                    isDown = !isDown;
                }
            }
        }
        return sb.toString();
    }
}
