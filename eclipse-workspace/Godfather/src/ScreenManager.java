import java.awt.CardLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class ScreenManager {
	Frame frame  = new Frame();
	ContentPane contentPane = new ContentPane();
	HomePage home = new HomePage(frame.width, frame.height, this, frame.absolute_path);
	AdminPanelPage admin = new AdminPanelPage(frame.width, frame.height, this, frame.absolute_path);
	VariantStorePage store = new VariantStorePage(frame.width, frame.height, this, frame.absolute_path);
	
	public ScreenManager() {
	
		frame.setContentPane(contentPane);
		
		contentPane.addPage(home, "home");
		contentPane.addPage(admin, "admin");
		contentPane.addPage(store, "store");
	}
	
	public void showPage(String pageName) {
		contentPane.showPage(pageName);
	}
	
	public void setGrade9th() {
		Grade9th grade9 = new Grade9th();
		store.grade = new Grade9th();
		store.BuildGrid();
	}
	
	public void setGrade11th() {
		Grade11th grade11 = new Grade11th();
		store.grade = new Grade9th();
		store.BuildGrid();
	}
}
