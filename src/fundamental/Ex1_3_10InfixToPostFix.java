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
				ops.push(s);// �������������ջ
			} else if (s.equals(")")) {
				// ���������žͽ���ֵ �� �������ֱ� ��ջ
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
			}else {// ����+ - / * sqrt ������ֵջ
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
//		//���������ɺ��� ctrl + z ��ô,�ᵼ�¶�ȡ��������;
//		//�������enter���������ж�ȡ�����ǻ������ѭ����
//		//�Ȱ���enterȻ�����ctrl + z���Ϳ��Գɹ���ȡ�����˳�ѭ��
//		while (!StdIn.isEmpty()) {
//			String s = StdIn.readString();
//			if (s.equals("(")) {
//			} else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
//				ops.push(s);// �������������ջ
//			} else if (s.equals(")")) {
//				// ���������žͽ���ֵ �� �������ֱ� ��ջ
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
//			}else {// ����+ - / * sqrt ������ֵջ
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
