package com.pellegrini.code.AddressBook;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVRecord;


public class ContactsDao {
	private static Map<String, Contact> contactsMap = new HashMap<>(10);
	
	public static void create(String id, Contact contact) {
		String name = contact.getName();
		String surname = contact.getSurname();
		String phone = contact.getPhone();
		String email = contact.getEmail();
		String company = contact.getCompany();
		contactsMap.put(id, new Contact(id, name, surname, phone, email, company));
	}
	
	public static Map<String, Contact> read() throws IOException {
		return contactsMap;
	}
	
	public static void update(String id, Contact contact) {
		contactsMap.get(id).setName(contact.getName());
		contactsMap.get(id).setSurname(contact.getSurname());
		contactsMap.get(id).setPhone(contact.getPhone());
		contactsMap.get(id).setEmail(contact.getEmail());
		contactsMap.get(id).setCompany(contact.getCompany());
	}
	
	public static void delete(String id) {
		contactsMap.remove(id);
	}
	
	public static void setContact(CSVRecord record) {
		System.out.println(record.toString());
		String uniqueIdentifier = record.get(0);
		String name = record.get(1);
		String surname = record.get(2);
		String phone = record.get(3);
		String email = record.get(4);
		String company = record.get(5);
		contactsMap.put(uniqueIdentifier, new Contact(uniqueIdentifier, name, surname, phone, email, company));
	}
}
