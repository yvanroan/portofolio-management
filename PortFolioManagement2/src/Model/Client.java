package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Client {
	
	private String name, surname, status, sex, address, location, profile;
	private int idClient, idCom;
	
	
	public Client() {
		
	}

	public Client(String name, String surname, String sex, String address, String location, String profile) {
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.address = address;
		this.location = location;
		this.profile = profile;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getIdCom() {
		return idCom;
	}
	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", surname=" + surname + ", status=" + status + ", address=" + address
				+ ", location=" + location + ", profile=" + profile + ", idClient=" + idClient + ", idCom=" + idCom
				+ "]";
	}
	
}
