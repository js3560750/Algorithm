package com.js.string;

/**
 * 空格替换练习
 * 
 * 给定一个字符串，只有字母和空格组成，把空格替换成“%20”。
 * 要求只在原字符串上进行替换，字符串的空间足够。但Java又不能改已有的字符串长度，因此这题的意思用char[]来做
 * 
 * 如果不是限定只能在原字符串上替换，可以用StringBuffer，这边遍历原字符串，那边构造新字符串
 * 如果用replace直接替换，那就没意思了
 * 
 * @author 188949420@qq.com
 *
 */
public class ReplaceSpace {

	public String myreplace(String initString) {
		char[] chars=initString.toCharArray();
		//先遍历原字符串获得空格的个数
		int count=0;
		for(int i=0;i<initString.length();i++) {
			//注意这里是字符，用单引号
			if(chars[i]==' ') {
				count++;
			}
		}
		
		//建立新的char[]放替换后的字符串
		char[] res=new char[initString.length()+count*2];
		
		//替换
		int index=0;
		for(int i=0;i<initString.length();i++) {
			if(chars[i]!=' ') {
				res[index++]=chars[i];	//注意index自增
			}else {
				res[index++]='%';
				res[index++]='2';
				res[index++]='0';
				
			}
		}
		
		return String.valueOf(res);
		
	}
	
	public static void main(String[] args) {
		String s="sfdsf dsf sf wrwe 1234 34fsd 3fd ";
		System.out.println(new ReplaceSpace().myreplace(s));
	}
}
