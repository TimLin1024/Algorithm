package fundamental;

//Date API����һ��ʵ��,ռ�ռ�С����������������Լ��ʱ���ṩ��Щֵʱ���ѵ�ʱ�����	
public class BasicDate {
	
	private final int value;

	public BasicDate(int m, int d, int y) {
		value = y * 512 + m * 32 + d;
	}

	public int getMonth() {
		return (value / 32) % 16;
	}

	public int getYear() {
		return value / 512;
	}

	public int getDay() {
		return value % 32;
	}

	@Override
	public String toString() {
		return getMonth() + "/" + getDay() + "/" + getYear();
	}
}
