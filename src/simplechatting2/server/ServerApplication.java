package simplechatting2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import lombok.Data;
import simplechatting2.client.ChattingClient;
import simplechatting2.dto.JoinReqDto;
import simplechatting2.dto.JoinRespDto;
import simplechatting2.dto.MessageReqDto;
import simplechatting2.dto.MessageRespDto;
import simplechatting2.dto.RequestDto;
import simplechatting2.dto.ResponseDto;

@Data
class ConnectedSocket extends Thread {
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Gson gson;
	
	private String username;
	
	public ConnectedSocket(Socket socket){
		this.socket = socket;
		gson = new Gson();
		socketList.add(this);
	}
	
	// server가 client한테 받을 땐 Request.
	// server가 client한테 보낼 땐 Response.
	// 이런 과정을 "인터페이스"라고 한다. 요청과 응답에 관한 것이기 때문이다.
	// 서로 text만 보낼 수 있기 때문에 JSON으로 왔다갔다 해야 한다.
	
	@Override
	public void run() {
		
		try {
			inputStream = socket.getInputStream();		// 클라이언트한테 받을 수 있는 "통로"를 열어줌
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));		// 서버한테 값을 받는다
			
			while(true) {
				String request = in.readLine();		// requestDto(JSON), 연결이 되고 요청이 들어온다
				RequestDto requestDto = gson.fromJson(request, RequestDto.class);
				
				switch(requestDto.getResource()) {
					case "join": 
							JoinReqDto joinReqDto = gson.fromJson(requestDto.getBody(), JoinReqDto.class);
							username = joinReqDto.getUsername();
							List<String> connectedUsers = new ArrayList<>();
							for(ConnectedSocket connectedSocket : socketList) {
								connectedUsers.add(connectedSocket.getUsername());
							}
							JoinRespDto joinRespDto = new JoinRespDto(username + "님이 접속하였습니다.", connectedUsers);
							System.out.println(joinRespDto);
							
							sendToAll(requestDto.getResource(), "ok", gson.toJson(joinRespDto));
							break;		// join일 때만 실행이 되기 때문에 case가 끝나면 break를 걸어준다.
					case "sendMessage":
						MessageReqDto messageReqDto = gson.fromJson(requestDto.getBody(), MessageReqDto.class);
						
						if(messageReqDto.getToUser().equalsIgnoreCase("all")) {
							String message = messageReqDto.getFromUser() + "[전체]: " + messageReqDto.getMessageValue();
							MessageRespDto messageRespDto = new MessageRespDto(message);
							sendToAll(requestDto.getResource(), "ok", gson.toJson(messageRespDto));
						}else {
							String message = messageReqDto.getFromUser() + "[" + messageReqDto.getToUser() + "]: " + messageReqDto.getMessageValue();
							MessageRespDto messageRespDto = new MessageRespDto(message);
							sendToUser(requestDto.getResource(), "ok", gson.toJson(messageRespDto), messageReqDto.getToUser());
						}
						
						break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}
	
	// 프로그램이 실행될 때 마다 만들어진 각각의 Client들한테 보내준다.
	private void sendToAll(String resource, String status, String body) throws IOException {
		ResponseDto responseDto = new ResponseDto(resource, status, body);
		
		for(ConnectedSocket connectedSocket : socketList) {
			OutputStream outputStream = connectedSocket.getSocket().getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			out.println(gson.toJson(responseDto));
		}
	}
	
	private void sendToUser(String resource, String status, String body, String toUser) throws IOException {
		ResponseDto responseDto = new ResponseDto(resource, status, body);
		for(ConnectedSocket connectedSocket : socketList) {
			if(connectedSocket.getUsername().equals(toUser) || connectedSocket.getUsername().equals(username)) {		// Map을 쓰면 효율적이다. Key값으로 username을 넣는다
				OutputStream outputStream = connectedSocket.getSocket().getOutputStream();
				PrintWriter out = new PrintWriter(outputStream, true);
				
				out.println(gson.toJson(responseDto));
				// break;를 하면 둘 중에 하나만 찾기 때문에 한 명한테만 간다.
			}
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