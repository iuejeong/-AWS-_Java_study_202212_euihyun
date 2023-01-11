package j16_Object;
// 자바 라이브러리에 Object 클래스가 존재함
public class ToString {
	
	public static void main(String[] args) {
//		Object obj = new Object(); 
//		System.out.println(obj); // 출력할 때 기본적으로 toString을 달고 나온다.
//		String str2 = obj; // toString의 결과를 담고 싶다면 .toString을 붙여줘야 한다. toString이 String을 반환해주기 때문
//		String str = obj.toString();
//		System.out.println(str);
		
		Student student1 = new Student("조병철", 34);
		Student student2 = new Student("김동민", 28);
		Student student3 = new Student("김두영", 28);
		Student student4 = new Student("강의진", 29);
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
		System.out.println(student4);
		
		System.out.println();
		
//		System.out.println(student1.toString()); // toString()을 넣어도 위 출력과 동일하다
//		System.out.println(student2.toString());
//		System.out.println(student3.toString());
//		System.out.println(student4.toString());
		
		
		
		
	}

	@Override
	public String toString() {
		return "ToString [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
