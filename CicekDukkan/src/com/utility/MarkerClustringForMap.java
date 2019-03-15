package com.utility;

import java.util.ArrayList;

import com.model.Order;

public class MarkerClustringForMap {

	public static ArrayList<Order> checkSameCoordinates(ArrayList<Order> orders) {

		ArrayList<Order> ordersForMapping = new ArrayList<Order>(orders);

		for (int i = 0; i < orders.size(); i++) {
			for (int j = i + 1; j < orders.size(); j++) {

				if (orders.get(i).getLatitude() == orders.get(j).getLatitude()
						&& orders.get(i).getLongitude() == orders.get(j).getLongitude()) {
					ordersForMapping.get(j).setLatitude(orders.get(j).getLatitude() + 00.00002);
					ordersForMapping.get(j).setLongitude(orders.get(j).getLongitude() + 00.00002);
				}
			}
		}

		return ordersForMapping;

	}

}
