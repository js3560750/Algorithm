package com.js.sort;

import java.util.Arrays;

/**
 * 
 *  三色排序练习题
 * 
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 * 
 * @author 18894
 *
 */
public class Exercise_ThreeColorSort {

	public static void main(String[] args) {


		int[] test={1,2,0,2,1,1,0,0,2,2,1,0};
		
		System.out.println(Arrays.toString(mySort(test)));
	}

	/**
	 * 思路是左边设置脚标Left=0,作为存放0元素的区间，右边设置脚标right=n-1，作为存放2元素的区间
	 * 
	 * 从头开始遍历一直到脚标right，如果遍历到0则放入左边区间，left+1，如果遍历到2，则放入右边区间，right-1，遍历到1不管
	 * 
	 * 关键是遍历到2时，和右边right进行了交换，此时交换过来的是新元素，还未比较过，遍历的脚标不要+1
	 * 
	 * @param arr
	 * @return
	 */
	private static int[] mySort(int[] arr){
		
		int n=arr.length;
		
		//定义左边存放0的脚标Left和右边存放2的脚标right
		int left=0;
		int right=n-1;
		int i=0;
		
		while(i<=right){	//这里一定要加=号，比如最后一位是1110这个序列，i读到最后一位时，肯定要比较一下啊
			if(arr[i]==0){
				swap(arr,i,left);
				left++;
				i++;
			}else if(arr[i]==2){	//关键！！如果arr[i]==2，那么交换了i和right后，i不能自增，因为从右边right部分换过来的值是新值，未比较过
				swap(arr,i,right);
				right--;	
			}else{
				i++;
			}
			
		}
		
		return arr;
	}
	
	private static void swap(int[] arr,int a,int b){
		
			int temp=arr[a];
			arr[a]=arr[b];
			arr[b]=temp;

	}
}
