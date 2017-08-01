package com.js.sort;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		//测试用例
		int [] test={0,3,5,1,2,9,4,5};
		
		//打印结果
		System.out.println(Arrays.toString(mySort(test)));
	}
	
	/**
	 * 冒泡排序，从小到大排列
	 * 
	 * 
	 * 时间复杂度O(N方)
	 * 
	 * 最左边开始依次与右边比较，如果比右边大就交换位置，一直比到最右边
	 * 然后左边第二个元素开始与右边比较
	 * 如此循环
	 * 
	 * @param a 要排序的数组
	 * @return
	 */
	private static int[] mySort(int[] a){
		
		int n=a.length;
		
		while(n>1){
			int temp=0;
			//注意这里i<n-1不是i<n，因为倒数第二个（即i=n-2）与倒数第一个进行比较是最后一次比较
			for(int i=0;i<n-1;i++){
				if(a[i]>a[i+1]){
					temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
				}
			}
			n-=1;
		}
		
		return a;
	}
}
