package com.js.string;

/**
 * 
 * 字符串中的单词逆序
 * "pig loves dog"变成 "dog loves pig"
 * 
 * 逆序思路，整体逆序、局部逆序，是字符串问题中非常重要的技巧
 * 
 * 步骤：
 * 1、实现将字符串所有字符逆序的函数function
 * 2、利用function将字符串所有字符逆序
 * "pig loves dog"变成 "god sevol gip"
 * 3、找到逆序后的字符串中每一个单词的区域，利用function将每一个单词逆序
 * "god sevol gip"变成"dog loves pig"
 * 
 * 
 * @author 188949420@qq.com
 *
 */
public class NiXu {
	
	public static void main(String[] args) {
		String s="pig loves dog";
		System.out.println(reverseSentence(s));
	}

	
	//对一句话中的单词进行逆序
	public static String reverseSentence(String a) {
		//字符串为Null和字符串长度为0是不一样的
		//String=""是长度为0，不为空
		if(a==null||a.length()==0) {
			return a;
		}
		
		char[] s=a.toCharArray();
		rotateWord(s);
		return String.valueOf(s);
		
	}
	
	//把字符串中的单词逆序的算法"pig loves dog"变成 "god sevol gip"
	public static void rotateWord(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		
		//步骤2：利用function将字符串所有字符逆序
		reverse(chas, 0, chas.length-1);
		
		//步骤3：找到逆序后的字符串中每一个单词的区域，利用function将每一个单词逆序
		int left=-1;
		int right=-1;
		//找"god sevol gip"中的单词，顺着走一遍就懂了
		for(int i=0;i<chas.length;i++) {
			//遇到空格跳过
			if (chas[i] != ' ') {
				//如果i等于最左边或者当前脚标左边是空格，那么这个就是单词的起始脚标
				left = ((i == 0 || chas[i - 1] == ' ' )? i : left);
				//如果i等于最右边或当前脚标的右边是空格，那么这个就是单词的结束脚标
				right = ((i == chas.length - 1 || chas[i + 1] == ' ' )? i : right);
			}
			//若left、right都不等于-1则找出了单词的脚标
			if (left != -1 && right != -1) {
				reverse(chas, left, right);
				left = -1;
				right = -1;
			}
		}
	}
	
		//步骤1：实现将字符串所有字符逆序的函数function
		//逆序function
		//abc变成cba
		public static void reverse(char[] chas,int start,int end) {
			char temp;
			while(start<end) {
				temp=chas[start];
				chas[start]=chas[end];
				chas[end]=temp;
				start++;
				end--;
			}
		}
}
