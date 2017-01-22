package sorting;

public class MergeBU {
	private static Comparable[] aux;//�鲢����ĸ�������
	public static void sort(Comparable[] a) {

		
		//����logN�������鲢
		int N = a.length;
		aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz + sz) {//sz������Ĵ�С
			for (int lo = 0; lo < N - sz; lo += sz+sz) {//lo:�����������
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1,N-1));
			}
		}
	}
	// ԭ�ع鲢�����漰������Ԫ�ظ��Ƶ�һ�����������У��ٰѹ鲢�Ľ���Ż�ԭ������
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;

		for (int k = lo; k <= hi; k++) {// ע����lo �� hi ������a.length
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) { // ��벿���Ѿ���Խ�硱��,����벿���Ѿ��þ�
				a[k] = aux[j++];
			} else if (j > hi) {// �Ұ벿���Ѿ���Խ�硱��,���Ұ벿���Ѿ��þ�
				a[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
//			if (i > mid) { // ��벿���Ѿ���Խ�硱��,����벿���Ѿ��þ�
//				a[k] = aux[j];
//				j++;
//			} else if (j > hi) {// �Ұ벿���Ѿ���Խ�硱��,���Ұ벿���Ѿ��þ�
//				a[k] = aux[i];
//				i++;
//			} else if (less(a[i], a[j])) {
//				a[k] = aux[i];
//				i++;
//			} else {
//				a[k] = aux[j];
//				j++;
//			}
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	
}
