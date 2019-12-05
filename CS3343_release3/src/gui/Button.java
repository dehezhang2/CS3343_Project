package gui;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton{
	private static final Font FONT_STYLE = new Font("acefont-family", Font.BOLD, 20);
	private static final int BUTTON_WIDTH = 180;
	private static final int BUTTON_HEIGHT = 40;
	
	public Button(String name, Font font, int x, int y, int height, int width ) {
		super(name);
		this.setFont(font);
		this.setBounds(x, y, width, height);
	}
	
	public Button(String name, int x, int y) {
		super(name);
		this.setFont(FONT_STYLE);
		this.setBounds(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
	}
	
	public void bind(ButtonBindable binded_obj) {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				binded_obj.refresh();
				binded_obj.display();
			}
		});
	}
	
}
