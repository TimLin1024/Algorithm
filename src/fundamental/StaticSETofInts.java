package fundamental;

import java.util.Arrays;

public class StaticSETofInts {
	private int[] a;
	public StaticSETofInts(int[] keys) {
		for (int i = 0; i < keys.length; i++) {
			a[i] = keys[i];//保护性复制
		}
		Arrays.sort(a);
	}
	public boolean contains(int key) {
		return rank(key) != -1;
	}
	//找出给定键出现的次数
	public int hasMany(int key) {
	int cnt = 0;
		int pos = rank(key);
		if (pos != -1) {
			//右边重复情况
			while (pos < a.length-1 && a[pos+1] == key) {
				pos++;
				cnt++;
			}
			//左边重复情况
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
			//键要么存在于a[lo..high],要么不存在
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
}
