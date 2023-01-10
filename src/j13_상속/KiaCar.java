package j13_상속;

public class KiaCar extends Car {

	public KiaCar() {
		super(); // 나의 부모. 상위 객체를 의미함, super는 가장 상위에 있어야 한다.
		System.out.println("자식");
	}
	
	@Override
	public int discountPrice(int percentage) {
		return super.discountPrice(percentage);
	} 
	
	
	
}
