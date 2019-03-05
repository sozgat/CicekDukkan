package com.custom_compare;

import java.util.Comparator;

import com.model.Order;

public class DistanceInRed implements Comparator<Order> {
	
		@Override
		public int compare(Order o1, Order o2) {
			return Double.compare(o2.getDistanceToRed(),o1.getDistanceToRed());
		}
	

}
