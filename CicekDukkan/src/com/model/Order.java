package com.model;

public class Order {
	
	private int orderId;
	private double latitude;
	private double longitude;
	private double distanceToRed;
	private double distanceToGreen;
	private double distanceToBlue;
	private int choosenStoreId=0; //0=Çiçek Bayisi Seçilmemiþ 1=Kýrmýzý Bayi 2=Yeþil Bayi 3=Mavi Bayi 
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getDistanceToRed() {
		return distanceToRed;
	}
	public void setDistanceToRed(double distanceToRed) {
		this.distanceToRed = distanceToRed;
	}
	public double getDistanceToGreen() {
		return distanceToGreen;
	}
	public void setDistanceToGreen(double distanceToGreen) {
		this.distanceToGreen = distanceToGreen;
	}
	public double getDistanceToBlue() {
		return distanceToBlue;
	}
	public void setDistanceToBlue(double distanceToBlue) {
		this.distanceToBlue = distanceToBlue;
	}
	public int getChoosenStoreId() {
		return choosenStoreId;
	}
	public void setChoosenStoreId(int choosenStoreId) {
		this.choosenStoreId = choosenStoreId;
	}
	
		
	

}
