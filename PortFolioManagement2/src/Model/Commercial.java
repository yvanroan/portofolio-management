package Model;

public class Commercial {
	
	private String name, surname, profileC,phone, password;
	private int idCom,  deleted;
	
	public Commercial() {
	
	}

	public Commercial(String name, String surname, String password, String profileC) {
		this.name = name;
		this.surname = surname;
		this.profileC = profileC;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	public String getProfileC() {
		return profileC;
	}

	public void setProfileC(String profileC) {
		this.profileC = profileC;
	}

	public int getIdCom() {
		return idCom;
	}

	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Commercial [name=" + name + ", surname=" + surname + ", profileC=" + profileC + ", password=" + password
				+ ", idCom=" + idCom + ", phone=" + phone + "]";
	}

}
