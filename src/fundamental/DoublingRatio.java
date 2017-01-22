package fundamental;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingRatio {
	
	public static double timeTrail(int N) {
		int MAX = 100000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(-MAX, MAX);
		}
		Stopwatch stopwatch = new Stopwatch();
		ThreeSum.count(a);
		return stopwatch.elapsedTime();
	}
	
	
	public static void main(String[] args) {
		double prev = timeTrail(125);
		for(int N = 250 ; true; N+=N){
			double time = timeTrail(N);
			StdOut.printf("%6d %7.1f ", N , time);
			StdOut.printf("%5.1f\n", time / prev);
			prev = time;
		}
	}
}
