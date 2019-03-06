package com.cicek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.compare.DistanceInBlue;
import com.compare.DistanceInGreen;
import com.compare.DistanceInRed;
import com.constants.Constants;
import com.model.Counter;
import com.model.Order;
import com.model.Store;
import com.services.WriteToJS;
import com.utility.BoundaryUtil;
import com.utility.CalculateUtil;
import com.utility.ExcelRead;
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
			
			distanceToStore.put(Constants.RED_STORE_ID, DistanceCalculator.getDistance(red.getLatitude(), red.getLongitude(), latB, lonB));

			distanceToStore.put(Constants.GREEN_STORE_ID,DistanceCalculator.getDistance(green.getLatitude(), green.getLongitude(), latB, lonB));

			distanceToStore.put(Constants.BLUE_STORE_ID,DistanceCalculator.getDistance(blue.getLatitude(), blue.getLongitude(), latB, lonB));
		}
		
//		PrintUtil.printOrders(orders);
		BoundaryUtil.assignCloseOrderToStore(orders,red,green,blue);
		PrintUtil.printOrders(orders);
		CalculateUtil.optimizeOrders(orders, red, green, blue);
		CalculateUtil.checkMaxCapacityAfterOptimizeOrders(orders, red, green, blue);
		//Collections.sort(orders,new DistanceInGreen(1));
		PrintUtil.printOrders(orders);
		//CalculateUtil.totalCosts(orders);
		
		
		
		//int max =  Math.max(Math.max(count.get(Constants.BLUE_STORE_ID),count.get(Constants.RED_STORE_ID)),count.get(Constants.GREEN_STORE_ID));
		do {
			//PrintUtil.printOrders(orders);
			BoundaryUtil.test(orders ,red, green, blue);
			BoundaryUtil.assignCloseOrderToStoreCheck(orders,red,green,blue);
			//PrintUtil.printOrders(orders);
			
		}while(BoundaryUtil.boundaryCheck(orders, red, green, blue) == 0 );
		
		//Collections.sort(orders,new DistanceInBlue());
		PrintUtil.printOrders(orders);
		CalculateUtil.totalCosts(orders);
		
		//testDistance(orders);
		
		//Ready to write js.
		WriteToJS w = new WriteToJS();
		w.write(orders, new Store[] {red, green, blue});
		
	}
/*
	public static void testDistance(ArrayList<Order> orders) {
		double redTemp, greenTemp, blueTemp;
		ArrayList<Double> red = new ArrayList<Double>();
		ArrayList<Double> green = new ArrayList<Double>();
		ArrayList<Double> blue = new ArrayList<Double>();

		

		// Hangi Þubede Kaç Sipariþ Var?
		System.out.println("\nToplam Sipariþ (Kýrmýzý)	: " + red.size());
		System.out.println("Toplam Sipariþ (Yeþil)   	: " + green.size());
		System.out.println("Toplam Sipariþ (Mavi)	 	: " + blue.size());
		System.out.println("\n");

		// 0=Çiçek Bayisi Seçilmemiþ 1=Kýrmýzý Bayi 2=Yeþil Bayi 3=Mavi Bayi
		// Longitude= x ekseni , Latitude = y ekseni

		// Þuanlýk


		checkMaxCapacityAfterCalculateParalelArea(red, green, blue, orders);

		System.out.println("\nToplam Sipariþ (Kýrmýzý)	: " + red.size());
		System.out.println("Toplam Sipariþ (Yeþil)   	: " + green.size());
		System.out.println("Toplam Sipariþ (Mavi)	 	: " + blue.size());
		System.out.println("\n");

		// Collections.sort(Orders,new DistanceInBlue());
		// Collections.sort(Orders,new DistanceInGreen());

//  Sorting of arraylist using Collections.sort
//		 Collections.sort(red);
//		 Collections.sort(green);
//		 Collections.sort(blue);

		PrintUtil.printOrders(orders);

		// toplam uzaklýk hesabý
		double tk = 0, ty = 0, tm = 0;
		for (double counter : red) {
			// System.out.println( k++ + ". Kýrmýzý : " + counter);
			tk += counter;
		}

		for (double counter : green) {
			// System.out.println( k++ + ". Yeþil : " + counter);
			ty += counter;
		}

		for (double counter : blue) {
			// System.out.println( k++ + ". Mavi : " + counter);
			tm += counter;
		}

		System.out.println("\n Toplam Maliyet (Kýrmýzý) : " + tk);
		System.out.println("\n Toplam Maliyet (Yeþil) : " + ty);
		System.out.println("\n Toplam Maliyet (Mavi) : " + tm);

	}

	
	*/
}
