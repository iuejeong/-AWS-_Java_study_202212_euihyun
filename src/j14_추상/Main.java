package j14_추상;

public class Main {

	public static void main(String[] args) {
//		Transportation transportation = new Transportation(); -> Transportation 클래스가 추상 클래스이기 때문에 생성 불가
		Transportation transportation = new Airplane();
		transportation.go();
	}
	
}
                                      