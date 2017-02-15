package fundamental;

import edu.princeton.cs.algs4.StdRandom;
//一种能为用例计算一组数据的实时平均值的抽象数据类型
public class Accumulator {
	private int N;
	private double sum;

	public Accumulator() {
		
	}

	public void addDataValue(double val) {
		sum += val;
		++N;
	}

	public double mean() {
		return sum / N;
	}

	@Override
	public String toString() {
		return "Mean ("+ N +" values):" + String.format("%7.5f", mean());
	}
	public static void main(String[] args) {
		int T = 100000;
		Accumulator a = new Accumulator();
		for (int i = 0; i < T; i++) {
			a.addDataValue(StdRandom.random());
		}
		System.out.println(a);
	}
}
