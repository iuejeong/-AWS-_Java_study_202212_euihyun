package j19_컬렉션;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
/**
 * 
 * 1. class User 안에 사용할 변수들을 선언
 * 2. 변수에 들어갈 배열 User[] userArray 선언
 * 3. 선언했던 배열을 List로 바꾼다.
 * 4. user라는 변수에 searchUser() 메서드를 주입한다.
 * 5. 매개 변수의 값은 아까 리스트로 바꿨던 userList, 내가 찾고 싶은 유저의 이름인 searchUsername의 값을 넣는다
 * 6. User 객체 변수의 값을 null로 지정해준다. null로 지정해줌으로써 검색 확인을 해주기 위해.
 * 7. 
 */

class User {
	private String username;
	private String name;
}

public class ArrayUserMain {
	
	public static void main(String[] args) {
		
		User[] userArray = {
				new User("aaa", "김종환"),
				new User("bbb", "고병수"),
				new User("ccc", "손민재"),
				new User("ddd", "황창욱"),
		};
		
		List<User> userList = Arrays.asList(userArray);
		
		String searchUsername = "ddd";
		User user = searchUser(userList, searchUsername);
		
		if(user == null) {
			System.out.println("검색실패!");
			System.out.println("존재하지 않는 계정입니다.");
		}else {
			System.out.println("검색성공!");
			System.out.println(searchUsername + "계정의 회원 이름은 " + user.getName() + "입니다");
		}
		/*
		 * 검생성공! aaa계정의 회원 이름은 김종환입니다.
		 * 검색실패! 존재하지 않는 계정입니다.
		 */
		

		}
		
	private static User searchUser(List<User> userList, String username) {
		User user = null;
		
		for(User u : userList) {
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		
		return user;
		
	}

}
