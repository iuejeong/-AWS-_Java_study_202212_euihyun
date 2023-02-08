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
	
	public static List<SocketServer> clientList = new ArrayList<>();	// SocketServer를 담는 공간, Socket들을 담은 list
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private static int autoIncrement = 1;
	private	String name; 
	
	public SocketServer(Socket socket) {		// 방금 연결된 소켓을 준다.
		this.socket = socket;
		name = "user" + autoIncrement++;
		clientList.add(this);
	}
	
	@Override
	public void run() {		// 실행이 되는 부분이기 때문에 서버의 기능을 하는 역할들을 넣어주면 된다.
		
		System.out.println("[연결된 클라이언트 정보: ]");
		System.out.println("IP: " + socket.getInetAddress());		// 실제 클라이언트 주소의 IP를 가져다 준다.
		
		try {
			inputStream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			sendToAll(name + "님이 접속하였습니다.");
			
			while(true) {
				String message = reader.readLine();		// message가 들어올 때까지 기다린다.
				if(message == null) {	// null이 들어왔다는 것은 통신이 끊겼다는 것. 이유는 message를 받았다는 것은 문자열로 들어왔기 때문에
					break;
				}
				sendToAll(message); 	// if가 걸리지 않으면 모든 사용자들에게 message를 전달함.
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				inputStream.close();	// 서버를 종료시킨다.
				outputStream.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	// BroadCasting : 모든 클라이언트에게 동시에 데이터를 쏴줄 때 사용
	private void sendToAll(String message) throws IOException {
		for(SocketServer socketServer : clientList) {
				outputStream = socketServer.socket.getOutputStream();
				PrintWriter writer = new PrintWriter(outputStream, true);
				writer.println(name + ": " + message);		// name : 방금 들어온 대상
				
		}
	}
}





















