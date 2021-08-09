package Model;

import java.sql.Timestamp;

public class Visit {
	
	private String goal, description;
	private Timestamp period;
	private int idCom, idCl;

	public Visit() {
		
	}

	public Visit(String goal, String description, int idCom, int idCl) {
		this.goal = goal;
		this.description = description;
		this.idCom = idCom;
		this.idCl = idCl;
	}
	
	public int getIdCom() {
		return idCom;
	}

	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}

	public int getIdCl() {
		return idCl;
	}

	public void setIdCl(int idCl) {
		this.idCl = idCl;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	public Timestamp getPeriod() {
		return period;
	}

	public void setPeriod(Timestamp period) {
		this.period = period;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Visit [goal=" + goal + ", description=" + description + ", period=" + period + ", idCom=" + idCom
				+ ", idCl=" + idCl + "]";
	}
}
