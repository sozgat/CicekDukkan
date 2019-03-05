package com.model;

public class Point
{
	private int storeId;
	private double latitude;
	private double longitude;
	private int maxOrderCapacity;
	private int minOrderCapacity;
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
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
	public int getMaxOrderCapacity() {
		return maxOrderCapacity;
	}
	public void setMaxOrderCapacity(int maxOrderCapacity) {
		this.maxOrderCapacity = maxOrderCapacity;
	}
	public int getMinOrderCapacity() {
		return minOrderCapacity;
	}
	public void setMinOrderCapacity(int minOrderCapacity) {
		this.minOrderCapacity = minOrderCapacity;
	}
	
}
