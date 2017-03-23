package com.js.sort;

import java.util.*;

public class QuickSort {

	public static void main(String[] args) {
		
		//测试用例
		int [] test={0,3,5,3,1,2,9,4,5};
		
		int n=test.length;
		
		mySort(test,0,n-1);
		
		System.out.println(Arrays.toString(test));

	}
	
	/**
	 * 快速排序
	 * 
	 * 时间复杂度O(NlogN)
	 * 
	 * 在序列中随机选取一个数，然后把这个数放在序列的第一位，遍历这个序列，所有比这个小数小的放在该数左边，比这个数大的放在该数右边
	 * 
	 * 那么该数左右两边仍然是无序的，相当于左右两个序列，再分别进行上述过程，不断进行迭代。
	 * 
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	private static void mySort(int[] arr,int start,int end)
	{
		if(start<end)
		{
			
			int mid=partition(arr,start,end);	//mid是随机选取的比较对象的脚标
			
			mySort(arr,start,mid);	//迭代对比较对象左边的数组序列继续进行快速排序
			
			mySort(arr,mid+1,end);	//迭代对比较对象右边的数组序列继续进行快速排序
		}
	}
	
	//交换位置
	private static void swap(int[] arr,int a,int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	//快速排序中 单次运行一次
	private static int partition(int[] arr,int start,int end)
	{
		Random rad=new Random();
		int n=end-start+1;	//注意这里取的不是数组长度，而是要取比较的起始脚标到结束脚标之间的数据个数，在迭代过程中，start和end是会变的
		int index=start+rad.nextInt(n);	//nextInt(n)是从0到n-1范围内产生随机数，注意前面必须+start，因为start在迭代过程中是会变的
		
		swap(arr,start,index);	//把比较对象放到数组的第一位，之后arr[start]就作为比较对象
		
		int j=start;	//这个是脚标值，非常重要，作为小于比较对象存放数组（并不真的new一个数组）的脚标指针
		
		for(int i=start;i<=end;i++)	//遍历数组，如果小于比较对象，则把该数据依次放在比较对象右边
		{
			if(arr[i]<arr[start])
			{
				swap(arr,i,++j);//这里的++j非常重要，因为比较对象放在第一位，所以存放小于比较对象的数据就得放在其右边，j默认=start，所以运行前+1
				
			}
		}
		
		swap(arr,start,j);	//把始终放在第一位的比较对象与小于比较对象序列的最后一位交换，使整个数组比较对象的左边（乱序）全是小于比较对象的，右边（乱序）全是大于比较对象的
		
		return j;	//返回比较对象的脚标，以便分开迭代比较对象左右两边的乱序数组
	}
	

}
