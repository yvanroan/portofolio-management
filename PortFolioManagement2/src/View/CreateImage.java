package View;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CreateImage {
	
	private int scaleX, scaleY;
	private ImageIcon img;
	
	public CreateImage (int scaleX, int scaleY) {
		this.scaleX = scaleX;
		this.scaleY = scaleY;
	}
	
	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public JLabel generate() {
		Image Nimg = img.getImage();
		Image img_temp = Nimg.getScaledInstance(this.scaleX, this.scaleY, Image.SCALE_SMOOTH);
		img = new ImageIcon(img_temp);
		JLabel background = new JLabel("", img, JLabel.CENTER);
		
		return background;
	}
}
