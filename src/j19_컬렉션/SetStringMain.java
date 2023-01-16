package j19_컬렉션;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetStringMain {

	public static void main(String[] args) {
		
		Set<String> setStr = new HashSet<>();
		List<String> listStr = new ArrayList<>();
		
		listStr.add("임나영");
		listStr.add("이강용");
		listStr.add("임나영");
		listStr.add("임나영");
		
		System.out.println(listStr);
		
		setStr.add("김상현");
		setStr.add("강대협");
		setStr.add("손지호");
		setStr.add("최해혁");
		setStr.addAll(listStr); // addAll을 할 경우 collection이 Set과 List의 상위 클래스이기 때문에 List를 넣을 수 있다.
		// 순서가 뒤죽박죽 출력되고 중복 출력이 안 되는 이유는 hash값을 넣었기 때문
		System.out.println(setStr); // Set은 get같은 것이 없다. 이유는 key값이 없기 때문에 setStr.get은 불가능
		String searchName = "손지호";
		
		for(String name : setStr) {
			if(name.equals(searchName)) {
				System.out.println(name); // 이렇게 값을 직접 비교해줘야 한다.
			}
		}
		
		Iterator<String> iterator = setStr.iterator(); //Iterator를 쓰는 것이 중요함.
		while(iterator.hasNext()) {
			String n = iterator.next();
			if(n.equals(searchName)) {
				System.out.println(n);
			}
		}
	}
	
}
