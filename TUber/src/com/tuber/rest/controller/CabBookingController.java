package com.tuber.rest.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tuber.rest.dto.CustomerDto;
import com.tuber.rest.repo.CabDto;
import com.tuber.rest.service.UberCabService;

@RestController
@RequestMapping("cabBooking")
public class CabBookingController {
	
	@Autowired
	private UberCabService uberService;

	@RequestMapping(value="bookcab1",method = RequestMethod.GET)
	public ResponseEntity<CustomerDto> bb (){
		return new  ResponseEntity<CustomerDto>(new CustomerDto("email", 1, -1, 1,null,null),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="bookCab",method = RequestMethod.GET)
	public ResponseEntity<String> bookCab(@RequestParam(required=true,value="email") String email, @RequestParam(required=true,value="latitude") int latitude,@RequestParam(required=true,value="longitude") int longitude,@RequestParam(required=true,value="cabColour") int cabColour){
		CustomerDto customerDto =new CustomerDto(email, latitude, longitude, cabColour, null, null);
				
		System.out.println(customerDto);
			//return new  ResponseEntity("",HttpStatus.BAD_REQUEST);
		//return new ResponseEntity<CustomerDto>(new CustomerDto("email", 1, -1, 1), HttpStatus.OK);
		boolean cabStatus;
		cabStatus = uberService.checkCabAvailabilty();
		
		if(!cabStatus){
			return new ResponseEntity<String>("Request Denied",HttpStatus.OK);
		}
		
		String cabId = uberService.checkCabAvailabiltyByNearestLocation(customerDto);
		
		if(cabId == null){
			return new ResponseEntity<String>("Request Denied",HttpStatus.OK);
		}else{
			uberService.bookCab(cabId,customerDto);
			return new ResponseEntity<String>("Cab booked successfully. CabId="+cabId,HttpStatus.OK);
		}
	}
	@RequestMapping(value="endCab",method = RequestMethod.GET)
	public ResponseEntity<String> endRide(@RequestParam(required=true,value="cabId") String cabId, @RequestParam(required=true,value="latitude") int latitude,@RequestParam(required=true,value="longitude") int longitude){
		if(cabId.isEmpty()){
			return new ResponseEntity<String>("Please pass the valid CabId",HttpStatus.OK);
		}
		
		String charges = uberService.endRide(cabId, latitude, longitude);
		if(charges==null){
			return new ResponseEntity<String>("Please pass the valid CabId",HttpStatus.OK);
		}
		return new ResponseEntity<String>(charges,HttpStatus.OK);
	}
	
	@RequestMapping(value="availCabs",method = RequestMethod.GET)
	public ResponseEntity<Map<String, CabDto>> getAvailableCabs(){
		
		
		return new ResponseEntity<Map<String, CabDto>>(uberService.getAvailableCabs(),HttpStatus.OK);
	}
}
