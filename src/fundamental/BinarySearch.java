package fundamental;

import javax.sound.midi.MidiChannel;

public class BinarySearch {
	// ������ Ҫ��low��high���涨��Χ
	// public static int rank(int[] a,int num) {
	// int mid = a.length / 2;
	// while (mid >= 0) {
	// if (a[mid] > num) {
	// mid = (mid + a.length) / 2;
	// }else if (a[mid] < num) {
	// mid = mid / 2;
	// }else {
	// return mid;
	// }
	// }
	// return -1;
	// }

	public static int rank(int[] a, int num) {
		int low = 0;
		int high = a.length - 1;
		int mid = (low + high) / 2;
		while (low <= high) {
			if (a[mid] > num) {
				high = mid - 1;
			} else if (a[mid] < num) {
				low = mid + 1;
			} else {
				return mid;
			}
			mid = (low + high) / 2;
		}
		return -1;
	}

	public static int rankMinIndex(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		int mid = (low + high) / 2;
		while (low <= high) {
			if (a[mid] > key) {
				high = mid - 1;
			} else if (a[mid] < key) {
				low = mid + 1;
			} else {
				//˳�򲻿ɵߵ�����Ȼmid-1����Խ��
				while (mid > 0 && key == a[mid - 1] ) {
					--mid;
				}
				return mid;
			}
			mid = (low + high) / 2;
		}
		return -1;
	}

	public static int recurseBinarySearch(int[] a, int low, int high, int key) {
		if (low < high) {
			int mid = (low + high) / 2;
			if (key < a[mid]) {
				return recurseBinarySearch(a, low, mid - 1, key);
			} else if (key > a[mid]) {
				return recurseBinarySearch(a, mid + 1, high, key);
			} else {
				return mid;
			}
		} else {
			return -1;
		}
	}

	// ����ĵݹ�Ҫдreturn�������ڡ��������������ȥ���� ��
	// public static int traverseBinarySearch(int[] a, int low, int high, int
	// key) {
	// if (low < high) {
	// int mid = (low + high) / 2;
	// if (key < a[mid]) {
	// traverseBinarySearch(a, low, mid - 1, key); //δ��return�ᱨ��
	// } else if (key > a[mid]) {
	// traverseBinarySearch(a, mid + 1, high, key); //δ��return�ᱨ��
	// } else {
	// return mid;
	// }
	// } else {
	// return -1;
	// }
	// }
}
