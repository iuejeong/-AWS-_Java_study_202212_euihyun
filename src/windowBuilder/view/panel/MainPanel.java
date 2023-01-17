package windowBuilder.view.panel;

import java.awt.CardLayout;

import lombok.Data;

@Data
public class MainPanel extends InitPanel {
	
	private static final long serialVersionUID = 1L;

	private CardLayout mainCard;

	private static MainPanel instance;
	
	public static MainPanel getInstance() {
		if(instance == null) {
			instance = new MainPanel();
		}
		return instance;
	}
	
	private MainPanel() {
		// bounds -> x,y축 너비, 높이 다 설정
		// size -> 가로 세로만
		mainCard = new CardLayout();
		setLayout(mainCard);
	}
	
	public void init() {
		LoginPanel loginPanel = new LoginPanel();
		add(loginPanel, "loginPanel");
		
		RegisterPanel registerPanel = new RegisterPanel();
		add(registerPanel, "registerPanel");
	}
	
	
}
