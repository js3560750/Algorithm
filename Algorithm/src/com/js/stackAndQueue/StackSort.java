package com.js.stackAndQueue;


import java.util.Stack;

/**
 * 对栈按升序进行排序，即最大的元素位于栈顶
 * 
 * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中
 * 
 * @author 188949420@qq.com
 *
 */
public class StackSort {

	public static Stack<Integer> sort(Stack<Integer> stack) {
		Stack<Integer> stackHelper = new Stack<>();
		
		//注意执行pop()、push()方法时，stack.size()的值是变化的，所以不能用for循环遍历带pop\push操作的栈
		
		while(!stack.empty()) {
			int temp =stack.pop();
			//如果stackHelper空了，就要把数据压入stackHelper
			//如果stackHelper不为空，并且stackHelper顶部数据大于temp，就要把这个数据弹出来放入stack，把小的temp放入stackHelper中
			while(!stackHelper.empty()&&temp<stackHelper.peek()) {
				stack.push(stackHelper.pop());
			}
			stackHelper.push(temp);
			
		}
	
		return stackHelper;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(4);
		stack.push(3);
		stack.push(7);
		stack.push(2);
		Stack<Integer> stackHelper=sort(stack);
		System.out.println(stackHelper.pop());
		System.out.println(stackHelper.pop());
		System.out.println(stackHelper.pop());
		System.out.println(stackHelper.pop());
		System.out.println(stackHelper.pop());
	}
}
