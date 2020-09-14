package com.pellegrini.code.AddressBook;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CsvService {
	public static final String ADDRESS_BOOK_DATA = "dataGet.csv";
	public static void dumpDataIntoCsv(Map<String, Contact> listContacts) throws IOException {
			List<Contact> listContacs = new ArrayList<>(10);
			for(Map.Entry<String, Contact> entry : listContacts.entrySet())
				listContacs.add(entry.getValue());
			
			try {
				BufferedWriter writer = Files.newBufferedWriter(Paths.get(ADDRESS_BOOK_DATA));
				CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("company", "email").withTrim());
				Contact contact1 = listContacs.get(0);
	            printer.printRecord(contact1.getCompany(),contact1.getEmail());
	            printer.flush();
	            printer.close();
			} catch(Exception e) {
				System.out.println("(dump data into csv) Exception registered: " + e);
			}
	}
	public static HashMap<String, Contact> loadFromCsv() throws IOException {
		try (
	            Reader reader = Files.newBufferedReader(Paths.get(ADDRESS_BOOK_DATA));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
	    ) {
			if(!ContactsDao.read().isEmpty())
				System.out.println("lol");
			HashMap<String, Contact> contactsMap = new HashMap<>();
			for (CSVRecord csvRecord : csvParser) {
                contactsMap.put(csvRecord.get(0), new Contact(csvRecord.get(0), csvRecord.get(1), csvRecord.get(2), csvRecord.get(3), csvRecord.get(4), csvRecord.get(5)));
            }
			
			return contactsMap;
		} catch (Exception e) {
			System.out.println("(load from csv) Exception registered: " + e);
			
			return new HashMap<String, Contact>();
		}
	}
	public static void generateCsvForDebug() throws IOException {
		try (FileWriter writer = new FileWriter(ADDRESS_BOOK_DATA)) {
			UUID uuid = UUID.randomUUID();
			writer.append(uuid.toString() + ",Mario,Rossi,+39 123 456 7890,mario@rossi.it,Mario Rossi srl");
		} catch(Exception e) {
			System.out.println("(generate csv for debug) Exception registered: " + e);
		}
	}
}
