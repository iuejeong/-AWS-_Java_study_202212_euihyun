package j12_배열;

public class Array2 {
	
	public static void printNames(String[] names) {
		for(int i = 0; i < names.length; i++) {
			System.out.println("이름[" + (i + 1) + "]: " + names[i]);
		}
		
		System.out.println();
		
	}

	public static void main(String[] args) {
		
		String[] names = new String[3]; // 들어갈 값이 정해져있지 않을 때, 들어갈 공간이 확실할 때
		
		names[0] = "김상현";
		names[1] = "임나영";
		names[2] = "김종환";
		
		String[] names2 = new String[] {"이상현", "손지호", "이강용"}; // 들어갈 값이 정해져있을 때. 크기를 지정하지 않는다
		String[] names3 = {"김두영", "강대협", "이현수", "김재영"}; // 크기를 지정하지 않는다. new String[]을 생략. 첫 초기화할 때만 가능하다.
		
		printNames(names);
		printNames(names2);
		printNames(names3);
		
		
	}

}
