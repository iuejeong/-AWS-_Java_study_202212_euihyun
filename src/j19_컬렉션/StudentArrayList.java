package j19_컬렉션;

import java.util.ArrayList;
import java.util.List;

public class StudentArrayList {
	
	public static void updateYear( 
			List<Student> students,
			String searchName,
			int newYear) { // 메서드를 이용한 방법
		
		for(Student student : students) {
			if(student.getName().equals(searchName)) {
				student.setYear(newYear);
				return;
			}
		}
		
		System.out.println("검색 실패!!");
		
	}
	
	public static void main(String[] args) {
		

		
	List<Student> students = new ArrayList<>();
		students.add(new Student("김종환", 1));
		students.add(new Student("고병수", 2));
		students.add(new Student("손민재", 3));
		students.add(new Student("황창욱", 4));
		
//		System.out.println(students);
//		
//		System.out.println(students.get(0).getName());
//		boolean check = students.contains(); -> () 안에 주소값이 들어가야 한다. ex) students.get(0)
		String searchName = "손민재";
		// 이름이 searchName인 학생을 찾아서 학년을 4학년으로 바꿔라
		// 만약 searchName 동일한 이름이 없으면 "검색실패" 메세지 출력
		
		boolean flag = true;
		for(int i = 0; i < students.size(); i++) { // 기본 for문을 쓰는 방법
			Student student = students.get(i);
			if(student.getName().equals(searchName)) {
				student.setYear(4);
				flag = false;
				break;
			}
	} 
		
		for(Student student : students) { // forEach를 쓰는 방법
			if(student.getName().equals(searchName)) {
					student.setYear(4);
					flag = false;
					break;
				}
			}
		
		if(flag) {
			System.out.println("검색 실패!!!");
		}
		
		System.out.println(students);
		
		updateYear(students, "황창욱", 1);
		System.out.println(students);
		
	}

}
