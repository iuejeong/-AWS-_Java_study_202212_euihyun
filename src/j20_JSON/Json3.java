package j20_JSON;

import com.google.gson.Gson;

public class Json3 {
	
	public static void main(String[] args) {
		Gson gson = new Gson(); // 객체는 그 기능을 쓰기 위해 생성을 한다. -> 객체 사용은 두 가지로 나뉜다. 1. 스태틱을 쓸 것인가, 2. 생성해서 쓸 것인가.
		
		gson.toJson(null); 					// object	-> 		json
		gson.fromJson("", Object.class); 	// json		->		object
		
	}

}
