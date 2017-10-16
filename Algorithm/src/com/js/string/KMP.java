package com.js.string;

import java.util.Arrays;

/**
 * 高效的字符串匹配算法
 * KMP算法
 * 时间复杂度O(m+n),m是目标串长度，n是模板串长度，目标串就是长的那个
 * 
 * 对比前缀树（Trie），前缀树时间复杂度O(n)，显然Trie更快，但是要存储目标串，因此消耗很大空间。KMP更适合用一个模板串去匹配多个目标串的场景
 * 
 * 参考
 * http://www.ruanyifeng.com/blog/2013/05/Knuth–Morris–Pratt_algorithm.html
 * 
 * @author 188949420@qq.com
 *
 */
public class KMP {
	
	public static void main(String[] args) {
		String str = "1111BBC ABCDAB ABCDABCDABDE";
        String sub = "ABCDABD";

        
       System.out.println(kmp(str,sub));
	}
	
	
	/**
	 * 生成部分匹配值表
	 * "部分匹配值"就是"前缀"和"后缀"的最长的共有元素的长度。
	 * 以"ABCDABD"为例，
	 * ABCDABD
	 * 0000120
	 * 
	 * @param sub
	 * @return
	 */
	private static int[] next(String sub) {
        int[] n = new int[sub.length()];	//新建数组，默认赋0，而不是null，数组长度就是new int[长度]里的长度
        int x = 0;
        for (int i = 1; i < sub.length(); i++) {
        	//不懂为毛，只能强行记住了
            while (x > 0 && sub.charAt(x) != sub.charAt(i)) {
                x = n[x - 1];
            }

            if (sub.charAt(i) == sub.charAt(x)) {
                x++;
            }

            n[i] = x;
        }
        return n;
    }

	/**
	 * 这算法不是KMP吧！！！！或者是太高端的KMP？？？反正我看不懂啊！！！
	 * 结果验证是正确的！！！
	 * 
	 * @param str 目标串
	 * @param sub 模板串
	 * @return 目标串开始匹配的脚标
	 */
	public static int kmp(String str, String sub) {
        if(str == null || sub == null || str.length() == 0 || sub.length() == 0){
            throw new IllegalArgumentException("str或者sub不能为空");
        }

        int j = 0;	//j是已匹配的字符数
        int[] n = next(sub);	//next是部分匹配值
        
        //如果是KMP算法， 这里不可能i++,挨个比较，没有跳为
        //KMP的核心思想是：移动位数 = 已匹配的字符数 - 对应的部分匹配值！！！！！！！而这for循环没有这个思想
        for (int i = 0; i < str.length(); i++) {
        	//又是这个，不懂为毛
            while(j > 0 && str.charAt(i) != sub.charAt(j)){
                j = n[j - 1];
            }

            if(str.charAt(i) == sub.charAt(j)){
                j++;
            }

            if(sub.length() == j){
                int index = i - j + 1;
                return index;
            }
        }

        return -1;
    }
    
}
