package fundamental;

public class Ex_1_3_15_KQueue {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();
		int i = 0;
		while(i <= 28){
			queue.enqueue(i+"");
			i++;
		}
//		i = queue.size();
		while (queue.size() != Integer.valueOf(args[0])) {
//			i--;
			queue.dequeue();
		}
		System.out.println(queue.dequeue());
	}
}
