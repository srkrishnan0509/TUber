package com.tuber.rest.repo;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.tuber.rest.constant.CabColour;
import com.tuber.rest.util.DistanceCalculation;

public class CabLocations {
	private static Map<String, CabDto> x1y1 = new HashMap<String,CabDto>();

	static {
		x1y1.put("x1y101",new CabDto("x1y101", CabColour.PINK, 1, 1));
		x1y1.put("x1y102",new CabDto("x1y102", CabColour.BLACK, 3, 2));
		x1y1.put("x1y103",new CabDto("x1y103", CabColour.WHITE, 2, 3));
		x1y1.put("x2y101",new CabDto("x2y101", CabColour.PINK, -1, 1));
		x1y1.put("x2y102",new CabDto("x2y102", CabColour.BLACK, -3, 2));
		x1y1.put("x2y103",new CabDto("x2y103", CabColour.WHITE, -2, 3));
		x1y1.put("x2y201",new CabDto("x2y201", CabColour.PINK, -1, -1));
		x1y1.put("x2y202",new CabDto("x2y202", CabColour.BLACK, -3, -2));
		x1y1.put("x2y203",new CabDto("x2y203", CabColour.WHITE, -2, -3));
		x1y1.put("x1y201",new CabDto("x1y201", CabColour.PINK, 1, -1));
		x1y1.put("x1y202",new CabDto("x1y202", CabColour.BLACK, 3, -2));
		x1y1.put("x1y203",new CabDto("x1y203", CabColour.WHITE, 2, -3));
	}

	public static Map<String, CabDto> getX1Y2List() {
		return x1y1;
	}
	
	public static void setCabLocation(String cabId, int latitude, int longtitude ){
		CabDto cabDto = x1y1.get(cabId);
		cabDto.setLatitude(latitude);
		cabDto.setLongitude(longtitude);
		x1y1.put(cabId, cabDto);
	}
	
	
	public static String getNearestCab(int latitude, int longtitude, int color){
		Map<String , Double> cabDistance = new HashMap<String , Double>();
		Entry<String, Double> min = null;
		for (Entry<String, CabDto> entry : x1y1.entrySet()) {
			if(CabAvail.getCabStatus(entry.getValue().getCabId())){
			if(color==1){
				if(entry.getValue().getCabColor()==color){
					cabDistance.put(entry.getValue().getCabId(), DistanceCalculation.calculateBetweenTwoDistance(entry.getValue().getLatitude(), entry.getValue().getLongitude(), latitude, longtitude));
				}
			}else{
				if(entry.getValue().getCabColor()!=1){
				cabDistance.put(entry.getValue().getCabId(), DistanceCalculation.calculateBetweenTwoDistance(entry.getValue().getLatitude(), entry.getValue().getLongitude(), latitude, longtitude));
				}
				}
			}
		}
		if(cabDistance.isEmpty()){
			return null;
		}
		
		for (Entry<String, Double> entry : cabDistance.entrySet()) {
		    if (min == null || min.getValue() > entry.getValue()) {
		        min = entry;
		    }
		}
		
		return min.getKey();
	}
	
	public static Map<String, CabDto> getAvailbleCabs(){
		Map<String, CabDto> temp = new HashMap<String,CabDto>(x1y1);
		List<String> listOfNotAvailCabs = CabAvail.getAllNotAVailCabs();
		for(String cabId: listOfNotAvailCabs){
			temp.remove(cabId);
		}
		return temp;
	}
}