package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Model.Boss;

public class NewBoss extends JPanel {

	protected JPanel container, content, menu, mncpte, addcm, updatecm, consultcm, rdv, infoscm;
	protected JTextField com_name, com_surname, com_adr, com_tel,com_id;
	protected Boss boss;
	private Color menuBg = new Color(184, 207, 229);
	protected JTabbedPane thumbnail;
	private String[] tabs = {"Mon compte", "Ajouter commercial", "Modifier commercial", "Consulter commercial", "Rendez-vous" ,"Infos commercial"};
	protected JPanel[] panels = {mncpte, addcm, updatecm, consultcm, rdv, infoscm};
	protected int state = 0;
	private JButton edit;
	
	public NewBoss() {

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
		
//		initialisation des sous-panel
		mncpte = new JPanel();
		mncpte.setBackground(menuBg);
		addcm = new JPanel();
		addcm.setBackground(menuBg);
		updatecm = new JPanel();
		updatecm.setBackground(menuBg);
		consultcm = new JPanel();
		consultcm.setBackground(menuBg);
		rdv = new JPanel();
		rdv.setBackground(menuBg);
		infoscm = new JPanel();
		infoscm.setBackground(menuBg);
		
		
//		mon compte
		
		mncpte.setLayout(null);
		
//		JPanel lab_panel = new JPanel();
//		lab_panel.setBackground(null);
//		lab_panel.setBounds(5, 10, 300, 50);
//		JLabel label = new JLabel("Editer votre photo de profile");
//		label.setFont(new Font("Serif", Font.BOLD, 19));
//		lab_panel.add(label);
//		
//		JPanel profile_part = new JPanel();
//		profile_part.setLayout(new BorderLayout());
//		profile_part.setBackground(null);
//		profile_part.setBounds(80, 80, 140, 140);
//		profile_part.add(prof_img, BorderLayout.CENTER);
//		
//		edit = new JButton("Editer");
//		edit.setBounds(100, 250, 100, 30);
		
		
		//mncpte.add(edit);
		
		JPanel update = new JPanel();
		update.setBackground(null);
		update.setLayout(null);
		update.setBounds(230, 0, 950, 485);
		
		JLabel l = new JLabel("Vos informations personnelles ", JLabel.CENTER);
		l.setFont(new Font("Serif", Font.BOLD, 21));
		l.setBounds(50, 0, 400, 50);
		
		JPanel form = new JPanel();
		form.setBackground(null);
		form.setBorder(new EmptyBorder(20, 10, 20, 10));
		form.setLayout(new GridLayout(5, 2, 7, 30));
		form.setBounds(0, 55, 500, 300);
		
		// fonts
		
		Font labelFont = new Font("Californian FB", Font.BOLD, 18);
		Font fieldFont = new Font("Serif", Font.BOLD, 19);
		
		// labels
		
		JLabel name = new JLabel("Nom: ", JLabel.CENTER);
		name.setForeground(Color.black);
		name.setFont(labelFont);
		JLabel surname = new JLabel("Prénom: ", JLabel.CENTER);
		surname.setForeground(Color.black);
		surname.setFont(labelFont);
		JLabel phone = new JLabel("N° téléphone: ", JLabel.CENTER);
		phone.setForeground(Color.black);
		phone.setFont(labelFont);
		JLabel adr = new JLabel("Addresse : ", JLabel.CENTER);
		adr.setForeground(Color.black);
		adr.setFont(labelFont);
		JLabel poste = new JLabel("Poste : ", JLabel.CENTER);
		poste.setForeground(Color.black);
		poste.setFont(labelFont);
		
		

		
		//a remplacer par les infos de la bd
		
		JLabel nom = new JLabel("bd ", JLabel.CENTER);
		nom.setForeground(Color.black);
		nom.setFont(labelFont);
		JLabel surnom = new JLabel("bd ", JLabel.CENTER);
		surnom.setForeground(Color.black);
		surnom.setFont(labelFont);
		JLabel tel = new JLabel("bd ", JLabel.CENTER);
		tel.setForeground(Color.black);
		tel.setFont(labelFont);
		JLabel pass = new JLabel("bd ", JLabel.CENTER);
		pass.setForeground(Color.black);
		pass.setFont(labelFont);
		JLabel post = new JLabel("President Directeur Generale ", JLabel.CENTER);
		post.setForeground(Color.black);
		post.setFont(labelFont);
		
	
		
		// Buttons
		edit = new JButton("MODIFIER VOS INFORMATIONS");
		edit.setFont(new Font("Serif", Font.ITALIC, 16));
		edit.setBounds(130, 380, 300, 40);
		//signup.addActionListener(this);
		
		form.add(name);
		form.add(nom);
		form.add(surname);
		form.add(surnom);
		form.add(phone);
		form.add(tel);
		form.add(adr);
		form.add(pass);
		form.add(poste);
		form.add(post);
		
		//form.add(com_conpassf);
		
		update.add(l);
		update.add(form);
		update.add(edit);

		
//		mncpte.add(lab_panel);
//		mncpte.add(profile_part);
		mncpte.add(update);
		
		
		//ajout commercial
		
				addcm.setLayout(null);
				
				//panel com
				
				JPanel add_cm = new JPanel();
				add_cm.setBackground(null);
				add_cm.setLayout(null);
				add_cm.setBounds(50, 0, 950, 485);
				
				//contenu addcm
				
				JLabel enter = new JLabel("Veuillez entrer l'identifiant du commercial a ajouter ", JLabel.CENTER);
				enter.setFont(new Font("Serif", Font.BOLD, 27));
				enter.setBounds(100, 0, 700, 50);
				
				JTextField add_tf= new JTextField();
				add_tf.setBounds(270, 150, 350, 30);
				
				
				JButton add=new JButton("Ajouter Commercial");
				add.setFont(new Font("Serif", Font.ITALIC, 16));
				add.setBounds(320, 200, 250, 50);
		
				
				add_cm.add(enter);
				add_cm.add(add_tf);
				add_cm.add(add);
				
				addcm.add(add_cm);
				
				//modif commercial
				
				updatecm.setLayout(null);
				
				//panel com
				
				JPanel update_cm = new JPanel();
				update_cm.setBackground(null);
				update_cm.setLayout(new GridLayout(5, 2, 7, 30));
				update_cm.setBounds(200, 60, 400, 280);
				
				//contenu modifcm
				
				JLabel enter1 = new JLabel("Modification des donnees des Commerciaux ", JLabel.CENTER);
				enter1.setFont(new Font("Serif", Font.BOLD, 27));
				enter1.setBounds(100, 0, 700, 50);
				
				JLabel id = new JLabel("Identifiant Commercial: ", JLabel.CENTER);
				id.setForeground(Color.black);
				id.setFont(labelFont);
				JLabel name1 = new JLabel("Nom Commercial: ", JLabel.CENTER);
				name1.setForeground(Color.black);
				name1.setFont(labelFont);
				JLabel surname1 = new JLabel("Prénom Commercial: ", JLabel.CENTER);
				surname1.setForeground(Color.black);
				surname1.setFont(labelFont);
				JLabel phone1 = new JLabel("Téléphone Commercial: ", JLabel.CENTER);
				phone1.setForeground(Color.black);
				phone1.setFont(labelFont);
				JLabel adr1 = new JLabel("Addresse Commercial: ", JLabel.CENTER);
				adr1.setForeground(Color.black);
				adr1.setFont(labelFont);				
				JLabel hint = new JLabel("NB: On ne peut pas modifier l'identifiant du Commercial il sert juste pour "
						+ "la recherche lors de la suppresion"+"\n"+" et la modification ", JLabel.CENTER);
				hint.setForeground(Color.black);
				hint.setFont(labelFont);
				hint.setBounds(5, 350, 900, 20);
				//textfield
				
				com_id = new JTextField();
				
				com_name = new JTextField();
				
				com_surname = new JTextField();
				
				com_tel = new JTextField();
				
				com_adr = new JTextField();
				
				
//				JTextField add_tf= new JTextField();
//				add_tf.setBounds(270, 150, 350, 30);
				
				
				JButton modif=new JButton("Modifier ");
				modif.setFont(new Font("Serif", Font.ITALIC, 16));
				modif.setBounds(250, 400, 150, 50);
				
				JButton supr= new JButton("Supprimer "); 
				supr.setFont(new Font("Serif", Font.ITALIC, 16));
				supr.setBounds(450, 400, 150, 50);
				
				update_cm.add(id);
				update_cm.add(com_id);
				update_cm.add(name1);
				update_cm.add(com_name);
				update_cm.add(surname1);
				update_cm.add(com_surname);
				update_cm.add(phone1);
				update_cm.add(com_tel);
				update_cm.add(adr1);
				update_cm.add(com_adr);
				
				
				updatecm.add(enter1);
				updatecm.add(update_cm);
				updatecm.add(hint);
				updatecm.add(supr);
				updatecm.add(modif);
				
				
			//consult commercial
				
				// infos clients 
				infoscm.setLayout(null);
				
				JPanel infos = new JPanel();
				infos.setLayout(null);
				infos.setBounds(20, 10, 900, 110);
				
				JLabel infosLab = new JLabel("Bien vouloir cliquer sur le boutton ci-dessous afin d'obtenir la liste "
						+ "des clients des différents commerciaux", JLabel.CENTER);
				infosLab.setBounds(40, 20, 800, 20);
				infosLab.setFont(new Font("Serif", Font.ITALIC, 18));
				
				JButton info = new JButton("informations clients");
				info.setFont(new Font("Serif", Font.ITALIC, 16));
				info.setBounds(340, 55, 200, 30);
				//info.addActionListener(this);
				
				infos.add(infosLab);
				infos.add(info);
				
				JPanel inftable = new JPanel();
				inftable.setBounds(20, 120, 900, 320);
				inftable.setLayout(new BorderLayout());
				inftable.setBackground(Color.white);
				inftable.setBorder(new EmptyBorder(10, 10, 10, 10));
				
				String[] inftitle = {"IDclient", "Nom", "Prénom", "Adresse", "Localisation", "IDCom", "NomCom", "PrénomCom"};
				Object[][] infdata = {};
				JTable inftab = new JTable(infdata, inftitle);
				inftab.setRowHeight(30);
				inftab.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				inftab.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
				inftab.setFont(new Font("Serif", Font.ITALIC, 18));
				inftab.getTableHeader().setFont(new Font("Serif", Font.ITALIC, 18));
				inftab.setPreferredSize(new Dimension(820, 290));
				
				inftable.add(inftab.getTableHeader(), BorderLayout.NORTH);
				inftable.add(new JScrollPane(inftab), BorderLayout.CENTER);
				
				infoscm.add(infos);
				infoscm.add(inftable);
				
				
				
				
				// visite
				rdv.setLayout(null);
				
				JPanel rdvpart = new JPanel();
				rdvpart.setLayout(null);
				rdvpart.setBounds(70, 20, 800, 420);
				
				JLabel rdvLab = new JLabel("Programmer les différents visite avec vos clients ici ", JLabel.CENTER);
				rdvLab.setFont(new Font("Serif", Font.ITALIC, 18));
				rdvLab.setBounds(10, 5, 800, 50);
				
				JPanel rdvp = new JPanel();
				rdvp.setLayout(new GridLayout(1, 2, 0, 0));
				rdvp.setBounds(50, 60, 700, 30);
				rdvp.setBackground(Color.white);
				
				Font lf = new Font("Serif", Font.BOLD, 16);
				Font df = new Font("Serif", Font.ITALIC, 16);
				
				JPanel p1 = new JPanel();
				p1.setLayout(null);
				JPanel p2 = new JPanel();
				p2.setLayout(null);
				JPanel p3 = new JPanel();
				p3.setLayout(null);
				p3.setBounds(50, 110, 700, 260);
				
				JLabel l1 = new JLabel("Identifiant client: ", JLabel.CENTER);
				l1.setFont(lf);
				l1.setBounds(5, 0, 200, 20);
				JLabel l2 = new JLabel("Objectif du visite ", JLabel.CENTER);
				l2.setFont(lf);
				l2.setBounds(5, 5, 200, 20);
				JLabel l3 = new JLabel("Jour-Heure du visite: ", JLabel.CENTER);
				l3.setFont(lf);
				l3.setBounds(5, 0, 200, 20);
				
				JTextField rdvIdCl = new JTextField();
				rdvIdCl.setBounds(210, 0, 50, 25);
				JTextField rdvgoal = new JTextField();
				rdvgoal.setBounds(210, 0, 270, 30);
				rdvgoal.setFont(new Font("Serif", Font.ITALIC, 16));
				JComponent txtarea = new JTextArea("Description....");
				txtarea.setBorder(new EmptyBorder(10, 20, 10, 20));
				txtarea.setFont(df);
				JScrollPane scp = new JScrollPane(txtarea);
				scp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				scp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				JFormattedTextField rdvDate = null;
				try {
					MaskFormatter msf = new MaskFormatter("####-##-## ##:##:##");
					rdvDate = new JFormattedTextField(msf);
					rdvDate.setToolTipText("La syntaxe est la suivante: yyyy-mm-dd hh:mm:ss");
					rdvDate.setBounds(210, 0, 125, 25);
				}
				catch(ParseException e) {
					e.printStackTrace();
				}
				
				JPanel p31 = new JPanel();
				JPanel p32 = new JPanel();
				p32.setLayout(new BorderLayout());
				p32.setBounds(50, 60, 635, 180);
				p31.setLayout(null);
				p31.setBounds(120, 15, 500, 30);
				
				p31.add(l2); p31.add(rdvgoal);
				p32.add(scp, BorderLayout.CENTER);
				p1.add(l1); p1.add(rdvIdCl);
				p2.add(l3); p2.add(rdvDate);
				p3.add(p31); p3.add(p32);
				rdvp.add(p1); rdvp.add(p2);
				
				JButton rdvbtn = new JButton("Effectuer visite");
				rdvbtn.setFont(df);
				rdvbtn.setBounds(320, 370, 200, 30);
				//rdvbtn.addActionListener(this);
				
				rdvpart.add(rdvLab);
				rdvpart.add(p3);
				rdvpart.add(rdvp);
				rdvpart.add(rdvbtn);
				
				rdv.add(rdvpart);
				
				
		thumbnail.addTab(tabs[0], mncpte);
		thumbnail.addTab(tabs[1], addcm);
		thumbnail.addTab(tabs[2], updatecm);
		thumbnail.addTab(tabs[3], consultcm);
		thumbnail.addTab(tabs[4], rdv);
		thumbnail.addTab(tabs[5], infoscm);
		
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

