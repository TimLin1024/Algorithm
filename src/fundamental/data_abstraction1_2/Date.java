package fundamental.data_abstraction1_2;
//��Basic��ȣ����ռ�ʡʱ��
public class Date {
	private final int mon;
	private final int year;
	private final int day;

	public Date(int m, int d, int y) {
		mon = m;
		day = d;
		year = y;
	}

	public int getMonth() {
		return mon;
	}

	public int getYear() {
		return year;
	}

	public int getDay() {
		return day;
	}
	
	@Override
	public boolean equals(Object obj) {
		//���������ͬ��ֱ�ӷ���true ����Ҫ�������Թ���
		if (this == obj) {
			return true;
		}
		//����Ϊ��ֱ�ӷ���false
		if (obj == null) {
			return false;
		}
		//����������಻ͬ
		if (obj.getClass() != this.getClass()) {
			return false;
		}
//		//����û��ô�ã�����ֱ��getClass�ȽϺ�
//		if (!(obj instanceof Date)) {
//			return false;
//		}
		//ǿ������
		Date that = (Date)obj;
		if (that.day != day) {
			return false;
		}
		if (that.year != year) {
			return false;
		}
		if (that.mon != mon) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getMonth() + "/" + getDay() + "/" + getYear();
	}
}
