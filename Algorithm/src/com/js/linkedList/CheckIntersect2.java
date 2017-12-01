package com.js.linkedList;

/**
 * 判断两个“有环”单链表是否相交
 * 
 * 相交的话返回第一个相交的节点，不想交的话返回空。如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
 * 
 * https://www.nowcoder.com/study/vod/1/5/14
 * 
 * 
 * @author 188949420@qq.com
 *
 */
public class CheckIntersect2 {
	
	/**
	 * 思路是：
	 * 
	 * 根据com.js.linkedList.CheckLoop.java里的算法先找到两个有环单链表各自的入环节点。
	 * 1、如果两个入环节点是同一个节点，那么这两个有环单链表肯定是相交的。
	 * 然后采用CheckIntersect1里的方法三，过程一模一样，只需修改遍历的结尾为入环节点而不是链表尾。
	 * 2、如果两个入环节点不是同一个节点，
	 * 则从第一个单链表的入环节点开始遍历，如果能回到该节点，则两单链表不相交；
	 * 如果遍历到了第二个单链表的入环节点，则相交，返回任何一个入环节点都正确。这里还是看视频讲解https://www.nowcoder.com/study/vod/1/5/10案例十一
	 * @param head1
	 * @param head2
	 * @return
	 */
	public ListNode check(ListNode head1,ListNode head2) {
		return null;
	}
	
	private ListNode findLoopNode(ListNode head) {
		return null;
	}

}
