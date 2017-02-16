package fundamental.base_model1_1;

public class Ex1_1_24Euclid {
		
	public static int gcd(int p, int q) {
		return gcd(p, q, 1);
	}
	
	public static int gcd(int p, int q,int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print(" ");
		}
		System.out.println("p:" + p + ",q:" + q);
		if (q == 0) {
			return p;
		}
		int r = p % q;
		return gcd(q, r, ++depth);
	}

	public static void main(String[] args) {
		gcd(1111111, 1234567);
	}
}