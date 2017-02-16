package fundamental.bag_stack_queue1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//Stack的测试用例Partenteses，从标准流中读取一个文本流并使用栈判断其中的括号是否匹配完整
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
	            //c 可能情况有多种，例如" ", 但是只对括号进行处理
	        	char c = s.charAt(i);
	            
	            if (c == '(' || c == '[' || c == '{')
	                open.push(c);
	            //思想是每次对匹配错误进行处理，如果，有一个匹配错就说明全错了。
	            //学习 ：事件的本身复杂考虑其 对立事件
	            else if ((c == ')' && (open.isEmpty() || open.pop() != '(')) ||
	                     (c == ']' && (open.isEmpty() || open.pop() != '[')) ||
	                     (c == '}' && (open.isEmpty() || open.pop() != '{')))
	                return false;
	        }
	        
	        return open.isEmpty();
	    }
	    
	    public static void main(String[] args)
	    {
	        String s = StdIn.readAll().trim();//去掉首尾字符串
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
