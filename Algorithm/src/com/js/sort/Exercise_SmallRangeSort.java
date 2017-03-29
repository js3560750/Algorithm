package com.js.sort;

import java.util.Arrays;

/**
 * 小范围排序练习
 * 
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
 * 请选择一个合适的排序算法针对这个数据进行排序。
 * 给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
 * 测试样例：
 * [2,1,4,3,6,5,8,7,10,9],n=10,k=2
 * 返回：[1,2,3,4,5,6,7,8,9,10]
 * 
 * @author 18894
 *
 */
public class Exercise_SmallRangeSort {

	public static void main(String[] args) {

		int[] test={2,1,4,3,6,5,8,7,10,9};
		
		
		
		System.out.println(Arrays.toString(mySort(test, test.length, 2)));


	}
	
	/**
	 * 解题思路
	 * 
	 * 因为所给序列每个元素移动的距离不会超过k，因此选取arr前k个数，其中必然有一个元素可以排在第一位，k+1个数就是有两个元素可以有效排序。
	 * So
	 * 首先从arr中取出前k个数放入数组heap，并且使heap具有小根堆性质：即任一节点不大于其左右两个孩子节点。
	 * 这个heap的堆顶就是该数组的最小值，把这个最小值作为有序序列的第一个，然后把heap[0]替换为arr中前k个之后+1的那个元素，再对heap进行调整使其符合小根堆
	 * 再弹出heap[0]作为有序序列的第二个，如此重复，直到把arr后k个元素装进heap，此时依次把heap中的元素弹出1个，heap范围缩小1个,调整为小根堆，直到所有元素弹出，搞定！
	 * 
	 * 
	 * 
	 * @param arr
	 * @param length
	 * @param k
	 * @return
	 */
	private static int[] mySort(int[] arr,int length,int k){
		
		
		int[] heap=Arrays.copyOf(arr, k);
		
		//建立小根堆，堆顶元素就是这个序列的最小值
		buildSmallHeap(heap);
		
		//heap元素目前是从0到k-1，把heap[0]元素提出来作为从小到大有序序列的第一位，即arr[0]
		//然后把arr[k]赋值给heap[0]，继续对heap进行调整，确保小根堆性质，如此循环以上
		//这个循环一直到arr[length-1]=heap[0]，即arr的最后一个元素赋给了heap，之后就要把整个heap依次提取出来给arr，不需要调整小根堆性质
		for(int i=k;i<length;i++){
			arr[i-k]=heap[0];		//arr[i-k]很关键，因为i从k开始+1,所以arr[i-k]表示的是arr[0]、arr[1]、arr[2]一直到往后
			heap[0]=arr[i];
			adjust(heap,0,k); //k就是heap.length
		}
		

		
		//把整个heap依次提取出来给arr
		for(int j=arr.length-k;j<arr.length;j++){	//arr[j]是arr数组后k个元素的第一个
			
			arr[j]=heap[0];
			heap[0]=heap[k-1];
			
			adjust(heap,0,--k);
			
		}

		
		return arr;
	}
	
	//建立小根堆
	private static void buildSmallHeap(int[] arr){
		for(int i=arr.length/2-1;i>=0;i--){
			
			adjust(arr,i,arr.length);
		}

	}
	
	//调整脚标index之后的序列符合小根堆性质
	private static void adjust(int[] arr,int index,int length){
		
		int temp=arr[index];
		for(int i=2*index+1;i<length;i=2*i+1){
			if(i!=length-1&&arr[i]>arr[i+1]){
				i++;
			}
			if(temp<arr[i]){
				break;
			}else{
				arr[index]=arr[i];
				index=i;
			}
			
		}
		arr[index]=temp;	//注意for循环结束后才交换元素值
	}

}
