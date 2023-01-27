package j01_출력;

class User {
	private String username;
	private String password;
	private String name;
	private String email;
	
	
	public User(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		
		System.out.println("[사용자 정보]");
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		System.out.println("name: " + name);
		System.out.println("email: " + email);
	}
	
	
}

public class UserMain {
	
	public static void main(String[] args) {
		User user = new User("junil", "1234", "김준일", "junil@gmail.com");
			
		
			System.out.println(user);
		
	}
	
}
