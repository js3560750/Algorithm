package com.js.linkedList;

/**
 * https://www.nowcoder.com/study/vod/1/5/11
 * 看“小炒肉好吃不啦”写的答案
 * 
 * 过一遍就好了
 * 
 * @author 188949420@qq.com
 *
 */

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;
 
    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class RandomListClone {

	public RandomListNode Clone(RandomListNode pHead)
    {
 
        if(pHead == null){
            return null;
        }
        // 复制所有节点，放置在原始链表后面
        RandomListNode nod = pHead;
        RandomListNode next = null;
        while(nod != null){
            next = nod.next;
            nod.next = new RandomListNode(nod.label);
            nod.next.next = next;
            nod = next;
        }
        // 复制random节点
        nod = pHead;
        RandomListNode nodCopy;
        while(nod != null){
            next = nod.next.next;
            nodCopy = nod.next;
            nodCopy.random = nod.random != null ? nod.random.next : null;
            nod=next;
        }
        // 整理链表得到结果
        nod = pHead;
        RandomListNode res = pHead.next;
        while(nod != null){
            next = nod.next.next;
            nodCopy = nod.next;
            nod.next = next;
            nodCopy.next = next != null ? next.next : null;
            nod = next;
        }
        return res;
    }
}
