package com.js.stackAndQueue;

import java.util.Stack;

/**
 * 栈的反转
 * 
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构
 * 
 * @author 188949420@qq.com
 *
 */
public class ReverseStack {

	//删除并获得栈的最底层元素，保持栈其他元素不变
	//用递归，非常巧妙
	//用{1,2,3}自己过一遍就明白了
	private static int getBottom(Stack<Integer> stack) {
		int result = stack.pop();	
		if(stack.empty()) {
			return result;	//栈空时返回的result就是最底层的那个元素
		}else {
			int next = getBottom(stack);
			stack.push(result);
			return next; 
		}
	}
	
	/**
	 * 将栈逆序，不申请额外的数据结构
	 * 用递归，非常巧妙
	 * 自己用{1,2,3}跑一下就懂了
	 * @param stack
	 */
	private static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		
		int i=getBottom(stack);
		reverseStack(stack);
		stack.push(i);
	}
	
	
}
