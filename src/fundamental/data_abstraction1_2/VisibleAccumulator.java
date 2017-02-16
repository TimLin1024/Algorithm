package fundamental.data_abstraction1_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class VisibleAccumulator {
	private double sum;
	private int N;
	//���һ�����캯����ָ����Ҫ����ĵ��������ǵ����ֵ�����ڵ���ͼ��ı�����
	public VisibleAccumulator(int trials, double max) {
		StdDraw.setXscale(0, trials);
		StdDraw.setYscale(0, max);
		StdDraw.setPenRadius(.005);
	}

	public void addDataValue(double val) {
		sum += val;
		++N;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.point(N, sum / N);
	}

	public double mean() {
		return sum / N;
	}

	@Override
	public String toString() {
		return "Mean (" + N + " values):" + String.format("%7.5f", mean());
	}

	public static void main(String[] args) {
		int T = 2000;
		VisibleAccumulator a = new VisibleAccumulator(T,1.0);//����Ϊ1.0 ��Ϊ����randomֵΪ[0, 1).
		for (int i = 0; i < T; i++) {
			a.addDataValue(StdRandom.random());
		}
		System.out.println(a);
	}
}
