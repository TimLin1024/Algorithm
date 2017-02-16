package fundamental.algorithm_analysis1_4;

import java.util.Arrays;

import fundamental.base_model1_1.BinarySearch;

/*
 * 找出数组中和为0的整数对 的数目
 * 假设数组中没有重复的元素
 * */
public class TwoSumFast {
	/*
	 * 如果返回的j>i，
	 * 如果返回的 j，小于i大于1， 不能增加计数器的值，以免重复计数*/
	public static int count(int[] a) {
		int cnt = 0;
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			if (BinarySearch.rank(a, -a[i]) > i) {
				cnt++;
			}
		}
		return cnt;
	}
}
