package com.model;

public class Store {

	public static Point redCompany = new Point();
	public static Point greenCompany = new Point();
	public static Point blueCompany = new Point();
	
	public static void init()
	{
		redCompany.setStoreId(1);
		redCompany.setLatitude(41.049792);
		redCompany.setLongitude(29.003031);
		redCompany.setMinOrderCapacity(20);
		redCompany.setMaxOrderCapacity(30);
		
		greenCompany.setStoreId(2);
		greenCompany.setLatitude(41.069940);
		greenCompany.setLongitude(29.019250);
		greenCompany.setMinOrderCapacity(35);
		greenCompany.setMaxOrderCapacity(50);
		
		blueCompany.setStoreId(3);
		blueCompany.setLatitude(41.049997);
		blueCompany.setLongitude(29.026108);
		blueCompany.setMinOrderCapacity(20);
		blueCompany.setMaxOrderCapacity(45);
	}
}