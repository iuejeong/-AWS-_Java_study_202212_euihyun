package j05_입력;

import java.util.Scanner;

public class input2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("문자열1: ");
		String str1 = scanner.nextLine(); // 띄어쓰기 허용
		
		System.out.print("문자열2: ");
		String str2 = scanner.next(); // 띄어쓰기 와 엔터가 동일하게 생각함. 그래서 띄어쓰기 허용 불가
		
		System.out.println("정수: ");
		int number1 = scanner.nextInt();
		
		System.out.println("실수: ");
		double number2 = scanner.nextDouble();
		
		System.out.println("사용자 문자열1: " + str1);
		System.out.println("문자열2: " + str2);
		System.out.println("정수: " + number1);
		System.out.println("실수: " + number2);
		
	}
}