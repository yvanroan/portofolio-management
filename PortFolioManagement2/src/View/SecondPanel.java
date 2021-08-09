package View;

import Controller.LoginModel;
import Controller.SignupForm;
import Model.Boss;
import Model.Commercial;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondPanel extends JPanel implements ActionListener {
	
	protected JLabel msg;
	protected JButton login = new JButton("SE CONNECTER");
	protected Font font_tf = new Font("Times New Roman", Font.BOLD, 18);
	protected Color bg_field = new Color(240, 240, 240);
	protected JTextField login_username;
//	protected JPasswordField login_password;
	protected JTextField login_password;
	protected Boss boss;
	protected Commercial com;
	protected JOptionPane dialog_confirm, dialog_error, dialog_success;
	protected int state;
	MenuPanel panel = new MenuPanel();
	public SecondPanel() {
		
		this.setLayout(null);
		
		/**************************************************
		 ********************* LOGIN **********************
		 **************************************************/
		
		CreateImage Imgcreator = new CreateImage(1000, 740);
		Imgcreator.setImg(new ImageIcon("mesImages/registration.jpg"));
		JLabel background = Imgcreator.generate();
		background.setBounds(0, 0, 1000, 740);
		background.setLayout(null);
		
		JLabel login_lab = new JLabel("SE CONNECTER A UN COMPTE");
		
		login_lab.setFont(new Font("Californian FB", Font.BOLD, 24));
		login_lab.setForeground(Color.black);
		login_lab.setBounds(350, 50, 350, 100);
		
		JPanel login_form = new JPanel();
		login_form.setLayout(new GridLayout(3, 1, 0, 30));
		login_form.setBounds(300, 200, 400, 300);
		login_form.setBorder(new EmptyBorder(50, 30, 50, 30));
		login_form.setBackground(new Color(0, 0, 0, 80));
		
		login_username = new JTextField("nom d'utilisateur");
		login_username.setBorder(new EmptyBorder(0, 10, 0, 10));
		login_username.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		login_username.setBackground(new Color(240, 240, 240));
		
		login_password = new JPasswordField("password");
		login_password.setBorder(new EmptyBorder(0, 10, 0, 10));
		login_password.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		login_password.setBackground(new Color(240, 240, 240));
		
		login.setFont(font_tf);
		login.setBackground(new Color(66, 139, 202));
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		
		login_form.add(login_username);
		login_form.add(login_password);
		login_form.add(login);
		
		background.add(login_lab);
		background.add(login_form);
		
		this.add(background);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton btnSource = (JButton) e.getSource();
		
		if (btnSource == login) {
			dialog_error = new JOptionPane();
			dialog_confirm = new JOptionPane();

//			int confirm = dialog_confirm.showConfirmDialog(null, "Voulez-vous vraiment confirmer??", "Connection",
//					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

			String username = login_username.getText();
//			String password = login_password.getPassword().toString();
			String password = login_password.getText();

//			if (confirm == JOptionPane.OK_OPTION) {
			SignupForm sgf = new SignupForm();

			if (sgf.setName(username) || sgf.setPassword(password)) {
				dialog_error.showMessageDialog(null, sgf.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			} else {

				LoginModel log = new LoginModel(username, password);
				boss = log.loginBoss();
				com = log.login();
				if (log.hasErrors()) {
					dialog_error.showMessageDialog(null, log.getErrorMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
					login_password.setText("");
				}
				if(com == null) {
					setState(2);


				}
				else {

					setState(1);
					System.out.println(com.toString());
				}
			}
//		}
		}		
	}
}
