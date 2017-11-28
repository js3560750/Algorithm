package com.js.stackAndQueue;

import java.util.Stack;

/**
 * 可查询最值的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
 * 
 * 采用下面视频中案例一的结构二
 * https://www.nowcoder.com/study/vod/1/4/1
 * 
 * @author 188949420@qq.com
 *
 */
public class StackGetMin {
	public Stack<Integer> stackDate = new Stack<Integer>();	//定义一个数据栈
	public Stack<Integer> stackMin = new Stack<Integer>();	//用来存放数据栈的当前最小值
	
	//将数据压入stackDate，同时如果该数据小于stackMin的栈顶，则也压入stackMin，否则stackMin继续压入当前栈顶，即当前的栈的最小值
	public void push(int node) {
		stackDate.push(node);
		//如果stackMin为空或者stackMin的栈顶元素小于等于node，则压入node
		//peek()方法返回栈顶元素并不弹出
		if(stackMin.empty()||node<=stackMin.peek()) {
			stackMin.push(node);
		}else {
			stackMin.push(stackMin.peek());
		}
	}
	
	//数据出栈很简单，Date和Min同时出栈就行了
	public void pop() {
		if(stackDate.empty()) {
			throw new RuntimeException("Your stack is empty");
		}
		
		stackDate.pop();
		stackMin.pop();
		
	}
	
	//获取当前栈的最小值
	public int min() {
		if(stackMin.empty()) {
			throw new RuntimeException("Your stack is empty");
		}
		
		return stackMin.peek();
	}
	
	
	
	
}
