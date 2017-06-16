package com.wxg.mysolution;

/**
 * Container With Most Water
 */
public class Problem11 {
    public int maxArea(int[] height) {
        int length = height.length;
        int maxArea = 0;
        for (int i = 0; i < length - 1;i++) {
            for (int j = i + 1; j< length;j++) {
                maxArea = Math.max(maxArea, getArea(height, i, j));
            }
        }
        return maxArea;
    }

    private int getArea(int a[], int i, int j) {
        if (a[i] > a[j])
            return getArea(a, j, i);
        return Math.abs(j - i) * a[i];
    }


    public int getMaxArea(int[] height) {
        int water = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            water = Math.max(water, (j - i) * h);
            while (height[i] <= h && i < j)
                i++;
            while (height[j] <= h && i < j)
                j--;
        }
        return water;
    }


    public static void main(String[] args) {
        int[] height = {2,1};
        Problem11 p = new Problem11();
        int maxArea = p.maxArea(height);
        System.out.println(maxArea);
    }
}
