package j17_스태틱.싱글톤;
// 하나의 객체를 여럿 공유할 때 쓰인다
public class KIA {
//
	private static KIA instance = null;
	
	private KIA() {} // 생성자가 하나여야 하기 때문에 private이다 -> 유일하기 때문에 싱글톤
	
	public static KIA getInstance() { // static이기 때문에 모든 영역에서 다 가져올 수 있다.
		if(instance == null) {
			instance = new KIA();
		}
		return instance;
	} // 모든 싱글톤은 여기까지 세트다.
	
	public void printCompanyName() {
		System.out.println(getClass().getSimpleName());
	}
	
}
