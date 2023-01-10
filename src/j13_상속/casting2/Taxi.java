package j13_상속.casting2;

public class Taxi extends Transportation {
	
	@Override // @시작하는 문법을 어노테이션이라 한다. -> 재정의됐다는 표시용임.
	public void go() {
		System.out.println("택시를 타고 출발");
	}

	@Override
	public void stop() {
		System.out.println("택시를 타고 도착");
	}
	
	public void chekTaxiNumber() {
		System.out.println("택시 번호 확인");
	}
	
}
