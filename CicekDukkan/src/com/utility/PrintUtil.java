package com.utility;

import java.util.ArrayList;

import com.constants.Constants;
import com.model.Order;

public class PrintUtil {

	public static void printOrders(ArrayList<Order> orders) {
		System.out.println("OId- SId - Distance To Red -- Distance To Green -- Distance To Blue \n");
		for (int i = 0; i < orders.size(); i++) {
			System.out.println(orders.get(i).getOrderId() + " - " + orders.get(i).getChoosenStoreId() + " => "
					+ orders.get(i).getDistanceToStore().get(Constants.RED_STORE_ID) + " - "
					+ orders.get(i).getDistanceToStore().get(Constants.GREEN_STORE_ID) + " - "
					+ orders.get(i).getDistanceToStore().get(Constants.BLUE_STORE_ID));
		}
	}

}
