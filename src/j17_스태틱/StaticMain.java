package j17_스태틱;
// static은 공유의 영역이다.
// 생성하지 않아도 클래스명.변수명 = 값; 가능
public class StaticMain {
	
	public static void main(String[] args) {
		
		System.out.println("출력1: " + TestA.getNum());
		System.out.println();
		
		TestA.setNum(100);
		System.out.println("출력2: " + TestA.getNum());
	}

}
