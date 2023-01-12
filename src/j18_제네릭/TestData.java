package j18_제네릭;
// 제네릭은 일반 자료형을 못 쓴다. 래퍼 클래스만 가능하다
// 자료형을 바꿀 때 제네릭을 사용한다
// ex) <T>(Type을 줄임)  -> 제네릭 
public class TestData<T, E> {

	private T data1;
	private E data2; // Wrapper Class(래퍼 클래스) -> 일반 자료형을 클래스화 시킨 것
	
	public TestData(T data1, E data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return "TestData [data1=" + data1 + ", data2=" + data2 + "]";
	}
	
}
