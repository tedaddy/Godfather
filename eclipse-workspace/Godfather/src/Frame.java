import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;

public class Frame extends JFrame{
	String absolute_path;
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int width = Double.valueOf(screenSize.getWidth()).intValue();
	static int height = Double.valueOf(screenSize.getHeight()).intValue();
	
	public Frame() {
		Path currentRelativePath = Paths.get("");
		String path = currentRelativePath.toAbsolutePath().toString();
		absolute_path = path.replaceAll("\\\\", "/");
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(absolute_path + "/fonts/HollyWoodHills.ttf")));
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(absolute_path + "/fonts/OCR.TTF")));
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(absolute_path + "/fonts/consolas.ttf")));
		} catch (IOException|FontFormatException e) {
		     System.out.println(e);
		}
		
		addKeyListener(new ExitKeyListener());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setUndecorated(true);
		setResizable(true);
		setBounds(0, 0, width, height);
		setVisible(true);
	}

}
