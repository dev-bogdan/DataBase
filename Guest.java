package lista;

import java.io.Serializable;

public class Guest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 String lastName;
	String firstName;
	 String email;
	 String phoneNumber;

	public Guest(String lastName, String firstName, String email, String phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}
