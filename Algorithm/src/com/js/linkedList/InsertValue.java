package com.js.linkedList;

/**
 * 	有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。

	给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
	
	测试样例：[1,3,4,5,7],[1,2,3,4,0],2
	返回：{1,2,3,4,5,7}
	
 * @author 188949420@qq.com
 *
 */
public class InsertValue {

	public ListNode insert(int[] A,int[] next,int val) {
		if(A==null||A.length==0) {
			ListNode head =new ListNode(val);
			head.next=head;
			return head;
		}
		
		//先构造环形链表！！！！！！！！！！！！！！！！！！！！！！！！！！！！重要！！！！！！！！！！！！！！！
		int len =A.length;
		ListNode head = new ListNode(A[0]);	//头节点
		ListNode tail =head;				//尾节点
		 				
		for (int i = 0; i < len-1; i++) {	//这里用len-1而不用A.length-1是减少函数调用，相同值的重复调用就用赋值，以此提升速度
			ListNode curNode = new ListNode(A[next[i]]);	//每增加一个节点
			tail.next=curNode;					//之前尾节点就指向当前增加的这个节点
			tail=curNode;						//当前增加的这个节点就变成了尾节点
		}
		
		
		//插入值
		ListNode preNode=head;
		ListNode nextNode=preNode.next;
		if(val<=head.val||val>=tail.val) {	//如果插入的值最小或者插入值最大，都在头尾节点之间插入这个节点
			ListNode curNode = new ListNode(val);
			curNode.next=head;
			tail.next=curNode;
			return curNode;
		}
		
		
		while(nextNode!=null&&val>nextNode.val) {	//一直寻找合适的插入点，preNode和nextNode一直向后遍历
			preNode=nextNode;
			nextNode=preNode.next;
		}
		ListNode curNode= new ListNode(val);	//直到找到合适的插入点
		curNode.next=nextNode;
		preNode.next=curNode;
		return head;
		
		
	}
	
	
	
	
	
	
	
	
	
}
