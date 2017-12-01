package com.js.linkedList;

import java.util.Hashtable;

/**
 * 有两个"无环"单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交
 * 
 * 最简单的方法一：
 * 如果只是判断两“无环”单链表是否相交，只需要判断最后的一个节点是否是同一节点。
 * 但方法一无法返回相交的那个节点，要找相交的那个节点还需用下面的两个方法。
 * 
 * 方法二：
 * 没有额外空间复杂度的要求，可以用哈希表
 * 遍历链表一，值存入哈希表，再遍历链表二，如果在哈希表中有相同的值，则相交。
 * 
 * 方法三：
 * 有额外空间复杂度O(1)的限制。
 * 假设M>N，则链表一先走M-N步，然后链表一和链表二一起走，如果相遇，则相交。
 * 
 * @author 188949420@qq.com
 *
 */
public class CheckIntersect1 {

	//方法一
	public boolean check1(ListNode headA, ListNode headB) {
		if(headA==null||headB==null) {
			return false;
		}
		
		//找到链表A的最后一个节点
		while(headA!=null){
            if(headA.next==null){
                break;
            }
			headA=headA.next;
        }
        
		//找到链表B的最后一个节点
        while(headB!=null){
            if(headB.next==null){
                break;
            }
            headB=headB.next;
        }
        
        //判断最后一个节点是否相同
        if(headA==headB){
            return true;
        }else{
            return false;
        }
	}
	
	//方法二
	public boolean check2(ListNode head1,ListNode head2) {
		if(head1==null||head2==null) {
			return false;
		}
		
		Hashtable<ListNode, ListNode> hash =new Hashtable<>();	//注意哈希表来做链表直接存节点ListNode
		
		while(head1!=null) {
			hash.put(head1, head1);	
			head1=head1.next;
		}
		
		while(head2!=null) {
			if(hash.containsKey(head2)) {
				return true;
			}else {
				head2=head2.next;
			}
		}
		
		return false;
	}
	
	
	//方法三
	public boolean check3(ListNode head1, ListNode head2) {
		if(head1==null||head2==null) {
			return false;
		}
		
		//先获得两个链表的长度
		int m = 0;
		int n = 0;
		ListNode temp1=head1;
		while(temp1!=null) {
			++m;
			temp1=temp1.next;
		}
		
		ListNode temp2=head2;
		while(temp2!=null) {
			++n;
			temp2=temp2.next;
		}
		
		//假设链表1长度>=链表2长度
		int count=m-n;
		while(count!=0) {	//链表1先走M-N步
			head1=head1.next;
			--count;
		}
		
		while(head1!=null&&head2!=null) {	//链表1和链表2一起走，每走一步判断节点是否相同，第一次相同节点就是相交点
			if(head1==head2) {
				return true;
			}else {
				head1=head1.next;
				head2=head2.next;
			}
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
