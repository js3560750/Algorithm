package com.js.stackAndQueue;

/**
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。 
 * 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。 
 * 以数组为[4,3,5,4,3,3,6,7]，w=3为例。
 * 因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，
 * 第三个窗口[5,4,3]的最大值为5。第四个窗口[4,3,3]的最大值为4。
 * 第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。
 * 所以最终返回[5,5,5,4,6,7]。
 * 
 * 
 * @author 188949420@qq.com
 *
 */
public class SlideWindow {
	
	//滑动窗口
	public int[] slide(int[] arr,int w) {
		int[] res= new int[arr.length-w+1];
		for(int i=0;i<res.length;i++) {
			res[i]=getMax(arr,i,i+w);
		}
		return res;
	}
	
	//获得指定区域的最大值
	private int getMax(int[] arr,int start,int end) {
		int max=arr[start];
		for (int i = start; i < end; i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr= {4,3,5,4,3,3,6,7};
		SlideWindow sw=new SlideWindow();
		int[] res=sw.slide(arr, 3);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
	}
}
