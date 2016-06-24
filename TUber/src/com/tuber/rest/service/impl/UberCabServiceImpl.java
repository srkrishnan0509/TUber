package com.tuber.rest.service.impl;


import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tuber.rest.dto.CustomerDto;
import com.tuber.rest.repo.CabAvail;
import com.tuber.rest.repo.CabDto;
import com.tuber.rest.repo.CabLocations;
import com.tuber.rest.repo.UsedCars;
import com.tuber.rest.service.UberCabService;
import com.tuber.rest.util.CabFare;

@Service("uberCabService")
public class UberCabServiceImpl implements UberCabService{

	
	
	
	@Override
	public String checkCabAvailabiltyByNearestLocation(CustomerDto customerDto) {
		String cabId = CabLocations.getNearestCab(customerDto.getLatitude(), customerDto.getLongitude(), customerDto.getCabColour());
		if(cabId==null){
			return null;
		}
		return cabId;
	}

	@Override
	public boolean checkCabAvailabilty() {
		return CabAvail.isAnyCabAvaliable();
	}
	
	
	public static void main(String[] args) {
		UberCabServiceImpl cab = new UberCabServiceImpl();
		CustomerDto customerDto = new CustomerDto("st",11 , 2, 1,null,null);
		String cabId = cab.checkCabAvailabiltyByNearestLocation(customerDto);
		System.out.println(cabId);
		System.out.println(CabAvail.getCabStatus(cabId));
		cab.bookCab(cabId, customerDto);
		System.out.println(CabAvail.getCabStatus(cabId));
	}

	@Override
	public boolean bookCab(String cabId, CustomerDto customerDto) {
		CabAvail.setCabStatus(cabId, false);
		customerDto.setStartTime(new Date());
		UsedCars.startRide(cabId, customerDto);;
		return false;
	}

	@Override
	public String endRide(String cabId, int latitude, int longitude) {
		CabAvail.setCabStatus(cabId, true);
		
		CustomerDto customerDto = UsedCars.stopRide(cabId);
		if(customerDto==null){
			return null;
		}
		customerDto.setEndTime(new Date());
		CabLocations.setCabLocation(cabId, latitude, longitude);
		String fare = CabFare.getCabFare(customerDto, latitude, longitude);
		return fare;
	}

	@Override
	public Map<String, CabDto> getAvailableCabs() {
		// TODO Auto-generated method stub
		return CabLocations.getAvailbleCabs();
	}
	
	

}
