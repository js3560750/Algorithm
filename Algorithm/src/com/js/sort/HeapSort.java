package com.js.sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		//测试用例
		int [] test={-8,-10,2,9,4,5,0,88,34,27,-3,-19,20,31};
		
		System.out.println(Arrays.toString(mySort(test)));
		
		//adjustDownToUp(test, 0, test.length); 	
		System.out.println(Arrays.toString(buildBigHeap(test)));

	}

	/**
	 * 堆排序
	 * 
	 * 时间复杂度 建堆：O(n)，每次调整O(log n)，故最好、最坏、平均情况下：O(n*logn);
	 * 
	 * 对于节点i，其二叉树左孩子是2*i+1，右孩子是2*i+2，其父节点是(i-1)/2=i/2-1向下取整
	 * 
	 * 堆排序是把待排序序列arr看成完全二叉树的顺序存储结构，大根堆性质：即任意节点不小于其左右两个孩子节点，大根堆的最大元素一定在堆顶
	 * 
	 * 首先执行buildBigHeap函数建立大根堆，建立的过程中从最后一个元素的父节点开始依次减1调用adjustDownToUp函数，
	 * 因为adjustDownToUp函数是保证其传入的index脚标之后的元素符合大根堆性质。
	 * 因为又是从最后一个元素的父节点开始依次减1调用的adjustDownToUp函数，因此能保证buildBigHeap函数执行完成后，所得序列符合大根堆性质
	 * 
	 * 然后把大根堆的堆顶和最后一位元素互换，作为有序序列的最大值，因为最后一位元素如今变成了堆顶，很可能破坏大根堆性质（任意节点不小于其左右两个孩子节点），
	 * 因此调用adjustDownToUp函数且传入的index=0，length-1
	 * 来使除了最后一个元素的剩下序列重新符合大根堆性质
	 * 
	 * 继续上面的过程，把堆顶和倒数第二位元素互换，作为有序序列的第二大值，如此重复，得到从小到大的有序序列
	 * 
	 * 
	 */
	private static int[] mySort(int[] arr){
		arr=buildBigHeap(arr);	//初始建堆，array[0]为第一趟值最大的元素
		for(int i=arr.length-1;i>0;i--){	//因为i=arr.length-1,所以arr[i]是堆最后(最底)一个元素
			int temp=arr[0];	//将堆顶元素arr[0]和堆底元素arr[i]交换，即得到当前最大元素正确的排序位置
			arr[0]=arr[i];
			arr[i]=temp;
			//i这里的形参是Length不是脚标，而i=length-1，所以排除了最后一个元素（该元素是最大值）
			//从堆顶开始自上而下重新整理，把排除了最后一个元素的堆的最大元素放到堆顶
			adjustDownToUp(arr, 0, i);	
		}
		
		return arr;
	}
	
	
	//将array看成完全二叉树的顺序存储结构,建立大根堆,即任意节点不小于其左右两个孩子节点，大根堆的最大元素一定在堆顶
	private static int[] buildBigHeap(int[] arr){
		//从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
		for(int i=(arr.length-2)/2;i>=0;i--){
			
			adjustDownToUp(arr,i,arr.length); 	//	把整个二叉树中最大的元素放到树顶（堆顶）
		}
		
		return arr;
	}
	
	//调整堆，使传入的脚标index之后的序列保持大根堆的性质
	private static void adjustDownToUp(int[] arr,int index,int length){
		int temp=arr[index];
		for(int j=2*index+1;j<length;j=2*j+1){	//j为初始化为节点index的左孩子，沿节点较大的子节点向下调整
			if(j!=length-1&&arr[j]<arr[j+1]){		//取节点较大的子节点的下标
				j++;							//如果节点的右孩子>左孩子，则取右孩子节点的下标
			}
			if(temp>arr[j]){					//这里的j已经表示的左右孩子中较大者
				break;							//根节点 >=左右子女中关键字较大者，调整结束
			}else{								//根节点 <左右子女中关键字较大者，
				//将左右子结点中较大值array[j]赋给到双亲节点上
				//千万不要修改arr[j]的值，因为仍需要他和她的左右子节点比较，因为是自上而下进行的比较选出最大值放到堆顶，并不是单纯的交换位置
				arr[index]=arr[j];		
				//【关键】修改index值，这里可以理解为交换AB的值，但是没有立即交换，而是当for循环结束后才交换AB的值。
				//这里的AB交换是沿着节点较大子节点不断向下一直到底，寻找到最开始传入的arr[index]和沿路的所有值进行比较，一直让arr[index]小于其父节点，大于其子节点的位置才交换
				//并且是当for循环完毕之后才交换AB的值，temp是中间变量
				index=j;						
				
			}
			
		}
		arr[index]=temp;	//这里arr[index]代表的是被调整的节点
	}
}
