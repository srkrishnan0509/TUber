package com.tuber.rest.repo;

import java.util.Date;

public class CabDto {
	private String cabId;
	private int cabColor;
	private int latitude;
	private int longitude;
	

	public String getCabId() {
		return cabId;
	}

	public void setCabId(String cabId) {
		this.cabId = cabId;
	}

	public int getCabColor() {
		return cabColor;
	}

	
	public void setCabColor(int cabColor) {
		this.cabColor = cabColor;
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

	public CabDto(String cabId, int cabColor, int latitude, int longitude) {
		super();
		this.cabId = cabId;
		this.cabColor = cabColor;
		this.latitude = latitude;
		this.longitude = longitude;
	}

}
