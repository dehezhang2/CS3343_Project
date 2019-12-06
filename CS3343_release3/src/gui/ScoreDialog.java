package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import score.ScoreBoard;

@SuppressWarnings("serial")
public class ScoreDialog extends JDialog implements ButtonBindable{
	/**
	 * 
	 */
	private static final String[] columnNames = {"Name", "Score", "Time"};
	private JFrame father;
	
	public ScoreDialog(JFrame f) {
		super(f, true);

		setTitle("ScoreBoard");
		setSize(400,400);
		
		this.father = f;
		renderTable(this.getContentPane());
		setVisible(false);
	}

	private void renderTable(Container panel) {
		ScoreBoard scoreboard = ScoreBoard.getInstance();
		JTable scoretable = new JTable(scoreboard.getScores("data/1.txt"), columnNames);
		panel.add(new JScrollPane(scoretable));
		scoretable.setEnabled(false);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		this.renderTable(this.getContentPane());
		setBounds(this.father.getBounds().x+75, this.father.getBounds().y+75, 500, 350);
	}
	
	
}
