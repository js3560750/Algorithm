	package com.js.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		//测试用例
		int [] test={0,3,5,3,1,2,9,4,5};
		
		int n=test.length;
		
		System.out.println(Arrays.toString(sort(test,0,n-1)));

	}

	/**
	 * 合并（并归）排序
	 * 
	 * 时间复杂度O(NlogN)
	 * 
	 * 先把所有元素分割为容量为2的分组，在分组内进行从小到大的排序
	 * 然后把所有元素按相邻位置分割为容量为4的分组，在分组内进行从小到大的排序
	 * 再分为容量为8，依次类推，直到容量>=元素总数
	 * 
	 * @param arr
	 * @return
	 */
	
	
	//递归分成小部分
	private static int[] sort(int[] arrays,int start,int end)
	{
		if(start<end)
		{
			int mid=(start+end)/2;
			sort(arrays,start,mid);
			sort(arrays,mid+1,end);
			merge(arrays,start,mid,end);
		}
		
		return arrays;
	}
	
	//合并数组
	private static void merge(int[] arrays,int start,int mid,int end)
	{
		int length=end-start+1;	//获得arrays元素总数
		int[] temp =new int[length];//用来存放比较之后数据的数组，最后将其值复制回到原来的数组
		int i=start;
		int j=mid+1;
		int index=0;
		
		//临时数组选取左、右子数组中较小的数值
		while(i<=mid&&j<=end)
		{
			if(arrays[i]<arrays[j])
			{
				temp[index]=arrays[i];
				i++;
				index++;
			}
			else
			{
				temp[index]=arrays[j];
				j++;
				index++;
			}
		}
		
		//剩余的直接放入临时数组
		while(i<=mid)
		{
			temp[index]=arrays[i];
			index++;
			i++;
		}
		
		//剩余的直接放入临时数组
		while(j<=end)
		{
			temp[index]=arrays[j];
			index++;
			j++;
		}
		
		//把临时数组的数据放回原数组相应的位置
		index=0;
		for(int t=start;t<=end;t++,index++)
		{
			arrays[t]=temp[index];
		}
		
		
	}
}
