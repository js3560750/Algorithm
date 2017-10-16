package com.js.string;

/**
 * 判断字符串A和B是互为旋转词
 * 比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"
 * 
 * 时间复杂度O(N)
 * 
 * 步骤：
 * 1、判断str1与str2长度是否相等
 * 2、如果长度相等，生成str1+str2的大字符串
 * 3、用KMP算法判断大字符串中是否含有str2
 * 
 * 
 * 
 * @author 188949420@qq.com
 *
 */
public class XuanZhuanCi {

	public static boolean rotation(String s1,String s2) {
		if(s1.length()!=s2.length()||s1==null||s2==null) {
			return false;
		}
		String s3=s1+s1;
		
		return s3.contains(s2);	//这里用的自带函数，效率高应该用KMP算法
	}
	
	public static void main(String[] args) {
		String s1="1234";
		String s2="2341";
		System.out.println(rotation(s1, s2));
	}
}
