package com.cicek;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.compare.DistanceInBlue;
import com.compare.DistanceInGreen;
import com.compare.DistanceInRed;
import com.constants.Constants;
import com.model.Order;
import com.model.Store;
import com.services.WriteToJS;
import com.utility.BoundaryUtil;
import com.utility.CalculateUtil;
import com.utility.DistanceCalculator;
import com.utility.ExcelRead;
import com.utility.MarkerClustringForMap;
import com.utility.PrintUtil;

public class OrdersDelivery {

	public static void main(String[] args) {

		Store red = new Store(Constants.RED_STORE_ID, Constants.RED_LATITUDE, Constants.RED_LONGITUDE,
				Constants.RED_MAX_ORDER, Constants.RED_MIN_ORDER);

		Store green = new Store(Constants.GREEN_STORE_ID, Constants.GREEN_LATITUDE, Constants.GREEN_LONGITUDE,
				Constants.GREEN_MAX_ORDER, Constants.GREEN_MIN_ORDER);

		Store blue = new Store(Constants.BLUE_STORE_ID, Constants.BLUE_LATITUDE, Constants.BLUE_LONGITUDE,
				Constants.BLUE_MAX_ORDER, Constants.BLUE_MIN_ORDER);

		ArrayList<Order> orders = ExcelRead.getExcelData();

		for (int i = 0; i < orders.size(); i++) {
			double latB = orders.get(i).getLatitude();
			double lonB = orders.get(i).getLongitude();
			HashMap<Integer, Double> distanceToStore = orders.get(i).getDistanceToStore();

			distanceToStore.put(Constants.RED_STORE_ID,
					DistanceCalculator.getDistance(red.getLatitude(), red.getLongitude(), latB, lonB));

			distanceToStore.put(Constants.GREEN_STORE_ID,
					DistanceCalculator.getDistance(green.getLatitude(), green.getLongitude(), latB, lonB));

			distanceToStore.put(Constants.BLUE_STORE_ID,
					DistanceCalculator.getDistance(blue.getLatitude(), blue.getLongitude(), latB, lonB));
		}

		BoundaryUtil.assignCloseOrderToStore(orders, red, green, blue);
		PrintUtil.printOrders(orders);
		CalculateUtil.optimizeOrders(orders, red, green, blue);
		CalculateUtil.checkMaxCapacityAfterOptimizeOrders(orders, red, green, blue);
		PrintUtil.printOrders(orders);

		do {

			BoundaryUtil.CounterOfOrdersInBigTriangle(orders, red, green, blue);
			BoundaryUtil.assignCloseOrderToStoreCheck(orders, red, green, blue);

		} while (BoundaryUtil.boundaryCheck(orders, red, green, blue) == 0);

		PrintUtil.printOrders(orders);
		CalculateUtil.totalCosts(orders);
		
		

		// Ready to write js.
		WriteToJS w = new WriteToJS();
		w.write(MarkerClustringForMap.checkSameCoordinates(orders), new Store[] { red, green, blue });

		try {
			File htmlFile = new File("OrdersMap.html");
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
