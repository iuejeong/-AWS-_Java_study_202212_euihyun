package j05_입력;

import java.util.Scanner;

public class input1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] nums = new int[5];
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print("입력" + (i + 1) + ": ");
			if (scanner.hasNextInt()) {
				nums[i] = scanner.nextInt();
				sum += nums[i];
			} else {
				System.out.println("Invalid input, please enter an integer.");
				scanner.next();
				i--;
			}
		}
		System.out.println("입력값: " + sum);
	}
}