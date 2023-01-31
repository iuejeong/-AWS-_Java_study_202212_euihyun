package j24_람다;

public class Lambda1 {
	
	public static void main(String[] args) {
		// new Instrument() {} -> 익명클래스는 독립적으로 존재할 수 있다.
		Instrument instrument = new Instrument() {
			
			@Override
			public String play(String instrument) {
				
				return instrument + "을(를) 연주합니다.";
			}
		}; // 실행이 아니라 구현하는 부분.(정의)
		
		// 람다도 익명클래스와 같이 정의와 생성을 같이한다.
		// 익명클래스는 클래스가 주체, 람다는 메소드가 주체
		// 인터페이스 안에 메소드가 하나만 존재해야 한다. 그래야 그 하나에 집중이 가능하다.
		// 람다는 앞에 대상이 있어야 한다. 혼자서는 못 쓴다.
		// 람다를 쓸 수 있는 인터페이스는 추상메소드가 무조건!! 하나만!! 존재해야한다.(람다를 쓸 수 있는 조건)
		// public String play = ->로 바뀜 그래서 화살표 함수라고도 칭한다.
		// Instrument를 참조 변수로 지정해줌과 동시에 생성
		Instrument instrument2 = (String itm) -> {
			return itm + "을(를) 연주합니다.";
		};
		
		// 매개변수의 자료형을 생략할 수 있다.
		// 이미 인터페이스에서 자료형이 정의가 되어있기 때문에 생략 가능
		// 매개변수의 이름을 바꿀 수 있다.
		Instrument instrument3 = (itm) -> {
			return itm + "을(를) 연주합니다.";
		};
		
		// 매개변수가 하나이면 매개변수를 감싸는 괄호를 생략할 수 있다. (매개 변수가 하나일 때만!, 2개 이상이거나 없으면 X)
		Instrument instrument4 = itm -> {
			return itm + "을(를) 연주합니다.";
		};
		
		// 구현부의 명령이 하나일 때 중괄호를 생략할 수 있다
		// 이때 return 자료형이 정해져있으면 return값으로 사용이 된다.
		// 람다에서 중괄호를 생략했다는 것은 return을 무조건 생략해야 한다. (if문도 실행문이 하나일 때 중괄호 생략 가능)
		// 람다의 장점: 메인메서드 내에 지역 변수를 사용가능하다.
		// 단, 지역 변수로 사용하고 있는 변수명을 매개변수로 사용 불가 ex) 위 itm 자리에 instrument를 쓸 수 없음
		// 람다를 쓰는 이유: 1. 간결함, 2. 메서드를 재정의해서 여러 개 활용 가능, 3. 한 번만 정의해서 쓴다 == 익명클래스
		Instrument instrument5 = itm -> itm + "을(를) 연주합니다.";
		
		int result = 10 + 20;
		
		Instrument instrument6 = itm -> itm + "을(를) 연주합니다." + result;
		
		
		System.out.println(instrument2.play("기타"));
		
		String playText = instrument2.play("드럼");
		System.out.println(playText);
		
		System.out.println(instrument6.play("피아노"));
		
	}

}
