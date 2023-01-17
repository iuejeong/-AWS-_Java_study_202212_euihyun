package j21_예외;

import java.util.Arrays;
import java.util.List;

public class ThrowsException {
	
	public static void printList(List<String> list, int size) throws Exception { // throws는 예외를 미룬다는 의미, throw는 강제적으로 예외를 실행
		
		for(int i = 0; i < size; i++) {
			System.out.println("[" + i + "]" + list.get(i));
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		
		String[] names = {"김수현", "이종현", "박성진", "김동민"};
		
		try {
			printList(Arrays.asList(names), 5);
		} catch (Exception e) {
			e.printStackTrace(); // 이 친구가 있어야 어디서 예외가 발생했는지 알 수 있음. 중요함!
		} finally { // 예외가 터져도 실행이 되고, 안 터져도 무조건 실행이 된다. but 프로그램이 꺼지는 건 막을 수는 없다.
			System.out.println("무조건 실행");
		}
		
		System.out.println("프로그램 정상 종료");
		
	}

}












