package j18_제네릭;

public class Main {
	
	public static void main(String[] args) {
		// 제네릭 타입은 생성될 때 결정된다.
		TestData<String, Integer> td = new TestData<String, Integer>("김준일", 30);
		TestData<String, Double> td2 = new TestData<String, Double>("junil", 100.05);
		System.out.println(td);
		System.out.println(td2);
		
	}

}
