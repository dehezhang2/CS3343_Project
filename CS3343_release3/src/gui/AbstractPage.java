package gui;

import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class AbstractPage extends JFrame{
	public AbstractPage() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
		this.setLayout(null);
	}
	
	protected abstract void renderContent();
	
	
}
