package com.js.string;

/**
 * 对于两个字符串A和B(假设就字母和数字)，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。

	给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。

	测试样例：
	"abc",3,"bca",3
	返回：true

 * @author 188949420@qq.com
 *
 */
public class CiYuBianXing {

	public static boolean ciyubianxing(String a,int lena,String b,int lenb) {
		if(a==null||b==null||lena!=lenb) {
			return false;
		}
		char[] c1=a.toCharArray();
		char[] c2=b.toCharArray();
		
		//对于ASCII码，字母A对应的是65，数字0对应的是48，256个够用了
		int[] map=new int[256];	//256就是脚标0到255
		
		for(int i=0;i<lena;i++) {
			//比如c1[1]=A,A的ASCII码又是65，则map[65]自增1
			map[c1[i]]++;
		}
		//检验变形词
		for(int j=0;j<lenb;j++) {
			//这一步是关键，如果等于0，说明B的该字符在A中没有出现过，或出现的次数不一致
			if(map[c2[j]]==0) {
				return false;
			}
			map[c2[j]]--;
		}
		//上面没返回false，则是变形词，返回true
		return true;
	}
	
	public static void main(String[] args) {
		String a="ABCCE11";
		String b="ABCCE21";
		System.out.println(ciyubianxing(a, 7, b, 7));
	}
}
