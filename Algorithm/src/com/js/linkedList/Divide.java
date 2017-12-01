package com.js.linkedList;

/**
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 * 并且保证结点值不重复!!!给的中间值可能不等于任何一个节点值
 * 
 * 	测试样例：{1,4,2,5},3
	结果：{1,2,4,5}
 * @author 188949420@qq.com
 *
 */
public class Divide {

	public ListNode divide(ListNode head,int val) {
		if(head==null||head.next==null) {	//Null的检查不要漏了head.next
			return head;
		}
		
		ListNode smallHead=null,smallCurrent=null;	//比val小和等于val的依次连到small后面
		
		ListNode bigHead=null,bigCurrent=null;		//比val大的依次连到big后面 ，最后将这两个连起来就是我们要的
		
		ListNode curNode=head;
		ListNode nextNode=null;
		while(curNode!=null) {	//遍历所有节点
				
			if(curNode.val<=val) {
				if(smallHead==null) {	//small链表建立头节点
					smallHead=curNode;
					smallCurrent=smallHead;
				}else {
					smallCurrent.next=curNode;	//small链表建立头节点之后的节点
					smallCurrent=curNode;
				}
			} 
			else {							//big链表
				if(bigHead==null) {
					bigHead=curNode;
					bigCurrent=bigHead;
				}else {
					bigCurrent.next=curNode;
					bigCurrent=curNode;
				}
			}
			
			nextNode=curNode.next;	//遍历所有节点
			curNode.next=null;	//!!!!!!!!!!!不要这一句会显示“内存超过了使用限制”！！！！！！！！！！！逻辑上不加应该是可以的！！！
			curNode=nextNode;	
			
		}
		
		//将上面两个链表再合起来
		if(smallCurrent!=null) {	//smallCurrent现在是small表的尾节点,无需判断bigHead是否为null
			smallCurrent.next=bigHead;
		}
		
		return smallHead!=null?smallHead:bigHead;
	}
}
