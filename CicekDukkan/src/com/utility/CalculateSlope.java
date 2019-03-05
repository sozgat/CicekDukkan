package com.utility;

//Eðim hesaplamasý
public class CalculateSlope {
	
	// Latitude = y ekseni , Longitude= x ekseni
	public static double slope(double x1, double y1, double x2, double y2) {
		double slope = (y2 - y1) / (x2 - x1);
		return slope;
	}

}
