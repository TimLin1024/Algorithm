package fundamental.data_abstraction1_2;
//与Basic相比，花空间省时间
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
		//如果引用相同，直接返回true 不需要其他测试工作
		if (this == obj) {
			return true;
		}
		//对象为空直接返回false
		if (obj == null) {
			return false;
		}
		//两个对象的类不同
		if (obj.getClass() != this.getClass()) {
			return false;
		}
//		//书上没这么用，还是直接getClass比较好
//		if (!(obj instanceof Date)) {
//			return false;
//		}
		//强制类型
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
