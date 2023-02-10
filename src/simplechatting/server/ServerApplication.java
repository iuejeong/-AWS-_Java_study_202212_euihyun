package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
class ConnectedSocket extends Thread {
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private String username;
	
	public ConnectedSocket(Socket socket){
		this.socket = socket;
		socketList.add(this);
	}
	
	@Override
	public void run() {
		
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);	// 클라이언트한테 줄 수 있는 "통로"를 열어줌
			out.println("join");		//클라이언트한테 join이라는 값을 준다.
			
			inputStream = socket.getInputStream();		// 클라이언트한테 받을 수 있는 "통로"를 열어줌
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));		// 서버한테 값을 받는다
			
			username = in.readLine();		// 받은 값을 변수에 넣는다.
			System.out.println(username + "님이 접속하였습니다.");	// server에 username + "님이 접속하였습니다."를 띄움
			
			String userListStr = "";
			
			for(int i = 0; i < socketList.size(); i++) {
				userListStr += socketList.get(i).getUsername();
				if(i < socketList.size() - 1) {
					userListStr += ",";
				}
			}
			
			for(ConnectedSocket connectedSocket : socketList) {
				outputStream = connectedSocket.getSocket().getOutputStream();
				out = new PrintWriter(outputStream, true);
				// @welcome = 프로토콜, 프로토콜 : 컴퓨터끼리의 약속, 규율
				out.println("@welcome/" + username + "님이 접속하였습니다.");     // 모든 client한테 "@welcome/" + username + "님이 접속하였습니다."를 돌려줌
				out.println("@userList/" + userListStr);
			}
			
			
			
			// 서버 안 꺼지게 놔둠
			while(true) {
				String message = in.readLine();
				for(ConnectedSocket connectedSocket : socketList) {
					outputStream = connectedSocket.getSocket().getOutputStream();
					out = new PrintWriter(outputStream, true);
					out.println(message);		// 모두한테 보내줘야 한다.
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

public class ServerApplication {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("=====<<< 서버 실행 >>>=====");
			
			while(true) {
				// list에 넣어놔야 공통으로 쓸 수 있다. while 안에 넣을 경우 계속 새로 생성하게 된다. 그래서 while 바깥에 놔야 한다.
				Socket socket = serverSocket.accept(); // 클라이언트의 접속을 기다리는 녀석(accept 소켓을 리턴해줌!), 연결 버튼 누를 때까지 기다림.
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);
				connectedSocket.start();
				
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