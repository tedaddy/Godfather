import java.awt.CardLayout;

import javax.swing.*;

public class ScreenManager {
	Frame frame;
	JPanel contentPane;
	
	public ScreenManager() {
		frame = new Frame();
		contentPane = new JPanel();
		contentPane.setLayout(new CardLayout());
	}
	
	public void getPage(String pageName) {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, pageName);
	}
}
