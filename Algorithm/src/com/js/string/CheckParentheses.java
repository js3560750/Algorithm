package com.js.string;

/**
 * 判断合法括号串
 * 
	测试样例：
	"(()())",6
	返回：true
	
	测试样例：
	"()a()()",7
	返回：false
	
	测试样例：
	"()(()()",7
	返回：false
 * 
 * @author 188949420@qq.com
 *
 */
public class CheckParentheses {
	
	public boolean chkParentheses(String s) {
		if(s==null||s.length()==0) {
			return false;
		}
		/*这个count很关键，如果遇到(，count++，如果遇到)，count--，
		 * 因此count最后一定等于0才返回true，
		 * 并且过程中，如果count<0则说明有多的)在左边去了
		 */
		int count=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				count++;
			}else if(s.charAt(i)==')') {
				count--;
			}
			
			//以)开头的情况和)多了的情况
			if(count<0) {
				return false;
			}
			
			//没有括号的情况和()a这种情况
			if(count==0&&s.charAt(i)!=')'&&s.charAt(i)!='(') {
				return false;
			}
		}
		if(count==0) {
			return true;
		}else {
			return false;	//(多了的情况
		}
	}
	
	public static void main(String[] args) {
		String s=")(()()";
		System.out.println(new CheckParentheses().chkParentheses(s));
	}
}
