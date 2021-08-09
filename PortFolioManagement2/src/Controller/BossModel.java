package Controller;

import DAO.ConnectDB;
import Model.Boss;
import Model.Commercial;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BossModel {
	
List <Commercial> listComs;
	
	public List <Commercial> findAllCommercials() {
		
		try {
			listComs = new ArrayList<Commercial>();
			
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM commercial cm");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Commercial com = new Commercial();
				com.setIdCom(rs.getInt("IDCom"));
				com.setName(rs.getString("name"));
				com.setSurname(rs.getString("surname"));
				com.setPassword(rs.getString("password"));
				com.setPhone(rs.getString("phone"));
				com.setProfileC(rs.getString("profileC"));
				com.setDeleted(rs.getInt("deleted"));
				listComs.add(com);
			} 
		}
		catch(Exception e) {
			System.err.println(e);
		}
		return listComs;
	}
	
	public Commercial find (int id) {
		Commercial com = new Commercial();
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM commercial WHERE IDComt = ?");
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
			System.err.println(e);
		}
		return com;
	}
	
	public boolean exist() {
		
		boolean rtn = false;
		
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM boss");
			ResultSet rs = ps.executeQuery();
			
			// on se positionne à la fin du tuple
			rs.last();
			int rows = rs.getRow();
		
			if (rows <= 0) {
				rtn = false;
			}
			else {
				rtn = true;
			}
			
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return rtn;
	}
	
	public boolean create (Boss boss) {
		
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("INSERT INTO boss (name, surname, phone, address, password, profile)"
					+ " VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, boss.getName());
			ps.setString(2, boss.getSurname());
			ps.setString(3, boss.getPhone());
			ps.setString(4, boss.getAddress());
			ps.setString(5, boss.getPassword());
			ps.setString(6, boss.getProfile());
			
			return ps.executeUpdate() > 0;
		}
		catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	public boolean update(Boss boss) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("UPDATE boss SET "
					+ "name = ?, surname = ?, password = ?, phone = ?, address = ?, profile = ? WHERE IDBoss = ?");
			ps.setString(1, boss.getName());
			ps.setString(2, boss.getSurname());
			ps.setString(3, boss.getPassword());
			ps.setString(4, boss.getPhone());
			ps.setString(5, boss.getAddress());
			ps.setString(6,  boss.getProfile());
			ps.setInt(7, boss.getIdBoss());
			
			return ps.executeUpdate() > 0; 
		}
		catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	public boolean delete(Boss boss) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("DELETE FROM boss WHERE IDClient = ?");
			ps.setInt(1, boss.getIdBoss());
			
			return ps.executeUpdate() > 0; 
		}
		catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	public void setId(Boss boss) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT IDBoss FROM boss WHERE phone = ?");
			ps.setString(1, boss.getPhone());
			ResultSet rs = ps.executeQuery();
			int value = 0;
			while (rs.next()) {
				value = rs.getInt("IDBoss");
			}
			boss.setIdBoss(value);
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
}
