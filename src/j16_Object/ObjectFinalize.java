package j16_Object;
// public은 외부에서 접근지정을 해주기 위해 존재하는 것
// class만 쓸 경우 패키지 내에서만 사용 가능
class Test {
	private int num;

	public Test(int num) {
		super();
		this.num = num;
		System.out.println(num + "생성");
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println(num + "객체 소멸"); // finalize는 소멸할 때 쓴다. 가비지컬렉터가 실행이 됐을 때 쓰인다.
		// 실시간 프로그램에서 소멸을 원하지 않을 때 쓴다. 하지만 소멸을 안 하는 것이 아니고 기존의 데이터를 복사가 된 후 진행이 된다.
	}
	
	
}

public class ObjectFinalize {
	
	public static void main(String[] args) {
		
		Test test = null;
		
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // 이처럼 여유가 있을 때는 랜덤으로 소멸시키지 않는다.
			test = new Test(i);
			
			test = null;
			
			System.gc(); //가비지 컬렉터 실행, 우선순위가 낮음 -> JVM이 여유가 있을 때 실행이 됨, 무엇을 소멸시킬지 모르기 때문에 주의를 하고, 함부로 사용하면 안 된다.
		}
		
	}

}
