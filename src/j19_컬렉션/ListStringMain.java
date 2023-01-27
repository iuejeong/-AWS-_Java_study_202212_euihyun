package j19_컬렉션;

import java.util.ArrayList;
import java.util.List;

public class ListStringMain {
	
	public static void main(String[] args) {
		
		String[] strArray = new String[] {"java", "python", "C++"};
		String[] newStrArray = new String[strArray.length + 1];
		
		for(int i = 0; i < strArray.length; i++) {
			newStrArray[i] = strArray[i];
		}
		newStrArray[strArray.length] = "html";
		
		System.out.println("[strArray]");
		for(String str : strArray) {
			System.out.println(str);
		}
		System.out.println();
		
		System.out.println("[newStrArray]");
		for(String str : newStrArray) {
			System.out.println(str);
		}
		System.out.println();
		
		//////////////////////////////////////////////
		//자료구조 또는 알고리즘이라 한다.
		ArrayList<String> strList = new ArrayList<>();
		strList.add("java"); // java 추가
		strList.add("python");
		strList.add("python");
		strList.add("python");
		strList.add("python");
		strList.add("python");
		strList.remove("java"); // java 제거
		strList.add(1, "java"); // 1번 인덱스 자리에 java 추가
		strList.remove(1); // 1번 인덱스 삭제

		for(int i = 0; i < strList.size(); i++) {
			System.out.print("[" + i + "]: ");
			System.out.println(strList.get(i));
		}
		
		for(String str : strList) {
			System.out.println(str);
		}
		
		
		
	}

}
