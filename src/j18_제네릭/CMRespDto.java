package j18_제네릭;

// Commit Message Response Data Transfer Object
// 클라이언트가 서버에게 요청을 날리면 동일한 형식으로 응답해주는 응답인터페이스
// 응답할 때 사용하는 "공동 응답 객체"라고 한다.
public class CMRespDto<T> {
	
	private int code;
	private String message;
	private T data; // 배열로도 가능, 생성할 때 자체적으로도 배열 가능
	
	public CMRespDto(int code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	@Override
	public String toString() {
		return "CMRespDto [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
	
	

}
