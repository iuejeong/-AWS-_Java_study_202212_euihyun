package j25_소켓.multiSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static final int PORT = 9090;
	
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);		// 서버를 연다.
			System.out.println("서버를 실행합니다.");
			
			while(true) {			// 클라이언트의 접속을 받는 무한 루프
				// 클라이언트의 접속을 기다린다
				Socket socket = serverSocket.accept();	
				
				// SocketServer객체에 클라이언트의 접속을 던져줌으로써 쓰레드를 받는다, 클라이언트가 접속하면 Socket 객체를 하나 생성, 방금 연결된 클라이언트와 1ㄷ1로만 소통한다.
				SocketServer socketServer = new SocketServer(socket);
				
				// 쓰레드 실행
				socketServer.start();		
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("서버를 종료합니다.");
		}
		
	}
	
}
