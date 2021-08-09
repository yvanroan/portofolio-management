package View;

import javax.swing.JFrame;

public class Frame extends JFrame{

	NewBoss b;
	public Frame() {
		b =new NewBoss();
		this.setSize(1000, 740);
		this.setTitle("Portfolio Management");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setContentPane(b);
		this.setVisible(true);
		
	}
}
