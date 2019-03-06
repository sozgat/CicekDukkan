package com.utility;

import java.util.ArrayList;
import java.util.Collections;

import com.compare.DistanceInBlue;
import com.compare.DistanceInGreen;
import com.compare.DistanceInRed;
import com.constants.Constants;
import com.model.Order;
import com.model.Store;

//Eðim hesaplamasý
public class CalculateUtil {
	
	public static int countStore(ArrayList<Order> orders, int storeId) {
		int counter = 0;
		for (Order order : orders) {
			if (order.getChoosenStoreId() == storeId) {
				counter++;
			}
		}
		return counter;
	}
	
	
	// Latitude = y ekseni , Longitude= x ekseni
	public static double slope(double x1, double y1, double x2, double y2) {
		double slope = (y2 - y1) / (x2 - x1);
		return slope;
	}

	public static void totalCosts(ArrayList<Order> orders) {
		double redCosts = 0, greenCosts = 0, blueCosts = 0, notChoosenCosts = 0;

		for (Order order : orders) {
			if (order.getChoosenStoreId() == Constants.RED_STORE_ID) {
				redCosts += order.getDistanceToStore().get(Constants.RED_STORE_ID);
			} else if (order.getChoosenStoreId() == Constants.GREEN_STORE_ID) {
				greenCosts += order.getDistanceToStore().get(Constants.GREEN_STORE_ID);
			} else if (order.getChoosenStoreId() == Constants.BLUE_STORE_ID) {
				blueCosts += order.getDistanceToStore().get(Constants.BLUE_STORE_ID);
			} else if (order.getChoosenStoreId() == 0) {
				notChoosenCosts++;
			}

		}
		
		System.out.println("\nRED TOTAL COSTS: " + redCosts + "\nGREEN TOTAL COSTS: "+ greenCosts+"\nBLUE TOTAL COSTS: "+ blueCosts);
		System.out.println("TOTAL COSTS: " + (redCosts+greenCosts+blueCosts) );
	}

	public static void optimizeOrders(ArrayList<Order> orders, Store red, Store green, Store blue) {
		for (int i = 0; i < orders.size(); i++) {

			if (orders.get(i).getChoosenStoreId() == Constants.RED_STORE_ID) {
				double slope = slope(Constants.BLUE_LONGITUDE, Constants.BLUE_LATITUDE,
						Constants.GREEN_LONGITUDE, Constants.GREEN_LATITUDE);
				boolean check = CheckAboveOfParallelLine.Calculate(slope, Constants.RED_LONGITUDE,
						Constants.RED_LATITUDE, Constants.BLUE_LONGITUDE,
						Constants.BLUE_LATITUDE, Constants.GREEN_LONGITUDE,
						Constants.GREEN_LATITUDE, orders.get(i).getLongitude(), orders.get(i).getLatitude());
				if (check == false) {
					orders.get(i).setChoosenStoreId(Constants.NOT_CHOOSEN_STORE_ID);
					red.decrementCurrentOrderCount();
				}

			}
			if (orders.get(i).getChoosenStoreId() == Constants.GREEN_STORE_ID) {
				double slope = slope(Constants.RED_LONGITUDE, Constants.RED_LATITUDE,
						Constants.BLUE_LONGITUDE, Constants.BLUE_LATITUDE);
				boolean check = CheckAboveOfParallelLine.Calculate(slope, Constants.GREEN_LONGITUDE,
						Constants.GREEN_LATITUDE, Constants.RED_LONGITUDE,
						Constants.RED_LATITUDE, Constants.BLUE_LONGITUDE,
						Constants.BLUE_LATITUDE, orders.get(i).getLongitude(), orders.get(i).getLatitude());
				if (check == false) {
					orders.get(i).setChoosenStoreId(Constants.NOT_CHOOSEN_STORE_ID);
					green.decrementCurrentOrderCount();
				}
			}
			if (orders.get(i).getChoosenStoreId() == Constants.BLUE_STORE_ID) {
				double slope = slope(Constants.GREEN_LONGITUDE, Constants.GREEN_LATITUDE,
						Constants.RED_LONGITUDE, Constants.RED_LATITUDE);
				boolean check = CheckAboveOfParallelLine.Calculate(slope, Constants.BLUE_LONGITUDE,
						Constants.BLUE_LATITUDE, Constants.RED_LONGITUDE,
						Constants.RED_LATITUDE,Constants.GREEN_LONGITUDE,
						Constants.GREEN_LATITUDE, orders.get(i).getLongitude(), orders.get(i).getLatitude());
				if (check == false) {
					orders.get(i).setChoosenStoreId(Constants.NOT_CHOOSEN_STORE_ID);
					blue.decrementCurrentOrderCount();
				}
			}

		}
	}

	public static void checkMaxCapacityAfterOptimizeOrders(ArrayList<Order> orders,Store red, Store green, Store blue)

	{
		if (red.getCurrentOrderCount() > red.getMaxOrderCapacity()) {
			Collections.sort(orders, new DistanceInRed(0));
			for (int i = 0; i < orders.size(); i++) {

				if (orders.get(i).getChoosenStoreId() == red.getStoreId()
						&& red.getCurrentOrderCount() > red.getMaxOrderCapacity()) {
					orders.get(i).setChoosenStoreId(0);
					red.decrementCurrentOrderCount();
				}
			}
		}
		if (green.getCurrentOrderCount() >green.getMaxOrderCapacity()) {
			Collections.sort(orders, new DistanceInGreen(0));
			for (int i = 0; i < orders.size(); i++) {

				if (orders.get(i).getChoosenStoreId() == green.getStoreId()
						&& green.getCurrentOrderCount() >green.getMaxOrderCapacity()) {
					orders.get(i).setChoosenStoreId(0);
					green.decrementCurrentOrderCount();
				}
			}
		}
		if (blue.getCurrentOrderCount() > blue.getMaxOrderCapacity()) {
			Collections.sort(orders, new DistanceInBlue(0));
			PrintUtil.printOrders(orders);
			for (int i = 0; i < orders.size(); i++) {
				if (orders.get(i).getChoosenStoreId() == blue.getStoreId()
						&& blue.getCurrentOrderCount() > blue.getMaxOrderCapacity()) {
					orders.get(i).setChoosenStoreId(0);
					blue.decrementCurrentOrderCount();
				}
			}

		}
	}
}
