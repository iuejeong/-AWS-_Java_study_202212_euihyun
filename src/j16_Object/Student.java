package j16_Object;

import java.util.Objects;

// Object는 최상위 클래스.
// 그래서 모든 클래스는 Object를 가진다.
// extends Object가 생략이 되어있다.
// 생략되어있던 걸 명시하는 순간, 기존에 있던 것은 사라진다 -> 자바의 특징
public class Student {
	
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age); // name과 age를 조합해서 하나의 hash코드를 만듦
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		
		if(!(obj.getClass() == Student.class)) {
			return false;
		}
		
		Student s = (Student) obj;
		boolean result = name.equals(s.name) && age == s.age;
		
		return result;
	}

	@Override
	public String toString() {
		return "이름: " + name + "\n나이: " + age;
	}
	
}
