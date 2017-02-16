package fundamental.data_abstraction1_2;

import java.util.Arrays;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Ex_1_2 {

	public static void ex1Point2D(int N) {
		StdDraw.setXscale(0, 1.0);
		StdDraw.setYscale(0, 1.0);
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.setPenRadius(0.005);
		Point2D[] point2ds = new Point2D[N];
		for (int i = 0; i < N; i++) {
			point2ds[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
			point2ds[i].draw();
		}
		double minDistance = 1.0;
		// 计算距离
		for (int i = 0; i < point2ds.length; i++) {
			for (int j = i + 1; j < point2ds.length; j++) {
				if (point2ds[i].distanceTo(point2ds[j]) < minDistance) {
					minDistance = point2ds[i].distanceTo(point2ds[j]);
				}
			}
		}
		System.out.println("minDistance: " + minDistance);
	}

	public static void testPoint2D() {
		// int x0 = Integer.parseInt(args[0]);
		// int y0 = Integer.parseInt(args[1]);
		// int N = Integer.parseInt(args[2]);
		int x0 = 10;
		int y0 = 10;
		int N = 1000;

		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(0, 100);
		StdDraw.setPenRadius(.005);
		Point2D[] points = new Point2D[N];
		for (int i = 0; i < N; i++) {
			int x = StdRandom.uniform(100);
			int y = StdRandom.uniform(100);
			points[i] = new Point2D(x, y);
			points[i].draw();
		}

		// draw p = (x0, x1) in red
		Point2D p = new Point2D(x0, y0);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(.02);
		p.draw();

		// draw line segments from p to each point, one at a time, in polar
		// order
		StdDraw.setPenRadius();
		StdDraw.setPenColor(StdDraw.BLUE);
		Arrays.sort(points, p.polarOrder());
		for (int i = 0; i < N; i++) {
			p.drawTo(points[i]);
			StdDraw.show(100);
		}
	}

	public static void ex2Interval1D(int N) {
		Interval1D[] interval1ds = new Interval1D[N];

		for (int i = 0; i < interval1ds.length; i++) {
			interval1ds[i] = new Interval1D(StdRandom.uniform(0.1, N * 0.5), StdRandom.uniform(N * 0.5, N * 1.0));
		}
		for (int i = 0; i < interval1ds.length; i++) {
			for (int j = i + 1; j < interval1ds.length; j++) {
				if (interval1ds[i].intersects(interval1ds[j])) {
					System.out.println(interval1ds[i]);
					System.out.println(interval1ds[j]);
				}
			}
		}
	}

	public static void ex3Interval2D(int N, double min, double max) {
		Interval2D[] interval2ds = new Interval2D[N];
		int intersectCount = 0;
		for (int i = 0; i < interval2ds.length; i++) {
			double lo = StdRandom.uniform(min, max);
			Interval1D interval1d1 = new Interval1D(lo, StdRandom.uniform(lo, max));
			Interval1D interval1d2 = new Interval1D(lo, StdRandom.uniform(lo, max));
			interval2ds[i] = new Interval2D(interval1d1, interval1d2);
			interval2ds[i].draw();
		}
		for (int i = 0; i < interval2ds.length; i++) {
			for (int j = i + 1; j < interval2ds.length; j++) {
				if (interval2ds[i].intersects(interval2ds[j])) {
					++intersectCount;
				}

			}
		}
		System.out.println(intersectCount);
	}

	// 回环变位
	public static boolean ex6IsCircularRotation(String str1, String str2) {
		// 字符串加上本身，如果是回环变位，那么str2一定会在ss中
		String ss = str1 + str1;
		if (ss.indexOf(str2) == -1 || str1.length() != str2.length()) {
			return false;
		}
		return true;
	}

	public static String mystery(String s) {
		int N = s.length();
		if (N <= 1) {
			return s;
		}
		String a = s.substring(0, N / 2);
		String b = s.substring(N / 2, N);
		return mystery(b) + mystery(a);
	}
	


	public static void main(String[] args) {
		// ex1Point2D(10000);
		System.out.println(mystery("ABCD"));
	}

}
