package j25_소켓;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {

	public static final int PORT = 9090;
	
	public static void main(String[] args) {		
		List<Socket> clients = new ArrayList<>();
		
		try {
			ServerSocket serverSocket = new ServerSocket(PORT); // 포트 번호로 서버를 여는 중
			
			while(true) {
				System.out.println("클라이언트의 접속을 기다리는 중입니다.");
				
				Socket socket = serverSocket.accept();				// 소켓 하나가 클라이언트를 생성해줌. 하나만 생성되기 때문에 무한루프
				clients.add(socket);
				
				System.out.println("클라이언트가 연결되었습니다.");
				System.out.println(clients);
				
				OutputStream outputStream = socket.getOutputStream();		// output -> 나가다 즉, 보내주다
				
				PrintWriter out = new PrintWriter(outputStream, true);		// PrintWriter -> 문자열을 전송할 때 사용
				out.println("___서버에 접속한 것을 환영합니다.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
