package com.company;

/**
 * Created by IDEA on 26/01/15.
 */
public class SortNumbers {
    // In-place sorting, therefore return type is void.
    public static void sort(double[] nums) {
        // For each i, we make sure that nums[i] is the minimum from i to the end
        for(int i=0; i<nums.length; i++) {
            int min = i;
            for(int j=i; j<nums.length; j++) {
                if(nums[j] < nums[min]) {
                    min = j;
                }
            }
            double tmp;
            tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }
}
