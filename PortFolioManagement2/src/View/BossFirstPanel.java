package View;

import Controller.BossModel;
import Controller.SignupForm;
import Model.Boss;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;


public class BossFirstPanel extends JPanel implements ActionListener {
	
	private JPanel top, form;
	protected JButton signup = new JButton("S'INSCRIRE");
	protected JTextField name_f, surname_f, address_f, phone_f;
	protected JPasswordField pass_f, conpass_f;
	protected JTextField[] textFields = {name_f, surname_f, address_f, phone_f};
	private JLabel name, surname, address, phone, password, conpass;
	private Font labelFont = new Font("Times New Roman", Font.ITALIC, 22);
	private Font fieldFont = new Font("Serif", Font.ITALIC, 16);
	private Color bg = new Color (255, 255, 255, 110);
	private Color fieldBg = new Color (0, 0, 0, 120);
	protected JOptionPane dialog_confirm, dialog_error, dialog_success;
	protected BossModel bossManager = new BossModel();
	protected int state = 0;
	
	public BossFirstPanel() {
		
		CreateImage Imgcreator = new CreateImage(1000, 740);
		Imgcreator.setImg(new ImageIcon("mesImages/boss_meeting.jpeg"));
		JLabel background = Imgcreator.generate();
		background.setBounds(0, 0, 1000, 740);
		background.setLayout(null);
		
		top = new JPanel();
		top.setBounds(300, 20, 400, 60);
		top.setBorder(new EmptyBorder(10, 0, 0, 0));
		top.setBackground(new Color(66, 139, 202, 180));
		
		JLabel lab = new JLabel("Formulaire d'inscription", JLabel.CENTER);
		lab.setForeground(Color.white);
		lab.setFont(new Font("Times New Roman", Font.BOLD, 26));
		
		top.add(lab);
		background.add(top);
		
		form = new JPanel();
		form.setBackground(bg);
		form.setBounds(300, 80, 400, 540);
		form.setBorder(new EmptyBorder(20, 20, 20, 20));
		form.setLayout(new GridLayout(3, 1, 0, 10));
		
		JPanel part1 = new JPanel();
		part1.setBackground(fieldBg);
		part1.setBorder(new EmptyBorder(10, 15, 15, 15));
		part1.setLayout(new GridLayout(4, 1, 0, 8));
		
		JPanel part2 = new JPanel();
		part2.setBackground(fieldBg);
		part2.setBorder(new EmptyBorder(10, 15, 15, 15));
		part2.setLayout(new GridLayout(4, 1, 0, 8));
		
		JPanel part3 = new JPanel();
		part3.setBackground(fieldBg);
		part3.setBorder(new EmptyBorder(10, 15, 15, 15));
		part3.setLayout(new GridLayout(4, 1, 0, 8));
		
		// création des labels
		name = new JLabel("Nom: ");
		name.setForeground(Color.white);
		name.setFont(labelFont);
		surname = new JLabel("Prénom: ");
		surname.setForeground(Color.white);
		surname.setFont(labelFont);
		
		address = new JLabel("Adresse: ");
		address.setForeground(Color.white);
		address.setFont(labelFont);
		phone = new JLabel("Téléphone: ");
		phone.setForeground(Color.white);
		phone.setFont(labelFont);
		
		password = new JLabel("Mot de passe: ");
		password.setForeground(Color.white);
		password.setFont(labelFont);
		conpass = new JLabel("Confirmer mot de passe: ");
		conpass.setForeground(Color.white);
		conpass.setFont(labelFont);
		
		
		// création des fields
		name_f = new JTextField();
		name_f.setBorder(new EmptyBorder(0, 10, 0, 10));
		name_f.setFont(fieldFont);
		name_f.addActionListener(this);
		
		surname_f = new JTextField();
		surname_f.setBorder(new EmptyBorder(0, 10, 0, 10));
		surname_f.setFont(fieldFont);
		surname_f.addActionListener(this);
		
		address_f = new JTextField();
		address_f.setBorder(new EmptyBorder(0, 10, 0, 10));
		address_f.setFont(fieldFont);
		address_f.addActionListener(this);
		
		try {
			MaskFormatter tel = new MaskFormatter("### ## ## ##");
			phone_f = new JFormattedTextField(tel);
			phone_f.setBorder(new EmptyBorder(0, 10, 0, 10));
			phone_f.setFont(fieldFont);
			phone_f.addActionListener(this);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		
		pass_f = new JPasswordField();
		pass_f.setBorder(new EmptyBorder(0, 10, 0, 10));
		pass_f.setFont(fieldFont);
		pass_f.addActionListener(this);
		
		conpass_f = new JPasswordField();
		conpass_f.setBorder(new EmptyBorder(0, 10, 0, 10));
		conpass_f.setFont(fieldFont);
		conpass_f.addActionListener(this);
		
		part1.add(name);
		part1.add(name_f);
		part1.add(surname);
		part1.add(surname_f);
		
		part2.add(address);
		part2.add(address_f);
		part2.add(phone);
		part2.add(phone_f);
		
		part3.add(password);
		part3.add(pass_f);
		part3.add(conpass);
		part3.add(conpass_f);
		
		form.add(part1);
		form.add(part2);
		form.add(part3);
		
		signup.setBounds(300, 620, 400, 50);
		signup.setBackground(new Color(66, 139, 202));
		signup.setForeground(Color.white);
		signup.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		signup.addActionListener(this);
		
		background.add(form);
		background.add(signup);
		
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

		JButton btnSource = (JButton) e.getSource();
		
		if (btnSource == signup) {
			
			String name, surname, address, password, confirm_pass;
			String phone;
			SignupForm sgf;
			
			dialog_error = new JOptionPane();
			dialog_confirm = new JOptionPane();
			dialog_success = new JOptionPane();
			
			name = name_f.getText(); surname = surname_f.getText(); address = address_f.getText(); 
			password = pass_f.getPassword().toString(); confirm_pass = conpass_f.getPassword().toString();
//			phone = Integer.valueOf(phone_f.getText().replaceAll("\\s", ""));
			phone = phone_f.getText();
			
			int confirm = dialog_confirm.showConfirmDialog(null, "Voulez-vous vraiment confirmer??", "Soumission du formulaire", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (confirm == JOptionPane.OK_OPTION) {
				if (password.equals(confirm_pass)) {
					
					sgf = new SignupForm();
					
					if (sgf.hasErrorFields(name, surname, password, phone) || sgf.setAddress(address)) {
						dialog_error.showMessageDialog(null, sgf.getErrorMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else {
						
						Boss boss = new Boss();
						boss.setName(sgf.getName());
						boss.setSurname(sgf.getSurname());
						boss.setPassword(sgf.getPassword());
						boss.setPhone(sgf.getPhone());
						boss.setAddress(address);
						boss.setProfile("mesImages/profile.jpg");
						BossModel bossManager = new BossModel();
						
						if(bossManager.create(boss)) {
							dialog_success.showMessageDialog(null, "création éffectué", "Validation", JOptionPane.INFORMATION_MESSAGE);
							setState(1);
						}
					}
				}
				else {
					dialog_error.showMessageDialog(null, "Les mots de passe ne sont pas équivalents", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	
}
