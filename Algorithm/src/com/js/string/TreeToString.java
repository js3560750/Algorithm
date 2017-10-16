package com.js.string;

/**
 * 二叉树序列化
 * 
 * 传入二叉树的头结点，返回字符串
 * 
 * @author 188949420@qq.com
 *
 */
public class TreeToString {
	
	//定义二叉树
	class TreeNode{
		int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	//二叉树序列化方法
	public String serial(TreeNode head) {
		if(head==null) {
			return "#!";
		}
		
		String res=head.val+"!";
		
		res+=serial(head.left);
		res+=serial(head.right);
		
		return res;
	}
}


