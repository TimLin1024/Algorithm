package fundamental;

import java.util.Scanner;

public class TestNextAndNextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(",");
		System.out.println("�������������");
		String name = scanner.next();
		System.out.println("�������������");
//		int age = scanner.nextInt();
		String age = scanner.next();
		System.out.println("��������Ĺ���");
//		int wage = scanner.nextInt();
		String wage = scanner.next();
		System.out.println("�����Ϣ����");
		System.out.println("������" + name + "\n����" + age + "\n����" + wage );
	}
}
