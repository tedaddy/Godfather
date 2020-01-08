import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class VariantStorePage extends Page{
	
	JPanel gridpanel = new JPanel();
	JButton[] cards;
	Grade grade;
	
	public VariantStorePage(int width, int height, ScreenManager screenManager, String absolute_path) {
		super(width, height, absolute_path);
		
		HomeButton homeButton = new HomeButton();

		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				screenManager.showPage("home");
			}
		});
		this.add(homeButton, BorderLayout.NORTH);
		
		gridpanel.setBorder(null);
		gridpanel.setBackground(new Color(255,204,96));	
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(gridpanel);
		
	}
	
	public void BuildGrid() {
		int count = grade.getCountOfVariants();
		cards = new JButton[count];
		gridpanel.removeAll();
		for( int i = 0; i < count; i++ ) {
			cards[i] = new Card();
			cards[i].setText("numb." + (i+1));
			gridpanel.add(cards[i]);
		}
	}

}
