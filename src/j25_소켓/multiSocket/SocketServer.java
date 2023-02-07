package j25_소켓.multiSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer extends Thread {
	
	public static List<SocketServer> clientList = new ArrayList<>();
	private Socket socket;
	private	String name; 
	
	public SocketServer(Socket socket) {
		this.socket = socket;
		clientList.add(this);
	}
	
	@Override
	public void run() {		// 실행이 되는 부분이기 때문에 서버의 기능을 하는 역할들을 넣어주면 된다.
		
		System.out.println("[연결된 클라이언트 정보: ]");
		System.out.println("IP: " + socket.getInetAddress());		// 실제 클라이언트 주소의 IP를 가져다 준다.
		
		try {
			InputStream inputStream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(outputStream, true);
			
			writer.println("서버에 접속 성공!");
			writer.println("사용자 이름을 입력하세요!");
			
			String message = null;
			boolean loginFlag = false;
			
			while((message = reader.readLine()) != null) {		// 상대방이 보낸 메세지
				if(name == null) {
					name = message;
					System.out.println("\n서버에 " + name + "님이 접속하였습니다.");
				}
				
				for(SocketServer s : clientList) {
					try {
						outputStream = s.socket.getOutputStream();
						writer = new PrintWriter(outputStream, true);
						
						if(!loginFlag) {
							writer.println("\n" + s.name + "님이 접속하였습니다.");
							loginFlag = true;
							continue;
						}
						
						writer.println("\n" + s.name + ": " + message);
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}





















