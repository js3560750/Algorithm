package com.js.linkedList;

import java.util.Hashtable;

/**
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。
 * 如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 * 
 * https://www.nowcoder.com/study/vod/1/5/12
 * 
 * 解法一：
 * 如果没有额外空间复杂度O(1)的限制，可以用哈希表来实现。
 * 从头节点开始遍历，记录每个节点到哈希表中，如果链表无环，遍历到链表尾也不会出现重复的节点。
 * 如果有环，那么肯定会有相同的节点，第一个相同节点就是进入环的第一个节点。
 * 
 * 解法二：
 * 额外空间复杂度O(1)的限制下，固定方法，记住就行，数学证明略。
 * 从头节点开始，用快慢两个指针开始遍历，快指针一次走两步，慢指针一次走一步。
 * 如果链表无环，则快指针会迅速的走到链表尾。
 * 如果有环，那么快慢指针会在环中的某个位置相遇，在相遇的时候，让快指针从链表头节点重新遍历，并且快指针一次只走一步，慢指针也继续走，
 * 当快慢指针再次相遇的时候，相遇的节点就是进入环的第一个节点。
 * 
 * @author 188949420@qq.com
 *
 */
public class CheckLoop {

	//方法一
	public int chkLoop1(ListNode head) {
		
		Hashtable<ListNode, ListNode> hash= new Hashtable<>();
		
		
		while(head!=null) {
			if(hash.containsKey(head)) {	
				return hash.get(head).val;
			}else {
				hash.put(head, head);
			}
			head=head.next;
		}
		
		//遍历到结尾了都没发现环返回-1
		return -1;
	}
	
	//方法二
	public int chkLoop2(ListNode head) {
		if(head==null||head.next==null) {
			return -1;
		}
		
		ListNode fast=head;
		ListNode slow=head;
		
		
		while(fast!=null&&fast.next!=null) {	//因为fast一次走两步，可能fast.next就是Null了，那么fast.next.next就是空指针异常
			
			fast=fast.next.next;
			slow=slow.next;
			
			if(fast==slow) {	//注意遇见了同一节点，是fast==slow，不是fast.val==slow.val
				ListNode fast2=head;
				while(fast2!=slow) {
					fast2=fast2.next;
					slow=slow.next;
				}
				return slow.val;
			}
				
			
		}
		
		//遍历到结尾了都没发现环返回-1
		return -1;
	}
	
	
	
	
	
	
	
}
