package com.model;

public class Company {

	public static Point redCompany = new Point();
	public static Point greenCompany = new Point();
	public static Point blueCompany = new Point();
	
	public static void init()
	{
		redCompany.setLatitude(41.049792);
		redCompany.setLongitude(29.003031);
		
		greenCompany.setLatitude(41.069940);
		greenCompany.setLongitude(29.019250);
		
		blueCompany.setLatitude(41.049997);
		blueCompany.setLongitude(29.026108);
	}
}