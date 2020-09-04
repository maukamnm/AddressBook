package com.mmunoz;

import java.time.LocalDate;
//Creating a class to represent photo by using a constructor
//and be used as an object in AddressBook.
//Also using toString and setters and getters. 
public class Photo {

	private int id;
	private LocalDate dateOfPhoto;
	String notes;

	public Photo(int id, LocalDate dateOfPhoto, String notes) {
		super();
		this.id = id;
		this.dateOfPhoto = dateOfPhoto;
		this.notes = notes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateOfPhoto() {
		return dateOfPhoto;
	}

	public void setDateOfPhoto(LocalDate dateOfPhoto) {
		this.dateOfPhoto = dateOfPhoto;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "[Photo:id-" + id + "|Date Of Photo-" + dateOfPhoto + " |notes-" + notes;
	}

}
