package j26_스레드;

public class ThreadTest {

	public static void main(String[] args) {
		
		LoopThread loopThread1 = new LoopThread("김상현");
		LoopThread loopThread2 = new LoopThread("강대협");
		LoopThread loopThread3 = new LoopThread("손지호");
		LoopThread loopThread4 = new LoopThread("김재영");
		
		
		System.out.println(loopThread1.getPriority());	// 우선순위 셋팅, 우선순위가 전부 동일하다는 결과
		System.out.println(loopThread2.getPriority());	// 스레드는 숫자가 클수록 우선순위가 높다.
		System.out.println(loopThread3.getPriority());
		System.out.println(loopThread4.getPriority());
		
		loopThread1.start();		// start 메소드 안에 run 메소드가 있다.
		loopThread2.start();
		loopThread3.start();
		loopThread4.start();
		
		
	}
	
}
