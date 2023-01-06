package j05_입력;

import java.util.Scanner;

public class input4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		
		int max = 0;
		int min = 0;
		
		System.out.println("정수 3개 입력: ");
		a = scanner.nextInt();		
		b = scanner.nextInt();		
		c = scanner.nextInt();		

		max = a; 
		max = b > max ? b : max;
		max = c > max ? c : max;
		
		min = a;
		min = b < max ? b : max;
		min = c < max ? c : max;
	
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
		
		
		
	}
}