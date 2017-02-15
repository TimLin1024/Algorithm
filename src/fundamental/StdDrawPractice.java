package fundamental;

import java.util.Arrays;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class StdDrawPractice {
	//画出三条曲线 y = x, y = x * x, y = i * log(i);
	public static void drawCurve() {
		int N = 100;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N * N);
		StdDraw.setPenRadius(.01);

		for (int i = 0; i < N; i++) {
			StdDraw.point(i, i);
			StdDraw.point(i, i * i);
			StdDraw.point(i, i * Math.log(i));
		}
	}

	// 随机数组排序后的效果
	public static void randomRectangle() {
		int N = 50;
		double[] ds = new double[N];
		for (int i = 0; i < ds.length; i++) {
			ds[i] = StdRandom.random();
		}
		Arrays.sort(ds);
		for (int i = 0; i < ds.length; i++) {
			double x = 1.0 * i / N;
			double y = ds[i] / 2.0;
			double rw = 0.5 / N;
			double rh = ds[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}


	public static void testInterval2D() {
		double xlo = .20;
		double xhi = .50;
		double ylo = .50;
		double yhi = .60;
		int T = 30000;
		Interval1D xiInterval1d = new Interval1D(xlo, xhi);
		Interval1D yiInterval1d = new Interval1D(ylo, yhi);
		Interval2D box = new Interval2D(xiInterval1d, yiInterval1d);
		box.draw();

		Counter counter = new Counter("hits");
		for (int i = 0; i < T; i++) {
			double x = Math.random();
			double y = Math.random();
			Point2D p = new Point2D(x, y);
			if (box.contains(p)) {
				counter.increment();
			} else {
				p.draw();
			}
		}
		System.out.println("counter.tally() " + counter.tally());
		System.out.println("box.area() " + box.area());
	}

	public static void main(String[] args) {
		testInterval2D();
	}
}
