package com.tuber.rest.repo;

import java.util.HashMap;
import java.util.Map;

import com.tuber.rest.dto.CustomerDto;

public class UsedCars {
	private static Map<String, CustomerDto> usedCars = new HashMap<String, CustomerDto>();
	
	public static void startRide(String cabId , CustomerDto customerDto){
		usedCars.put(cabId, customerDto);
	}
	
	public static CustomerDto getCustomerDetails(String cabId){
		return usedCars.get(cabId);
	}
	
	public static CustomerDto stopRide(String cabId){
		return usedCars.remove(cabId);
	}
	
	
}
