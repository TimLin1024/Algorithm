package fundamental;

import java.util.Scanner;

public class TestNextAndNextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(",");
		System.out.println("请输入你的姓名");
		String name = scanner.next();
		System.out.println("请输入你的年龄");
//		int age = scanner.nextInt();
		String age = scanner.next();
		System.out.println("请输入你的工资");
//		int wage = scanner.nextInt();
		String wage = scanner.next();
		System.out.println("你的信息如下");
		System.out.println("姓名：" + name + "\n年龄" + age + "\n工资" + wage );
	}
}
