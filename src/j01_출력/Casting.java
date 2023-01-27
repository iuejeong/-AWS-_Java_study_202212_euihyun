package j01_출력;

abstract class Program {
	public abstract void develop();
	public abstract void garvageCollection();
	public abstract void defineStructure();
}

class Java extends Program {

	@Override
	public void develop() {
		System.out.println("자바 프로그램을 개발합니다.");
	}
	
	public void garvageCollection() {
		System.out.println("메모리를 정리합니다.");
	}

	@Override
	public void defineStructure() {
		
	}
	
}

class C extends Program {

	@Override
	public void develop() {
		System.out.println("C 프로그램을 개발합니다.");
	}
	
	public void defineStructure() {
		System.out.println("구조체를 정의합니다.");
	}

	@Override
	public void garvageCollection() {
		
	}
}

public class Casting {
	
	public static void main(String[] args) {
		
		Program[] programs = new Program[2];
		programs[0] = new Java(); 
		programs[1] = new C();
		
		
		for(int i = 0; i < programs.length; i++) {
			programs[i].develop();
			programs[i].garvageCollection();
			programs[i].defineStructure();
		}
	}
}
