package com.tuber.rest.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CabAvail {
	//Key as Cab Id and Value as Cab booking status. true - available false- not available
	private static Map<String, Boolean> cabStatus = new HashMap<String, Boolean>();
	static{
		cabStatus.put("x1y101", true);
		cabStatus.put("x1y102", true);
		cabStatus.put("x1y103", true);
		cabStatus.put("x2y101", true);
		cabStatus.put("x2y102", true);
		cabStatus.put("x2y103", true);
		cabStatus.put("x2y201", true);
		cabStatus.put("x2y202", true);
		cabStatus.put("x2y203", true);
		cabStatus.put("x1y201", true);
		cabStatus.put("x1y202", true);
		cabStatus.put("x1y203", true);
		
	}
	
	public static boolean getCabStatus(String cabId){
		return cabStatus.get(cabId);
	}
	
	public static void setCabStatus (String cabId,boolean cabAvail){
		cabStatus.put(cabId, cabAvail);
	}
	
	public static boolean isAnyCabAvaliable(){
		for(boolean cabStatus : cabStatus.values()){
			if(cabStatus==true){
				return true;
			}
		}
		return false;
	}
	
	public static List<String> getAllNotAVailCabs(){
		List<String> availCabs = new ArrayList<String>();
		for(Entry<String, Boolean> entry :cabStatus.entrySet()){
			if(entry.getValue()==false){
				availCabs.add(entry.getKey());
			}
		}
		return availCabs;
	}
	
}
