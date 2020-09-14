package com.pellegrini.code.AddressBook;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


public class AddressBookService {
	public static Contact checkData(Contact data) throws IOException {
		String empty = "-";
		if(data.getName().isEmpty())
			data.setName(empty);
		if(data.getSurname().isEmpty())
			data.setSurname(empty);
		if(data.getPhone().isEmpty())
			data.setPhone(empty);
		if(data.getEmail().isEmpty())
			data.setEmail(empty);
		if(data.getCompany().isEmpty())
			data.setCompany(empty);
		
		if(!data.getName().equals(empty))
			data.setName(data.getName().trim());
		if(!data.getSurname().equals(empty))
			data.setSurname(data.getSurname().trim());
		if(!data.getPhone().equals(empty))
			data.setPhone(data.getPhone().trim());
		if(!data.getEmail().equals(empty))
			data.setEmail(data.getEmail().trim());
		if(!data.getCompany().equals(empty))
			data.setCompany(data.getCompany().trim());
		
		return data;
	}
	public static String generateUniqueIdentifier() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	public static void create(HttpServletRequest request) throws IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String company = request.getParameter("company");
		ContactsDao.create(id, checkData(new Contact(id, name, surname, phone, email, company)));
		CsvService.dumpDataIntoCsv(ContactsDao.read());
	}
	public static void delete(HttpServletRequest request) throws IOException {
		String id = request.getParameter("id");
		ContactsDao.delete(id);
		CsvService.dumpDataIntoCsv(ContactsDao.read());
	}
	public static void update(HttpServletRequest request) throws IOException {
		String idUpdate = request.getParameter("id");
		String nameUpdate = request.getParameter("name");
		String surnameUpdate = request.getParameter("surname");
		String phoneUpdate = request.getParameter("phone");
		String emailUpdate = request.getParameter("email");
		String companyUpdate = request.getParameter("company");
		ContactsDao.update(idUpdate, checkData(new Contact(idUpdate, nameUpdate, surnameUpdate, phoneUpdate, emailUpdate, companyUpdate)));
		CsvService.dumpDataIntoCsv(ContactsDao.read());
	}
}
