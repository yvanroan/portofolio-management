package View;

import Controller.ClientModel;
import Controller.CommercialModel;
import Controller.SignupForm;
import Controller.VisitModel;
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
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

public class MenuPanel extends JPanel implements ActionListener {
	
	protected JPanel container, mncpte, addcl, updatecl, rdv, lsvisites, infoscl, profile, inftable, vistable;
	protected JTextField com_namef, com_surnamef, com_passf, com_conpassf, com_phonef, rdvIdCl, rdvDate, rdvgoal;
	protected JTabbedPane thumbnail;
	protected JLabel profile_img, profile_title, prof_img;
	protected Commercial com;
	private String[] tabs = {"Mon compte", "Ajouter client", "Modifier client", "visiter client", "Liste Visites", "Infos clients"};
	protected JButton edit, signup, info, visite, rdvbtn;
	private Color menuBg = new Color(184, 207, 229);
	protected int state = 0;
	protected CommercialModel comManager = new CommercialModel();
	protected JOptionPane dialog_confirm, dialog_error, dialog_success;
	protected JTable inftab, vistab;
	protected JTextArea txtarea;
	CreateImage ic;
	private int IDcom;
	private String passwordCom;

	public MenuPanel() {
		
		this.setLayout(null);
		
		CreateImage Imgcreator = new CreateImage(1000, 400);
		Imgcreator.setImg(new ImageIcon("mesImages/meeting.jpg"));
		JLabel background = Imgcreator.generate();
		background.setBounds(0, 0, 1000, 200);
		background.setLayout(null);
		this.add(background);
		
		// profile image
		profile = new JPanel();
		profile.setPreferredSize(new Dimension(160, 160));
		profile.setBackground(new Color(0, 0, 0, 0));
		profile.setBounds(100, 30, 140, 140);
		profile.setLayout(new BorderLayout());
		background.add(profile);
		
		// profile items
		ic = new CreateImage(160, 160);
		ic.setImg(new ImageIcon("mesImages/profile.jpg"));
		profile_img = ic.generate();
		profile_title = new JLabel("", JLabel.CENTER);
		profile_title.setFont(new Font("Californian", Font.BOLD, 15));
		profile_title.setBorder(new EmptyBorder(5, 0, 0, 0));
		
		profile.add(profile_img, BorderLayout.CENTER);
		profile.add(profile_title, BorderLayout.SOUTH);
		
		// principal menu container
		container = new JPanel();
		container.setBounds(0, 200, 1100, 700);
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		// menu
		thumbnail = new JTabbedPane();
		thumbnail.setBounds(20, 0, 1050, 485);
		thumbnail.setOpaque(false);
		thumbnail.setAutoscrolls(true);
		thumbnail.setBackground(Color.white);
		
		// initialisation des panels pour le menu
		
		mncpte = new JPanel();
		mncpte.setBackground(menuBg);
		addcl = new JPanel();
		addcl.setBackground(menuBg);
		updatecl = new JPanel();
		updatecl.setBackground(menuBg);
		rdv = new JPanel();
		rdv.setBackground(menuBg);
		lsvisites = new JPanel();
		lsvisites.setBackground(menuBg);
		infoscl = new JPanel();
		infoscl.setBackground(menuBg);
		
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
		JPanel profile_part = new JPanel();
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
		
		com_namef = new JTextField();
		com_namef.setBackground(null);
		com_namef.setBorder(BorderFactory.createLineBorder(Color.black));
		com_namef.setFont(fieldFont);
		com_surnamef = new JTextField();
		com_surnamef.setBackground(null);
		com_surnamef.setBorder(new EmptyBorder(0, 10, 0, 10));
		com_surnamef.setBorder(BorderFactory.createLineBorder(Color.black));
		com_surnamef.setFont(fieldFont);
		try {
			MaskFormatter tel = new MaskFormatter("### ## ## ##");
			com_phonef = new JFormattedTextField(tel);
			com_phonef.setBackground(null);
			com_phonef.setBorder(BorderFactory.createLineBorder(Color.black));
			com_phonef.setFont(fieldFont);
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		com_passf = new JPasswordField();
		com_passf.setBackground(null);
		com_passf.setBorder(BorderFactory.createLineBorder(Color.black));
		com_passf.setFont(fieldFont);
		com_conpassf = new JPasswordField();
		com_conpassf.setBackground(null);
		com_conpassf.setBorder(BorderFactory.createLineBorder(Color.black));
		com_conpassf.setFont(fieldFont);
		
		// Buttons
		signup = new JButton("MODIFIER");
		signup.setFont(new Font("Serif", Font.ITALIC, 16));
		signup.setBounds(200, 380, 200, 40);
		signup.addActionListener(this);
				
		
		form.add(name);
		form.add(com_namef);
		form.add(surname);
		form.add(com_surnamef);
		form.add(phone);
		form.add(com_phonef);
		form.add(psswd);
		form.add(com_passf);
		form.add(cpsswd);
		form.add(com_conpassf);
		
		update.add(l);
		update.add(form);
		update.add(signup);
		
		mncpte.add(lab_panel);
		mncpte.add(profile_part);
		mncpte.add(update);
		
		
		//ajout client 
		
				addcl.setLayout(null);
				
				//panel com
				
				JPanel add_cm = new JPanel();
				add_cm.setBackground(null);
				add_cm.setLayout(null);
				add_cm.setBounds(50, 0, 950, 485);
				
				//contenu addcm
				
				JLabel enter = new JLabel("Veuillez entrer l'identifiant du Client a ajouter ", JLabel.CENTER);
				enter.setFont(new Font("Serif", Font.BOLD, 27));
				enter.setBounds(100, 0, 700, 50);
				
				JTextField add_tf= new JTextField();
				add_tf.setBounds(270, 150, 350, 30);
				
				
				JButton add=new JButton("Ajouter Client");
				add.setFont(new Font("Serif", Font.ITALIC, 16));
				add.setBounds(320, 200, 250, 50);

				
				add_cm.add(enter);
				add_cm.add(add_tf);
				add_cm.add(add);
				
				addcl.add(add_cm);

		
//modif commercial
				
				updatecl.setLayout(null);
				
				//panel com
				
				JPanel update_cm = new JPanel();
				update_cm.setBackground(null);
				update_cm.setLayout(new GridLayout(5, 2, 7, 30));
				update_cm.setBounds(200, 80, 400, 280);
				
				//contenu modifcm
				
				JLabel enter1 = new JLabel("Modification des donnees des Client ", JLabel.CENTER);
				enter1.setFont(new Font("Serif", Font.BOLD, 27));
				enter1.setBounds(100, 0, 700, 50);
				
				JLabel id = new JLabel("Identifiant Client: ", JLabel.CENTER);
				id.setForeground(Color.black);
				id.setFont(labelFont);
				JLabel name1 = new JLabel("Nom Client: ", JLabel.CENTER);
				name1.setForeground(Color.black);
				name1.setFont(labelFont);
				JLabel surname1 = new JLabel("Prénom Client: ", JLabel.CENTER);
				surname1.setForeground(Color.black);
				surname1.setFont(labelFont);
				JLabel phone1 = new JLabel("Téléphone Client: ", JLabel.CENTER);
				phone1.setForeground(Color.black);
				phone1.setFont(labelFont);
				JLabel adr1 = new JLabel("Addresse Client: ", JLabel.CENTER);
				adr1.setForeground(Color.black);
				adr1.setFont(labelFont);				
				JLabel hint = new JLabel("NB: On ne peut pas modifier l'identifiant du client il sert juste pour "
						+ "la recherche lors de la suppresion et la modification ", JLabel.CENTER);
				hint.setForeground(Color.black);
				hint.setFont(labelFont);
				hint.setBounds(20, 380, 900, 20);
				//textfield
				
				JTextField com_id = new JTextField();
				
				JTextField com_name = new JTextField();
				
				JTextField com_surname = new JTextField();
				
				JTextField com_tel = new JTextField();
				
				JTextField com_adr = new JTextField();
				
				
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
				
				
				updatecl.add(enter1);
				updatecl.add(update_cm);
				updatecl.add(hint);
				updatecl.add(supr);
				updatecl.add(modif);
		
		// infos clients 
		infoscl.setLayout(null);
		
		JPanel infos = new JPanel();
		infos.setLayout(null);
		infos.setBounds(20, 10, 900, 110);
		
		JLabel infosLab = new JLabel("Bien vouloir cliquer sur le boutton ci-dessous afin d'obtenir la liste "
				+ "des clients", JLabel.CENTER);
		infosLab.setBounds(40, 20, 800, 20);
		infosLab.setFont(new Font("Serif", Font.ITALIC, 18));
		
		info = new JButton("informations clients");
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
		
		String[] inftitle = {"IDclient", "Nom", "Prénom", "Adresse", "Phone"};
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
		
		infoscl.add(infos);
		infoscl.add(inftable);
		
		// liste des visites
		
		lsvisites.setLayout(null);
		
		JPanel visites = new JPanel();
		visites.setLayout(null);
		visites.setBounds(20, 10, 900, 110);
		
		JLabel visitesLab = new JLabel("Bien vouloir cliquer sur le boutton ci-dessous afin d'obtenir la liste "
				+ "des visites éffectuées à vos différents clients", JLabel.CENTER);
		visitesLab.setBounds(30, 20, 830, 20);
		visitesLab.setFont(new Font("Serif", Font.ITALIC, 18));
		
		visite = new JButton("liste visites");
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
		
		String[] vistitle = {"IDClient", "Name", "Surname", "Address", "Phone", "Goal"};
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
		
		rdvIdCl = new JTextField();
		rdvIdCl.setBounds(210, 0, 50, 25);
		rdvgoal = new JTextField();
		rdvgoal.setBounds(210, 0, 270, 30);
		rdvgoal.setFont(new Font("Serif", Font.ITALIC, 16));
		txtarea = new JTextArea("Description....");
		txtarea.setBorder(new EmptyBorder(10, 20, 10, 20));
		txtarea.setFont(df);
		JScrollPane scp = new JScrollPane(txtarea);
		scp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
		
		rdvbtn = new JButton("Effectuer visite");
		rdvbtn.setFont(df);
		rdvbtn.setBounds(320, 370, 200, 30);
		rdvbtn.addActionListener(this);
		
		rdvpart.add(rdvLab);
		rdvpart.add(p3);
		rdvpart.add(rdvp);
		rdvpart.add(rdvbtn);
		
		rdv.add(rdvpart);
		
		thumbnail.addTab(tabs[0], mncpte);
		thumbnail.addTab(tabs[1], addcl);
		thumbnail.addTab(tabs[2], updatecl);
		thumbnail.addTab(tabs[3], rdv);
		thumbnail.addTab(tabs[4], lsvisites);
		thumbnail.addTab(tabs[5], infoscl);
		
		container.add(thumbnail);
		this.add(container);
	}	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public void initComData (Commercial c) {
		com = c;
		profile_img.setIcon(new ImageIcon(com.getProfileC()));
		prof_img.setIcon(new ImageIcon(com.getProfileC()));
		profile_title.setText(com.getName()+" "+com.getSurname());
		com_namef.setText(com.getName());
		com_surnamef.setText(com.getSurname());
		com_phonef.setText(String.valueOf(com.getPhone()));
		passwordCom = com.getPassword();
		IDcom= com.getIdCom();
	}
	
	public void actionPerformed (ActionEvent e) {

		JButton btnSource = (JButton)e.getSource();

		if (btnSource == edit) {
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File f = chooser.getSelectedFile();
			String filename = f.getAbsolutePath();
			com.setProfileC(filename);
			comManager.update(com);
			profile_img.setIcon(new ImageIcon(filename));
			prof_img.setIcon(new ImageIcon(filename));
		}

		if (btnSource == info) {
			Object[][] data = {};
		String[] inftitle = {"IDclient","First Name", "Last Name", "Adresse", "Phone"};
			DefaultTableModel rows = new DefaultTableModel(data, inftitle);
			ClientModel clientManager = new ClientModel();
			List <Client> listcl = clientManager.findAll();

			for (Client cl: listcl) {
				Commercial clCom;
				clCom = comManager.find(cl.getIdCom());
				rows.addRow(new Object[] {cl.getIdClient(), cl.getName(), cl.getSurname(), cl.getAddress(), cl.getPhone()}
				);
			}

			inftab.setModel(rows);

		}

		if (btnSource == visite) {
			com = new Commercial();
			com.setIdCom(IDcom);
			String[] title = {"IDclient", "First Name", "Last Name", "Adress", "Phone", "Period", "goal"};
			Object[][] data = {};
			DefaultTableModel rows = new DefaultTableModel(data, title);
			ClientModel clientManager = new ClientModel();
			VisitModel visitManager = new VisitModel();
			List <Visit> listvis = visitManager.find(com);

			for(Visit vs: listvis) {
				Client cl;
				cl = clientManager.find(vs.getIdCl());
				rows.addRow(new Object[] {cl.getIdClient(), cl.getName(), cl.getSurname(), cl.getAddress(), cl.getPhone(), vs.getPeriod(),
						vs.getGoal()});
			}
			vistab.setModel(rows);
		}

		if (btnSource == signup) {
//			if( ==com_passf.getText() && com_passf.getText()==com_conpassf.getText()) {

				String name, surname, password, confirm_pass;
				String phone;
				SignupForm sgf;

				dialog_error = new JOptionPane();
				dialog_confirm = new JOptionPane();
				dialog_success = new JOptionPane();

				name = com_namef.getText(); surname = com_surnamef.getText(); password = com_passf.getText();
				confirm_pass = com_conpassf.getText();
//			phone = Integer.valueOf(com_phonef.getText().replaceAll("\\s", ""));
				phone = com_phonef.getText();
				int confirm = dialog_confirm.showConfirmDialog(null, "Do you really want to update this data?", "Update",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (confirm == JOptionPane.OK_OPTION) {
					System.out.println(confirm+ "=" +confirm_pass);
					if (password.equals(confirm_pass) && passwordCom.equals(password)) {

						sgf = new SignupForm();

						if (sgf.hasErrorFields(name, surname, password, phone)) {
							dialog_error.showMessageDialog(null, sgf.getErrorMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
						}
						else {

							com.setName(sgf.getName());
							com.setSurname(sgf.getSurname());
							com.setPassword(sgf.getPassword());
							com.setPhone(sgf.getPhone());

							if(comManager.update(com)) {
								dialog_success.showMessageDialog(null, "mise à jour éffectuée", "Validation", JOptionPane.INFORMATION_MESSAGE);
								com_namef.setText("");com_surnamef.setText("");com_passf.setText("");com_conpassf.setText("");com_phonef.setText("");
								setState(2);
								profile_title.setText(com.getName()+" "+com.getSurname());
								profile_title.setBackground(null);
							}
						}
					}
					else {
						dialog_error.showMessageDialog(null, "The password is incorrect, please go back and check it!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
		}
		if (btnSource == rdvbtn) {

			String dte, goal, comment, error = "";
			int id = 0;
			Timestamp ts = null;

			SignupForm sgf = new SignupForm();

			if (sgf.isNumeric(rdvIdCl.getText())) {
				id = Integer.valueOf(rdvIdCl.getText().trim());
			}
			else {
				if (rdvIdCl.getText() == null) {
					error += "Vous devez préciser l'identifiant du client" + "\n";
				}
				else {
					error += "L'identifiant du client doit être un chiffre" + "\n";
				}
			}
			dte = rdvDate.getText();
			String extractDate = dte.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "");

			if (extractDate == null) {
				error += "Vous devez absolument préciser la date de votre visite" + "\n";
			}
			else {
				ts = Timestamp.valueOf(dte);
			}
			comment = txtarea.getText().trim();
			if (sgf.isNumeric(comment)) {
				error += "La description de votre visite doit contenir des caractères et non des chiffres" + "\n";
			}
			else {
				if (comment == null) {
					error += "Vous devez absolument renseigner une description de votre visite";
				}
				else if (comment.length() < 20) {
					error += "La description de votre visite doit contenir au moins 150 caractères" + "\n";
				}
				else {}
			}

			goal = rdvgoal.getText().trim();
			if (sgf.isNumeric(goal)) {
				error += "Le but de votre visite doit contenir des caractères et non des chiffres" + "\n";
			}
			else {
				if (goal == null) {
					error += "Vous devez absolument renseigner le but de votre visite";
				}
				else if (goal.length() < 5) {
					error += "Le but de votre visite doit contenir au moins 15 caractères" + "\n";
				}
				else {}
			}

			dialog_error = new JOptionPane();
			dialog_confirm = new JOptionPane();
			dialog_success = new JOptionPane();

			int confirm = dialog_confirm.showConfirmDialog(null, "Voulez-vous vraiment confirmer??", "Soumission du formulaire",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (confirm == JOptionPane.OK_OPTION) {
				if (error.length() > 0) {
					dialog_error.showMessageDialog(null, error, "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else {
					VisitModel visitManager = new VisitModel();
					if (visitManager.add(1, id, goal, comment, ts)) {
						dialog_success.showMessageDialog(null, "visite éffectuée", "Validation", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						dialog_error.showMessageDialog(null, "Une erreur est survenue lors de l'insertion des données", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
}
//<>