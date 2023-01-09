package j12_배열;

public class Array5 {
	
	public static void transferArray(int[] oldArray, int[] newArray) { // 데이터를 옮겨주는 작업
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i]; // 새로 만든 배열에 기존 배열 값을 넣어주는 역할
		}
	}

	public static int[] addArrayLength(int[] array) { // 새로운 크기의 배열을 만들어주는 작업
		int[] newArray = new int[array.length + 1]; // 기존 배열의 크기에 + 1
		transferArray(array, newArray); // 기존 배열과 증가한 배열을 transferArray에 전달
		return newArray;
	}
	
	public static int[] addData(int[] array, int data) { // 값을 넣어주는 행위
		int[] newArray = addArrayLength(array); // 배열을 늘려주는 행위
		newArray[array.length] = data;
		return newArray;
	}
	
	// addData 메소드만 사용하기 때문에 다른 두 메소드들은 private를 사용해서 숨겨주는 것이 캡슐화이다         
	
	public static void main(String[] args) {
		
		int[] nums = new int[0]; // 0개인 배열
		
		nums = addData(nums, 1); // (배열, 추가하고 싶은 값)
		nums = addData(nums, 2);
		nums = addData(nums, 3);
		nums = addData(nums, 4);
		nums = addData(nums, 5);
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
	}
	
}
