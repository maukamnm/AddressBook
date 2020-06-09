package com.mmunoz;

import java.util.ArrayList;

public class BaseContact {
	private int number;
	private String name;
	private Photo photo = new Photo();
	private ArrayList<Photo> photos = new ArrayList<>();
	Location location = new Location();
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
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
	
}
