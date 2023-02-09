package usermanagemaent.frame;

import java.awt.CardLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import usermanagemaent.dto.RequestDto;
import usermanagemaent.dto.ResponseDto;
import usermanagemaent.setvice.UserService;

public class UserManagemanetFrame extends JFrame {
	
	private static Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private BufferedReader reader;
	private PrintWriter writer;
	private Gson gson;
	
	private List<JTextField> loginFields;
	private List<JTextField> registerFields;
	
	
	private CardLayout mainCard;
	private JPanel mainPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField registerUsernameField;
	private JPasswordField registerPasswordField;
	private JTextField registerNameField;
	private JTextField registerEmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					socket = new Socket("127.0.0.1", 9090);
					
					
					UserManagemanetFrame frame = new UserManagemanetFrame();
					frame.setVisible(true);
				} catch (ConnectException e) {
					JOptionPane.showMessageDialog(null, "서버에 연결할 수 없습니다.",  "접속실패", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserManagemanetFrame() {
		try {
			inputStream = socket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream));
			outputStream = socket.getOutputStream();
			writer = new PrintWriter(outputStream, true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		gson = new Gson();
		
		loginFields = new ArrayList<>();
		registerFields = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		
		mainCard = new CardLayout();
		mainPanel.setLayout(mainCard);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setOpaque(false); 	
		
		mainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);
		
		JLabel logoText = new JLabel("User Management Login");
		logoText.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(29, 23, 332, 67);
		loginPanel.add(logoText);
		
		JLabel loginText = new JLabel("Login");
		loginText.setFont(new Font("D2Coding", Font.PLAIN, 25));
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setBounds(139, 79, 98, 35);
		loginPanel.add(loginText);
		
		usernameField = new JTextField();
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBounds(44, 184, 301, 26);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(44, 245, 301, 26);
		loginPanel.add(passwordField);
		
		JLabel usernameLabel = new JLabel("Username or email");
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setFont(new Font("D2Coding", Font.PLAIN, 12));
		usernameLabel.setBounds(44, 162, 133, 15);
		loginPanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("D2Coding", Font.PLAIN, 12));
		passwordLabel.setBounds(44, 220, 122, 15);
		loginPanel.add(passwordLabel);
		
		JButton loginButton = new JButton("Login");
		
//		MouseListener listener = new MouseAdapter() {
//		
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			
//		}
//			
//		}; 풀어쓴 것
		
		loginButton.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseClicked(MouseEvent e) {
				JsonObject loginUser = new JsonObject();
				loginUser.addProperty("usernameAndEmail", usernameField.getText());
				loginUser.addProperty("password", passwordField.getText()); // JsonText가 됨
				
				UserService userService = UserService.getInstance();
				
				Map<String, String> response = userService.authorize(loginUser.toString());
				
				if(response.containsKey("error")) {
					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE); // 처음은 null, 2,3번째는 메세지 내용, 4번째는 아이콘
					return;
				}
				
				JOptionPane.showMessageDialog(null, response.get("oK"), "oK", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		loginButton.setBackground(new Color(51, 204, 255));
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		loginButton.setBounds(44, 301, 301, 41);
		loginPanel.add(loginButton);
		
		JLabel signupDesc = new JLabel("Don't have an account?");
		signupDesc.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		signupDesc.setHorizontalAlignment(SwingConstants.LEFT);
		signupDesc.setBounds(92, 375, 138, 15);
		loginPanel.add(signupDesc);
		
		JLabel signupLink = new JLabel("Sign up");
		signupLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "registerPanel");
				clearFields(loginFields);
			}
		});
		signupLink.setForeground(new Color(204, 0, 102));
		signupLink.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 12));
		signupLink.setHorizontalAlignment(SwingConstants.LEFT);
		signupLink.setBounds(238, 375, 57, 15);
		loginPanel.add(signupLink);
		
		JLabel forgotPasswordLink = new JLabel("Forgot your password?");
		forgotPasswordLink.setForeground(new Color(204, 0, 51));
		forgotPasswordLink.setHorizontalAlignment(SwingConstants.LEFT);
		forgotPasswordLink.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 12));
		forgotPasswordLink.setBounds(124, 401, 138, 15);
		loginPanel.add(forgotPasswordLink);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(registerPanel, "registerPanel");
		registerPanel.setLayout(null);
		
		JLabel signinLink = new JLabel("Sign in");
		signinLink.setForeground(new Color(204, 0, 102));
		signinLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "loginPanel");
				clearFields(registerFields);
			}
		});
		signinLink.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 12));
		signinLink.setHorizontalAlignment(SwingConstants.CENTER);
		signinLink.setBounds(255, 412, 88, 29);
		registerPanel.add(signinLink);
		
		JLabel registerLogoText = new JLabel("User Management Login");
		registerLogoText.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogoText.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		registerLogoText.setBounds(29, 23, 332, 67);
		registerPanel.add(registerLogoText);
		
		registerUsernameField = new JTextField();
		registerUsernameField.setHorizontalAlignment(SwingConstants.CENTER);
		registerUsernameField.setColumns(10);
		registerUsernameField.setBounds(41, 146, 301, 26);
		registerPanel.add(registerUsernameField);
		
		JLabel registerPasswordLabel_1 = new JLabel("Password");
		registerPasswordLabel_1.setFont(new Font("D2Coding", Font.PLAIN, 12));
		registerPasswordLabel_1.setBounds(41, 182, 122, 15);
		registerPanel.add(registerPasswordLabel_1);
		
		JLabel registerUsername = new JLabel("Username");
		registerUsername.setHorizontalAlignment(SwingConstants.LEFT);
		registerUsername.setFont(new Font("D2Coding", Font.PLAIN, 12));
		registerUsername.setBounds(41, 124, 133, 15);
		registerPanel.add(registerUsername);
		
		registerPasswordField = new JPasswordField();
		registerPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		registerPasswordField.setBounds(41, 207, 301, 26);
		registerPanel.add(registerPasswordField);
		
		JLabel registerNameLabel = new JLabel("name");
		registerNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerNameLabel.setFont(new Font("D2Coding", Font.PLAIN, 12));
		registerNameLabel.setBounds(41, 245, 133, 15);
		registerPanel.add(registerNameLabel);
		
		registerNameField = new JTextField();
		registerNameField.setHorizontalAlignment(SwingConstants.CENTER);
		registerNameField.setColumns(10);
		registerNameField.setBounds(41, 267, 301, 26);
		registerPanel.add(registerNameField);
		
		JLabel registerEmailLabel = new JLabel("email");
		registerEmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerEmailLabel.setFont(new Font("D2Coding", Font.PLAIN, 12));
		registerEmailLabel.setBounds(41, 303, 133, 15);
		registerPanel.add(registerEmailLabel);
		
		registerEmailField = new JTextField();
		registerEmailField.setHorizontalAlignment(SwingConstants.CENTER);
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(41, 325, 301, 26);
		registerPanel.add(registerEmailField);
		
		JButton registerButton = new JButton("Register");
		
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JsonObject userJson = new JsonObject();
				userJson.addProperty("username", registerUsernameField.getText());
				userJson.addProperty("password", registerPasswordField.getText());
				userJson.addProperty("name", registerNameField.getText());
				userJson.addProperty("email", registerEmailField.getText());
				
				RequestDto<String> requestDto = new RequestDto<String>("register", userJson.toString());
				writer.println(gson.toJson(requestDto));	// 서버로의 요청
				writer.flush();
				
				try {
					String response = reader.readLine();
					System.out.println("응답 옴!");
					ResponseDto<?> responseDto = gson.fromJson(response, ResponseDto.class);
					
					if (responseDto.getCode().equals("error")) {
						JOptionPane.showMessageDialog(null, responseDto.getBody(), responseDto.getCode(),
								JOptionPane.ERROR_MESSAGE);
						return; // 클릭 메소드를 빠져나감
					}
					
					JOptionPane.showMessageDialog(null, responseDto.getBody(), responseDto.getCode(),
							JOptionPane.INFORMATION_MESSAGE);
					mainCard.show(mainPanel, "loginPanel");
					clearFields(registerFields);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
//				UserService userService = UserService.getInstance();
//				
//				Map<String, String> response = userService.register(userJson.toString());
//				
//				if(response.containsKey("error")) {
//					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
//					return;
//				}
//			
//				JOptionPane.showMessageDialog(null, response.get("OK"), "OK", JOptionPane.INFORMATION_MESSAGE);
//				mainCard.show(mainPanel, "loginPanel");
//				clearFields(registerFields);
			}
		});
		
		registerButton.setForeground(Color.BLACK);
		registerButton.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		registerButton.setBackground(new Color(51, 204, 255));
		registerButton.setBounds(41, 367, 301, 35);
		registerPanel.add(registerButton);
		
		JLabel registerLabel = new JLabel("Register");
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setFont(new Font("D2Coding", Font.PLAIN, 25));
		registerLabel.setBounds(143, 79, 111, 35);
		registerPanel.add(registerLabel);
		
		loginFields.add(usernameField);
		loginFields.add(passwordField);
		
		registerFields.add(registerUsernameField);
		registerFields.add(registerPasswordField);
		registerFields.add(registerNameField);
		registerFields.add(registerEmailField);
	}
	
	private void clearFields(List<JTextField> textFields) {
		for(JTextField field : textFields) {
			// 공백이라도 있으면 setText를 해라
			if(field.getText().isEmpty()) {
				continue;
			}
			field.setText("");
		}
	}
	
}















