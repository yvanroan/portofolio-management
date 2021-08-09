package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {

	FirstPanel fp = new FirstPanel();
	SecondPanel sp = new SecondPanel();
	MenuPanel mp = new MenuPanel();
	BossFirstPanel bfp = new BossFirstPanel();
	BossSecondPanel bsp = new BossSecondPanel();
	BossThirdPanel btp = new BossThirdPanel();
	
	private CardLayout cl = new CardLayout();
	String[] panels = {"firstP", "secondP", "menuP", "bossFirstP", "bossSecondP", "bossThirdP"};
	boolean update = true;
	private Image img;
	
	public MainFrame() {
		
		try {
			img = ImageIO.read(new File("mesImages/portfolio.jpg"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		this.setSize(1000, 740);
		this.setTitle("Portfolio Management");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(img);
//		this.setLayout(cl);
//		this.add(fp, panels[0]);
//		this.add(sp, panels[1]);
//		this.add(mp, panels[2]);
//		this.add(bfp, panels[3]);
//		this.add(bsp, panels[4]);
//		this.add(btp, panels[5]);
		this.setContentPane(mp);
		this.setVisible(true);
		
//		WhoisOpen();
	}
	
	public void WhoisOpen() {
		
		int i = 0;
		
		while (update) {
			
			if (fp.getState() == 1) {
				cl.show(this.getContentPane(), panels[1]);
			}
			if (fp.getState() == 2) {
				cl.show(this.getContentPane(), panels[3]);
			}
			if (fp.getState() == 3) {
				cl.show(this.getContentPane(), panels[4]);
			}
			if (bfp.getState() == 1) {
				cl.show(this.getContentPane(), panels[4]);
			}
			if (bsp.getState() == 1) {
				bsp.boss = btp.boss;
				btp.setState(1);
				cl.show(this.getContentPane(), panels[5]);
			}
			
			if (mp.getState() == 1) {
				update = false;
			}
			if (btp.getState() == 1) {
				update = false;
			}
			
			if (sp.getState() == 1) {
				mp.initComData(sp.com);
				mp.setState(1);
				cl.show(this.getContentPane(), panels[2]);
			}
			
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
//<>