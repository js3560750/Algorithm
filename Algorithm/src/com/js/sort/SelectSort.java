package com.js.sort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {

		//测试用例
		int[] test={3,4,6,1,9,0,5};
		
		System.out.println(Arrays.toString(mySort2(test)));

	}
	
	/**
	 * 选择排序
	 * 更简单的实现方法
	 * @param arr
	 * @return
	 */
	private static int[] mySort2(int[] arr) {
		
		//注意两个for循环的初值和判定条件
		for(int i=0;i<arr.length-1;i++) {
			
			for(int j=i+1;j<arr.length;j++) {
				
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	
	
	/**
	 * 选择排序
	 * 
	 * 时间复杂度O(N方)
	 * 
	 * 含义是遍历0到n-1,选出最小的数字与第一个数据交换
	 * 然后遍历1到n-1，再选出最小的与第二个数据交换
	 * 以此类推到最后一位
	 * 
	 * @param arr
	 * @return
	 */
	private static int[] mySort(int[] arr){
		
		int n=arr.length;
		
		//i=n-1是最后一个元素
		for(int i=0;i<n;i++)
		{
			//如何从一排元素中选出最小的？
			//直接假定第一个是最小的，然后第一个与第二个进行比较，如果第二个小于第一个，则把第二个定义为最小（脚标）
			
			int min=arr[i];
			int min_index=i;
			
			for(int j=i+1;j<n;j++)
			{
				//注意是拿min和遍历的元素比较，如果拿arr[i]和arr[j]进行比较就混乱了
				if(min>arr[j])
				{
					min=arr[j];
					min_index=j;
				}
			}
			
			arr[min_index]=arr[i];
			arr[i]=min;

		}
		
		return arr;
	}


}
