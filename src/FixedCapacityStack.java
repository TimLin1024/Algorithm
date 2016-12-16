
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
		a[N] = null;//����������룬��Ϊnullʹ���ܱ����� ��ǰ��--Nʹ�����ڵ�N=ԭ���ĵ�ջ��Ԫ�أ�
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
//		����СΪN< = max��ջ�ƶ�����һ����С��ͬ��������
		
		Item[] tmp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			tmp[i] = a[i];
		}
		a = tmp;
	}
	
}
