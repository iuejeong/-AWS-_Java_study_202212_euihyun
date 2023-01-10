package j15_인터페이스;

public class Main {

	public static void main(String[] args) {
		
		Equipment[] equipments = new Equipment[2];
		
		equipments[0] = new GeneralCalculator();
		equipments[1] = new SmartPhone();
		
		Calculator calculator = new Computer();
		
		System.out.println("모든 장비 전원 켜기");
		for(Equipment eq : equipments) {
			eq.powerOn();
		}
		System.out.println();
		
		System.out.println("모든 장비에서 10과 0을 나누기"); // 숫자에 계산이 들어가면 double로 선언함
		for(Equipment eq : equipments) {
			Calculator c = (Calculator) eq;
			double result = c.division(10, 2);
			System.out.println("결과: " + result);
		}
		System.out.println();
		
		System.out.println("모든 장비 전원 끄기");
		for(Equipment eq : equipments) {
			eq.powerOff();
		}
		System.out.println();
		
	}
	
}

/*
 * 문제점
 * 1. 왜 Equipment 배열인가
 * 답변 :
 * 
 * 2. Calculator변수에 Computer가 왜 생성이 되어있는가, Computer클래스는 무슨 역할을 하는가
 * 답변 :
 * 
 * 3. for each의 자세한 개념
 * 답변 :
 * 
 * 4. for each문에 들어간 Equipment
 * 답변 :
 * 
 * 5. Calculator로의 형변환이 일어난 이유
 * 답변 :
 * 
 * 6. 추상 클래스와 메소드는 정확히 무슨 역할을 하는가
 * 답변 :
 * 
 * 7. interface, abstract, implements는 언제 쓰는 것인가, 각각 무슨 차이가 있는가
 * 답변 :
 * 
 */



