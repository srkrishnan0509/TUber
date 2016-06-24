package com.tuber.rest.dto;

import java.util.Date;

public class CustomerDto {

	private String email;

	private Integer latitude;

	private Integer longitude;

	private Integer cabColour;
	
	private Date startTime;
	
	private Date endTime;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerDto() {
		super();
	}

	public int getLatitude() {
		return latitude;
	}


	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getCabColour() {
		return cabColour;
	}

	public void setCabColour(int cabColour) {
		this.cabColour = cabColour;
	}

	@Override
	public String toString() {
		return "CustomerDto [email=" + email + ", latitude=" + latitude + ", longitude=" + longitude + ", cabColour="
				+ cabColour + "]";
	}

	

	public CustomerDto(String email, Integer latitude, Integer longitude, Integer cabColour, Date startTime,
			Date endTime) {
		super();
		this.email = email;
		this.latitude = latitude;
		this.longitude = longitude;
		this.cabColour = cabColour;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public void setCabColour(Integer cabColour) {
		this.cabColour = cabColour;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
