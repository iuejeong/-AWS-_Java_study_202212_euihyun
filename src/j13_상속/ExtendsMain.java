package j13_상속;

public class ExtendsMain {

	public static void main(String[] args) {
	
		KiaCar kiaCar = new KiaCar();
		
		kiaCar.setPrice(30000000);
		
		System.out.println(kiaCar); // 상위 객체 먼저 찍힘.

		System.out.println(kiaCar.getPrice());
		System.out.println(kiaCar.discountPrice(20));
		
		
	}
	
}
