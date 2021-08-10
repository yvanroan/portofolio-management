package View;

import Controller.*;
import Model.Boss;
import Model.Client;
import Model.Commercial;
import Model.Visit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.util.List;

public class BossThirdPanel extends JPanel implements ActionListener {
	protected JButton edit, signup, info, visite, rdvbtn;
	private JFormattedTextField boss_phonef;
	protected JPanel container, mncpte, createcm, updatecm, lsvisites, rdv, infoscm, profile, inftable, vistable,profile_part;
	protected JTextField boss_namef, boss_surnamef, boss_passf, boss_conpassf;
	protected Boss boss;
	protected JTabbedPane thumbnail;
	private String[] tabs = {"My account", "Add Commercial", "Update Commercial", "Commercial's visits" ,"Commercials' data"};
	protected JPanel[] panels = {mncpte, createcm, updatecm,lsvisites, rdv, infoscm};
	private Color menuBg = new Color(184, 207, 229);
	protected int state = 0;
	protected JTable inftab, vistab;
	protected JOptionPane dialog_confirm, dialog_error, dialog_success;
	private int IDboss;
	private String passwordboss;
	protected JLabel profile_img, profile_title, prof_img;
	BossModel bossManager = new BossModel();
	
	public BossThirdPanel() {

		this.setLayout(null);

		CreateImage Imgcreator = new CreateImage(1000, 400);
		Imgcreator.setImg(new ImageIcon("mesImages/boss_login.jpeg"));
		JLabel background = Imgcreator.generate();
		background.setBounds(0, 0, 1000, 200);
		background.setLayout(null);
		this.add(background);

//		// profile image
		profile = new JPanel();
		profile.setPreferredSize(new Dimension(160, 160));
		profile.setBackground(new Color(0, 0, 0, 0));
		profile.setBounds(100, 30, 140, 140);
		profile.setLayout(new BorderLayout());
		background.add(profile);

//		// profile items
		CreateImage ic = new CreateImage(1000, 400);
		ic.setImg(new ImageIcon("mesImages/profile.jpeg"));
		profile_img = ic.generate();
		profile_title = new JLabel("Lorem ipsum", JLabel.CENTER);
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
//
//		// menu
		thumbnail = new JTabbedPane();
		thumbnail.setBounds(20, 0, 950, 485);
		thumbnail.setOpaque(false);
		thumbnail.setAutoscrolls(true);
		thumbnail.setBackground(Color.white);
	
// initialisation des panels pour le menu

	mncpte = new JPanel();
		mncpte.setBackground(menuBg);
	createcm = new JPanel();
		createcm.setBackground(menuBg);
	updatecm = new JPanel();
		updatecm.setBackground(menuBg);
	rdv = new JPanel();
		rdv.setBackground(menuBg);
	lsvisites = new JPanel();
		lsvisites.setBackground(menuBg);
	infoscm = new JPanel();
		infoscm.setBackground(menuBg);

	// traitement des panels

	// user account panel

		mncpte.setLayout(null);

	JPanel lab_panel = new JPanel();
		lab_panel.setBackground(null);
		lab_panel.setBounds(5, 10, 300, 50);
	JLabel label = new JLabel("Editer votre photo de profile");
		label.setFont(new Font("Serif", Font.BOLD, 19));
		lab_panel.add(label);

	// picture part
	profile_part = new JPanel();
		profile_part.setLayout(new BorderLayout());
		profile_part.setBackground(null);
		profile_part.setBounds(80, 80, 140, 140);
		prof_img = ic.generate();
		profile_part.add(prof_img, BorderLayout.CENTER);

	edit = new JButton("Editer");
		edit.setBounds(100, 250, 100, 30);
		edit.addActionListener(this);

		mncpte.add(edit);

	JPanel update = new JPanel();
		update.setBackground(null);
		update.setLayout(null);
		update.setBounds(430, 0, 950, 485);

	JLabel l = new JLabel("Editer vos informations personnelles: ", JLabel.CENTER);
		l.setFont(new Font("Serif", Font.BOLD, 19));
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
	JLabel psswd = new JLabel("Mot de passe: ", JLabel.CENTER);
		psswd.setForeground(Color.black);
		psswd.setFont(labelFont);
	JLabel cpsswd = new JLabel("Confirmer mot de passe: ", JLabel.CENTER);
		cpsswd.setForeground(Color.black);
		cpsswd.setFont(labelFont);

	// création des fields

	boss_namef = new JTextField();
		boss_namef.setBackground(null);
		boss_namef.setBorder(BorderFactory.createLineBorder(Color.black));
		boss_namef.setFont(fieldFont);
	boss_surnamef = new JTextField();
		boss_surnamef.setBackground(null);
		boss_surnamef.setBorder(new EmptyBorder(0, 10, 0, 10));
		boss_surnamef.setBorder(BorderFactory.createLineBorder(Color.black));
		boss_surnamef.setFont(fieldFont);
		try {
		MaskFormatter tel = new MaskFormatter("### ## ## ##");
		boss_phonef = new JFormattedTextField(tel);
		boss_phonef.setBackground(null);
		boss_phonef.setBorder(BorderFactory.createLineBorder(Color.black));
		boss_phonef.setFont(fieldFont);
	}
		catch (ParseException e) {
		e.printStackTrace();
	}
	boss_passf = new JPasswordField();
		boss_passf.setBackground(null);
		boss_passf.setBorder(BorderFactory.createLineBorder(Color.black));
		boss_passf.setFont(fieldFont);
	boss_conpassf = new JPasswordField();
		boss_conpassf.setBackground(null);
		boss_conpassf.setBorder(BorderFactory.createLineBorder(Color.black));
		boss_conpassf.setFont(fieldFont);

	// Buttons
	signup = new JButton("UPDATE");
		signup.setFont(new Font("Serif", Font.ITALIC, 16));
		signup.setBounds(200, 380, 200, 40);
		signup.addActionListener(this);


		form.add(name);
		form.add(boss_namef);
		form.add(surname);
		form.add(boss_surnamef);
		form.add(phone);
		form.add(boss_phonef);
		form.add(psswd);
		form.add(boss_passf);
		form.add(cpsswd);
		form.add(boss_conpassf);

		update.add(l);
		update.add(form);
		update.add(signup);

		mncpte.add(lab_panel);
		mncpte.add(profile_part);
		mncpte.add(update);


	//ajout client

				createcm.setLayout(null);

	//panel boss

	JPanel add_cm = new JPanel();
				add_cm.setBackground(null);
				add_cm.setLayout(null);
				add_cm.setBounds(50, 0, 950, 485);

	//contenu createcm

	JLabel enter = new JLabel("Create a new Commercial", JLabel.CENTER);
				enter.setFont(new Font("Serif", Font.BOLD, 27));
				enter.setBounds(100, 0, 700, 50);

	JTextField add_tf= new JTextField();
				add_tf.setBounds(270, 150, 350, 30);


	JButton add=new JButton("Add Commercial");
				add.setFont(new Font("Serif", Font.ITALIC, 16));
				add.setBounds(320, 200, 250, 50);


				add_cm.add(enter);
				add_cm.add(add_tf);
				add_cm.add(add);

				createcm.add(add_cm);


//modif Commercial

				updatecm.setLayout(null);

	//panel boss

	JPanel update_cm = new JPanel();
				update_cm.setBackground(null);
				update_cm.setLayout(new GridLayout(5, 2, 7, 30));
				update_cm.setBounds(200, 80, 400, 280);

	//contenu modifcm

	JLabel enter1 = new JLabel("Update the Commercial's data", JLabel.CENTER);
				enter1.setFont(new Font("Serif", Font.BOLD, 27));
				enter1.setBounds(100, 0, 700, 50);

	JLabel id = new JLabel("Commercial's Id: ", JLabel.CENTER);
				id.setForeground(Color.black);
				id.setFont(labelFont);
	JLabel name1 = new JLabel("Commercial's First Name: ", JLabel.CENTER);
				name1.setForeground(Color.black);
				name1.setFont(labelFont);
	JLabel surname1 = new JLabel("Commercial's Last Name: ", JLabel.CENTER);
				surname1.setForeground(Color.black);
				surname1.setFont(labelFont);
	JLabel phone1 = new JLabel("Commercial's Phone: ", JLabel.CENTER);
				phone1.setForeground(Color.black);
				phone1.setFont(labelFont);
	JLabel adr1 = new JLabel("Commercial's Address: ", JLabel.CENTER);
				adr1.setForeground(Color.black);
				adr1.setFont(labelFont);
	JLabel hint = new JLabel("NB: You cannot update the Commercial's Id it is only used as reference "
			+ "for the updates", JLabel.CENTER);
				hint.setForeground(Color.black);
				hint.setFont(labelFont);
				hint.setBounds(20, 380, 900, 20);
	//textfield

	JTextField boss_id = new JTextField();

	JTextField boss_name = new JTextField();

	JTextField boss_surname = new JTextField();

	JTextField boss_tel = new JTextField();

	JTextField boss_adr = new JTextField();


//				JTextField add_tf= new JTextField();
//				add_tf.setBounds(270, 150, 350, 30);


	JButton modif=new JButton("UPDATE ");
				modif.setFont(new Font("Serif", Font.ITALIC, 16));
				modif.setBounds(250, 400, 150, 50);

	JButton supr= new JButton("DELETE ");
				supr.setFont(new Font("Serif", Font.ITALIC, 16));
				supr.setBounds(450, 400, 150, 50);

				update_cm.add(id);
				update_cm.add(boss_id);
				update_cm.add(name1);
				update_cm.add(boss_name);
				update_cm.add(surname1);
				update_cm.add(boss_surname);
				update_cm.add(phone1);
				update_cm.add(boss_tel);
				update_cm.add(adr1);
				update_cm.add(boss_adr);


				updatecm.add(enter1);
				updatecm.add(update_cm);
				updatecm.add(hint);
				updatecm.add(supr);
				updatecm.add(modif);

	// infos clients
		infoscm.setLayout(null);

	JPanel infos = new JPanel();
		infos.setLayout(null);
		infos.setBounds(20, 10, 900, 110);

	JLabel infosLab = new JLabel("Click on the button below to display all Commercial's Data", JLabel.CENTER);
		infosLab.setBounds(40, 20, 800, 20);
		infosLab.setFont(new Font("Serif", Font.ITALIC, 18));

	info = new JButton("Commercial's Data");
		info.setFont(new Font("Serif", Font.ITALIC, 16));
		info.setBounds(340, 55, 200, 30);
		info.addActionListener(this);

		infos.add(infosLab);
		infos.add(info);

	inftable = new JPanel();
		inftable.setBounds(20, 120, 900, 320);
		inftable.setLayout(new BorderLayout());
		inftable.setBackground(Color.white);
		inftable.setBorder(new EmptyBorder(10, 10, 10, 10));

	String[] inftitle = {"ID", "First Name", "Last Name", "Adress", "Phone"};
	Object[][] infdata = {};
	inftab = new JTable(infdata, inftitle);
	JScrollPane scrollinfo = new JScrollPane(inftab);
		scrollinfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollinfo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		inftab.setRowHeight(30);
		inftab.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		inftab.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		inftab.setFont(new Font("Serif", Font.ITALIC, 18));
		inftab.getTableHeader().setFont(new Font("Serif", Font.ITALIC, 18));
		inftab.setPreferredSize(new Dimension(820, 290));

		inftable.add(inftab.getTableHeader(), BorderLayout.NORTH);
		inftable.add(scrollinfo, BorderLayout.CENTER);

		infoscm.add(infos);
		infoscm.add(inftable);

	// liste des visites

		lsvisites.setLayout(null);

	JPanel visites = new JPanel();
		visites.setLayout(null);
		visites.setBounds(20, 10, 900, 110);

	JLabel visitesLab = new JLabel("Click on the button below to display all the visits made by the Commercials "
			, JLabel.CENTER);
		visitesLab.setBounds(30, 20, 830, 20);
		visitesLab.setFont(new Font("Serif", Font.ITALIC, 18));

	visite = new JButton("Commercial's Visits");
		visite.setFont(new Font("Serif", Font.ITALIC, 16));
		visite.setBounds(340, 55, 200, 30);
		visite.addActionListener(this);

		visites.add(visitesLab);
		visites.add(visite);

	vistable = new JPanel();
		vistable.setBounds(20, 120, 1000, 320);
		vistable.setLayout(new BorderLayout());
		vistable.setBackground(Color.white);
		vistable.setBorder(new EmptyBorder(10, 10, 10, 10));

	String[] vistitle = {"ID", "First Name", "Last Name", "Address", "Phone", "Period", "Goal"};
	vistab = new JTable(infdata, vistitle);
	JScrollPane scrollvisit = new JScrollPane(vistab);
		scrollvisit.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollvisit.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		vistab.setRowHeight(30);
		vistab.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		vistab.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		vistab.setFont(new Font("Serif", Font.ITALIC, 18));
		vistab.getTableHeader().setFont(new Font("Serif", Font.ITALIC, 18));
		vistab.setPreferredSize(new Dimension(820, 290));

		vistable.add(vistab.getTableHeader(), BorderLayout.NORTH);
		vistable.add(scrollvisit, BorderLayout.CENTER);

		lsvisites.add(visites);
		lsvisites.add(vistable);

//
		
		thumbnail.addTab(tabs[0], mncpte);
		thumbnail.addTab(tabs[1], createcm);
		thumbnail.addTab(tabs[2], updatecm);
		thumbnail.addTab(tabs[3], lsvisites);
		thumbnail.addTab(tabs[4], infoscm);
		
		container.add(thumbnail);
		this.add(container);
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	public void initBossData (Boss b) {
		boss = b;
		profile_img.setIcon(new ImageIcon(boss.getProfile()));
		profile_title.setText(boss.getName()+" "+boss.getSurname());
		boss_namef.setText(boss.getName());
		boss_surnamef.setText(boss.getSurname());
		boss_phonef.setText(String.valueOf(boss.getPhone()));
		passwordboss = boss.getPassword();
		IDboss= boss.getIdBoss();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton btnSource = (JButton)e.getSource();

		if (btnSource == edit) {
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File f = chooser.getSelectedFile();
			String filename = f.getAbsolutePath();
			boss.setProfile(filename);
			bossManager.update(boss);
			profile_img.setIcon(new ImageIcon(filename));
			prof_img.setIcon(new ImageIcon(filename));
			setState(2);
		}

		if (btnSource == info) {
			Object[][] data = {};
			String[] inftitle = {"Id", "First Name", "Last Name", "Phone"};
			DefaultTableModel rows = new DefaultTableModel(data, inftitle);
			BossModel bossManager = new BossModel();
			List<Commercial> listcom = bossManager.findAllCommercials();

			for (Commercial com: listcom) {
				rows.addRow(new Object[] {com.getIdCom(), com.getName(), com.getSurname(), com.getPhone()}
				);
			}

			inftab.setModel(rows);

		}

		if (btnSource == visite) {
			CommercialModel comman = new CommercialModel();
			ClientModel clman = new ClientModel();
			String[] title = {"Com Id","Com Name", "Client Id", "Client Name", "Address", "Phone", "Period", "Goal"};
			Object[][] data = {};
			DefaultTableModel rows = new DefaultTableModel(data, title);
			VisitModel visitManager = new VisitModel();
			List<Visit> listvis = visitManager.findAll();

			for(Visit vs: listvis) {
				Client cl = clman.find(vs.getIdCl());
				Commercial com = comman.find(vs.getIdCom());
				rows.addRow(new Object[] {vs.getIdCom(), com.getName(), vs.getIdCl(), cl.getName(), cl.getAddress(), cl.getPhone(), vs.getPeriod(),
						vs.getGoal()});
			}
			vistab.setModel(rows);
		}

		if (btnSource == signup) {
//			if( ==boss_passf.getText() && boss_passf.getText()==boss_conpassf.getText()) {

			String name, surname, password, confirm_pass;
			String phone;
			SignupForm sgf;

			dialog_error = new JOptionPane();
			dialog_confirm = new JOptionPane();
			dialog_success = new JOptionPane();

			name = boss_namef.getText(); surname = boss_surnamef.getText(); password = boss_passf.getText();
			confirm_pass = boss_conpassf.getText();
//			phone = Integer.valueOf(boss_phonef.getText().replaceAll("\\s", ""));
			phone = boss_phonef.getText();
			int confirm = dialog_confirm.showConfirmDialog(null, "Do you really want to update this data?", "Update",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (confirm == JOptionPane.OK_OPTION) {
				System.out.println(confirm+ "=" +confirm_pass);
				if (password.equals(confirm_pass) && passwordboss.equals(password)) {

					sgf = new SignupForm();

					if (sgf.hasErrorFields(name, surname, password, phone)) {
						dialog_error.showMessageDialog(null, sgf.getErrorMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else {

						boss.setName(sgf.getName());
						boss.setSurname(sgf.getSurname());
						boss.setPassword(sgf.getPassword());
						boss.setPhone(sgf.getPhone());

						if(bossManager.update(boss)) {
							dialog_success.showMessageDialog(null, "mise à jour éffectuée", "Validation", JOptionPane.INFORMATION_MESSAGE);
							boss_namef.setText("");boss_surnamef.setText("");boss_passf.setText("");boss_conpassf.setText("");boss_phonef.setText("");
//							setState(2);
							profile_title.setText(boss.getName()+" "+boss.getSurname());
							profile_title.setBackground(null);
						}
					}
				}
				else {
					dialog_error.showMessageDialog(null, "The password is incorrect, please go back and check it!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
//		if (btnSource == rdvbtn) {
//
//			String dte, goal, bossment, error = "";
//			int id = 0;
//			Timestamp ts = null;
//
//			SignupForm sgf = new SignupForm();
//
//			if (sgf.isNumeric(rdvIdCl.getText())) {
//				id = Integer.valueOf(rdvIdCl.getText().trim());
//			}
//			else {
//				if (rdvIdCl.getText() == null) {
//					error += "Vous devez préciser l'identifiant du client" + "\n";
//				}
//				else {
//					error += "L'identifiant du client doit être un chiffre" + "\n";
//				}
//			}
//			dte = rdvDate.getText();
//			String extractDate = dte.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "");
//
//			if (extractDate == null) {
//				error += "Vous devez absolument préciser la date de votre visite" + "\n";
//			}
//			else {
//				ts = Timestamp.valueOf(dte);
//			}
//			bossment = txtarea.getText().trim();
//			if (sgf.isNumeric(bossment)) {
//				error += "La description de votre visite doit contenir des caractères et non des chiffres" + "\n";
//			}
//			else {
//				if (bossment == null) {
//					error += "Vous devez absolument renseigner une description de votre visite";
//				}
//				else if (bossment.length() < 20) {
//					error += "La description de votre visite doit contenir au moins 150 caractères" + "\n";
//				}
//				else {}
//			}
//
//			goal = rdvgoal.getText().trim();
//			if (sgf.isNumeric(goal)) {
//				error += "Le but de votre visite doit contenir des caractères et non des chiffres" + "\n";
//			}
//			else {
//				if (goal == null) {
//					error += "Vous devez absolument renseigner le but de votre visite";
//				}
//				else if (goal.length() < 5) {
//					error += "Le but de votre visite doit contenir au moins 15 caractères" + "\n";
//				}
//				else {}
//			}
//
//			dialog_error = new JOptionPane();
//			dialog_confirm = new JOptionPane();
//			dialog_success = new JOptionPane();
//
//			int confirm = dialog_confirm.showConfirmDialog(null, "Voulez-vous vraiment confirmer??", "Soumission du formulaire",
//					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
//
//			if (confirm == JOptionPane.OK_OPTION) {
//				if (error.length() > 0) {
//					dialog_error.showMessageDialog(null, error, "Erreur", JOptionPane.ERROR_MESSAGE);
//				}
//				else {
//					VisitModel visitManager = new VisitModel();
//					if (visitManager.add(1, id, goal, bossment, ts)) {
//						dialog_success.showMessageDialog(null, "visite éffectuée", "Validation", JOptionPane.INFORMATION_MESSAGE);
//					}
//					else {
//						dialog_error.showMessageDialog(null, "Une erreur est survenue lors de l'insertion des données", "Erreur", JOptionPane.ERROR_MESSAGE);
//					}
//				}
//			}
//		}
	}
}

