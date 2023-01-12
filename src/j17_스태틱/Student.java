package j17_스태틱;

public class Student {
	
	private static final int CODE = 20230000;
	private static int ai = 1; // auto_increment
	
	private int studentCode;
	private String name;
	
	public Student(String name) {
		studentCode = CODE + ai;
		ai++;
		this.name = name;
	}
	
	public static int getAutoIncrement() { // 스태틱 메서드 안에서는 스태틱 변수와 지역 변수만 가능함
		System.out.println("현재 AI: " + ai);
//		System.out.println("학생이름: " + name);
		return ai;
	}

	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + "]";
	}
	
	
	
}
