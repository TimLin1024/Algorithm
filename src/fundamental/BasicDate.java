package fundamental;

//Date API的另一种实现,占空间小，但是向用例按照约定时间提供这些值时花费的时间更多	
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
