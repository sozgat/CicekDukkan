package com.custom_compare;

import java.util.Comparator;

import com.model.Order;

public class DistanceInGreen implements Comparator<Order> {
	
		@Override
		public int compare(Order o1, Order o2) {
			return Double.compare(o2.getDistanceToGreen(),o1.getDistanceToGreen());
		}
	

}
