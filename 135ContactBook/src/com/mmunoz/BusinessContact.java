package com.mmunoz;

import java.util.ArrayList;

public class BusinessContact extends BaseContact{
	//constructor for business contact that goes into the array list bc
	public BusinessContact(String name, long number, 
			String phone, ArrayList<Photo> photos, Location location, 
			String hours, String website) {
		super(name, number, phone, photos, location);
		this.hours = hours;
		this.website = website;
	}
	//constructor for editing contacts
	public BusinessContact(String name,long number, 
			String phone) {
		super(name, number, phone);
	}
	
	private String hours;
	private String website;
	
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	//toString for display contact
	@Override
	public String toString() {
		return "BusinessContact:Name-" + getName() + "|number-" + getNumber() + "|hours-" + hours + "|website-" + website;
	}
	//toFile for how it will be written to file
	public String toFile() {
		return "BusinessContact:" + getName() + "|" + getNumber() + "|" + hours + "|" + website;
	}
}