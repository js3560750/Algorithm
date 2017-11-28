package com.js.stackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 双栈队列
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop),队列是先进先出
 * 
 * 
 * @author 188949420@qq.com
 *
 */
public class TwoStack {

	/**
	 * 给定一个"操作序列"ope，
	 * 其中元素为正数代表push操作，为0代表pop操作，操作序列的意思就是按照这个序列进行push、pop操作
	 * 保证操作序列合法且一定含pop操作，
	 * 返回pop的结果序列(就是pop出去的是啥)
	 * 
	 * 	测试样例：[1,2,3,0,4,5,0,0]
		返回：[1,2,3]  pop出去的是1、2、3
	 * @param ope
	 * @param n
	 * @return
	 */
	public static int[] twoStack(int[] ope) {
		Stack<Integer> stackDate = new Stack<Integer>();
		Stack<Integer> stackHelper = new Stack<Integer>();
		ArrayList<Integer> array =new ArrayList<>();	//用来记录从头到尾pop出去的元素值
		
		
		for (int i = 0; i < ope.length; i++) {
			if(ope[i]>0) {
				stackDate.push(ope[i]);
			}else {
				//将stackDate的数据一个一个pop出来并压入stackHelper
				if(stackHelper.empty()) {
					while(!stackDate.empty()) {
						stackHelper.push(stackDate.pop());
					}
				}
				//stackHelper的pop就相当于这个双栈结构的队列pop操作（即先进先出，而不是栈自身的先进后出）
				array.add(stackHelper.pop());
				
				//只获得pop出去的序列不需要把stackHelper重新装回stackDate，
				//但如果想获得pop之后剩下的序列，就得重新装回去，所以还是重新装回去的好
				//pop完后要把剩下的重新装回stackDate，以便下一次操作
				//while(!stackHelper.empty()) {
				//	stackDate.push(stackHelper.pop());
				//}
			}
		}
		
		int[] res = new int[array.size()];
		for (int i = 0; i < res.length; i++) {
			res[i]=array.get(i);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] res= {1,2,3,0,4,0,0,5,6};
		int[] arr= twoStack(res);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
