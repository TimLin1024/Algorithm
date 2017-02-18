package fundamental.algorithm_analysis1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {
	// 统计一个文件中所有和为0的元组的数量
	public static int count(int[] a) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = j + 1; k < a.length; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	
		public static int betterCount(int[] a) {
			int cnt = 0;
			for (int i = 0; i < a.length; i++) {
				for (int j = i + 1; j < a.length; j++) {
					for (int k = j + 1; k < a.length; k++) {
						if ((long)a[i] + a[j] + a[k] == 0) {//使用long避免溢出
							cnt++;
						}
					}
				}
			}
			return cnt;
		}

	public static void main(String[] args) {
		int[] a = In.readInts("8Kints.txt");
		StdOut.println(count(a));
	}
}
