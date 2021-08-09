package Controller;

import DAO.ConnectDB;
import Model.Client;
import Model.Commercial;
import Model.Visit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VisitModel {
	List <Visit> listVisits;
	private Calendar cal = Calendar.getInstance();
	
	public List <Visit> findVisits(Commercial com, Client client) {
		try {
			listVisits = new ArrayList <Visit>();
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT cl.name, cl.surname, cm.name, cm.surname, period, goal"
					+ "  FROM client cl, commercial cm, visit v WHERE v.IDCom = ? and v.IDClient = ? and cm.IDCom = v.IDCom and cl.IDClient IN "
					+ "(SELECT cl.IDClient FROM client cl, commercial cm, visit v WHERE cl.IDCom = cm.IDCom and cl.IDClient = ?) and "
					+ "period <= ?");
			ps.setInt(1, com.getIdCom());
			ps.setInt(2, client.getIdClient());
			ps.setInt(3, client.getIdClient());
			ps.setTimestamp(4, new Timestamp(cal.getTimeInMillis()));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Visit visit = new Visit();
				visit.setIdCl(rs.getInt("IDClient"));
				visit.setIdCom(rs.getInt("IDCom"));
				visit.setGoal(rs.getString("goal"));
				visit.setPeriod(rs.getTimestamp("period"));
				visit.setDescription(rs.getString("description"));
				listVisits.add(visit);
			}
		}
		catch(Exception e) {
			System.err.println(e);
		}
		return listVisits;
	}
	
	public List <Visit> find(Commercial com) {
		try {
			listVisits = new ArrayList <Visit>();
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM visit WHERE idCom = ?");
			ps.setInt(1, com.getIdCom());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Visit visit = new Visit();
				visit.setIdCl(rs.getInt("IDClient"));
				visit.setIdCom(rs.getInt("IDCom"));
				visit.setGoal(rs.getString("goal"));
				visit.setPeriod(rs.getTimestamp("period"));
				visit.setDescription(rs.getString("description"));
				listVisits.add(visit);
			}
		}
		catch(Exception e) {
			System.err.println(e);
		}
		return listVisits;
	}
	
	public boolean add(int idcom, int idclient, String goal, String description, Timestamp period) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("INSERT INTO visit VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1, idclient);
			ps.setInt(2, idcom);
			ps.setString(3, goal);
			ps.setString(4, description);
			ps.setTimestamp(5, period);
			
			return ps.executeUpdate() > 0;
		}
		catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	public boolean update(int idcom, int idclient, String goal, String description, Timestamp period) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("UPDATE visit SET "
					+ "IDCom = ?, IDClient = ?, goal = ?, period = ?, description = ? WHERE IDCom = ? and IDClient = ?");
			ps.setInt(1, idcom);
			ps.setInt(2, idclient);
			ps.setString(3, goal);
			ps.setTimestamp(4, period);
			ps.setInt(5, idcom);
			ps.setInt(6, idclient);
			ps.setString(7, description);
			
			return ps.executeUpdate() > 0; 
		}
		catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	public boolean remove(Visit visit) {
		boolean returned = false;
		for (Visit vs: listVisits) {
			if (vs.equals(visit)) {
				listVisits.remove(vs);
				returned = true;
			}
		}
		return returned;
	}
}
