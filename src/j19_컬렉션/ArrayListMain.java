package j19_컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListMain {
	
	/**
	 * 
	 * CRUD(회사에서 할 일)
	 * C reate
	 * R ead
	 * U pdate
	 * D elete
	 * 
	 * 
	 */

	public static void main(String[] args) {
		// List 특징 : 순서가 있다, 중복이 가능하다 == 배열
		// int[] nums == List<Integer> nums
		// 배열과 List의 차이는 List는 객체다.
		// ArrayList<?> list = new ArrayList<String>(); -> 자료형이 String이다. 자료형이 정해주는 기준은 생성되는 시점이다.
		// 			//		 = new ArrayList<User>();
		// 			// 		 = new ArrayList<Object>(); -> 어떤 자료형이든 상관없이 쓰고 싶으면 Object를 쓴다.
		// ArrayList<String> list = new ArrayList<>(); 초기화할 때 앞 쪽에 어떤 자료형을 쓸 건지 변수가 존재해야 뒤에 생략이 가능하다.
		// list.toArray(); -> list를 배열로 바꿈. 배열 값이 object이기 때문에 꺼낼 때 하나하나씩 다 다운캐스팅을 해줘야 한다.
		// ArrayList는 List를 상속 받고 있고 그 안에 밑에 메서드들을 쓸 수 있게 설계되어 있다. 
		
		List<String> strList = new ArrayList<>();
		
		// * 값 추가
		strList.add("java");
		strList.add("python");
		System.out.println(strList);
		System.out.println();
		
		// 값 원하는 위치에 추가
		strList.add(1, "android");
		System.out.println(strList);
		System.out.println();
		
		// * 해당 인덱스의 값을 추출
		System.out.println(strList.get(0));
		String lang = strList.get(1);
		System.out.println(lang);
		System.out.println();
		
		// 리스트에 해당 값이 있는지 확인(T, F)
		System.out.println(strList.contains("C++"));
		System.out.println(strList.contains(lang));
		System.out.println();
		
		// 값 수정
		strList.set(2, "javascript");
		System.out.println(strList);
		System.out.println();
		
		// * 값 삭제
		strList.remove("android");
		System.out.println(strList);
		strList.remove(1);
		System.out.println(strList);
		System.out.println();
		
		// * 리스트의 크기 확인
		System.out.println(strList.size());
		System.out.println();
		
		// 리스트가 비었는지 확인
		System.out.println(strList.isEmpty());
		System.out.println();
		
		// 리스트 초기화
		strList.clear();
		System.out.println(strList.isEmpty());
		System.out.println();
		
		/* 
		 * * 배열을 리스트로 변환
		 * Arrays.asList(배열);
		 */
		String[] langs = {"java", "c++", "python", "javascript"};
		List<String> tempList = Arrays.asList(langs);
		strList.addAll(tempList);
		strList.addAll(2, tempList);
		System.out.println(strList);
		
		// * 해당 값의 위치(index) 왼쪽부터 찾기
		int findIndexLeft = strList.indexOf("java");
		System.out.println(findIndexLeft);
		
		// * 해당 값의 위치(index) 오른쪽부터 찾기
		int findIndexRight = strList.lastIndexOf("java");
		System.out.println(findIndexRight);
		
//		strList.set(1, "java");
//		System.out.println(strList);
//		strList.subList(strList.indexOf("java") + 1, strList.size()).indexOf("java");
		
		// fromIndex 부터 toIndex 전까지 부분만 리스트를 추출
		List<String> subList = strList.subList(1, 4); // 1번부터 4번 인덱스 전까지
		System.out.println(subList);
		
	
		
		
		// ==========<< 반복 >>==========
		// 일반 반복문
		for(int i = 0; i < strList.size(); i++) {
			System.out.println("[" + i + "]: " + strList.get(i));
		}
		System.out.println();
		
		// forEach
		for(String str : strList) {
			System.out.println("[값]: " + str);
		}
		System.out.println();
		
		// 람다식 forEach
		strList.forEach(str -> System.out.println("[값2]: " + str));
		System.out.println();
		
		// 반복자
		Iterator<String> iterator = strList.iterator(); // 쌓는다
		while(iterator.hasNext()) { // 다음을 꺼내라
			String lang2 = iterator.next(); // 제네릭 타입이랑 맞춰줘야 한다.
//			System.out.println("[값3]: " + iterator.next());
			System.out.println("[값3]: " + lang2); // 다음을 꺼내는 순간 값이 되고 출력이 된다.
		}
		
		// 위 반복자를 다 사용한 후 재사용하고 싶을 때
		iterator = strList.iterator();
		while(iterator.hasNext()) {
			String lang2 = iterator.next();
			System.out.println("[값3]: " + lang2);
		}
		
	}
	
}

