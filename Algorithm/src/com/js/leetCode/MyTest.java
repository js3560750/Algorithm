package com.js.leetCode;

import java.util.HashSet;
import java.util.Set;

public class MyTest {
	
	public static void main(String[] args) {
		int[] nums= {1,1,2,1,1,3,4,4,4};
		
		System.out.println(removeElement(nums, 4));
	}

	public static int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]!=val){
                count++;
            }
        }
        return count;
    }
}
