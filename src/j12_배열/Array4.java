package j12_배열;

public class Array4 {
	
	public static void printNames(String[] names) {
		J12_User[] users = new J12_User[3];
		J12_User[] users2 = new J12_User[] {
			new J12_User("aaa", "1234", "김삼겹", "aaa@gmail.com"),
			new J12_User("bbb", "1234", "박대패", "bbb@gmail.com"),
			new J12_User("ccc", "1234", "명갈비", "ccc@gmail.com")
		};
		J12_User[] user3 = {
				new J12_User("aaa", "1234", "김삼겹", "aaa@gmail.com"), 
				new J12_User("bbb", "1234", "박대패", "bbb@gmail.com"), 
				new J12_User("ccc", "1234", "명갈비", "ccc@gmail.com")
		};
		
		users[0] = new J12_User("aaa", "1234", "김삼겹", "aaa@gmail.com");
		users[1] = new J12_User("bbb", "1234", "박대패", "bbb@gmail.com");
		users[2] = new J12_User("ccc", "1234", "명갈비", "ccc@gmail.com");
		
		for(int i = 0; i < users.length; i++) {
			System.out.println(users[i].toString());
		}
	}

}
