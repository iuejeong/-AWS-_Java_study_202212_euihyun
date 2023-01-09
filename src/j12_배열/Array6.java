package j12_배열;

public class Array6 {

	public static void main(String[] args) {
		
		String[] names =  {"박성진", "조병철", "황창욱"};
		
		for(String name : names) { // for each, name는 변수 선언 names는 배열 for each는 처음부터 끝까지 하나씩 꺼낸다 
			System.out.println(name);
		}
		
		System.out.println("==========<forEach>==========");
		
			for(int i = 0; i < names.length; i++) {
				System.out.println(names[i]);
		}
			
			int[] nums = {1,2,3,4,5};
			
			for(int i : nums) {
				System.out.println("i: " + i);
			}
			
	}

}
