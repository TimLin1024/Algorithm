package fundamental.algorithm_analysis1_4;

import java.lang.reflect.Array;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex1_4_16_17 {
	
	public static double[] nearPair(double[] a) {
		Arrays.sort(a);
		double differ = 0;
		int index = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] - a[i-1] < differ) {
				index = i-1;
			}
		}
		double[] b = new double[2];
		b[0] = a[index];
		b[1] = a[index+1];
		return b;
	}
	public static double[] remotePair(double[] a) {
		Arrays.sort(a);
		double[] b = new double[2];
		b[0] = a[0];
		b[1] = a[a.length-1];
		return b;
	}
	public static void main(String[] args) {
		double[] ds = new double[100];
		for (int i = 0; i < ds.length; i++) {
			ds[i] = StdRandom.random();
		}
		Arrays.sort(ds);
		System.out.println("origial array "+Arrays.toString(ds));
		System.out.println("near pair "+ Arrays.toString(nearPair(ds)));
		System.out.println("remote pair "+ Arrays.toString(remotePair(ds)));
	}
}
