

import java.util.Stack;


public class Evaluate {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<>();
		Stack<Double> vals = new Stack<>();
		while (!StdIn.isEmpty()) {
			//��ȡ�ַ�����������������ջ
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
			}else if (s.equals(")")) {//����ַ�Ϊ������������������Ͳ���������������ѹ��ջ
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
