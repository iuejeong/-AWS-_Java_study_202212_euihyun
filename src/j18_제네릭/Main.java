package j18_제네릭;

public class Main {
	
	public static void main(String[] args) {
		// 제네릭 타입은 생성될 때 결정된다.
//		TestData<?, ?> td = new TestData<>("김준일", 30);  <?> -> 무슨 자료형이 들어올 줄 모른다. 그리고 와일드카드라고 칭한다.
		TestData<String, Integer> td = new TestData<String, Integer>("김준일", 30);
		TestData<String, Double> td2 = new TestData<String, Double>("junil", 100.05);
		System.out.println(td);
		System.out.println(td2);
		
		CMRespDto<TestData<String, Integer>> cm =
				new CMRespDto<TestData<String, Integer>>(200, "성공", td);
		
		System.out.println(cm);
	}

}
