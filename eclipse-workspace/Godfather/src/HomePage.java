import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

class HomePage extends Page{
		
	public HomePage(ScreenManager screenManager) {
		super(screenManager);
		
		JButton LogoLabel = new JButton("godfather");
		LogoLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				screenManager.showPage("admin");
			}
		});
		LogoLabel.setForeground(new Color(0,44,72));
		LogoLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		LogoLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		LogoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LogoLabel.setFont(new Font("Hollywood Hills", Font.PLAIN, 200));
		LogoLabel.setContentAreaFilled(false);
		LogoLabel.setRolloverEnabled(false);
		LogoLabel.setRequestFocusEnabled(false);
		LogoLabel.setBorderPainted(false);
		LogoLabel.setEnabled(true);
		LogoLabel.setFocusable(false);
		LogoLabel.setFocusTraversalKeysEnabled(false);
		LogoLabel.setFocusPainted(false);
		this.add(LogoLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Choose one pill. Choose wisely.");
		lblNewLabel_1.setForeground(new Color(0,44,72));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("OCR A Extended", Font.PLAIN, 30));
		this.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		this.add(panel_1, BorderLayout.CENTER);
		panel_1.setBackground(new Color(255,204,96));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setRequestFocusEnabled(false);
		lblNewLabel_3.setIcon(new ImageIcon(absolute_path + "/images/bluepill1.png"));
		lblNewLabel_3.setBounds((width/12)*8-30, (height/4)*2, 65, 62);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setRequestFocusEnabled(false);
		lblNewLabel_2.setBounds((width/12)*4-10, (height/4)*2, 65, 62);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(absolute_path + "/images/redpill1.png"));
		
		JButton button = new JButton("11");
		button.setContentAreaFilled(false);
		button.setRolloverEnabled(false);
		button.setRequestFocusEnabled(false);
		button.setBorderPainted(false);
		button.setEnabled(true);
		button.setFocusable(false);
		button.setFocusTraversalKeysEnabled(false);
		button.setFocusPainted(false);
		button.setFont(new Font("Hollywood Hills", Font.PLAIN, 30));
		button.setForeground(new Color(0, 44, 72));
		button.setBackground(new Color(0, 255, 0, 0));
		button.setBounds((width/12)*8-50, (height/4)*2, 98, 183);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setGrade11th();
				screenManager.showPage("store");
			}
		});
		panel_1.add(button);
		
		
		JButton btnNewButton = new JButton("9");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setRolloverEnabled(false);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setEnabled(true);
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(new Color(0,44,72));
		btnNewButton.setBackground(new Color(0, 255, 0, 0));
		btnNewButton.setFont(new Font("Hollywood Hills", Font.PLAIN, 30));
		btnNewButton.setBounds((width/12)*4-10, (height/4)*2, 91, 183);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setGrade9th();
				screenManager.showPage("store");
			}
		});
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(absolute_path + "/images/left_hand.png"));
		lblNewLabel_4.setBounds((width/12)*4-90, (height/4)-80, 293, 357);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(absolute_path + "/images/right_hand.png"));
		lblNewLabel_5.setBounds((width/12)*8-150, (height/4)-80, 264, 357);
		panel_1.add(lblNewLabel_5);
		
		Timer tm = new Timer(1, new ActionListener() {
		    public void actionPerformed(ActionEvent e) { 
		    	panel_1.removeAll();
		    	lblNewLabel_3.setBounds((width/12)*7+100, (height/4)*2, 65, 62);
		    	panel_1.add(lblNewLabel_3);
		    	lblNewLabel_2.setBounds((width/12)*4, (height/4)*2, 65, 62);
		    	panel_1.add(lblNewLabel_2);
		    	button.setBounds((width/12)*7+60, (height/4)*2, 98, 183);
		    	panel_1.add(button);
		    	btnNewButton.setBounds((width/12)*4, (height/4)*2, 91, 183);
		    	panel_1.add(btnNewButton);
		    	lblNewLabel_4.setBounds((width/12)*4-80, (height/4)-80, 293, 357);
		    	panel_1.add(lblNewLabel_4);
		    	lblNewLabel_5.setBounds((width/12)*7, (height/4)-80, 264, 357);
		    	panel_1.add(lblNewLabel_5);
		    	panel_1.revalidate();
		    	panel_1.repaint();
		    }
		});
		
		tm.start();
	}
	
	private void setGrade9th() {
		screenManager.store.setGrade(new Grade9th());
	}
	
	private void setGrade11th() {
		screenManager.store.setGrade(new Grade11th());
	}
	
}