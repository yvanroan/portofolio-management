package Controller;

import DAO.ConnectDB;
import Model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientModel {
	 
	List <Client> listClients;
	
	public List <Client> findAll() {
		try {
			listClients = new ArrayList<Client>();
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM client");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Client cl = new Client();
				cl.setIdClient(rs.getInt("IDClient"));
				cl.setName(rs.getString("name"));
				cl.setSurname(rs.getString("surname"));
				cl.setSex(rs.getString("sex"));
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
	
	public Client find(int id) {
		Client cl = new Client();
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM client WHERE IDClient = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cl.setIdClient(rs.getInt("IDClient"));
				cl.setName(rs.getString("name"));
				cl.setSurname(rs.getString("surname"));
				cl.setSex(rs.getString("sex"));
				cl.setStatus(rs.getString("status"));
				cl.setAddress(rs.getString("address"));
				cl.setPhone(rs.getString("phone"));
				cl.setIdCom(rs.getInt("IDCom"));
				cl.setProfile(rs.getString("profile"));
			} 
		}
		catch(Exception e) {
			System.err.println(e);
		}
		return cl;
	}
	
	public Client findByZone(String zone_geo) {
		Client cl = new Client();
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM client WHERE phone = ?");
			ps.setString(1, zone_geo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cl.setIdClient(rs.getInt("IDClient"));
				cl.setName(rs.getString("name"));
				cl.setSurname(rs.getString("surname"));
				cl.setSex(rs.getString("sex"));
				cl.setStatus(rs.getString("status"));
				cl.setAddress(rs.getString("address"));
				cl.setPhone(rs.getString("phone"));
				cl.setIdCom(rs.getInt("IDCom"));
				cl.setProfile(rs.getString("profile"));
			} 
		}
		catch(Exception e) {
			System.err.println(e);
		}
		return cl;
	}
	
	public boolean create(Client client) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("INSERT INTO client "
					+ "(name, surname, sex, address, phone, profile) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, client.getName());
			ps.setString(2, client.getSurname());
			ps.setString(3, client.getSex());
			ps.setString(4, client.getAddress());
			ps.setString(5, client.getPhone());
			ps.setString(6, client.getProfile());
			
			return ps.executeUpdate() > 0; 
		}
		catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	public boolean update(Client client) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("UPDATE client SET "
					+ "name = ?, surname = ?, sex = ?, status = ?, address = ?, phone = ?,"
					+ "profile = ? WHERE IDClient = ?");
			ps.setString(1, client.getName());
			ps.setString(2, client.getSurname());
			ps.setString(3, client.getSex());
			ps.setString(4, client.getStatus());
			ps.setString(5, client.getAddress());
			ps.setString(6, client.getPhone());
			ps.setString(7, client.getProfile());
			ps.setInt(8, client.getIdClient());
			
			return ps.executeUpdate() > 0; 
		}
		catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	public boolean delete(Client client) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("DELETE FROM client WHERE IDClient = ?");
			ps.setInt(1, client.getIdClient());
			
			return ps.executeUpdate() > 0; 
		}
		catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	public boolean remove(Client client) {
		boolean returned = false;
		for (Client cl: listClients) {
			if (cl.equals(client)) {
				listClients.remove(cl);
				returned = true;
			}
		}
		return returned;
	}
	
	public void setId(Client client) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT IDClient FROM client WHERE name = ? and surname = ? and address = ?");
			ps.setString(1, client.getName());
			ps.setString(2, client.getSurname());
			ps.setString(3, client.getAddress());
			ResultSet rs = ps.executeQuery();
			int value = 0;
			while (rs.next()) {
				value = rs.getInt("IDClient");
			}
			client.setIdClient(value);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

//<>