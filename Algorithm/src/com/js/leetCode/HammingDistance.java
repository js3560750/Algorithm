package com.js.leetCode;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ?   ?

The above arrows point to positions where the corresponding bits are different.
 * @author 188949420@qq.com
 *
 */
public class HammingDistance {

	public static void main(String[] args) {
		int result =hammingDistance(1, 4);
		System.out.println(Integer.toBinaryString(result));
		
	}
	
	 public static int hammingDistance(int x, int y) {
	        int xor=x^y;    //异或后，对应bit位相同的为0，不同位1
	        int count=0;
	        for(int i=0;i<31;i++){
	            
	            if(xor%2==1){
	                count++;
	            }
	            xor=xor>>1;
	        }
	        return count;
	        
	        
	    }
}
