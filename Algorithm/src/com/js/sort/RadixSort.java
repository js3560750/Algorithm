package com.js.sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		
		//测试用例，mySort函数中设置了i<=1000,因此测试用例只能到千位
		int [] test={1,33,85,433,1,4412,9,2234,5,0};
		
		System.out.println(Arrays.toString(mySort(test)));

	}
	
	
	/**
	 * 基数排序
	 * 
	 * 稳定性排序，并非比较排序，只能对非负数进行排序
	 * 
	 * 将所给序列从个位、到十位、到百位、再到千位。
	 * 
	 * 先说个位，取得每个元素的个位数，因为只可能是0-9，所以建立10个桶，每个桶放个位数对应的元素，再依次从0桶、1桶、2桶直到9桶取出这些元素，就是个位从小到大排序了
	 * 
	 * 再排十位，依次类推。
	 * 
	 * @param arr
	 * @return
	 */
	private static int[] mySort(int[] arr){
		
		int n=arr.length;
		
		//建立一个桶，高维0-9表示余数，低维表示整个序列该余数的个数,最多有n个
		int[][] bucket=new int[10][n];

		int[] count=new int[10];	//count[0]表示余数为0的个数，count[1]表示余数为1的个数
		
		
		
		for(int i=1;i<=1000;i*=10){	//这里i表示除数，i<=1000，表示所给数据的位数最多为千位
			
			//放入桶
			for(int j=0;j<n;j++){	//j表示遍历整个arr
				int yushu=arr[j]/i%10;	//获得余数
				bucket[yushu][count[yushu]]=arr[j];	//把对应余数的数据放入对应的桶中
				count[yushu]++;	//该余数的计数器+1
			}
			
			//从桶中取出
			int index=0;	//定义结果数组的脚标
			for(int p=0;p<10;p++){	//遍历0-9这10个桶，将桶中数据取出放入结果数组中
				for(int k=0;k<count[p];k++){
					arr[index++]=bucket[p][k];
					bucket[p][k]=0;	//将该数据置为0方便其他百位、千位、万位时存数据
				}
				
				count[p]=0;	//桶中数据都放入新的数组了，那么将该数据置为0方便其他百位、千位、万位时存数据
			}
		}
		
		return arr;
	}

}
