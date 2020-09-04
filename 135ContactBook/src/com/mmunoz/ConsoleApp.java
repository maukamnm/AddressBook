package com.mmunoz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ConsoleApp {
	static AddressBook addB = new AddressBook();
	static final File file = new File("file.txt");

	public static void main(String[] args) {
		read();
		addB.displayMenu();
		write();
	}
//reading from file using buffered reader and splitting each element with the pipe "|"
	public static void read() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String [] part = line.split("\\|");
				//
				switch (part[0]) {
				case "PersonContact":
					System.out.println("Personal Contact");
					addB.getBc().add(new PersonContact(part[1], Long.parseLong(part[5]), part[3], part[4], part[6],  (LocalDate.parse(part[2]))));
					break;
				case "BusinessContact":
					System.out.println(part[0]);
					addB.getBc().add(new BusinessContact(part[1], Integer.parseInt(part[2]), part[3]));
					break;
				default:
					System.out.println("Class not found");
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}System.out.println("Size = "+ addB.getBc().size());
	}

	//storing contacts which will be used in write
	private static void storeContactObject(FileWriter wr) {
		try {
			storeContact();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write() {
		try {
			FileWriter wr = new FileWriter(file, false);
			storeContactObject(wr);
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//throwing exceptions in case any problem occurs. 
	//storing contacts by running through the array with a for each loop 
	//depending on bus or pers it will tell us "writing "BLANK" contacts to file"
	private static void storeContact() throws IOException {
		FileWriter wr = new FileWriter(file, false);
		System.out.println("writing/storing personal contact to text file...");
		for (BaseContact base : addB.getBc()) {
			System.out.println(base);
			if (base.getClass().getSimpleName().contentEquals("PersonContact")) {
				System.out.println("Writing personal contacts to file...");
				System.out.println(((PersonContact)base).toFile()); //Casting base contact to person contact
				wr.write(((PersonContact)base).toFile() + System.lineSeparator());
			}
			if (base.getClass().getSimpleName().contentEquals("BusinessContact")) {
				System.out.println("Writing business contacts to file...");
				System.out.println(((BusinessContact)base).toFile()); //Casting base contact to business contact
				wr.write(((BusinessContact)base).toFile() + System.lineSeparator());
			}
		}
		wr.close();
	}
	
}
