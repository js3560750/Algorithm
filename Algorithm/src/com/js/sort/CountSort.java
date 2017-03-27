package com.js.sort;

import java.util.Arrays;

public class CountSort {

	public static void main(String[] args) {
		
		//测试用例
		int [] test={-1,3,5,-3,1,2,9,4,5};
		

		System.out.println(Arrays.toString(mySort(test)));

	}

	/**
	 * 计数排序
	 * 
	 * 适用范围：适合数据最大值和最小值相差不太大的排序
	 * 
	 * 时间复杂度为O(N+k)，k是输入数组的最大值-最小值+1，即范围。计数排序不是比较排序，快于任何比较排序算法，
	 * 这是以空间换时间，因为要建立Bucket[]且Bucket[]的大小=输入数组的范围
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	private static int[] mySort(int[] arr){
		//找出数组中的最大值和最小值
		int max=arr[0],min=arr[0];
		for(int a:arr){
			min=Math.min(a, min);
			max=Math.max(a, max);
		}
		
		int bucket_length=max-min+1;	//获得桶长度，定义为数组的最大值-最小值+1，因为要让bucket的脚标总数对应的是arr的值区间
		
		int[] bucket=new int[bucket_length];	//建立桶
		
		//放内容,统计数组arr中每个值为i的元素出现的次数，存入数组bucket的第i项，注意bucket脚标从0开始，而arr数组的最小值不一定是0！！！！！
		//比如-1是最小值，-1出现了5次，那么bucket[0]=5
		//比如3是第二小的值，3出现了9次，那么bucket[1]=9
		for(int a:arr){
			bucket[a-min]++;	//这里要减去min，因为arr的最小值未必是0
		}
		
		//倒出内容，完成排序
		int index=0;
		for(int i=0;i<bucket_length;i++){	//遍历bucket
			for(int j=0;j<bucket[i];j++){	//查看bucket每个脚标的值是多少，比如bucket[5]=3,那么arr中等于5的就有3个，依次倒出来
				arr[index++]=i+min;			//这里i要+min,因为arr的最小值未必是0
			}
		}
		
		return arr;
		
	}
}
