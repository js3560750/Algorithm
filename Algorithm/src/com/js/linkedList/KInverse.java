package com.js.linkedList;

import java.util.Stack;

/**
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。
 * 调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 * 
 * @author 188949420@qq.com
 *
 */
public class KInverse {

	public ListNode inverse(ListNode head, int k) {
		if(head==null||head.next==null) {
			return head;
		}
		
		Stack<Integer> stack =new Stack<>();
		
		ListNode curNode =head;	//遍历用
		ListNode temp =head;	//赋值用
		int count=0;
		while(curNode!=null) {	//思路是每个值都压入栈中，当数目等于k时，就从栈出依次弹出值并赋给链表
			stack.push(curNode.val);
			curNode=curNode.next;	//!!!!!!!!!!!!遍历链表只需要这一个节点就够了！！！！！！！！！！！！！！
			++count;
			if(count==k) {
				while(!stack.empty()) {	//判断栈是否为空
					temp.val=stack.pop();
					temp=temp.next;
				}
				count=0;
			}
		}
		return head;
		
	}
}
