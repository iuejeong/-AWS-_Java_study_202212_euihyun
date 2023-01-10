package j15_인터페이스;
// 기본적으로 abstract를 넣지 않아도 인터페이스는 abstract를 생략한다.
// 구현하는, 생성하는 용도가 아니다.
// 일반 메소드를 쓸 수 없다.
// 일반 변수를 가질 수 없다. 즉 멤버 변수를 못 가진다. 하지만 상수는 가질 수 있다.
public interface Calculator {
	
	public int ERROR = -9999999; // 이처럼 상수도 생략 가능.

	public double plus(double x, double y); // {} 구현객체를 쓸 수 없다.
	
	public double minus(double x, double y);
	
	public default double multiplication(double x, double y) { // 일반 메소드를 쓰고 싶다면 default를 써야 한다.
		return x * y;
	}
	
	public double division(double x, double y);
	
}
