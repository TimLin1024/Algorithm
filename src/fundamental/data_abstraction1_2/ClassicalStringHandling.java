package fundamental.data_abstraction1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class ClassicalStringHandling {
	//�ж��ַ����Ƿ�Ϊ����
	public static boolean isPalindrome(String s) {
		int N = s.length();
		for (int i = 0; i < N / 2; i++) {
			if (s.charAt(i) != s.charAt(N-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	//��һ�������в�������ȡ�ļ�������չ��
	public static void splitNameAndExtension(String title) {
		//�Ȼ�ȡ '.' �����ַ����е����� ,Ȼ�����subString������ע��ȡֵ����Ϊ[ )
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
