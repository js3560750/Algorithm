package com.js.string;

/**
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。

	给定一个字符串A，同时给定len，请返回平移后的字符串。
	
	测试样例：
	"ABCDE",3
	返回："DEABC"

 * @author 188949420@qq.com
 *
 */
public class WeiYi {
	
	public static String myWeiYi(String s,int len) {
		if(len>=s.length()) {
			return s;
		}
		
		//很简单，很精髓
		return (s+s).substring(len, len+s.length());
	}
	
	public static void main(String[] args) {
		String s="ABCDEF";
		System.out.println(myWeiYi(s, 3).toString());
	}
}
