package com.js.sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		
		//测试用例
		int [] test={0,3,5,3,1,2,9,4,5};
		
		mySort(test);
		
		System.out.println(Arrays.toString(test));

	}

	
	/**
	 * 
	 * 希尔排序，我比较喜欢这个，代码较短，也好理解
	 * 
	 * 先按feet=n/2选取初始步长，然后arr[feet]就作为第一个选取对象，把这个对象与左边间隔feet的被比较对象进行比较，
	 * 如果左边比右边大，则互换位置，仍是这个对象继续与右边间隔feet的对象进行比较，直到脚标溢出。溢出了选取arr[feet+1]作为选取对象
	 * 直到所有对象遍历完，就把feet=feet/2，继续上面的过程，直到feet=1进行最后一遍。
	 * 
	 * 时间复杂度根据步长的选择是否合理为O（nlogn）～O（n2）
	 * 希尔排序比插入排序快很多的原因：当h值很大时，数据项每一趟排序移动的元素个数少，但移动的距离很长，这是非常高效的；
	 * 当h值减小时，每一趟排序移动的元素个数增加，但此时的数据项已经接近于他们最终排序后的位置，插入排序可以更有效
	 * 
	 * @param arr
	 */
	private static void mySort(int[] arr){
	
		int n=arr.length;
		
		int feet=n/2;	//feet为步长，一般按这样选取初始步长，并且取半去小数缩减步长
		
		while(feet>0){
			
			
			for(int i=feet;i<n;i++){
				int index=i;	//index是选取对象的脚标,下面的index-feet是被比较对象的脚标
				while(index>=feet){	//这个while循环保证了只要选取对象脚标仍大于步长就会继续进行比较
					if(arr[index-feet]>arr[index]){
						swap(arr,index-feet,index);
						index=index-feet;	//如果被比较对象比选取对象大则互换了位置，因此本轮选取对象的脚标变化了，由index变成了index-feet
					}else{
						break;	//如果被比较对象小于选取对象，则跳出while循环，进入for循环的i++
					}
				}
			}
			//for循环遍历完，则改变步长，重新遍历
			feet=feet/2;
		}
		
	}
	
	
	//交换函数
	private static void swap(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}
