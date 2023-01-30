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

}
