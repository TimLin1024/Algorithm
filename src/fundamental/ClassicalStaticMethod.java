package fundamental;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class ClassicalStaticMethod {
	
	//判断是否是素数
	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	//计算调和级数
	public static double calculateHarmonicSeries(int num){
		double sum = 0.0;
		for (int i = 1; i <= num; i++) {
			sum += 1.0 / i;
		}
		return sum;
	}
	//计算平方根（牛顿迭代法）
	public static double sqrt(double c) {
		if (c < 0) {
			return Double.NaN;
		}
		double err =  1e-15;//1e 不是 le 囧
		double t = c;
		while(Math.abs(t-c/t) > err * t)
			t = (c/t + t) / 2.0;
		return t;
	}
	
	public static void main(String[] args) {
		System.out.println(calculateHarmonicSeries(10));
		System.out.println(isPrime(2));
		System.out.println(sqrt(9));
	}
}
