package j15_인터페이스;
// implements = 도구 -> 해당 클래스에 인터페이스를 쓰겠다
// extends는 하나의 클래스에서만 사용 가능하지만 implements는 , , , 찍으면서 여러 개를 사용 가능. 관계성이 중요함
public class GeneralCalculator extends Equipment implements Calculator {

	@Override
	public void powerOn() {
		System.out.println("일반 계산기 전원을 켭니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("일반 계산기 전원을 끕니다.");
	}

	@Override
	public double plus(double x, double y) {
		System.out.println("일반 계산기에서 더하기 실행");
		return x + y;
	}

	@Override
	public double minus(double x, double y) {
		System.out.println("일반 계산기에서 빼기 실행");
		return x - y;
	}

	@Override
	public double division(double x, double y) {
		
		if(x == 0 || y == 0) {
			return ERROR;
		}
		
		return x / y;
	}
	
	
	
}
