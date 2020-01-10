import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class AdminPanelPage extends Page{
	String name = "";
	
	public AdminPanelPage(ScreenManager screenManager) {
		super(screenManager);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(new Color(255,204,96));
		splitPane.setBorder(new EmptyBorder(20, 10, 0, 0));
		splitPane.setDividerSize(0);
		this.add(splitPane, BorderLayout.NORTH);
		
		JButton BackButton = new JButton("<< Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				screenManager.showPage("home");
			}
		});
		
		BackButton.setFocusable(false);
		BackButton.setFocusTraversalKeysEnabled(false);
		BackButton.setFocusPainted(false);
		BackButton.setBackground(new Color(255,204,96));
		BackButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		BackButton.setFont(new Font("Consolas", Font.BOLD, 32));
		BackButton.setHorizontalAlignment(SwingConstants.LEFT);
		splitPane.setLeftComponent(BackButton);
		
		JLabel NewLabel = new JLabel("");
		splitPane.setRightComponent(NewLabel);
		
		File databse_folder = new File("databases");
		String[] databases = databse_folder.list();
		
		JTree tree = new JTree();
		tree.setFocusable(false);
		tree.setBorder(new EmptyBorder(100, 30, 0, 0));
		tree.setBackground(new Color(255,204,96));
		tree.setModel(new DefaultTreeModel(
				new DefaultMutableTreeNode("databases") {
					{
						for( String database:databases ) {
							add(new DefaultMutableTreeNode(database));
						}

					}
				}
			));
			tree.addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode selectedNode = 
				    (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

				    Object nodeInfo = selectedNode.getUserObject();

				    name = nodeInfo.toString();
				}
			});

		this.add(tree, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(50, (int)(width/3.5), 50,  (int)(height/3.5)));
		panel.setPreferredSize(new Dimension(500, 500));
		panel.setMaximumSize(new Dimension(500, 500));
		panel.setBackground(new Color(255,204,96));
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		this.add(panel, BorderLayout.CENTER);
		
		JSplitPane splitPane1 = new JSplitPane();
		splitPane1.setPreferredSize(new Dimension(100, 100));
		splitPane1.setMaximumSize(new Dimension(100, 100));
		splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane1.setBackground(new Color(255,204,96));
		splitPane1.setDividerSize(0);
		splitPane1.setBorder(new EmptyBorder(0, 0, 20, 0));
		
		JSplitPane splitPane2 = new JSplitPane();
		splitPane2.setPreferredSize(new Dimension(100, 100));
		splitPane2.setMaximumSize(new Dimension(100, 100));
		splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane2.setBackground(new Color(255,204,96));
		splitPane2.setDividerSize(0);
		splitPane2.setBorder(new EmptyBorder(0, 0, 20, 0));
		
		JSplitPane splitPane3 = new JSplitPane();
		splitPane3.setPreferredSize(new Dimension(100, 100));
		splitPane3.setMaximumSize(new Dimension(100, 100));
		splitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane3.setBackground(new Color(255,204,96));
		splitPane3.setDividerSize(0);
		splitPane3.setBorder(new EmptyBorder(0, 0, 20, 0));
		
		JLabel taskLabel1 = new JLabel("Task 1");
		taskLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		taskLabel1.setFont(new Font("OCR A Extended", Font.PLAIN, 32));
		taskLabel1.setForeground(new Color(0,44,72));
		splitPane1.setLeftComponent(taskLabel1);
		taskLabel1.setBorder(new EmptyBorder(0, 0, 20, 0));
		
		JTextArea textArea1 = new JTextArea();
		textArea1.addKeyListener(new myKeyListener());
		textArea1.setMaximumSize(new Dimension(30, 30));
		textArea1.setBackground(Color.WHITE);
		splitPane1.setRightComponent(textArea1);
		
		JLabel taskLabel2 = new JLabel("Task 2");
		taskLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		taskLabel2.setFont(new Font("OCR A Extended", Font.PLAIN, 32));
		taskLabel2.setForeground(new Color(0,44,72));
		splitPane2.setLeftComponent(taskLabel2);
		taskLabel2.setBorder(new EmptyBorder(0, 0, 20, 0));
		
		JTextArea textArea2 = new JTextArea();
		textArea2.addKeyListener(new myKeyListener());
		textArea2.setMaximumSize(new Dimension(30, 30));
		textArea2.setBackground(Color.WHITE);
		splitPane2.setRightComponent(textArea2);
		
		JLabel taskLabel3 = new JLabel("Task 3");
		taskLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		taskLabel3.setFont(new Font("OCR A Extended", Font.PLAIN, 32));
		taskLabel3.setForeground(new Color(0,44,72));
		taskLabel3.setBorder(new EmptyBorder(0, 0, 20, 0));
		splitPane3.setLeftComponent(taskLabel3);
		
		//***
		class myLabel extends JLabel{			
			private myLabel(String str) {
				setText(str);
				setFont(new Font("OCR A Extended", Font.PLAIN, 16));
				setForeground(new Color(0,44,72));
				setHorizontalAlignment(SwingConstants.CENTER);
			}
			
		}
		class myTextArea extends JTextArea{			
			private myTextArea() {
				setBackground(Color.WHITE);
			}
			
		}
		
		JPanel littlePanel = new JPanel();
		littlePanel.setBorder(null);
		littlePanel.setBackground(new Color(255,204,96));
		littlePanel.setLayout(new GridLayout(5, 1, 0, 10));
		splitPane3.setRightComponent(littlePanel);
		
		JSplitPane splitTitle = new JSplitPane();
		splitTitle.setBorder(null);
		splitTitle.setBackground(new Color(255,204,96));
		splitTitle.setDividerSize(0);
		splitTitle.setLeftComponent(new myLabel("Title"));
		myTextArea titleArea = new myTextArea();
		titleArea.addKeyListener(new myKeyListener());
		splitTitle.setRightComponent(titleArea);
		
		
		JSplitPane splitFirst = new JSplitPane();
		splitFirst.setBorder(null);
		splitFirst.setBackground(new Color(255,204,96));
		splitFirst.setDividerSize(0);
		splitFirst.setLeftComponent(new myLabel("  �  "));
		myTextArea firstArea = new myTextArea();
		firstArea.addKeyListener(new myKeyListener());
		splitFirst.setRightComponent(firstArea);
		
		JSplitPane splitSecond = new JSplitPane();
		splitSecond.setBorder(null);
		splitSecond.setBackground(new Color(255,204,96));
		splitSecond.setDividerSize(0);
		splitSecond.setLeftComponent(new myLabel("  �  "));
		myTextArea secondArea = new myTextArea();
		secondArea.addKeyListener(new myKeyListener());
		splitSecond.setRightComponent(secondArea);
		
		JSplitPane splitThird = new JSplitPane();
		splitThird.setBorder(null);
		splitThird.setBackground(new Color(255,204,96));
		splitThird.setDividerSize(0);
		splitThird.setLeftComponent(new myLabel("  �  "));
		myTextArea thirdArea = new myTextArea();
		thirdArea.addKeyListener(new myKeyListener());
		splitThird.setRightComponent(thirdArea);
		
		JSplitPane splitForth = new JSplitPane();
		splitForth.setBorder(null);
		splitForth.setBackground(new Color(255,204,96));
		splitForth.setDividerSize(0);
		splitForth.setLeftComponent(new myLabel("  �  "));
		myTextArea forthArea = new myTextArea();
		forthArea.addKeyListener(new myKeyListener());
		splitForth.setRightComponent(forthArea);
		
		littlePanel.add(splitTitle);
		littlePanel.add(splitFirst);
		littlePanel.add(splitSecond);
		littlePanel.add(splitThird);
		littlePanel.add(splitForth);
		
		//***
		
		panel.add(splitPane1);
		panel.add(splitPane2);
		panel.add(splitPane3);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "You forget to choose database!","Adding problem",JOptionPane.ERROR_MESSAGE);
				}
				else if(!textArea1.getText().equals("") && !textArea2.getText().equals("") && !titleArea.equals("")) {
					variantModel variant = new variantModel();
					variant.tasks[0] = textArea1.getText();
					variant.tasks[1] = textArea2.getText() + ".mp3";
					variant.tasks[2] = titleArea.getText() + "+" + "<ul><li>" + firstArea.getText() + ";</li><li>" + secondArea.getText() + ";</li><li>" + thirdArea.getText() + ";</li><li>" + forthArea.getText() + ";</li></ul>";
					DBmanager db = new DBmanager();
					db.addSource(absolute_path + "/databases/" + name, variant.createJSONObject());
					textArea1.setText("");
					textArea2.setText("");
					titleArea.setText("");
					firstArea.setText("");
					secondArea.setText("");
					thirdArea.setText("");
					forthArea.setText("");
				}else {JOptionPane.showMessageDialog(null, "You didn't type something!","Adding problem",JOptionPane.ERROR_MESSAGE);}
			}
		});
		SubmitButton.setContentAreaFilled(false);
		SubmitButton.setFocusable(false);
		SubmitButton.setBorder(null);
		SubmitButton.setFocusTraversalKeysEnabled(false);
		SubmitButton.setFocusPainted(false);
		SubmitButton.setBackground(new Color(255,204,96));
		SubmitButton.setFont(new Font("Consolas", Font.BOLD, 32));
		SubmitButton.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(SubmitButton);		
	}

}
