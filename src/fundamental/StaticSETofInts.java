package fundamental;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
//���ֲ�����д �����ڴ����������н��в��ҵ�һ�ֳ����������ͣ�
public class StaticSETofInts {
	private int[] a;
	public StaticSETofInts(int[] keys) {
		a = new int[keys.length];
		for (int i = 0; i < keys.length; i++) {
			a[i] = keys[i];//�����Ը���
		}
		Arrays.sort(a);
	}
	public boolean contains(int key) {
		return rank(key) != -1;
	}
	//�ҳ����������ֵĴ���
	public int hasMany(int key) {
	int cnt = 0;
		int pos = rank(key);
		if (pos != -1) {
			//�ұ��ظ����
			while (pos < a.length-1 && a[pos+1] == key) {
				pos++;
				cnt++;
			}
			//����ظ����
			while (pos > 0 && a[pos-1] == key ) {
				pos--;
				cnt++;
			}
		}
		return cnt;
	}
	private int rank(int key) {
		int lo = 0;
		int hi = a.length-1;
		while (lo <= hi) {
			//��Ҫô������a[lo..high],Ҫô������
			int mid = (lo + hi) /2;
			if (key > a[mid]) {
				lo = mid + 1;
			}else if (key < a[mid]) {
				hi = mid - 1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] whiteList = In.readInts("tinyW.txt");
		StaticSETofInts setofInts = new StaticSETofInts(whiteList);
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (!setofInts.contains(key)) {
				System.out.println(key);
			}
		}
	}
}
