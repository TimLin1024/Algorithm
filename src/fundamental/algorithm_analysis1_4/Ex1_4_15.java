package fundamental.algorithm_analysis1_4;

public class Ex1_4_15 {
	// ʹ��һ�����Լ�����㷨�����ǻ��ڶ��ֲ��ҵ����Զ���������㷨��
	// ����������������к�Ϊ0�������Ե�����
	public static int twoSumZero(int[] a) {
		int cnt = 0;
		int pos = 0;// ��һ������
		int neg = 0;
		// �ҳ���һ��������λ��
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
			if (a[pos] + a[neg] < 0) {// ��С���㣬˵������С��
				pos++;
			} else if (a[pos] + a[neg] > 0) {// �ʹ���0��˵����������С
				neg--;
			} else {//��Ϊ0�������ж��飬�õ����˼�롣
				int samePos = 0;
				int sameNeg = 0;
				int tmp = a[pos];
				//�ҳ���ĳ���� ��ȵ����ָ���
				// ���е�pos++����д��a[pos++]�С�����Ϊѭ������һ�Σ���һ�ο϶���ȣ��ڶ��β��ܵȲ��Ȼ��ǻ�ִ�С�
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
	   /*A+B=k����---����������,���� k-A(1)=B(1) > k-A(2)=B(2)
     * ��˿��Խ���first��last�ֱ�ָ���׺�β
     * ���·�ʽ�������ظ����
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
	 * A+B+C=0   ���twoSumFaster.  B+C=-A���  ����k=-A����
     * */
	public static int threeSumFaster (int[] a) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			cnt += twoSumFasterK(a, -a[i]);
		}
		return cnt;
	}
}
