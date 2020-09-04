package com.mmunoz;
import java.util.Comparator;
//Using the comparator, I sort by name and in address book I 
//use a lambda expression for sort 
public class Sort implements Comparator<BaseContact> {
//TODO Tuesday :: James comparators
	@Override
	public int compare(BaseContact b1, BaseContact b2) {
		return b1.getName().compareTo(b2.getName());
	}

	@Override
	public String toString() {
		return "Sort";
	}
	
}
