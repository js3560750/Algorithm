package com.js.sort;

import java.util.Arrays;

public class HeapSort_smallHeap {

	public static void main(String[] args) {
		
		int [] test={3,5,7,9,2,5,0,4,1,7};
		
		//测试建立的小根堆，使每个节点不大于其左右两个孩子节点，与建立大根堆的函数只有2处不同！！！！！！！！！
		System.out.println(Arrays.toString(buildSmallHeap(test))); //并不是排序，只是建立小根堆

	}
	
	
	//建立小根堆
	private static int[] buildSmallHeap(int[] arr){
		
		for(int i=(arr.length-2)/2;i>=0;i--){
			
			adjustDownToUp(arr,i,arr.length); 	
		}
		
		return arr;
	}
	
	//调整堆，使传入的脚标index之后的序列保持大根堆的性质
		private static void adjustDownToUp(int[] arr,int index,int length){
			int temp=arr[index];
			for(int j=2*index+1;j<length;j=2*j+1){	
				if(j!=length-1&&arr[j]>arr[j+1]){		//与大根堆不同点1：选取左右孩子节点中的较小值
					j++;							
				}
				if(temp<arr[j]){				//与大根堆不同点2：如果父节点小于孩子节点中的较小值	
					break;							
				}else{								
					
					arr[index]=arr[j];		
					
					index=j;						
					
				}
				
			}
			arr[index]=temp;	
		}

}
