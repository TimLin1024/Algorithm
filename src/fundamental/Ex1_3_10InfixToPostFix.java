package fundamental;

import java.util.Scanner;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex1_3_10InfixToPostFix {
	
	public static void readWithScanner() {
		Stack<String> ops = new Stack<>();
		Stack<String> vals = new Stack<>();
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
//			String s = scanner.next();
			String s = scanner.nextLine();
			if (s.equals("(")) {
			} else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
				ops.push(s);// 操作符入操作符栈
			} else if (s.equals(")")) {
				// 遇到右括号就将数值 和 操作符分别 出栈
				String op = ops.pop();
				String val = vals.pop();
				if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
					val = String.format("%s %s %s", vals.pop(), val, op);
				} else if (op.equals("sqrt")) {
					val = String.format("%s %s", val, op);
				}
				vals.push(val);
			} else if (s.equals("z")) {
				break;
			}else {// 不是+ - / * sqrt 就入数值栈
				vals.push(s);
			}
		}
		
		System.out.println("vals.isEmpty(): " + vals.isEmpty());
		if (!vals.isEmpty()) {
			StdOut.println(vals.pop());
		}
	}
	
	public static void main(String[] args) {
		readWithScanner();
	}
//		Stack<String> ops = new Stack<>();
//		Stack<String> vals = new Stack<>();
//		//如果输入完成后按下 ctrl + z 那么,会导致读取不到东西;
//		//如果按下enter键，则会进行读取，但是会进入死循环。
//		//先按下enter然后进行ctrl + z，就可以成功读取并且退出循环
//		while (!StdIn.isEmpty()) {
//			String s = StdIn.readString();
//			if (s.equals("(")) {
//			} else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
//				ops.push(s);// 操作符入操作符栈
//			} else if (s.equals(")")) {
//				// 遇到右括号就将数值 和 操作符分别 出栈
//				String op = ops.pop();
//				String val = vals.pop();
//				if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
//					val = String.format("%s %s %s", vals.pop(), val, op);
//				} else if (op.equals("sqrt")) {
//					val = String.format("%s %s", val, op);
//				}
//				vals.push(val);
//			} else if (s.equals("z")) {
//				break;
//			}else {// 不是+ - / * sqrt 就入数值栈
//				vals.push(s);
//			}
//		}
//		
//		System.out.println("vals.isEmpty(): " + vals.isEmpty());
//		if (!vals.isEmpty()) {
//			StdOut.println(vals.pop());
//		}
//		
//	}

}
