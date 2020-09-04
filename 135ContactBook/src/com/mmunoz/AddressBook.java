package com.mmunoz;

import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.util.Scanner;

public class AddressBook {

	int countPhotoID = 0;
	int countLocID = 0;
	//making instances of the classes since addressbook has personal and business contacts 
	PersonContact personContact = new PersonContact(null, countLocID, null, null, null, null, null, null);
	BusinessContact businessContact = new BusinessContact(null, countLocID, null, null, null, null, null);
	ArrayList<BaseContact> bc = new ArrayList<>();

	Scanner sc = new Scanner(System.in);

	public void displayMenu() {
		menu: do { // Displays menu
			System.out.println("******************");
			System.out.println("*******MENU*******");
			System.out.println("******************");
			System.out.println("1] ADD PERSONAL CONTACT");
			System.out.println("2] ADD BUSINESS CONTACT");
			System.out.println("3] REMOVE CONTACT");
			System.out.println("4] SEARCH CONTACT");
			System.out.println("5] DISPLAY CONTACT");
			System.out.println("6] SORT CONTACT");
			System.out.println("7] EDIT CONTACT");
			System.out.println("0] EXIT");

			System.out.println("Select your option"); // switching through the menu
			switch (Integer.parseInt(sc.nextLine())) {
			//select which menu option you want to proceed with
			case 1:
				addPersonContact();
				break;
			case 2:
				addBusinessContact();
				break;
			case 3:
				removeContact();
				break;
			case 4:
				searchContact();
				break;
			case 5:
				displayContact();
				break;
			case 6:
				sortContact();
				break;
			case 7:
				editContact();
				break;
			default:
				System.out.println("EXIT");
				break menu;
			}
		} while (true);
	}
	//add personal contact 
	public void addPersonContact() {
		ArrayList<Photo> photo = new ArrayList<>();

		int countPhotoID = 0;
		int countLocID = 0;
		boolean addAnother = true;

		System.out.println("********************************");
		System.out.println("******Add Personal Contact******");
		System.out.println("********************************");

		try {
			System.out.println("Enter contact name: ");
			String name = sc.nextLine();
			System.out.println("Enter phone number: ");
			long number = Long.parseLong(sc.nextLine());
			System.out.println("Enter phone type(w for work, h for home, c for cell): ");
			String phone = sc.nextLine();
			System.out.println("Enter birthday in this format(YYYY-MM-DD)");
			String date = sc.nextLine();
			LocalDate DOB = LocalDate.parse(date);
			System.out.println("Enter description: ");
			String Description = sc.nextLine();
			System.out.println("Contact list: ");
			String list = sc.nextLine();
			System.out.println("Contact's relatives: ");
			String relative = sc.nextLine();

			do {
				System.out.println("******Contact Photo******");
				System.out.println("Enter contact photo date: ");
				System.out.println("Format is YYYY-MM-DD");
				String date2 = sc.nextLine();
				LocalDate dateOfPhoto = LocalDate.parse(date2);
				System.out.println("Contact photo description: ");
				String notes = sc.nextLine();
				photo.add(new Photo(countPhotoID, dateOfPhoto, notes));
				System.out.println("Add another photo? Y/N");
				String ans = sc.nextLine().toUpperCase();
				if (ans.contentEquals("N")) {
					addAnother = false;
				} else {
					addAnother = true;
				}

			} while (addAnother == true);

			System.out.println("***********************************");
			System.out.println("********Contact Location***********");
			System.out.println("************************************");

			System.out.println("Contact Location ID: " + ++countLocID);
			System.out.println("Contact Street:");
			String street = sc.nextLine();
			System.out.println("Contact: City");
			String city = sc.nextLine();
			System.out.println("Contact: State");
			String state = sc.nextLine();
			//add new personal contact with attributes from base contact and put it in an array of base contacts
			getBc().add(new PersonContact(name, number, phone, photo, new Location(countLocID, street, city, state),
					relative, list, DOB));

		} catch (Exception e) {
			System.out.println("Invalid input. Try again.");

		}
	}
	//Add business contact with business specific categories
	public void addBusinessContact() {
		ArrayList<Photo> photo = new ArrayList<>();

		boolean addAnother = true;

		System.out.println("********************************");
		System.out.println("******Add Business Contact******");
		System.out.println("********************************");

		try {
			System.out.println("Enter contact name: ");
			String name = sc.nextLine();
			System.out.println("Enter phone number: ");
			long number = Long.parseLong(sc.nextLine());
			System.out.println("Enter phone type (w for work, h for home, c for cell): ");
			String phone = sc.nextLine();
			System.out.println("Enter business hours: ");
			String hours = sc.nextLine();
			System.out.println("Enter business website URL: ");
			String website = sc.nextLine();

			do {
				System.out.println("*************************");
				System.out.println("******Contact Photo******");
				System.out.println("*************************");
				System.out.println("Photo ID = " + ++countPhotoID + "\n Enter contact photo date: ");
				System.out.println("Format is YYYY-MM-DD");
				String date2 = sc.nextLine();
				LocalDate dateOfPhoto = LocalDate.parse(date2);
				System.out.println("Contact photo description: ");
				String notes = sc.nextLine();
				photo.add(new Photo(countPhotoID, dateOfPhoto, notes));
				System.out.println("Add another photo? Y/N");
				String ans = sc.nextLine().toUpperCase();
				if (ans.contentEquals("N")) {
					addAnother = false;
				} else {
					addAnother = true;
				}

			} while (addAnother == true);

			System.out.println("***********************************");
			System.out.println("********Contact Location***********");
			System.out.println("************************************");

			System.out.println("Contact Location ID: " + ++countLocID);
			System.out.println("Contact Street:");
			String street = sc.nextLine();
			System.out.println("Contact: City");
			String city = sc.nextLine();
			System.out.println("Contact: State");
			String state = sc.nextLine();
			//Creating business contact with attributes from base, and new ones from business. 
			getBc().add(new BusinessContact(name, number, phone, new ArrayList<Photo>(),
					new Location(countLocID, street, city, state), hours, website));

		} catch (Exception e) {
			System.out.println("Invalid input. Try again.");
			addBusinessContact();
		}
	}
	//removing contact at the chosen index-1. 
	public void removeContact() {
		boolean removeContact = true;
		do {
			System.out.println("****************************");
			System.out.println("******Remove a contact******");
			System.out.println("****************************");
			System.out.println("Which to remove?");
			displayContact();
			int contactId = Integer.parseInt(sc.nextLine()) - 1;
			System.out.println(getBc().remove(contactId));
			displayContact();
			System.out.println("Remove another? Y or N");
			String response = sc.nextLine().toUpperCase();
			if (response.contentEquals("N")) {
				removeContact = false;
			} else {
				removeContact = true;
			}
		} while (removeContact == true);

	}

	public void searchContact() {
		System.out.println("*****************************");
		System.out.println("**Will search for a contact**");
		System.out.println("*****************************");
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		for (BaseContact c : getBc()) {
			if (c.getName().contentEquals(name)) {
				System.out.println(c);
			}
		}
	}

	public void displayContact() {
		int counter = 1;
		System.out.println("*******DISPLAY CONTACT*******");
		//displays contact starting at one, and goes in through list of bc
		for (BaseContact contact : getBc()) {
			System.out.println(counter++ + "]" + contact);
		}
	}
	//Editing contacts at the specific index and selecting business or personal
	public void editContact() {
		System.out.println("*****************************");
		System.out.println("*********Edit Contact********");
		System.out.println("*****************************");
		System.out.println("Which would you like to edit?");
		displayContact();
		int contactId = Integer.parseInt(sc.nextLine())-1;
		System.out.println("********Editing Contact******");
		System.out.println(getBc().get(contactId));
		if (getBc().get(contactId).getClass().getSimpleName().contentEquals("PersonContact")) {
			editPersonalContact((PersonContact) getBc().get(contactId));

		} else {
			editBusinessContact((BusinessContact) getBc().get(contactId));

		}
	}

	public void editPersonalContact(PersonContact bc) {
		//editing personal contact by going through entries again and resetting it to new values
		System.out.println("*****************************");
		System.out.println("***Editing Personal Contact**");
		System.out.println("*****************************");
		displayContact();
		try {
			System.out.println("Contact name: ");
			bc.setName(sc.nextLine());
			System.out.println("Contact phone: ");
			bc.setNumber(Long.parseLong(sc.nextLine()));
			System.out.println("Contact phone type: ");
			bc.setPhone(sc.nextLine());
			System.out.println("Contact birthday: \n Format : YYYY-MM-DD");
			bc.setDOB((LocalDate.parse(sc.nextLine())));
			System.out.println("Contact Relative: ");
			bc.setListOfRelatives(sc.nextLine());

			System.out.println("***********************************");
			System.out.println("********Contact Location***********");
			System.out.println("************************************");

			System.out.println("Contact Street:");
			String street = sc.nextLine();
			System.out.println("Contact: City");
			String city = sc.nextLine();
			System.out.println("Contact: State");
			String state = sc.nextLine();
			bc.setLocation(new Location(countLocID++, street, city, state));

			System.out.println("Contact photo id: " + countPhotoID);
			Integer.parseInt(sc.nextLine());
			System.out.println("Contact photo date: ");
			LocalDate date2 = (LocalDate.parse(sc.nextLine())); // setting it to local date?
			System.out.println("Contact Photo Description: ");
			String notes = sc.nextLine();
			bc.getPhotos().add(new Photo(countPhotoID, date2, notes)); // TODO note for tuesdsay :: get photo not set in
																		// array list
		} catch (Exception e) {
			System.out.println("Invalid input. Try again.");
			addPersonContact();
		}
	}

	public void editBusinessContact(BusinessContact bc) {
		//editing business contact by going through entries again and resetting it to new values
		System.out.println("*****************************");
		System.out.println("***Editing Business Contact**");
		System.out.println("*****************************");
		displayContact();
		try {
			System.out.println("Contact name: ");
			bc.setName(sc.nextLine());
			System.out.println("Contact phone: ");
			bc.setNumber(Long.parseLong(sc.nextLine()));
			System.out.println("Contact phone type: ");
			bc.setPhone(sc.nextLine());
			System.out.println("Contact hours: ");
			bc.setHours(sc.nextLine());
			System.out.println("Contact website: ");
			bc.setWebsite(sc.nextLine());

			System.out.println("***********************************");
			System.out.println("********Contact Location***********");
			System.out.println("************************************");

			System.out.println("Contact Location ID: " + countLocID);
			System.out.println("Contact Street:");
			String street = sc.nextLine();
			System.out.println("Contact: City");
			String city = sc.nextLine();
			System.out.println("Contact: State");
			String state = sc.nextLine();

			bc.setLocation(new Location(countLocID++, street, city, state));

			System.out.println("Contact photo id: ");
			Integer.parseInt(sc.nextLine());
			System.out.println("Contact Photo Description: ");
			String notes = sc.nextLine();

		} catch (Exception e) {
			System.out.println("Invalid input. Try again.");
			addPersonContact();
		}
	}

	public void sortContact() {
		sort: do {
			//sorting it by name since you (Rob) said that was all that was required when we talked the other day
			System.out.println("*********************");
			System.out.println("******SORT MENU******");
			System.out.println("*********************");

			System.out.println("1] NAME");
			System.out.println("Type your selection: ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				System.out.println("Search by first name: ");
				Collections.sort(getBc(), (b1, b2) -> b1.getName().compareTo(b2.getName()));
				for (BaseContact contact : getBc()) {
					System.out.println(contact);
				}
				break;
			default:
				System.out.println("Exit menu");
				break sort;
			}
		} while (true);
	}

	public ArrayList<BaseContact> getBc() {
		return bc;
	}

	public void setBc(ArrayList<BaseContact> bc) {
		this.bc = bc;
	}

	public PersonContact getPersonContact() {
		return personContact;
	}

	public void setPersonContact(PersonContact personContact) {
		this.personContact = personContact;
	}

	public BusinessContact getBusinessContact() {
		return businessContact;
	}

	public void setBusinessContact(BusinessContact businessContact) {
		this.businessContact = businessContact;
	}

}
