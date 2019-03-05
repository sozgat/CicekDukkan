package com.custom_compare;

import java.util.Comparator;

import com.model.Order;

public class DistanceInBlue implements Comparator<Order> {
	
	@Override
	public int compare(Order o1, Order o2) {
		return Double.compare(o2.getDistanceToBlue(),o1.getDistanceToBlue());
	}


}