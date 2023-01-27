package j01_출력;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Company {
	private int companyId;
	private String companyName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
}

public class Main3 {
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap();
		
		map.put("companyId", 100);
		map.put("companyName", "Apple");
		map.put("address", "Apple Computer Inc. 1 infinite Loop");
		map.put("city", "Cupertino");
		map.put("state", "CA");
		map.put("zipCode", "95014");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String mapJson = gson.toJson(map);
		
		System.out.println(mapJson);
		
	}
	
}
