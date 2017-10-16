package com.js.leetCode;

/**
 * 十进制转二进制
 * 
 * 
 * @author 188949420@qq.com
 *
 */
public class DecimalToBinary {

	public static void toBin(int num) {
		StringBuffer sb =new StringBuffer();
		while(num>0) {
			sb.append(num%2);
			num=num/2;
		}
		System.out.println(sb.reverse());
	}
	
	public static void main(String[] args) {
		toBin(2551);
	}
}
