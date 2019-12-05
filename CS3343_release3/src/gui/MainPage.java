package gui;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import score.ScoreBoard;

@SuppressWarnings("serial")
public class MainPage extends JFrame {
	
	private JLabel background;
	private Button start, score, setting;
	private SettingDialog dialog;
//	private ScoreDialog scoredialog;
	private ScoreBoard scoreboard;
	
	// Singleton
	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance() {
		return mainPage;
	}
	
	private MainPage() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
		this.setSize(650, 500);
		this.setLayout(null);
		
		this.scoreboard = new ScoreBoard();
		this.dialog = new SettingDialog(this);
		
		this.showBackground();
		this.showButton();
	}
	
	private void showBackground() {
		// TODO Auto-generated method stub
	 	ImageIcon background = new ImageIcon(getClass().getResource("/images/home.jpg"));
        this.background = new JLabel(background);
        this.background.setBounds(0, 0, getWidth(), getHeight());
        JPanel contentPanel = (JPanel)this.getContentPane();
        contentPanel.setOpaque(false);
        getLayeredPane().add(this.background, new Integer(Integer.MIN_VALUE));
	}
	
	private void showButton() {
		// TODO Auto-generated method stub
//		start = new JButton("Start");
//		start.setFont(new Font("acefont-family", Font.BOLD, 20));
//		start.setBounds(230, 150, 180, 40);
//		score = new JButton("Scores");
//		score.setFont(new Font("acefont-family", Font.BOLD, 20));
//		score.setBounds(230, 200, 180, 40);
//		setting = new JButton("Settings");
//     	setting.setFont(new Font("acefont-family", Font.BOLD, 20));
//	    setting.setBounds(230, 250, 180, 40);
		
		start = new Button("Start", 230, 150);
		PreGamePage pregamePage = new PreGamePage(this.dialog.getGame_size(), this);
		start.bind(pregamePage);
		
		score = new Button("Scores", 230, 200);
		this.scoreboard.showScoreBoard("data/1.txt");
		ScoreDialog scoredialog = new ScoreDialog(this.scoreboard.getScores(), this);
		score.bind(scoredialog);
		
		setting = new Button("Settings", 230, 250);
		setting.bind(this.dialog);
		
		this.add(start);
		this.add(score);
		this.add(setting);
	}
	
	public int getGamesize() {
		return this.dialog.getGame_size();
	}
	
//	private void adapter() {
//		// TODO Auto-generated method stub
//		start.addActionListener(this);
//		
//		score.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				scoreboard.showScoreBoard("data/1.txt");
//				Object[][] arr = scoreboard.getScores();
//				scoredialog = new ScoreDialog(arr, MainPage.getInstance());
//				scoredialog.setVisible(true);
//				scoredialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//			}
//		});
//			
//		setting.addActionListener(new ActionListener() {		
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				dialog.setVisible(true);
//				dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//			}
//		});
//		
//	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//
//		Point p = MainPage.getInstance().getLocation();
//		MainPage.getInstance().dispose();
//		
//		PreGamePage pregamePage = new PreGamePage(this.dialog.getGame_size(), MainPage.getInstance());
//		pregamePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pregamePage.setLayout(null);
//		pregamePage.setResizable(false);
//		pregamePage.setLocation(p);
//	}

}

