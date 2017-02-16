package fundamental.data_abstraction1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class ClassicalStringHandling {
	//判断字符串是否为回文
	public static boolean isPalindrome(String s) {
		int N = s.length();
		for (int i = 0; i < N / 2; i++) {
			if (s.charAt(i) != s.charAt(N-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	//从一个命令行参数中提取文件名和扩展名
	public static void splitNameAndExtension(String title) {
		//先获取 '.' 的在字符串中的索引 ,然后调用subString方法，注意取值区间为[ )
		int dotIndex = title.indexOf(".");
		String name = title.substring(0, dotIndex);
		String extension = title.substring(dotIndex+1, title.length());
	}
	
	public static void main(String[] args) {
		In in = new In("http://www.bing.com");
		System.out.println(in.readAll());
		in.close();
	}
}
