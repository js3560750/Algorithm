package com.js.leetCode;



/**
 * 十进制转十六进制
 * @author 188949420@qq.com
 *
 */
public class DecimalToHexadecimal {

	public static void toHex(int num) {
		StringBuffer sb =new StringBuffer();
		
		//int型有32位，4位转一个16进制，因此要转8次
		for(int i=0;i<8;i++) {
			//取最右边4位
			int temp = num & 15;//0000-0000-0000-0000-0000-0000-0000-1111=15
			if(temp>9) {
				sb.append((char)(temp-10+'A'));	//这里char转型
			}else {
				sb.append(temp);
			}
			num=num>>>4;	//无符号右移4位
		}
		System.out.println(sb.reverse());	//reverse()别掉了
	}
	
	public static void main(String[] args) {
		toHex(10);
	}
}
