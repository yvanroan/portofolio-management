package View;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

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
		progress();
	}
	
	public void progress() {
		this.setVisible(true);
		for(int i = 0; i <= 100; i++) {
			pgb.setValue(i);
			Random rand = new Random();
			int n = rand.nextInt(200);
			if (i == 100) {
				this.setVisible(false);
				TheLayout main = new TheLayout();
				main.frame.setVisible(true);
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