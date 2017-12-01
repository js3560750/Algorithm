package com.js.linkedList;

/**
 * 单链表
 * 给定头节点和要删除的节点值，执行删除操作
 * 
 * @author 188949420@qq.com
 *
 */
public class RemoveNode {

	public ListNode remove(ListNode head, int delVal) {
		
		if(head==null) {	//如果头节点为Null
			return null;
		}
		
		if(head.val==delVal) {	//如果要删除的是头节点
			return head.next;
		}
		
		//!!!!!!!!!!!!遍历链表只需要这一个节点就够了！！！！！！！！！！！！！！
		//但这里要操作上下节点两个节点才能执行删除操作，所以才遍历了两个节点
		ListNode preNode =head;
		ListNode curNode =preNode.next;
		while(curNode.val!=delVal) {	//开始找节点
			preNode=curNode;
			curNode=preNode.next;
		}
		//跳出while循环则找到了值等于delVal的节点，删除这个节点就是该节点上一个节点的next指向该节点的next，并且该节点.next=null。
		preNode.next=curNode.next;
		curNode.next=null;
		
		return head;
		
	}
}
