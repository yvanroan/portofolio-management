package Controller;

import DAO.ConnectDB;
import Model.Boss;
import Model.Commercial;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginModel {
	
	private String name, password, errorMessage = "";
	private boolean hasErr;
	private int completed=0;


	public LoginModel(String name, String password) {
		this.name = name.toLowerCase();
		this.password = password.toLowerCase();
	}
	
	public Commercial login() {
		Commercial com = null;
		try {
			System.out.print("yes login");
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM commercial WHERE name = ? and password = ?");
			ps.setString(1, this.name);
			ps.setString(2, this.password);
			ResultSet rs = ps.executeQuery();
			// on positionne le curseur à la fin du tuple
			rs.last();//this will tell you if there is actually any value returned for the querry
			int rows = rs.getRow();
			
			if (rows <= 0) {
				this.hasErr = true;
				System.out.println("yes noyhing");
			}
			else {
				completed = 1;
				// on positionne le curseur avant la première ligne du tuple
				rs.beforeFirst();
				while(rs.next()) {
					com = new Commercial();
					com.setIdCom(rs.getInt("IDCom"));
					com.setName(rs.getString("name"));
					com.setSurname(rs.getString("surname"));
					com.setPassword(rs.getString("password"));
					com.setPhone(rs.getString("phone"));
					com.setProfileC(rs.getString("profileC"));
				}

				return com;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return com;
	}
	
	public Boss loginBoss() {
		Boss boss = null;
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM boss WHERE name = ? and password = ?");
			ps.setString(1, this.name);
			ps.setString(2, this.password);
			ResultSet rs = ps.executeQuery();
			// on positionne le curseur à la fin du tuple
			rs.last();
			int rows = rs.getRow();
			
			if (rows <= 0) {
				System.out.println("yes nothing");
				this.hasErr = true;
			}
			else {
				completed =1;
				// on positionne le curseur avant la première ligne du tuple
				rs.beforeFirst();
				while(rs.next()) {
					boss = new Boss();
					boss.setIdBoss(rs.getInt("IDBoss"));
					boss.setName(rs.getString("name"));
					boss.setSurname(rs.getString("surname"));
					boss.setPassword(rs.getString("password"));
					boss.setPhone(rs.getString("phone"));
					boss.setAddress(rs.getString("address"));
					boss.setProfile(rs.getString("profile"));
				}
				return boss;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return boss;
	}
	
	public boolean hasErrors() {
		if (this.hasErr && completed == 0) {
			this.errorMessage += "Aucun identifiant avec ce mot de passe n'a été trouvé!";
			return true;
		}
		return false;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
}
