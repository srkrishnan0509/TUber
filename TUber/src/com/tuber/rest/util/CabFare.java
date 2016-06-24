package com.tuber.rest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tuber.rest.dto.CustomerDto;

public class CabFare {
	private  static SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	
	public static String getCabFare(CustomerDto customerDto, int latitude, int longitude){
		double totalFare =0;
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("Customer Mail Id : " + customerDto.getEmail()).append("\n");
		
		long timeTakeToTravel = getDateDifferenceInMin(sim.format(customerDto.getStartTime()).toString(), sim.format(customerDto.getEndTime()).toString());
		 // 1 dogecoin per minute
		totalFare = totalFare + timeTakeToTravel;
		stringBuff.append("Time Taken to travel in mins :" +timeTakeToTravel +", Charges : "+totalFare).append("\n");
		
		double distanceCovered = DistanceCalculation.calculateBetweenTwoDistance(customerDto.getLatitude(), customerDto.getLongitude(), latitude, longitude);
		//2 dogecoin per kilometer
		totalFare = totalFare + distanceCovered * 2;
		
		stringBuff.append("Distance travelled : "+distanceCovered ).append(" KM.").append("Charges : "+ distanceCovered * 2).append("\n");
		
		//Pink cars cost an additional 5 dogecoin.
		if(customerDto.getCabColour()==1){
			
			totalFare = totalFare + 5;
			stringBuff.append("Pink colour charges : " + 5).append("\n");
			
		}
		stringBuff.append("Total Fare : "+ totalFare);
		return stringBuff.toString();
	}

	
	private static long getDateDifferenceInMin(String fromDate, String toDate){
		Date d1=null;
		Date d2 = null;
		try {
			 d1 = sim.parse(fromDate);
			 d2 = sim.parse(toDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long diff = d2.getTime() - d1.getTime();
		
		long diffInMinutes = diff /(60 * 1000) % 60;
		return diffInMinutes;
	}



}
