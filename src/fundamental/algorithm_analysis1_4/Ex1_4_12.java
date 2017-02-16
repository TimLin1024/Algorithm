package fundamental.algorithm_analysis1_4;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import fundamental.base_model1_1.BinarySearch;

/*
 * ��дһ�����������ӡ�����������飨����N��int ֵ��
 * �����еĹ���Ԫ�أ�������������������ʱ��Ӧ�ú�N������
*/
public class Ex1_4_12 {
	public static void printSharedElement(int[] a1, int[] a2) {
		if (a1.length != a2.length) {
			System.out.println("Input error�� two array have different length");
			return;
		}
		int len = a1.length;
		int i = 0;
		int index = 0;
		while (i < len) {
			while ((index = BinarySearch.rank(a2, a1[i])) < 0) {
				i++;
			}
			StdOut.println(a1[i]);

			while (a1[i] == a1[i + 1]) {
				i++;
			}
			if (index >= 0) {
				while (a2[index] == a2[index + 1]) {
					index++;
				}
			}
		}
	}
	public static void printCommonNum(int[] a1, int[] a2, int len) {
		int i = 0;
		int j = 0;
		//��������Ҫ2*len (-1)?�αȽ�
		//eg: 
		//1   3   5   7
		//  2   4   6   8
		for(int k = 0; k<len * 2; k++){
			if (a1[i]>a2[j]) {
				j++;
				//�����������
				if (j == a2.length) {
					break;
				}
			}else if (a1[i]<a2[j]) {
				i++;
				//�����������
				if (i == a1.length) {
					break;
				}
			}else {
				StdOut.printf("%d ", a1[i]);
				i++;
				j++;
				//�����������
				if (i == a1.length || j == a2.length) {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		int N = 100;
		int[] a1 = new int[N];
		int[] a2 = new int[N];
		for (int i = 0; i < a1.length; i++) {
			a1[i] = StdRandom.uniform(-N, N);
		}
		for (int i = 0; i < a2.length; i++) {
			a2[i] = StdRandom.uniform(-N, N);
		}

		Arrays.sort(a1);
		Arrays.sort(a2);
		printCommonNum(a1, a2, a1.length);
	}
}
