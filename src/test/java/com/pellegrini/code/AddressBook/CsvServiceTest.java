package com.pellegrini.code.AddressBook;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CsvServiceTest {
	@Test
	public void testname() throws Exception {
		Map<String, Contact> listContacts = new HashMap<>();
		listContacts.put("12345", new Contact("12345", "Mario", "Rossi", "+39 123 456 7890", "mario@rossi.it", "Mario Rossi spa"));
		listContacts.put("23456", new Contact("23456", "Mario", "Verdi", "+39 123 456 7890", "mario@verdi.it", "Mario Verdi spa"));
		listContacts.put("34567", new Contact("34567", "Mario", "Blu", "+39 123 456 7890", "mario@blu.it", "Mario Blu spa"));
		CsvService.dumpDataIntoCsv(listContacts);
	}
}
