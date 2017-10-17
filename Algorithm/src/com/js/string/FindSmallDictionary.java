package com.js.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 拼接最小字典
 * 应用比较器comparator
 * 
 * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的
 * 测试样例：
	["abc","de"]
	"abcde"
	
 * 拼接字典顺序要记住：如果str1+str2<str2+str1，那么拼接这两个str组成字典序最小的话，str1要放前面
 * 因此多个字符串拼接并保持最小字典顺序时，可以先把多个字符串经过s1+s2与s2+s1比较之后，排个序，然后直接顺着拼接就好了
 * 
 * 
 * 
 * @author 188949420@qq.com
 *
 */
public class FindSmallDictionary {
	//应用比较器
	/**
	 * 常用来排序，Collections.sort()和Arrays.sort()都可以重载比较器
	 * 
	 * Java中Comparable与Comparator的区别
	 * Comparable是一个对象本身就已经支持自比较所需要实现的接口，如String、Integer自己就实现了Comparable接口，可完成比较大小操作。
	 * 在用Collections类的sort方法排序时若不指定Comparator，那就以自然顺序排序。所谓自然顺序就是实现Comparable接口设定的排序方式。
	 * 总而言之Comparable是自已完成比较，Comparator是外部程序实现比较。
	 * 
	 * @author 188949420@qq.com
	 *
	 */
	public class MyComparator implements Comparator<String>{
		
		/**
		 * compare方法定义如何去比较
		 * 如果返回负数，则o1<o2
		 * 返回0，则o1=o2
		 * 返回正数，则o1>o2
		 */
		@Override
		public int compare(String o1, String o2) {
			//String.compareTo() 方法比较两个字符串的字典
			/**
			 * 例: 
			String s1 = "abc"; 
			String s2 = "abcd"; 
			String s3 = "abcdfg"; 
			String s4 = "1bcdfg"; 
			String s5 = "cdfg"; 
			String s6 = "bbbb";
			System.out.println( s1.compareTo(s2) ); // -1 (前面相等,s1长度小1) 
			System.out.println( s1.compareTo(s6) ); // -1 (第一个不一样，只比较第一个，a比b小一位，所以是-1) 
			System.out.println( s1.compareTo(s3) ); // -3 (前面相等,s1长度小3) 
			System.out.println( s1.compareTo(s4) ); // 48 ("a"的ASCII码是97,"1"的的ASCII码是49,所以返回48) 
			System.out.println( s1.compareTo(s5) ); // -2 ("a"的ASCII码是97,"c"的ASCII码是99,所以返回-2)
			 */
			return (o1+o2).compareTo(o2+o1);
		}
	}
	
	//拼接最小字典
	public String findsmall(String[] strs) {
		if(strs==null) {
			return "";
		}
		
		//排序，并应用自己修改过后的比较器的排序规则
		Arrays.sort(strs,new MyComparator());
		
		//拼接
		String res="";
		for (int i = 0; i < strs.length; i++) {
			res+=strs[i];
		}
		
		return res;
		
	}
}
