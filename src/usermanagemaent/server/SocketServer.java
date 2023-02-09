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
		// 본인 멤버 변수에 받은 소켓을 넣어줌.
		// 클라이언트가 나올 때 마다 socket 서버를 생성해준다.
		this.socket = socket;
		gson = new Gson();
		// 소켓 서버들을 모다두는 리스트 생성
		socketServersList.add(this);
	}
	
	@Override
	public void run() {
		try {
			// 요청을 받는 녀석을 실행해준다.
			reciveRequest();
			
		} catch (IOException e) {
			// 클라이언트에서 먼저 종료를 했을 때.
			System.out.println(socket.getInetAddress() + " : " + socket.getPort() + " 클라이언트의 접속이 끊어졌습니다.");
		}
	}
	
	private void reciveRequest() throws IOException {
		inputStream = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		while(true) {
			// 클라이언트로부터 값을 받는 녀석
			String request = reader.readLine();
			// 연결이 끊김
			if(request == null) {
				// 강제로 예외 발생
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
				// object로 들어왔고, fromJson이 String이어야 하기 때문에 String으로 형변환을 해줘야 한다.
				ResponseDto<?> responseDto = AccountController.getInstance().register((String) requestDto.getBody()); 
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
		// response 던져준다
		writer.println(response);
		// 버퍼를 비운다.
		writer.flush();
	}
	
}



















