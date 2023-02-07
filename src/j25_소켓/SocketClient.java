package j25_소켓;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("127.0.0.1", 9090);
			System.out.println("서버에 접속 성공!");
			
			// 공식
			InputStream inputStream = socket.getInputStream();				// Stream = 흐름
			InputStreamReader streamReader = new InputStreamReader(inputStream);		// 1 byte씩 읽어주는 역할
			BufferedReader reader = new BufferedReader(streamReader);		// 1 byte씩 읽었던 것들을 한 번에 들고 와주는 역할
			
			System.out.println(reader.readLine());
			
		} catch (UnknownHostException e) {			// ip를 잡지 못했을 때
			e.printStackTrace();
		} catch (IOException e) {					// 통신을 잡지 못했을 때
			e.printStackTrace();
		}
		
	}
	
}
