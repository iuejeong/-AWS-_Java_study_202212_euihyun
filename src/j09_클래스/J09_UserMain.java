package j09_클래스;

public class J09_UserMain {

	public static void main(String[] args) {

		J09_User user1 = new J09_User();
		J09_User user2 = new J09_User();
		J09_User user3 = new J09_User();
		
		user1.userName = "aaa";
		user1.passWord = "1234";
		user1.name = "김종환";
		user1.email = "aaa@gmail.com";
		
		user1.printUserInfo();
		
		
		user2.userName = "dmlgus3585";
		user2.passWord = "dmlgus1234";
		user2.name = "정의현";
		user2.email = "dmlgus3585@naver.com";
		
		user2.printUserInfo();
		
		
		user3.userName = "dmlgus3585";
		user3.passWord = "dmlgus1234";
		user3.name = "정의현";
		user3.email = "dmlgus3585@gmail.com";
		
		user3.printUserInfo();
		
	}

}
