package j09_클래스;

public class J09_User {

	String userName;
	String passWord;
	String name;
	String email;
	
	public J09_User() {
		
	}
	
	void printUserInfo() {
		
		System.out.println("아이디: " + userName);
		System.out.println("비밀번호: " + passWord);
		System.out.println("이름: " + name);
		System.out.println("이메일: " + email);
		System.out.println();
		
	}
	
}
