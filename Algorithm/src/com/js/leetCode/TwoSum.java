package com.js.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述以下网址
 * 
 * https://leetcode.com/problems/two-sum/description/
 * 
 * @author 188949420@qq.com
 *
 */
public class TwoSum {

	public static void main(String[] args) {

		int[] nums = { 3, 2, 4 };
		int target = 6;

		twoSum(nums, target);
		
		System.out.println(hammingDistance(1, 4));

	}

	// 我自己写的解法时间复杂度O(n方)，太长了
	public static int[] twoSum(int[] nums, int target) {

		int[] result = new int[2]; // 注意新建数组的写法，这里new int[2]，数组内只能放2个元素

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}

		return null;

	}

	// 推荐的解法，时间复杂度O(n)
	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			// 注意这里map.get(complement) != i ，即对应nums[i]+X=target算出的X不能是nums[i]本身。 
			//为了避免input=[3,2,4] target=6 ,output=[0,0] 实际Output应该=[1,2]
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static int hammingDistance(int x, int y) {
        
		return Integer.bitCount(x^y);
        
    }
}
