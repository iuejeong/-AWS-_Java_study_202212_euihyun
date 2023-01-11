package j16_Object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectGetClass {
	
	public static void main(String[] args) {
		
		Student student = new Student("김재영", 29);
		
		// 타입, 클래스 이름, 클래스 안에 멤버 변수나 메서드 등을 확인할 때 사용함.
		// 둘의 객체가 같은지, 다른지 비교할 때 사용함.
		// 둘의 비교를 사용하는 경우는 다운캐스팅을 볼 때만 씀.
		System.out.println(student.getClass()); // student.getClass();를 하면 Student 정보를 가져온다 -> 생성된 객체
		System.out.println(Student.class); // 자료형에 .class를 찍으면 class Class의 정보를 가져온다 -> 객체 자체를 의미함. 타입의 비교 대상을 쓸 때 사용함
		
		System.out.println(student.getClass().getName());
		
		Class studentClass = student.getClass();
		
		String className = studentClass.getName();
		System.out.println("클래스 이름: " + className);
		
		String simpleName = studentClass.getSimpleName();
		System.out.println("클래스 이름만: " + simpleName);
		
		Field[] fields = studentClass.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field);
		}
		
		System.out.println();
		
		Method[] methods = studentClass.getDeclaredMethods(); // getDeclared -> 해당 클래스에서 선언했던 멤버 변수들을 모두 불러온다.
		for(Method method : methods) {
			System.out.println(method);
		}
		
	}
		
	

}
