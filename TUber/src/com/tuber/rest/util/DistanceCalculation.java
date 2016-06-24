package com.tuber.rest.util;

public class DistanceCalculation {
	//Pythagorean Theorem
	public static double calculateBetweenTwoDistance(int x1, int y1, int x2, int y2){
		return Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2));
	}
}
