package com.model;

import java.util.HashMap;

import com.constants.Constants;

public class Order {

	private int orderId;
	private double latitude;
	private double longitude;

	private HashMap<Integer, Double> distanceToStore = new HashMap<Integer, Double>();

	private int choosenStoreId = 0; // 0=Çiçek Bayisi Seçilmemiþ 1=Kýrmýzý Bayi 2=Yeþil Bayi 3=Mavi Bayi

	public HashMap<Integer, Double> getDistanceToStore() {
		return distanceToStore;
	}

	public void setDistanceToStore(HashMap<Integer, Double> distanceToStore) {
		this.distanceToStore = distanceToStore;
	}

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

	public int getChoosenStoreId() {
		return choosenStoreId;
	}

	public void setChoosenStoreId(int choosenStoreId) {
		this.choosenStoreId = choosenStoreId;
	}

	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", latitude=" + latitude + ", longitude=" + longitude + ", distanceToRed="
				+ distanceToStore.get(Constants.RED_STORE_ID) + ", distanceToGreen="
				+ distanceToStore.get(Constants.GREEN_STORE_ID) + ", distanceToBlue=" + distanceToStore.get(Constants.BLUE_STORE_ID)
				+ ", choosenStoreId=" + choosenStoreId + "]";
	}

}
