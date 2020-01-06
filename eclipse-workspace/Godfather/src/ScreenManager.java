import java.awt.CardLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class ScreenManager {
	Frame frame;
	JPanel contentPane;
	
	String ABSOLUTE_PATH;
	
	public ScreenManager(String path) {
		this.ABSOLUTE_PATH = path;
		
		frame = new Frame();
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout());
		
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(ABSOLUTE_PATH + "/fonts/HollyWoodHills.ttf")));
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(ABSOLUTE_PATH + "/fonts/OCR.TTF")));
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(ABSOLUTE_PATH + "/fonts/consolas.ttf")));
		} catch (IOException|FontFormatException e) {
		     System.out.println(e);
		}
		
		MainPage mainPage = new MainPage(frame.width, frame.height, this);
		
		contentPane.add(mainPage, "main page");
		
	}
	
	public void getPage(String pageName) {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, pageName);
	}
}
