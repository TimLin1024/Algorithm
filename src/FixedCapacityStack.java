
public class FixedCapacityStack<Item> {
	Item[] a;
	int N;
	
	public FixedCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
	}
	
	public void push(Item item){
		if (N == a.length) {
			resize(2*a.length);
		}
		a[N++] = item;
	}
	
	public Item pop(){
		Item item = a[--N];
		a[N] = null;//避免对象游离，致为null使其能被回收 （前面--N使得现在的N=原来的的栈顶元素）
		if (N > 0 && N == a.length/4) {
			resize(a.length/2);
		}
		return item;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void resize(int max) {
//		Item[] tmp = a;
//		a = (Item[])new Object[max];
//		for (int i = 0; i < tmp.length; i++) {
//			a[i] = tmp[i];
//		}
//		将大小为N< = max的栈移动到另一个大小不同的数组中
		
		Item[] tmp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			tmp[i] = a[i];
		}
		a = tmp;
	}
	
}
