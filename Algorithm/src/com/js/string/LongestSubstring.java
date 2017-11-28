package com.js.string;

/**
 * 找到字符串的最长无重复字符的子串的长度
 * 
 * 如“abcd"，则返回4
 * 如"abcb"，则返回3
 * 
 * 不懂！！！！！！！！！！！！！！！！！！！！！！！！！！
 * 
 * @author 188949420@qq.com
 *
 */
public class LongestSubstring {

	public int longestSubstring(String arr) {
        // write code here
        if (arr == null || arr.length() == 0) {
            return 0;
        }
        char[] chas = arr.toCharArray();
        // 记录上一次字符出现位置
        int[] map = new int[256];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        // 初始化
        int len = 0;
        int pre = -1; // 记录当前无重复子串的起始位置
        int cur = 0;
        // 状态转移
        for (int i = 0; i < chas.length; i++) {
            // 当上次字符出现位置，在无重复子串之后时，更新。
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            // 最大的子串长度的计算，当前结尾的无重复子串长度为 i - pre
            len = Math.max(len, cur);
            map[chas[i]] = i;
        }
        return len;
    }
	
	public static void main(String[] args) {
		String s="fdksiownvkcxojhfdsi";
		System.out.println(new LongestSubstring().longestSubstring(s));
	}
}
