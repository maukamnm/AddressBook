package com.mmunoz;

public class Photo {
	private int id; 
	private String FileName;
	private String DateOfPhoto;
	private String Description;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public String getDateOfPhoto() {
		return DateOfPhoto;
	}

	public void setDateOfPhoto(String dateOfPhoto) {
		DateOfPhoto = dateOfPhoto;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", FileName=" + FileName + ", DateOfPhoto=" + DateOfPhoto + ", Description="
				+ Description + "]";
	}
	
	
}

