package fundamental.algorithm_analysis1_4;

public class Ex1_4_15 {
	// 使用一个线性级别的算法（而非基于二分查找的线性对数级别的算法）
	// 计算已排序的数组中和为0的整数对的数量
	public static int twoSumZero(int[] a) {
		int cnt = 0;
		int pos = 0;// 第一个正数
		int neg = 0;
		// 找出第一个正数的位置
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				pos = i;
				break;
			}
		}
		if (a[pos] <= 0) {
			return -1;
		}
		neg = pos - 1;
		while (pos < a.length && neg > 0) {
			if (a[pos] + a[neg] < 0) {// 和小于零，说明正数小了
				pos++;
			} else if (a[pos] + a[neg] > 0) {// 和大于0，说明负数不够小
				neg--;
			} else {//和为0，可能有多组，用到组合思想。
				int samePos = 0;
				int sameNeg = 0;
				int tmp = a[pos];
				//找出与某正数 相等的数字个数
				// 其中的pos++不能写到a[pos++]中——因为循环会多加一次，第一次肯定相等，第二次不管等不等还是会执行。
				while (pos<a.length && a[pos]== tmp) {
					pos++;
					samePos++;
				}
				tmp = a[neg];
				while (neg >= 0 && a[neg] == tmp) {
					neg--;
					sameNeg++;
				}
				cnt = cnt + sameNeg * samePos;
			}
		}
		return cnt;
	}
	   /*A+B=k问题---由于已排序,所以 k-A(1)=B(1) > k-A(2)=B(2)
     * 因此可以建立first和last分别指向首和尾
     * 以下方式不包括重复情况
     * */
	public static int twoSumFasterK(int[] a, int k) {
		int cnt = 0;
		int first = 0;
		int last = a.length - 1;
		while (first < last) {
			if (a[first] + a[last] < k ) {
				first++;
			}else if (a[first] + a[last] > k) {
				last--;
			}else {
				cnt++;
				while (first<last && a[first] == a[++first]);
				while (first<last && a[last] == a[--last]);
			}
		}
		return cnt;
	}
	/*
	 * A+B+C=0   借鉴twoSumFaster.  B+C=-A便可  即令k=-A带入
     * */
	public static int threeSumFaster (int[] a) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			cnt += twoSumFasterK(a, -a[i]);
		}
		return cnt;
	}
}
