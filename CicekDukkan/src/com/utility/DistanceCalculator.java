package com.utility;

public class DistanceCalculator {

	public static double getDistance(double latA, double lonA, double latB, double lonB)//from A to B
	{
	    int radius = 6371;//Radius of the Earth in km
	    
	    double latDistance = Math.toRadians(latB - latA);
	    double lonDistance = Math.toRadians(lonB - lonA);
	    
	    double a = Math.sin(latDistance/2) * Math.sin(latDistance/2) + 
	               Math.cos(Math.toRadians(latA)) * Math.cos(Math.toRadians(latB)) *
	               Math.sin(lonDistance/2) * Math.sin(lonDistance/2);
	               
	   double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	   
	   return c * radius;//in km
	}
}
