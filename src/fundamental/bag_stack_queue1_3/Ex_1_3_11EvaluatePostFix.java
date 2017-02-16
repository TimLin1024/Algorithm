package fundamental.bag_stack_queue1_3;

import java.util.Scanner;

public class Ex_1_3_11EvaluatePostFix {

	public static void main(String[] args) {
		Stack<String> ops = new Stack<>();
		Stack<String> vals = new Stack<>();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			if (s.equals("+")) {
				s = Double.valueOf(vals.pop()) + Double.valueOf(vals.pop()) + "";
				vals.push(s);
			} else if (s.equals("-")) {
				double vTop = Double.valueOf(vals.pop());
				s = Double.valueOf(vals.pop()) - vTop + "";
				vals.push(s);
			} else if (s.equals("*")) {
				s = Double.valueOf(vals.pop()) * Double.valueOf(vals.pop())
						+ "";
				vals.push(s);
			} else if (s.equals("/")) {
				double vTop = Double.valueOf(vals.pop());
				s = Double.valueOf(vals.pop()) / vTop + "";
				vals.push(s);
			} else if (s.equals("sqrt")) {
				s = Math.sqrt(Double.valueOf(vals.pop())) + "";
				vals.push(s);
			} else {
				vals.push(s);
			}
		}
		if (!vals.isEmpty()) {
			System.out.println(vals.pop());
		}
	}
}
