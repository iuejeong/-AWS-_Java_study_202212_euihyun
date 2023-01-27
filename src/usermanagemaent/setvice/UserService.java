package usermanagemaent.setvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.mindrot.jbcrypt.BCrypt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import usermanagemaent.entity.RoleDtl;
import usermanagemaent.entity.User;
import usermanagemaent.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepository;
	private Gson gson;
	
	private static UserService instance;
	
	public static UserService getInstance() {
		if(instance == null) {
			instance = new UserService();
		}
		return instance;
	
	}
	
	private UserService() {
		userRepository = UserRepository.getInstance();
		gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public Map<String, String> register(String userJson) {
		// response : 응답
		Map<String, String> response = new HashMap<>();
		// Entry는 key와 value의 한 쌍. 그것들을 모아둔 것이 Map
		Map<String, String> userMap = gson.fromJson(userJson, Map.class);
		
		for(Entry<String, String> userEntry : userMap.entrySet()) {
			
			if(userEntry.getValue().isBlank()) {
				response.put("error", userEntry.getKey() + "은(는) 공백일 수 없습니다.");
				return response;
			}
		}
		
		
		User user = gson.fromJson(userJson, User.class);
		System.out.println("서비스에 넘어옴! User 객체로 변환");
		System.out.println(user);
		
		if(duplicatedUsername(user.getUsername())) {
			response.put("error", "이미 사용 중인 사용자 이름입니다.");
			return response;
		}
		
		if(duplicatedEmail(user.getEmail())) {
			response.put("error", "이미 사용 중인 이메일 입니다.");
			return response;
		}
//		String pw = BCrypt.hashpw("1234", BCrypt.gensalt());
//		System.out.println(pw);
//		System.out.println(BCrypt.checkpw("1234", pw));
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		System.out.println("암호화 후");
		System.out.println(user);
		
		userRepository.saveUser(user);
		
		RoleDtl roleDtl = RoleDtl.builder()
				.roleId(3)
				.userId(user.getUserId())
				.build();
		
		userRepository.saveRoleDtl(roleDtl);
		
		response.put("OK", "회원가입 성공!");
		
		return response;
	}
	
	private boolean duplicatedUsername(String username) {
		return userRepository.findUserByUsername(username) != null;
	}
	
	private boolean duplicatedEmail(String email) {
		return userRepository.findUserByEmail(email) != null;
	}
	
	public Map<String, String> authorize(String loginUserJson) {
		Map<String, String> loginUser = gson.fromJson(loginUserJson, Map.class); // Json을 Map으로 바꾼다.
		
		Map<String, String> response = new HashMap<>();
		
		for(Entry<String, String> entry : loginUser.entrySet()) {
			if(entry.getValue().isBlank()) {
				response.put("error", entry.getKey() + "은(는) 공백일 수 없습니다.");
				
				return response;
			}
		}
		//User ID 체크
		String usernameAndEmail = loginUser.get("usernameAndEmail");
		
		User user = userRepository.findUserByUsername(usernameAndEmail);
		if(user == null) {
			user = userRepository.findUserByEmail(usernameAndEmail);
			if(user == null) {
				response.put("error", "사용자 정보를 확인해주세요.");
				return response;
			}
		}
		
		// password 확인
		if(!BCrypt.checkpw(loginUser.get("password"), user.getPassword())) {
			response.put("error", "사용자 정보를 확인해주세요.");
			return response;
		}
		
		response.put("OK", user.getName() + "님 환영합니다.");
		return response;
		
	}
	

}
