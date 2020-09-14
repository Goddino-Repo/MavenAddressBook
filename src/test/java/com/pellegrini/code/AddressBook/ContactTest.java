package com.pellegrini.code.AddressBook;

import org.junit.Test;

public class ContactTest {
	@Test
	public void testname() throws Exception {
		Contact primo = new Contact("12345", "Mario", "Rossi", "+39 123 456 8790", "mario@rossi.it", "Mario Rossi spa");
		Contact secondo = new Contact("23456", "Mario", "Verdi", "+39 123 456 8790", "mario@verdi.it", "Mario Verdi spa");
		Contact terzo = new Contact("34567", "Mario", "Blu", "+39 123 456 8790", "mario@blu.it", "Mario Blu spa");
		System.out.println(primo.toString());
	}
}
