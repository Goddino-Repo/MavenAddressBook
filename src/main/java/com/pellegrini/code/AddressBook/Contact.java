package com.pellegrini.code.AddressBook;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"email", "phone"})
public class Contact {
	protected String uniqueIdentifier;
	protected String name;
	protected String surname;
	protected String phone;
	protected String email;
	protected String company;
	
	public Contact(String uniqueIdentifier, String name, String surname, String phone, String email, String company) {
		this.uniqueIdentifier = uniqueIdentifier;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.company = company;
	}
	public String toCsv() {
		return this.uniqueIdentifier + "," + this.name + "," + this.surname + "," + this.phone + "," + this.email + "," + this.company + "\n";
	}
}
