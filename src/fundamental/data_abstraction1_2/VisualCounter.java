package fundamental.data_abstraction1_2;

import java.util.regex.Pattern;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class VisualCounter {
		private int count;
		private int N;//操作的最大次数
		private int max;//最大绝对值
		public VisualCounter(int N, int max) {
			this.N = N;
			this.max = max;
			StdDraw.setXscale(0,N);
			StdDraw.setYscale(0,max/100);
			StdDraw.setPenRadius(.1);
			StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		}
		public void increment() {
			++count;
			++N;
		
			StdDraw.point(N, count);
		}
		public void decrement() {
			--count;
			++N;
			StdDraw.point(N, count);
		}
		
		public int tally() {
			return count;
		}

		public static void main(String[] args) {
			int T = 100000;
//			Counter head = new Counter("head");
//			Counter tail = new Counter("tail");
			VisualCounter visualCounter = new VisualCounter(100000, 8000);
			for (int i = 0; i < T; i++) {
				if (StdRandom.bernoulli(0.0)) {
					visualCounter.increment();
				}else{
					visualCounter.decrement();
				}
			}
			System.out.println(visualCounter.tally());
		}
}
