package com.model;

public class Store {

	private int storeId;
	private double latitude;
	private double longitude;
	private int maxOrderCapacity;
	private int minOrderCapacity;
	private int currentOrderCount; // bayideki sipariþ sayýsýný tutar

	public Store(int storeId, double latitude, double longitude, int maxOrderCapacity, int minOrderCapacity) {
		super();
		this.storeId = storeId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.maxOrderCapacity = maxOrderCapacity;
		this.minOrderCapacity = minOrderCapacity;
	}

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

	public int getCurrentOrderCount() {
		return currentOrderCount;
	}

	public void setCurrentOrderCount(int currentOrderCount) {
		this.currentOrderCount = currentOrderCount;
	}

	public void incrementCurrentOrderCount() {
		currentOrderCount++;
	}

	public void decrementCurrentOrderCount() {
		currentOrderCount--;
	}

}