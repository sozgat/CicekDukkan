package com.compare;

import java.util.Comparator;

import com.constants.Constants;
import com.model.Order;

public class DistanceInBlue implements Comparator<Order> {
	
	private int order;
	
	public DistanceInBlue() {
	}
	
	public DistanceInBlue(int order) {
		this.order = order;
	}

	@Override
	public int compare(Order o1, Order o2) {
		if(order == 0) {
			return Double.compare(o1.getDistanceToStore().get(Constants.BLUE_STORE_ID),o2.getDistanceToStore().get(Constants.BLUE_STORE_ID));
		}
		return Double.compare(o2.getDistanceToStore().get(Constants.BLUE_STORE_ID),o1.getDistanceToStore().get(Constants.BLUE_STORE_ID));
	}


}