package j18_제네릭;

public class Main2 {
/*	
 * ? 와일드카드 제약
 * extends	 대상 객체 하위
 * super 	대상 객체 상위
 * 
 * 
 * 	<?> -> Object라고 생각하면 됨. 하지만 Object는 잘 쓰지는 않는다
 * 	ex) <? extends Person>을 쓴다면 Person을 상속 받은 자료형만 return이 가능하다.
 * 	ex) <? super ~~>을 쓴다면 상위 객체만 사용 가능하다
 */
	public CMRespDto<?> reponse(CMRespDto<?> cmrespDto) {
		System.out.println("[응답데이터]");
		System.out.println(cmrespDto);
		return cmrespDto;
	}
	
	public static void main(String[] args) {
		Main2 main = new Main2();
		
		CMRespDto<String> hello 
			= new CMRespDto<String>(200, "성공", "안녕하세요");
		
		CMRespDto<Integer> score
			= new CMRespDto<Integer>(200, "성공", 85);
		
			System.out.println("hello");
			System.out.println(main.reponse(hello));
			
			System.out.println("score");
			System.out.println(main.reponse(score));

		// 안녕하세요.
	}

}
