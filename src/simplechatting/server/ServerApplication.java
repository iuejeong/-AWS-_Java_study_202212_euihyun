package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("=====<<< 서버 실행 >>>=====");
			
			Socket socket = serverSocket.accept(); // 클라이언트의 접속을 기다리는 녀석(accept 소켓을 리턴해줌!), 연결 버튼 누를 때까지 기다림.
			
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);	// 클라이언트한테 줄 수 있는 "통로"를 열어줌
			out.println("join");		//클라이언트한테 join이라는 값을 준다.
			
			InputStream inputStream = socket.getInputStream();		// 클라이언트한테 받을 수 있는 "통로"를 열어줌
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));		// 서버한테 값을 받는다
			
			String welcomMessage = in.readLine();		// 받은 값을 변수에 넣는다.
			System.out.println(welcomMessage);	// server에 welcomMessage를 띄움
			out.println(welcomMessage);			// client한테 welcomMessage를 돌려줌
			
			// 서버 안 꺼지게 놔둠
			while(true) {
				in.readLine();
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("=====<<< 서버 종료 >>>=====");
		}
			
	}

}