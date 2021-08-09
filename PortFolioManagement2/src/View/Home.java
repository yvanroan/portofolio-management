package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Home extends JFrame {
	
	protected SplashScreen sps = new SplashScreen();
	protected JPanel pan = new JPanel();
	protected JProgressBar pgb = new JProgressBar(0, 100);
	
	public Home() {
		this.setSize(450, 380);
		this.setTitle("home");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pgb.setSize(500, 100);
		pgb.setForeground(new Color(48, 200, 48));
		pan.setBackground(new Color(0, 0, 0, 80));
		this.setContentPane(sps);
		sps.setLayout(new BorderLayout());
		sps.add(pan);
		sps.add(pgb, BorderLayout.SOUTH);
		this.setVisible(true);
		progress();
	}
	
	public void progress() {
		
		for(int i = 0; i <= 100; i++) {
			pgb.setValue(i);
			Random rand = new Random();
			int n = rand.nextInt(200);
			if (i == 100) {
				this.setVisible(false);
				MainFrame main = new MainFrame();
				main.setVisible(true);
			}
			pgb.repaint();
			
			try {
				Thread.sleep(n);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
//<>