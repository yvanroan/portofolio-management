
package Model;

public class Boss {
	
	private String name, surname, address, password, profile,phone;
	private int idBoss;
	
	public Boss() {
		
	}

	public Boss (String name, String surname, String address, String password, String profile, int idBoss, String phone) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.password = password;
		this.profile = profile;
		this.idBoss = idBoss;
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getIdBoss() {
		return idBoss;
	}

	public void setIdBoss(int idBoss) {
		this.idBoss = idBoss;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Boss [name=" + name + ", surname=" + surname + ", address=" + address + ", password=" + password
				+ ", profile=" + profile + ", idBoss=" + idBoss + ", phone=" + phone + "]";
	}
	
	
}
