package j19_컬렉션.복습;

import java.util.HashMap;
import java.util.Map;

public class SearchData {
	
	public static void main(String[] args) {
		
		Map<String, Object> searchData = new HashMap<>();
		
		searchData.put("category", "소설");
		searchData.put("searchValue", "불편한 편의점");
		
		System.out.println(searchData); // Map을 toString
		System.out.println(searchData.get("category")); // get에 key를 넣고 value를 출력한다.
		System.out.println(searchData.get("searchValue"));
		
		System.out.println(searchData.keySet()); // key값들을 들고온다
		System.out.println(searchData.values()); // value들을 들고온다
		
		System.out.println(searchData.entrySet()); // key와 value들을 들고온다. entry를 뽑아낸 것.
		
		// {}안에 값은 반복 불가, []안에 값은 반복 가능
		
//		for(int i = 0; i < searchData.size(); i++) {
//			System.out.println(searchData.get(null));
//		} 인덱스로는 반복 불가
		
		for(String key : searchData.keySet()) {
			System.out.println(searchData.get(key));
		}
		
	}

}
