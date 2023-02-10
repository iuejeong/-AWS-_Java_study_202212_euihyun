package simplechatting.client;

import java.awt.EventQueue;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChattingClient extends JFrame {
	
	private Socket socket;
	private String username;
	
	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	private JTextField messageInput;
	private JList userlist;
	private DefaultListModel<String> userListModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = new ChattingClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChattingClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ipInput = new JTextField();
		ipInput.setText("127.0.0.1");
		ipInput.setBounds(533, 10, 109, 28);
		contentPane.add(ipInput);
		ipInput.setColumns(10);
		
		portInput = new JTextField();
		portInput.setText("9090");
		portInput.setBounds(648, 10, 61, 28);
		contentPane.add(portInput);
		portInput.setColumns(10);
		
		JButton connectButton = new JButton("연결");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;
				
				ip = ipInput.getText();
				port = Integer.parseInt(portInput.getText());
				
				try {
					socket = new Socket(ip, port);		// 클라이언트가 ip와 port를 생성하면서 접속을 하겠다.
					
					JOptionPane.showMessageDialog(null,
							socket.getInetAddress() + "서버 접속", 
							"접속 성공", 
							JOptionPane.INFORMATION_MESSAGE);
					
					InputStream inputStream = socket.getInputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));		// 서버한테 받을 수 있는 "통로"를 열어줌
					
					if(in.readLine().equals("join")) {		// 받은값이 join인지 확인
						username = JOptionPane.showInputDialog(null, "사용자 이름을 입력하세요.", JOptionPane.INFORMATION_MESSAGE);		
						
						OutputStream outputStream = socket.getOutputStream();		
						PrintWriter out = new PrintWriter(outputStream, true);		// 서버한테 줄 수 있는 "통로"를 열어줌
						
						out.println(username);
//						String welcomMessage = in.readLine();		// 서버가 준 걸 변수에 담는다.
//						contentView.append(welcomMessage);			// append -> 덧붙여서 쌓다, contentView에 받은 메시지를 담는다.
					}
					
					Thread thread = new Thread(() -> {
						try {
							InputStream input = socket.getInputStream();
							BufferedReader reader = new BufferedReader(new InputStreamReader(input));
							
							while(true) {
								String message = reader.readLine();
								if(message.startsWith("@welcome")) {
									int tokenIndex = message.indexOf("/");
									// substring : 해당 문자열에서 index 위치까지 잘라줌. tokenIndex에 ,를 찍을 경우 endIndex "전"까지 잘라준다.
									message = message.substring(tokenIndex + 1);
								} else if (message.startsWith("@userList")) {
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
									String[] usernames = message.split(",");
									userListModel.clear();
									for(String username : usernames) {
										userListModel.addElement(username);			// addElement : index가 자동 증가
									}
									continue;
								}
								contentView.append(message + "\n");
								messageInput.setText("");
							}
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					});
					
					thread.start();
					
				} catch (ConnectException e1) {
					
					JOptionPane.showMessageDialog(null,
							"서버 접속 실패", 
							"접속 실패", 
							JOptionPane.ERROR_MESSAGE);
					
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		connectButton.setBounds(715, 7, 61, 32);
		contentPane.add(connectButton);
		
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 10, 509, 341);
		contentPane.add(contentScroll);
		
		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);
		
		JScrollPane userListScroll = new JScrollPane();
		userListScroll.setBounds(533, 48, 243, 303);
		contentPane.add(userListScroll);
		
		userListModel = new DefaultListModel<>();
		userlist = new JList(userListModel);
		userListScroll.setViewportView(userlist);
		
		
		
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 374, 684, 43);
		contentPane.add(messageScroll);
		
		messageInput = new JTextField();
		messageInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					if(!messageInput.getText().isBlank()) {
						try {
							OutputStream outputStream = socket.getOutputStream();
							PrintWriter out = new PrintWriter(outputStream, true);
							
							out.println(username + ": " + messageInput.getText());
							messageInput.setText("");
							
					
					} catch (IOException e1) {
						e1.printStackTrace();
						}
					}
				}
			}
		});
		messageScroll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!messageInput.getText().isBlank()) {
					try {
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);
						
						out.println(username + ": " + messageInput.getText());
						messageInput.setText("");
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
					}
				}
			}
		});
		sendButton.setBounds(708, 374, 68, 43);
		contentPane.add(sendButton);
	}
}
