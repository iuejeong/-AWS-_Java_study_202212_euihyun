package j10_생성자;

public class J10_Student {
	
	// 참조 변수 or 레퍼런스 변수 or 멤버 변수라고 함
	public String name;
	public int age;
	
	// 참조 메서드 or 레퍼런스 메서드 or 멤버 메서드라고 함
	J10_Student() {
		System.out.println("기본 생성자 호출");
	}
	
	J10_Student(int age) {
		System.out.println("학생의 나이: " + age);
	}
	
	J10_Student(String name) {
		System.out.println("학생의 이름: " + name);
	}
	
	J10_Student(String name, int age) {
		this.name = name; // 우선순위는 지역변수다.
		this.age = age; // this는 자기자신의 주소다.
	}
	
	//멤버 변수 출력 용도
	void printInfo() {
		System.out.println("학생 이름: " + name);
		System.out.println("학생 나이: " + age);
	}
	
}
