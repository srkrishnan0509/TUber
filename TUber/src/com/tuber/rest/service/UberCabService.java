package com.tuber.rest.service;

import java.util.Map;

import com.tuber.rest.dto.CustomerDto;
import com.tuber.rest.repo.CabDto;

public interface UberCabService {
	
	public String checkCabAvailabiltyByNearestLocation(CustomerDto customerDto);
	
	public boolean checkCabAvailabilty();
	
	public boolean bookCab(String cabId,CustomerDto customerDto);
	
	public String endRide(String cabId, int latitude, int longitude);
	
	public Map<String, CabDto> getAvailableCabs();

}
