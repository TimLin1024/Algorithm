package fundamental.algorithm_analysis1_4;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import fundamental.base_model1_1.BinarySearch;

public class ThreeSumFast {
	
	public static int count(int[] a) {
		Arrays.sort(a);
		int N  =a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (BinarySearch.rank(a, -a[i]-a[j]) > j) {
					cnt ++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
	}
}
