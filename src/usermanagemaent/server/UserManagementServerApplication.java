package usermanagemaent.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class UserManagementServerApplication implements Runnable {

	private final static int PORT = 9090;
	private ServerSocket serverSocket;
	
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("============<< 서버 실행 >>============");
			
			socketConnection();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				serverSocket.close();
				System.out.println("============<< 서버 종료 >>============");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void socketConnection() throws IOException {
		while(true) {
			Socket socket = serverSocket.accept();
			SocketServer socketServer = new SocketServer(socket); // 방금 접속한 클라이언트를 SocketServer 객체에 전달해줌
			socketServer.start();
		}
	}
	
	public static void main(String[] args) {
		
		UserManagementServerApplication application = new UserManagementServerApplication();
		application.run();
		
	}
	
}
