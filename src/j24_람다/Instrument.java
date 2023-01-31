package j24_람다;

@FunctionalInterface // 람다를 의미. 메소드 2개 이상 만드는 걸 강제로 막아주는 역할
public interface Instrument {
	
	public String play(String instrument);
	
	public default void testPrint() {
		System.out.println("테스트"); // default는 구현된 메소드이기 때문에 몇 개든 상관없다.
	}
		
}
