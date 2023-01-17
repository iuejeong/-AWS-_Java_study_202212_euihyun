package j22_익명클래스;

public class Main {

	public static void main(String[] args) {
		
		Calculator c1 = new Addition();
		
		System.out.println(c1.calc(10, 20));
		
		
		// 구현된 클래스, 이 클래스의 이름이 없기 때문에 익명클래스라 한다. 무명 클래스 or 어나니머스 클래스라고도 한다.
		Calculator c2 = new Calculator() { // 한 번만 쓸 경우에는 굳이 생성해서 쓸 필요가 없다. 낭비다.
			
			@Override // 임시로 구현
			public int calc(int x, int y) { // 여기서만 정의해서 쓰는 1회성이기에 다른 곳에서는 못 쓴다
				return x - y;
			}
		};
		System.out.println(c2.calc(200, 100));
	}

}
