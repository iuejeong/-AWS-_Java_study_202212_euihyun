package usermanagemaent.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import usermanagemaent.dto.RequestDto;
import usermanagemaent.dto.ResponseDto;
import usermanagemaent.entity.User;
import usermanagemaent.server.controller.AccountController;

public class SocketServer extends Thread {

	private static List<SocketServer> socketServersList = new ArrayList<>();
	
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Gson gson;
	
	public SocketServer(Socket socket) {
		this.socket = socket;
		gson = new Gson();
		socketServersList.add(this);
	}
	
	@Override
	public void run() {
		try {
			reciveRequest();
			
		} catch (IOException e) {
			System.out.println(socket.getInetAddress() + " : " + socket.getPort() + " 클라이언트의 접속이 끊어졌습니다.");
		}
	}
	
	private void reciveRequest() throws IOException {
		inputStream = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		while(true) {
			String request = reader.readLine();
			if(request == null) {
				throw new ConnectException();
			}
			
			RequestMapping(request);
		}
	}
	
	private void RequestMapping(String request) throws IOException {		// Json 형식으로 들어온다.
		RequestDto<?> requestDto = gson.fromJson(request, RequestDto.class);		// 와일드카드이기 때문에 object로 들어온다
		String resource = requestDto.getResource();
		switch (resource) {		// resource에 들어오는 값에 따라 회원가입이든, 로그인이든, 채팅이든 case에 맞게 들어간다
			case "register":
				User user = gson.fromJson((String)requestDto.getBody(), User.class);	// object로 들어왔고, fromJson이 String이어야 하기 때문에 String으로 형변환을 해줘야 한다.
				ResponseDto<?> responseDto = AccountController.getInstance().register(user);
				sendResponse(responseDto);
				break;
			default:
				System.out.println("해당 요청은 처리할 수 없습니다.(404)");
				break;
		}
	}
	
	private void sendResponse(ResponseDto<?> responseDto) throws IOException {
		String response = gson.toJson(responseDto);
		outputStream = socket.getOutputStream();
		PrintWriter writer = new PrintWriter(outputStream, true);
		writer.println(response);
		writer.flush();
	}
	
}



















