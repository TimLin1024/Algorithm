package fundamental;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class ClassicalStaticMethod {
	
	//�ж��Ƿ�������
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
	//������ͼ���
	public static double calculateHarmonicSeries(int num){
		double sum = 0.0;
		for (int i = 1; i <= num; i++) {
			sum += 1.0 / i;
		}
		return sum;
	}
	//����ƽ������ţ�ٵ�������
	public static double sqrt(double c) {
		if (c < 0) {
			return Double.NaN;
		}
		double err =  1e-15;//1e ���� le ��
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
