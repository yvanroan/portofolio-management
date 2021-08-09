package View;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SplashScreen extends JPanel {
	
	/**
	 * @author Yvanroan
	 */
	private static final long serialVersionUID = 1L;
	private Image img;
	
	public  SplashScreen() {
		try {
			img = ImageIO.read(new File("MesImages/portfolio.jpg"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
