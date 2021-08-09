package Controller;

public class SignupForm {
	
	private String name, surname, address, password, errorMessage = "";
	private String phone;

	public SignupForm () {
		
	}

	public boolean hasErrorFields (String name, String surname, String password, String phone) {
		boolean namef = false, surnamef = false, passf = false, result = false;
		
		namef = setName(name.trim().toLowerCase());
		surnamef = setSurname(surname.trim().toLowerCase());
		setPhone(phone);
		passf = setPassword(password.trim().toLowerCase());
		
		if (namef || surnamef || passf) {
			result = true; 
		}
		return result;
	}
	

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		boolean value = false;
		
		if (!isNumeric(name)) {
			this.name = name;
		}
		else {
			this.errorMessage += "le champ nom ne peut contenir des chiffres"+ "\n";
			value = true;
		}
//		if(name.length() < 5) {
//			this.errorMessage += "Votre nom doit contenir au moins 5 caractères" + "\n";
//			value = true;
//		}
		return value;
	}
	

	public String getSurname() {
		return surname;
	}

	public boolean setSurname(String surname) {
		boolean value = false;
		
		if (!isNumeric(surname)) {
			this.surname = surname;
		}
		else {
			this.errorMessage += "le champ prenom ne peut contenir des chiffres"+ "\n";
			value = true;
		}
//		if(surname.length() < 5) {
//			this.errorMessage += "Votre prenom doit contenir au moins 5 caractères" + "\n";
//			value = true;
//		}
		
		return value;
	}
	
	

	public String getAddress() {
		return address;
	}

	public boolean setAddress(String address) {
		boolean value = false;
		if (!isNumeric(address)) {
			this.address = address;
		}
		else {
			this.errorMessage += "le champ adresse ne peut contenir des chiffres"+ "\n";
			value = true;
		}
		if(surname.length() < 5) {
			this.errorMessage += "Votre adresse doit contenir au moins 5 caractères" + "\n";
			value = true;
		}
		return value;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public boolean setPassword(String password) {
		boolean value = false;
		if (!isNumeric(password)) 
			this.password = password;
		else {
			this.errorMessage += "Votre mot de passe ne doit pas uniquement contenir des chiffres" +"\n";
		}
		if (password.length() < 6) {
			this.errorMessage += "Votre mot de passe doit contenir au moins 6 caractéres" + "\n";
			value = true;
		}
		return value;
	}

	public boolean isNumeric(String value) {
		try {
			Integer.parseInt(value);
		}
		catch(NumberFormatException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
//<>