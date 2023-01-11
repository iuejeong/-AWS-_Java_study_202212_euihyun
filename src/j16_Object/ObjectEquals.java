package j16_Object;

public class ObjectEquals {
	
	public static void main(String[] args) {
		String name1 = "김준일"; // "김준일" -> name1, 2 -> 생성하지 않았기 때문에 주소값 동일
		String name2 = "김준일";
		String name3 = new String("김준일"); // "김준일" -> new String -> name3 그래서 주소값이 바뀐다
		
		System.out.println(name1);
		System.out.println(name2);
		
		System.out.println(name1 == name2); //주소 비교
		System.out.println(name1.equals(name3)); // .equals를 할 경우 값을 비교하게 되어서 true가 나옴.
		
/////////////////////////////////////////////////////////////////
		
		// 생성을 2번 했기 때문에 주소 값이 다르다
//		Student s = new Student("박은빈", 24);
//		Student s1 = new Student("박은빈", 24);
//		Student s2 = new Student("박은빈", 24);
//		Student s1 = s; 이럴 경우는 주소가 같기 때문에 true다
//		Student s2 = s;
		
		Student s1 = new Student("박은빈", 24);
		Student s2 = new Student("박은빈", 24);
		SubStudent s3 = new SubStudent("박은빈", 24);
		
		System.out.println(s1.equals(s3));
	}

}
