package j21_예외;
// 프로그램의 오류를 예외라고 한다.
public class ArrayException {

	public static void main(String[] args) {
		
		Integer[] nums = {1, 2, 3, 4, 5};
		// try가 예외를 주고 catch가 처리한다.
		try {
			throw new NullPointerException(); // 강제로 예외 발생
//			for(int i = 0; i < 6; i++) {
//				System.out.println(nums[i]);
//			} // 하위 객체부터 예외 검사
	}	catch (IndexOutOfBoundsException e) {
			System.out.println("예외 처리함");
			
	}	catch (NullPointerException e ) { // 주소 참조를 하는데 대상이 null이다
		System.out.println("빈값 처리함");
		
	}	catch (Exception e) { // Exception은 최종적으로 걸리는 예외 처리이다.
		System.out.println("예상 못한 예외 처리함");
		
}

		System.out.println("프로그램 정상 종료");
		
	}
	
}
