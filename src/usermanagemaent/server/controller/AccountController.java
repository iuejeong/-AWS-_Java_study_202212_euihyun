package usermanagemaent.server.controller;

import java.util.Map;

import usermanagemaent.dto.ResponseDto;
import usermanagemaent.entity.User;
import usermanagemaent.setvice.UserService;

public class AccountController {
	
	
	private static AccountController instance;
	private UserService userService;
	
	private AccountController() {
		userService = UserService.getInstance();
	}
	
	// 쓰레드를 사용할 때 싱글톤을 사용하면 동기화를 무조건 해줘야 한다.
	// 한꺼번에 접근할 수 있는 상황이 발생하기 때문
	
	public static AccountController getInstance() {
		if (instance == null) {
			instance = new AccountController();
		}
		return instance;
	}
	
	public ResponseDto<?> register(String userJson) {
		
		Map<String, String> resultMap = userService.register(userJson);
		
		if(resultMap.containsKey("error")) {
			return new ResponseDto<String>("error", resultMap.get("error"));
		}
		
		return new ResponseDto<String>("ok", resultMap.get("ok"));
		
	}
	
}
