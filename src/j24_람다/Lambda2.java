package j24_람다;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Lambda2 {

	public static void main(String[] args) {
		
		// 1. Runnable - run()
		// 매개변수 X, 반환값 X
		Runnable a = () -> System.out.println("하나만 실행"); // 하나만 실행하기에 중괄호 생략, 매개변수 없어서 비어져있음.
		Runnable b = () -> {
			System.out.println("여");
			System.out.println("러");
			System.out.println("명");
			System.out.println("령");
			System.out.println("실");
			System.out.println("행");
		};
		
		a.run();
		a.run(); // 메서드가 정의되어져 있기 때문에 2번 이상도 실행 가능
		b.run();
		
		// 2. Supplier<T> - T get()
		// LocalDate 안에 format 메서드가 있다는 걸 알고 있어야 함.
		// 매개변수 X, 반환값 O
		Supplier<LocalDate> c = () -> LocalDate.now(); // 현재 날짜를 가져다 줌.
		Supplier<String> d = () -> {
			LocalDate now = LocalDate.now();
			return now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")); // 뭘 쓰든 시간 양식은 동일하다 연도: y, 달: M 일: d, 분: m
		};
		
		System.out.println(c.get());
		System.out.println(d.get());
		
		
		// 3. Consumer<T> - void T accept(T t)
		// 매개변수 O, 반환값 X
		Consumer<String> e = name -> {
			System.out.println("이름: " + name);
			System.out.println("오늘 날짜: " + d.get()); 
		}; // 정의와 생성
		
		e.accept("이종현"); // 호출
		
		// 메소드 참조 표현식([인스턴스] :: [메소드명 or new])
		Consumer<String> f =  System.out :: println;
		f.accept("출력");
		
		List<String> names = new ArrayList<>();
		names.add("김동민");
		names.add("김두영");
		names.add("장진원");
		names.add("조병철");
		
		Consumer<String> g = name -> System.out.println("이름: " + name + "님");
		
		names.forEach(g);
		
		// this = names (this = List) T == String
		// this에서 김동민을 꺼낸다 -> accept에 김동민이 들어간다 -> name에 김동민이 들어간다 -> 출력이 된다
//		   default void forEach(Consumer<? super String> action) {
//		        Objects.requireNonNull(action);
//		        for (String t : this) {
//		            action.accept(t);
//		        }
//		    }
		
		names.forEach(name -> {
			System.out.println("이름을 출력합니다.");
			System.out.println("이름: " + name);
			System.out.println();
		});

		Map<String, String> userMap = new HashMap<>();
		userMap.put("username", "aaa");
		userMap.put("password", "1234");
		
		// BiConsumer = BinaryConsumer = 이진 -> 매개변수가 2개다
		userMap.forEach((key, value) -> {
			System.out.println("key: " + key);
			System.out.println("value: " + value);
			System.out.println();
		});
		
		for(Entry<String, String> entry : userMap.entrySet()) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
			System.out.println();
		}
		
	}
	
}
