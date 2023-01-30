package j22_익명클래스;

public class Main {

	public static void main(String[] args) {
		// 인터페이스 클래스는 생성을 못한다.
		// 그래서 다른 클래스에서 재정의를 해준 후에 그 클래스를 생성해서 쓴다.
		
		Calculator c1 = new Addition();
		
		System.out.println(c1.calc(10, 20));
		
		
		// 구현된 클래스, 이 클래스의 이름이 없기 때문에 익명클래스라 한다. 무명 클래스 or 어나니머스 클래스라고도 한다.
		// 인터페이스 클래스여서 생성을 못한다. 그래서 이름을 없애겠다.
		// 딱 한 번만 쓸 수 있는 임시 클래스
		Calculator c2 = new Calculator() { // 한 번만 쓸 경우에는 굳이 생성해서 쓸 필요가 없다. 낭비다.
			
			@Override // 임시로 구현
			public int calc(int x, int y) { // 여기서만 정의해서 쓰는 1회성이기에 다른 곳에서는 못 쓴다
				return x - y;
			}
		};
		System.out.println(c2.calc(200, 100));
		
		Calculator c3 = (x, y) -> x * y; // 위 익명 클래스를 한 줄로 줄인 것, 생성부터 정의까지 나타냈는데 이것을 "람다"라고한다
		System.out.println(c3.calc(20, 3));
	}

}
