import java.awt.CardLayout;

import javax.swing.JPanel;

public class ContentPane extends JPanel{
	
	public ContentPane() {
		setLayout(new CardLayout());
	}
	
	public void addPage(Page page, String pageName) {
		add(page, pageName);
	}
	
	public void showPage(String pageName) {
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, pageName);
	}

}
