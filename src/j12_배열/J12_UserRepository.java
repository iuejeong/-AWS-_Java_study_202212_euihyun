package j12_배열;

//저장소
public class J12_UserRepository {
	
	private J12_User[] userTable;
	
	public J12_UserRepository(J12_User[] userTable) {
		this.userTable = userTable;
	}
	
	public J12_User[] getUserTable() {
		return userTable;
	}
	
	public void saveUser(J12_User user) {
		extendArrayOne();
		userTable[userTable.length - 1] = user;
	}
	
	private void extendArray(int length) {
		J12_User[] newArray = new J12_User[userTable.length + length];	
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}
	
	private void extendArrayOne() {
		J12_User[] newArray = new J12_User[userTable.length + 1];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}
	
	public void transferDataToNewArray(J12_User[] oldArray, J12_User[] newArray) {
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	public J12_User findUserByUsername(String username) {
		
		J12_User user = null; // return을 해주기 위해 비어있는 user를 생성
		
		for(J12_User u : userTable) {
			if(u == null) { // null 체크는 무조건 해야 함 만약에 null이라면 다음 if문이 실행이 안 됨
				continue;
			}
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		
		return user;
	}
	
	/*
	 * 
	 * 1.사용자이름으로 회원 조회
	 * 
	 * 2. 회원 정보 수정
	 * 		수정 할 사용자이름을 입력하세요:
	 * 
	 * 		<< 사용자이름: aaa>>
	 * 
	 * 		1. 비밀번호 변경
	 * 		2. 이름 변경
	 * 		3. 이메일 변경
	 * 
	 * 		b. 뒤로가기
	 */
	
}

