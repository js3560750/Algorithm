package com.js.sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		
		//测试用例
		int [] test={0,3,5,3,1,2,9,4,5};
		
		System.out.println(Arrays.toString(mySort(test)));

	}
	
	/**
	 * 插入排序，从小到大排序，类似于整理扑克牌。
	 * 
	 * 时间复杂度O(N方)
	 * 
	 * 开始摸牌时，左手的数据是空的，然后右手（乱序的数据）起牌，依次按照从小到大插入到左手中。
	 * 
	 * 从要操作的数据相邻的左边开始依次向左边比较。
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	private static int[] mySort(int[] arr){
		
		int i,j,target;
		
		int n=arr.length;
		
		//假定第一个元素放在了正确的位置上
		//这样，仅需要遍历角标1到n-1
		for(i=1;i<n;i++)
		{
			j=i;
			target=arr[i];	//把要插入的数据先放入target变量
			
			//当要操作的那个数据比这个数据左边的值小的话，就把相邻左边数据赋给操作数据，操作数据角标-1，继续比较下一个
			//当操作数据大于左边数据的时候，循环就跳出来了，此时的角标j就是插入数据该放置的位置
			while(j>0 && target<arr[j-1])
			{
				arr[j]=arr[j-1];
				j--;
			}
			
			arr[j]=target; 	//把操作数据放入该放置的位置
		}
		
		return arr;
	}

}
