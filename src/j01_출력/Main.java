package j01_출력;

import java.util.Arrays;
import java.util.List;

class SubjectService {
	
	private List<String> subjects;
	
	public SubjectService(List<String> subjects) {
		this.subjects = subjects;
	}
	
	public void showSubjects() {
		int length = 3;
		for(int i = 0; i < length; i ++) {
			System.out.println(subjects.get(i));
			System.out.println("git test");
			System.out.println("git test2");
		}
	}
}



public class Main {

	public static void main(String[] args) {
		
		List<String> subjects = Arrays.asList(new String[] {"C", "Java", "Python"});
		SubjectService subjectService = new SubjectService(subjects);
		subjectService.showSubjects(); 
			
	}
}
