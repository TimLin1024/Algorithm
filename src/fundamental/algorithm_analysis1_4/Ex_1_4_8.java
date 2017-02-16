package fundamental.algorithm_analysis1_4;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex_1_4_8 {

	public static int violenceSolution(int[] a) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static int fastSolution(int[] a) {
		int cnt = 0;
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			int j = i;
			// 排好了顺序，只要元素不相等了就直接进行跳出本个循环
			while (j < a.length - 1 && a[i] == a[j + 1]) {
				cnt++;
				j++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {

//		 //产生一些随机数
//		 int max = 100000;
//		 Out out = new Out("random.txt");
//		 for (int i = 0; i < max ;i++) {
//		 out.printf("%d ",StdRandom.uniform(-max, max));
//		 }
		int[] a = In.readInts("random.txt");
		StdOut.println(fastSolution(a));
		StdOut.println(violenceSolution(a));
	}
}
