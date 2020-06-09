package com.mmunoz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	Scanner sc = new Scanner(System.in);
	private ArrayList<BaseContact> contacts = new ArrayList<>();
	PersonContact personContact = new PersonContact();
	BusinessContact businessContact = new BusinessContact();
	public void displayMenu() {
		do { //Sorting through the Menu
			System.out.println("******************");
			System.out.println("*******MENU*******");
			System.out.println("******************");
			System.out.println("1] ADD CONTACT");
			System.out.println("2] REMOVE CONTACT");
			System.out.println("3] SEARCH CONTACT");
			System.out.println("4] DISPLAY CONTACT");
			System.out.println("0] EXIT");

			System.out.println("Select your option");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				addContact();
				break;
			case 2:
				removeContact();
				break;
			case 3:
				searchContact();
				break;
			case 4:
				displayContact();
				break;
			case 5:
				sortContact();
				break;
			default:
				System.out.println("EXIT");
				System.exit(0);
			}
		} while (true);
	}
	
	public String addContact() {
		System.out.println(contacts.add(personContact));
		System.out.println("Will add a contact");
		System.out.println("Enter Business, or Personal");
		String tryAgain = "False input, try again.";
		String option2 = "Business";
		String option1 = "Personal";
		String choice = sc.nextLine();
		 //Depending on which selection is to be added
		if (choice.contentEquals(option1)) {
			System.out.println("Enter Name, number, description, and DOB in this format(08241997)");
			String name = sc.nextLine();
			String number = sc.nextLine();
			String Description = sc.nextLine();
			String DOB = sc.nextLine();
			String newContact = personContact.createPersonalContact(name, number, Description, DOB);
			//Going to be adding contacts to the contacts array list.

			System.out.println(newContact);
			return newContact;
		}
		if (choice.contentEquals(option2)) {

			System.out.println("Enter Name, number, description, BusinessURL, and DOB in this format(08241997)");
			String name = sc.nextLine();
			int number = sc.nextInt();
			String Description = sc.nextLine();
			String websiteURL = sc.nextLine();
			int DOB = sc.nextInt();
			String newContact = businessContact.createBusinessContact(name, number, Description, websiteURL, DOB);
			System.out.println(newContact);
			return newContact;
		}
		return tryAgain;
	}

	public void removeContact() {
		System.out.println("Will remove a contact");
	}

	public void searchContact() {
		System.out.println("Will search for a contact");
	}

	public void displayContact() {
		System.out.println("Will display a contact");
	}

	public void sortContact() {
		System.out.println("Will sort contacts");
	}
}
