package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Model.Boss;

public class BossThirdPanel extends JPanel {

	protected JPanel container, content, menu, mncpte, addcm, updatecm, consultcm, rdv, infoscm;
	protected JTextField com_namef, com_surnamef, com_passf, com_conpassf;
	protected Boss boss;
	protected JTabbedPane thumbnail;
	private String[] tabs = {"Mon compte", "Ajouter commercial", "Modifier commercial", "Consulter commercial", "Rendez-vous" ,"Infos commercial"};
	protected JPanel[] panels = {mncpte, addcm, updatecm, consultcm, rdv, infoscm};
	protected int state = 0;
	
	public BossThirdPanel() {

		this.setLayout(null);
		
		CreateImage Imgcreator = new CreateImage(1000, 400);
		Imgcreator.setImg(new ImageIcon("mesImages/boss_login.jpeg"));
		JLabel background = Imgcreator.generate();
		background.setBounds(0, 0, 1000, 200);
		background.setLayout(null);
		this.add(background);
		
		// profile image
		JPanel profile = new JPanel();
		profile.setPreferredSize(new Dimension(160, 160));
		profile.setBackground(new Color(0, 0, 0, 0));
		profile.setBounds(100, 30, 140, 140);
		profile.setLayout(new BorderLayout());
		background.add(profile);
		
		// profile items
		CreateImage ic = new CreateImage(1000, 400);
		ic.setImg(new ImageIcon("mesImages/profile.jpeg"));
		JLabel profile_img = ic.generate();
		JLabel profile_title = new JLabel("Lorem ipsum", JLabel.CENTER);
		profile_title.setForeground(Color.white);
		profile_title.setFont(new Font("Californian", Font.BOLD, 15));
		profile_title.setBorder(new EmptyBorder(5, 0, 0, 0));
		
		profile.add(profile_img, BorderLayout.CENTER);
		profile.add(profile_title, BorderLayout.SOUTH);
		
		// principal menu container
		container = new JPanel();
		container.setBounds(0, 200, 1000, 700);
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		// menu
		thumbnail = new JTabbedPane();
		thumbnail.setBounds(20, 0, 950, 485);
		thumbnail.setOpaque(false);
		thumbnail.setAutoscrolls(true);
		thumbnail.setBackground(Color.white);
		
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
			thumbnail.addTab(tabs[i], panels[i]);
		}
		
		container.add(thumbnail);
		this.add(container);
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
