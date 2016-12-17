
public class Parentheses {
	//Stack�Ĳ�������Partenteses���ӱ�׼���ж�ȡһ���ı�����ʹ��ջ�ж����е������Ƿ�ƥ������
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
	        
	        for (int i = 0; i < n; i++)
	        {
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
	        String s = StdIn.readAll().trim();
	        
	        StdOut.println(isBalanced(s));
	    }

}
