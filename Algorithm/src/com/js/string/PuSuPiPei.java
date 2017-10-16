package com.js.string;

/*
 * 字符串匹配
 * 
 * 朴素模式匹配
 * 时间复杂度O(m*n),m是目标串长度，n是模板串长度
 * 
 * 
 */
public class PuSuPiPei {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="abcjdskjd7839sb";
		String s2="7839s";
		plain(s1,s2);
	}

	/**
	 * 朴素模式匹配
	 * @param source 目标字符串
	 * @param pattern 模式字符串
	 */
	private static void plain(String source,String pattern) {
		
		//匹配次数
		int count=0;
		int sl=source.length();
		int pl=pattern.length();
		if(source==null||pattern==null||pl<0||sl<pl) {
			System.out.println("传入参数错误，匹配失败");
			return;
		}
		//逐个进行匹配，注意i<=sl-pl
		for(int i=0;i<=sl-pl;i++) {
			//匹配次数+1
			count++;
			//截取要匹配的目标字符串
			String str=source.substring(i, i+pl);
			//匹配
			if(str.equals(pattern)) {
				System.out.println("匹配成功，一共匹配了："+count+"次");
				return;
			}
		}
		System.out.println("目标串中不包含模式串，一共匹配了："+count+"次");
		
	}
}
