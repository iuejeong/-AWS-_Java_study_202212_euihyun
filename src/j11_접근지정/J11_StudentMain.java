package j11_접근지정;
// import는 다른 패키지에 있으면 꼭 지정해줘야 한다. 동일 패키지 내에서는 필요없음
import j11_접근지정.default1.J11_StudentDefault;

public class J11_StudentMain {
	
	public static void main(String[] args) {
//		J11_Student s1 = new J11_Student();

//		s1.setName("김준일");
//		
//		s1.printInfo();
		
		J11_StudentDefault s2 = new J11_StudentDefault();
		
//		s2.name = "김준이";
		
//		System.out.println("이름: " + s2.name); // private을 걸었기 때문에 사용 불가.
		System.out.println("이름: " + s2.getName());
	}

}
