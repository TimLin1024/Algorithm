package fundamental;

import java.util.Arrays;

/*
 * �ҳ������к�Ϊ0�������� ����Ŀ
 * ����������û���ظ���Ԫ��
 * */
public class TwoSumFast {
	/*
	 * ������ص�j>i��
	 * ������ص� j��С��i����1�� �������Ӽ�������ֵ�������ظ�����*/
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
