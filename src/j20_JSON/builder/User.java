package j20_JSON.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
//Builder 어노테이션을 사용하면 AllArgsConstructor이 자동적으로 들어가있다.
public class User {
	
	private String username;
	private String password;
	private String name;
	private String email;
//	
//	public static UserBuilder builder() {
//		return new UserBuilder(); // UserBuilder에 static이 없다면 new User().new UserBuilder()로 생성을 해줘야 한다.
//	}
//	
//	@Data
//	public static class UserBuilder {
//		private String username;
//		private String password;
//		private String name;
//		private String email;
//		
//		public UserBuilder username(String username) {
//			this.username = username;
//			return this;
//		}
//		
//	
//		public UserBuilder password(String password) {
//			this.password = password;
//			return this;
//		}
//		
//		public UserBuilder name(String name) {
//			this.name = name;
//			return this;
//		}
//		
//		public UserBuilder email(String email) {
//			this.email= email;
//			return this;
//		}
//		
//		public User build() {
//			return new User(username, password, name, email); // 빌드업 패턴을 위해서는 AllArgsConstructor가 필수다.
//		}
//		
//	}
//	
//	
}
