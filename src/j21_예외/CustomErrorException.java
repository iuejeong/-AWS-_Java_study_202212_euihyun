package j21_예외;

public class CustomErrorException extends RuntimeException { // 보통은 RuntimeException을 상속 받는다

	public CustomErrorException() {
		System.out.println("내가 만든 예외 생성");
	}
	// 모든 예외의 최상위는 Throwable이다.
	public CustomErrorException(String message) {
		super(message);
	}
	
}
