package com.mmunoz;

import java.time.LocalDate;
import java.util.ArrayList;
//base contact -- attributes that are found in both business and personal contacts
public class BaseContact {
	private long number;
	private String name;
	private String phone;
	private ArrayList<Photo> photos = new ArrayList<>();
	private String city;
	private String street;
	private int id;
	private String state;
	private Location location = new Location(id, street, city, state);
	//constructor that as a parent class goes into personal and business
	public BaseContact(String name, long number, String phone, ArrayList<Photo> photos, Location location) {
		super();
		this.number = number;
		this.name = name;
		this.phone = phone;
		this.photos = photos;
		this.location = location;
	}
	//constructor for editing
	public BaseContact(String name, long number, String phone) {
		super();
		this.number = number;
		this.name = name;
		this.phone = phone;
	}
	
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ArrayList<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(ArrayList<Photo> photos) {
		this.photos = photos;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "BaseContact:Number-" + number + "|name-" + name + "|phone-" + phone + "|photos-" + photos
				+ "|location-" + location;
	}


}