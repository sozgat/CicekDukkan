package com.services;


import java.applet.Applet;
import java.io.IOException;
import java.util.ArrayList;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.cicek.DistanceCalculator;
import com.cicek.OrdersDelivery;
import com.model.Order;
import com.model.Store;
import com.utility.ExcelRead;
import netscape.javascript.JSObject;;

public class ArrayToJS extends Applet{
	
	private ArrayList<Order> orders = new ArrayList<Order>();
	public static int q=2;
	public JSObject r(JSObject q) {return q;}
	public int test() {return 5;}
	
	public ArrayList<Order> getOrders()
	{
		Store.init();// Initialize Company Coordinates
		
		try
		{
			orders = ExcelRead.getExcelData();//Read data from Excel
			
			double latA, lonA, latB, lonB;

			for (int i = 0; i < orders.size(); i++) //Lat&Lon to Distance
			{
				latB = orders.get(i).getLatitude();
				lonB = orders.get(i).getLongitude();

				// System.out.println("Coordinates: " + latB + " , " + lonB);

				latA = Store.redCompany.getLatitude();
				lonA = Store.redCompany.getLongitude();

				orders.get(i).setDistanceToRed(DistanceCalculator.getDistance(latA, lonA, latB, lonB));

				latA = Store.greenCompany.getLatitude();
				lonA = Store.greenCompany.getLongitude();

				orders.get(i).setDistanceToGreen(DistanceCalculator.getDistance(latA, lonA, latB, lonB));

				latA = Store.blueCompany.getLatitude();
				lonA = Store.blueCompany.getLongitude();

				orders.get(i).setDistanceToBlue(DistanceCalculator.getDistance(latA, lonA, latB, lonB));
			}
			
			OrdersDelivery.testDistance(orders);//choosenStoreId's are setting...
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}
}
