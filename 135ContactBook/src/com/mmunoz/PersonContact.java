package com.mmunoz;

import java.time.LocalDate;
import java.util.ArrayList;
//constructor for person contact that goes into the array list bc
//attributes, setters and getters, toString, and toFile(for writing to file)
public class PersonContact extends BaseContact {
	
	private LocalDate DOB;
	private String Description;
	private String ListOfRelatives;
	
	public PersonContact(String name, long number, String phone, ArrayList<Photo> photos, Location location, String ListOfRelatives, String Description, LocalDate DOB) {
		super(name, number, phone, photos, location);
		this.getName();
		this.getNumber();
		this.DOB = DOB;
		this.Description = Description;
		this.ListOfRelatives = ListOfRelatives;
	}
	public PersonContact(String name, long number, String phone, String ListOfRelatives, String Description, LocalDate DOB) {
		super(name, number, phone);
		this.getName();
		this.getNumber();
		this.DOB = DOB;
		this.Description = Description;
		this.ListOfRelatives = ListOfRelatives;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public String getListOfRelatives() {
		return ListOfRelatives;
	}
	public void setListOfRelatives(String ListOfRelatives) {
		this.ListOfRelatives = ListOfRelatives;
	}
	public void setDOB(LocalDate DOB) {
		this.DOB = DOB;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String notes) {
		this.Description = Description;
	}

	@Override
	public String toString() {
		return "PersonContact-name-" + getName() + "|DOB-" + DOB + "|Description-" + Description + "|ListOfRelatives-" + ListOfRelatives
				+ "|getNumber-" + getNumber() + "|getPhotos-" + getPhotos()
				+ "|getLocation-" + getLocation();
	}
	
	public String toFile() {
		return "PersonContact|" + getName() + "|" + DOB + "|" + Description + "|" + ListOfRelatives
				+ "|" + getNumber() + "|" + getPhone();
	}
}
