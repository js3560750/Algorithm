package com.js.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 * 给定两个链表的头指针headA和headB，请返回一个数组，元素为两个链表的公共部分。请保证返回数组的升序。
 * 
 * @author 188949420@qq.com
 *
 */
public class CommonValue {

	public int[] findCommonValue(ListNode headA,ListNode headB) {
		if(headA==null||headB==null) {
			return null;
		}
		List<Integer> list= new ArrayList<Integer>();
		
		while(headA!=null&&headB!=null) {	//注意两个链表都是升序
			if(headA.val>headB.val) {	//B的小则看B的下一个，不需要先建一个指针！！！
				headB=headB.next;	//!!!!!!!!!!!!遍历链表只需要这一个节点就够了！！！！！！！！！！！！！！
			}else if(headA.val<headB.val) {	//A的小则看A的下一个，不需要先建一个指针！！！
				headA=headA.next;	//!!!!!!!!!!!!遍历链表只需要这一个节点就够了！！！！！！！！！！！！！！
			}else {	//A=B时
				list.add(headA.val);	
				headA=headA.next;
				headB=headB.next;
			}
		}
		int len=list.size();	//相同值的重复调用就用赋值，以此提升速度
		int[] result=new int[len];
		for(int i=0;i<len;i++) {	//相同值的重复调用就用赋值，以此提升速度
			result[i]=list.get(i);
		}
		
		return result;
	}
}
