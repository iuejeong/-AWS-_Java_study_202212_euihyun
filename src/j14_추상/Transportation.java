package j14_추상; // 공통된 것을 모아놓은 것

/*
 * 추상 메소드가 하나라도 존재 한다면 추상 클래스로 봐야 함
 * 추상 클래스 자체는 설계도이기 때문에 생성이 불가능함.
 * 
 * 
 */

public abstract class Transportation {

	
	// 추상 메소드
	public abstract void go(); // 구현할 것이 없다.
	
	public abstract void stop();
	
}
