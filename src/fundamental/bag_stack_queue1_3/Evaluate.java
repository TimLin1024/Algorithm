package fundamental.bag_stack_queue1_3;


import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
//Dijkstra的双栈算术表达式求值算法

//假设表达式没有省略任何括号，数字和字符均以空白字符相隔
public class Evaluate {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<>();
		Stack<Double> vals = new Stack<>();
		while (!StdIn.isEmpty()) {
			//读取字符，如果是运算符就入栈
			String s = StdIn.readString();
			if(s.equals("("));
			else if (s.equals("+")) {
				ops.push(s);
			}else if (s.equals("-")) {
				ops.push(s);
			}else if (s.equals("*")) {
				ops.push(s);
			}else if (s.equals("/")){
				ops.push(s);
			}else if (s.equals("sqrt")) {
				ops.push(s);
			}else if (s.equals(")")) {
				//如果字符为“）”，弹出运算符和操作数，计算结果并压入栈
				String operator = ops.pop();
				double val = vals.pop();
				if (operator.equals("+")) {
					val = vals.pop() + val;
				}else if (operator.equals("-")) {
					val = vals.pop() - val;
				}else if (operator.equals("*")) {
					val = vals.pop() * val;
				}else if (operator.equals("/")) {
					val = vals.pop() / val;
				}else if (operator.equals("sqrt")) {
					val = Math.sqrt(val);
				}
				vals.push(val);
			}else {
				vals.push(Double.parseDouble(s));
			}
		}
		StdOut.println(vals.pop());
	}
}
