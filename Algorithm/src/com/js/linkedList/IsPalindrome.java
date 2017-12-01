package com.js.linkedList;

import java.util.Stack;

/**
 * 检查链表是否为回文。
 * 
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * 
 * 测试样例：
{1,2,3,2,1}
返回：true
{1,2,2,1}
返回：true
{1,2,3,2,3}
返回：false
 * 
 * @author 188949420@qq.com
 *
 */
public class IsPalindrome {
	
	/**
	 * 思路是申请一个栈，把链表的所有元素都压入栈中
	 * 然后再把栈中的元素依次弹出，和链表一一对比，如果全对，则为回文结构
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
		if(head==null||head.next==null) {	//空和单独元素判断为true
			return true;
		}
		
		Stack<Integer> stack =new Stack<>();
		
		ListNode temp =head;	//把链表的所有元素都压入栈中
		while(temp!=null) {
			stack.push(temp.val);
			temp=temp.next;
		}
		
		ListNode cur =head;		//把栈中的元素依次弹出，和链表一一对比
		while(cur!=null) {
			if(cur.val!=stack.pop()) {
				return false;
			}
			cur=cur.next;
		}
		return true;
		
	}

}
