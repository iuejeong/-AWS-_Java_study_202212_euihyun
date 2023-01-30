package j12_배열.di;

public class Test_A {
	
	private final Test_B tb; // 무조건 한 번은 초기화가 일어나야 함.
	
	public Test_A(Test_B tb) {
		this.tb = tb; 
	// Test_B tb = new Test_A -> 테스트B는 테스트A를 의존하고 있다 -> Dependency 즉, 의존성이 높다 == 결합도가 높다
	}
	
//	public void setTb(Test_B tb) {
//		this.tb = tb;
//	}
	
	public void testA1() {
		System.out.println("테스트A1 메소드 호출!!");
//		Test_B tb = new Test_B();
		
		tb.testB1();
	}
	
	public void testA2() {
		System.out.println("테스트A2 메소드 호출!!");
//		Test_B tb = new Test_B();
		
		tb.testB1();
			
	}
	

}
