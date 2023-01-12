package j17_스태틱;

import java.time.LocalDateTime;
import java.util.Date;

public class Car {

	private	static final int NOW_YEAR = LocalDateTime.now().getYear();
	
	private static final String CODE = "KIA-" + NOW_YEAR + "-";
	private static int ai = 1;
	
	private String serialCode;
	private String modelName;
	
	public Car(String modelName) {
		serialCode = CODE + String.format("%04d", ai); // d = decimal 숫자, %04 = 공간을 4개 만들어서 0을 4개로 채우겠다
		this.modelName = modelName;
		ai++;
	}

	@Override
	public String toString() {
		return "Car [serialCode=" + serialCode + ", modelName=" + modelName + "]";
	}
	
			

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private static String code = "KIA-2023-";	//KIA-2023-0000
//	private static int codePlus = 1;
//	
//	private String serialCode;
//	private String modelName;
//	
//	public Car(String Name) {
//		serialCode = code + codePlus;
//		codePlus++;
//		this.modelName = Name;
//		
//	}
//
//	@Override
//	public String toString() {
//		return "Car [serialCode=" + serialCode + ", modelName=" + modelName + "]";


	

	

	
	
	
	
}
