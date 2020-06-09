package com.mmunoz;

import java.util.ArrayList;

public class PersonContact extends BaseContact {
	private int DOB;
	private String Description;
	private ArrayList<ArrayList<String>> listOfRelative = new ArrayList<ArrayList<String>>();
	 String newContact;
	
	public String createPersonalContact(String name, String number, String Description, String DOB){
	return newContact;
	}
	public int getDOB() {
		return DOB;
	}
	public void setDOB(int dOB) {
		DOB = dOB;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public ArrayList<ArrayList<String>> getListOfRelative() {
		return listOfRelative;
	}
	public void setListOfRelative(ArrayList<ArrayList<String>> listOfRelative) {
		this.listOfRelative = listOfRelative;
	}
	@Override
	public String toString() {
		return "PersonContact [DOB=" + DOB + ", Description=" + Description + ", listOfRelative=" + listOfRelative
				+ ", newContact=" + newContact + "]";
	}
	
}
