package fundamental;

import javax.xml.bind.ValidationEvent;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import lib.StdIn;
import lib.StdOut;

public class Ex_1_3_09 {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();

		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();

			if (s.equals("("))
				;
			else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt"))
				ops.push(s);
			else if (s.equals(")")) {
				String op = ops.pop();
				String v = vals.pop();

				if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))
					v = String.format("( %s %s %s )", vals.pop(), op, v);
				else if (op.equals("sqrt"))
					v = String.format("( %s %s )", op, v);

				vals.push(v);
			} else
				vals.push(s);
			// else vals.push(((Double)Double.parseDouble(s)).toString());
		}
		System.out.println("vals.isEmpty()" + vals.isEmpty());
		System.out.println(vals.pop());
		// StdOut.println();
	}

	// public static void main(String[] args) {
	// completeInfixExpr();
	// }
	public static void completeInfixExpr() {
		Stack<String> ops = new Stack<>();
		Stack<String> vals = new Stack<>();
		// ops.push("+");
		// vals.push("67");
		// vals.push("8u9");
		while (!StdIn.isEmpty()) {
			System.out.println("StdIn is not empty() ");
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
			} else {
				vals.push(s);
			}
		}
		StdOut.println(vals.pop());

	}

}
