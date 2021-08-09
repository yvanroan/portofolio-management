package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FirstPanel extends JPanel implements ActionListener {
	
	protected JPanel header, center, main;
	protected JButton bossbtn = new JButton("Gérant");
	protected JButton combtn = new JButton("Commercial");
	protected Font first_font;
	protected Font second_font;
	protected int state = 0;
	
	public FirstPanel() {
		
		first_font = new Font("Serif", Font.ITALIC, 24);
		second_font = new Font("Lucida calligraphy", Font.BOLD, 30);
		
		CreateImage Imgcreator = new CreateImage(1000, 740);
		Imgcreator.setImg(new ImageIcon("mesImages/bg.jpg"));
		JLabel background = Imgcreator.generate();
		background.setBounds(0, 0, 1000, 740);
		background.setLayout(null);
		
		center = new JPanel();
		center.setBackground(new Color(255, 255, 255, 0));
		center.setBounds(170, 220, 700, 170);
		center.setBorder(new EmptyBorder(5, 20, 20, 20));
		center.setLayout(new GridLayout(2, 1, 0, 20));
		
		
		JLabel label = new JLabel("Connectez-vous en tant que:  ", JLabel.CENTER);
		label.setForeground(Color.white);
		label.setFont(second_font);
		
		JPanel center1 = new JPanel();
		center1.setBackground(new Color(0, 0, 0, 0));
		center1.setLayout(new GridLayout(1, 2, 70, 0));
		
		bossbtn.setPreferredSize(new Dimension(70, 40));
		bossbtn.setForeground(Color.white);
		bossbtn.setFont(first_font);
		bossbtn.setBackground(new Color(66, 139, 202));
		bossbtn.addActionListener(this);
		
		combtn.setPreferredSize(new Dimension(700, 40));
		combtn.setForeground(Color.white);
		combtn.setFont(first_font);
		combtn.setBackground(new Color(66, 139, 202));
		combtn.addActionListener(this);
		
		center1.add(bossbtn);
		center1.add(combtn);
		
		center.add(label);
		center.add(center1);
		
		background.add(center, BorderLayout.CENTER);
		this.add(background);
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.bossbtn) {
			if (new BossFirstPanel().bossManager.exist()) {
				setState(3);
			}
			else {
				setState(2);
			}
		}
		
		if (e.getSource() == this.combtn) {
			setState(1);
		}
	}
}
