package fundamental.bag_stack_queue1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_09 {

	public static void main(String[] args) {
		completeInfixExpr();
	}

	public static void completeInfixExpr() {
		Stack<String> ops = new Stack<>();
		Stack<String> vals = new Stack<>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("(")) {

			} else if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*") || s.equals("sqrt")) {
				ops.push(s);
			} else if (s.equals(")")) {
				String op = ops.pop();
				String val = vals.pop();
				if (op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*")) {
					val = String.format("( %s %s %s )", vals.pop(), op, val);
				} else if (s.equals("sqrt")) {
					val = String.format("(sqrt %s )", val);
				}
				vals.push(val);
			} else {
				vals.push(s);
			}
		}
		StdOut.println(vals.pop());
	}
}
