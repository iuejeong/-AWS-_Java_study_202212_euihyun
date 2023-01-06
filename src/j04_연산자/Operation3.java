package j04_연산자;

/*
 * 논리 연산자
 * 
 * AND (곱) T && T, T && F 하나라도 0이면 0 즉, 모든 조건이 부합해야 함
 * 
 * OR (합) T || F하나만 참이어도 참
 * 
 * NOT (부정) !T
 */

public class Operation3 {
	public static void main(String[] args) {
		int num = 10;
		
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = num % 2 > 0;
		
		System.out.println(flag1 && flag2);
		System.out.println(flag1 && flag3);
		System.out.println(!(flag2 || flag3 && flag1));
		
	}
}
