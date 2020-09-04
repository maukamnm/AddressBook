
package com.mmunoz;
//class and attributes for location where we have a 
//constructor for the creation of the location object 
//as well as setters and getters
public class Location {
	private int id;
	private String Street;
	private String City;
	private String State;

	public Location(int id, String Street, String city, String state) {
		super();
		this.id = id;
		this.Street = Street;
		this.City = city;
		this.State = state;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getStreet() {
		return Street;
	}



	public void setStreet(String street) {
		Street = street;
	}



	public String getCity() {
		return City;
	}



	public void setCity(String city) {
		City = city;
	}



	public String getState() {
		return State;
	}



	public void setState(String state) {
		State = state;
	}



	@Override
	public String toString() {
		return "Location:id-" + id + "|Street-" + Street + "|City-" + City + "|State-" + State;
	}	
}
