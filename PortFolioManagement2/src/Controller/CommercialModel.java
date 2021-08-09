package Controller;

import DAO.ConnectDB;
import Model.Client;
import Model.Commercial;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommercialModel {
	
	List <Client> listClients;
	List <Commercial> listCommercials;
	
	public List <Client> findAllClients(Commercial com) {
		try {
			listClients = new ArrayList<Client>();
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM client cl, commercial cm WHERE"
					+ " cm.IDCom = cl.IDCom");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Client cl = new Client();
				cl.setIdClient(rs.getInt("IDClient"));
				cl.setName(rs.getString("name"));
				cl.setSurname(rs.getString("surname"));
				cl.setStatus(rs.getString("status"));
				cl.setAddress(rs.getString("address"));
				cl.setPhone(rs.getString("phone"));
				cl.setIdCom(rs.getInt("IDCom"));
				cl.setProfile(rs.getString("profile"));
				listClients.add(cl);
			} 
		}
		catch(Exception e) {
			System.err.println(e);
		}
		return listClients;
	}
	
	public List <Commercial> getAllCom() {
		try {
			listCommercials = new ArrayList<Commercial>();
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM commercial");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Commercial c = new Commercial();
				c.setIdCom(rs.getInt("IDCom"));
				c.setName(rs.getString("name"));
				c.setSurname(rs.getString("surname"));
				c.setPassword(rs.getString("password"));
				c.setPhone(rs.getString("phone"));
				c.setProfileC(rs.getString("profileC"));
				c.setDeleted(rs.getInt("deleted"));
				listCommercials.add(c);
			}
		}
		catch(Exception e) {
			System.err.println(e);
		}
		return listCommercials;
	}
	
	public Commercial find (int id) {

		Commercial com = new Commercial();
		
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM commercial WHERE IDCom = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				com.setIdCom(rs.getInt("IDCom"));
				com.setName(rs.getString("name"));
				com.setSurname(rs.getString("surname"));
				com.setPassword(rs.getString("password"));
				com.setPhone(rs.getString("phone"));
				com.setProfileC(rs.getString("profileC"));
				com.setDeleted(rs.getInt("deleted"));
			} 
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return com;
	}
	
	public boolean create (Commercial com) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("INSERT INTO commercial (name, surname, password, phone, profileC, deleted)"
					+ " VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, com.getName());
			ps.setString(2, com.getSurname());
			ps.setString(3, com.getPassword());
			ps.setString(4, com.getPhone());
			ps.setString(5, com.getProfileC());
			
			return ps.executeUpdate() > 0;
		}
		catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	public boolean update(Commercial com) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("UPDATE commercial SET "
					+ "name = ?, surname = ?, password = ?, phone = ?, profileC = ? WHERE IDCom = ?");
			ps.setString(1, com.getName());
			ps.setString(2, com.getSurname());
			ps.setString(3, com.getPassword());
			ps.setString(4, com.getPhone());
			ps.setString(5, com.getProfileC());
			ps.setInt(6, com.getIdCom());
			
			return ps.executeUpdate() > 0; 
		}
		catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	public boolean delete(Commercial com) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("DELETE FROM commercial WHERE IDCom = ?");
			ps.setInt(1, com.getIdCom());
			
			return ps.executeUpdate() > 0; 
		}
		catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	public void setId(Commercial com) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT IDCom FROM commercial WHERE phone = ?");
			ps.setString(1, com.getPhone());
			ResultSet rs = ps.executeQuery();
			int value = 0;
			while (rs.next()) {
				value = rs.getInt("IDCom");
			}
			com.setIdCom(value);
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
}

//<>