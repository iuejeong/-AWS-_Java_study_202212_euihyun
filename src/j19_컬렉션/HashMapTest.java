package j19_컬렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {
	// Object는 value의 자유를 위해 쓴다.
	public static void main(String[] args) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("username", "aaa");
		dataMap.put("password", "1234");
		dataMap.put("name", "김준일");
		dataMap.put("email", "aaa@gmail.com");
		
		List<String> hobby = new ArrayList<>();
		hobby.add("골프");
		hobby.add("축구");
		hobby.add("농구");
		hobby.add("음악감상");
		
		dataMap.put("hobbys", hobby); // Object로 하면 업캐스팅으로 뭐든 되지만 value를 따로 빼고 쓰고 싶다면 다운 캐스팅을 해서 써야 한다
		
		System.out.println(dataMap);
		
//		List<String> list = dataMap.get("hobbys"); 이건 오브젝트 타입이어서 안 된다.
		List<String> list = (List<String>) dataMap.get("hobbys"); // 이렇게 다운 캐스팅을 써야지 가능하다. 보통 넓은 영역으로 List를 많이 사용한다.
		System.out.println(list.get(0));
		
	}

}
