package fundamental.bag_stack_queue1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//Stack�Ĳ�������Partenteses���ӱ�׼���ж�ȡһ���ı�����ʹ��ջ�ж����е������Ƿ�ƥ������
public class Ex1_3_4Parentheses {
//	public static void main(String[] args) {
//		Stack<String> stack = new Stack<>();
//		while (!StdIn.isEmpty()) {
//			String item = StdIn.readString();
//			if (item.equals("{")) {
//				stack.push(item);
//			}else if (item.equals("[")) {
//				stack.push(item);
//			}else if (item.equals("(")) {
//				stack.push(item);
//			}else if(item.equals("]")){
//				if (stack.pop().equals("[")) {
//					StdOut.println("true");
//				}else{
//					StdOut.println("false");
//				}
//			}else if (item.equals(")")) {
//				if (stack.pop().equals("(")) {
//					StdOut.println("true");
//				}else{
//					StdOut.println("false");
//				}
//			}else if(item.equals("}")) {
//				if (stack.pop().equals("{")) {
//					StdOut.println("true");
//				}else{
//					StdOut.println("false");
//				}
//			}
//		}
//		StdOut.print("finish judge");
//	}
	  public static boolean isBalanced(String s)
	    {
	        Stack<Character> open = new Stack<Character>();
	        int n = s.length();
	        
	        for (int i = 0; i < n; i++){
	            //c ��������ж��֣�����" ", ����ֻ�����Ž��д���
	        	char c = s.charAt(i);
	            
	            if (c == '(' || c == '[' || c == '{')
	                open.push(c);
	            //˼����ÿ�ζ�ƥ�������д����������һ��ƥ����˵��ȫ���ˡ�
	            //ѧϰ ���¼��ı����ӿ����� �����¼�
	            else if ((c == ')' && (open.isEmpty() || open.pop() != '(')) ||
	                     (c == ']' && (open.isEmpty() || open.pop() != '[')) ||
	                     (c == '}' && (open.isEmpty() || open.pop() != '{')))
	                return false;
	        }
	        
	        return open.isEmpty();
	    }
	    
	    public static void main(String[] args)
	    {
	        String s = StdIn.readAll().trim();//ȥ����β�ַ���
//	        StdOut.println(isBalanced(s));
	        StdOut.println(isMatched(s));
	    }
	    public static boolean isMatched(String s) {
	    	s = s.trim();
	    	Stack<Character> stack = new Stack<>();
	    	for(int i=0; i<s.length(); i++){
	    		char c = s.charAt(i);
	    		if (c == '(' || c == '[' || c == '{') {
					stack.push(c);
				}else if(  (c == ')' && stack.isEmpty() || stack.pop() != '(')
						|| (c == ']' && stack.isEmpty() || stack.pop() != '[')
						|| (c == '}' && stack.isEmpty() || stack.pop() != '{')){
					return false;
				}
	    	}
	    	return stack.isEmpty();
	    }

}
