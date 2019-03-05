package com.cicek;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.custom_compare.DistanceInBlue;
import com.custom_compare.DistanceInGreen;
import com.custom_compare.DistanceInRed;
import com.model.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.utility.CalculateSlope;
import com.utility.CheckAboveOfParallelLine;
import com.utility.ExcelRead;

public class OrdersDelivery {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// CTRL + SHIFT + O => installs packages automatically.te

		Store.init();// Initialize Company Coordinates

		try {
			ArrayList<Order> orders = ExcelRead.getExcelData();
			double latA, lonA, latB, lonB;

			for (int i = 0; i < orders.size(); i++) {
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

			// Cihan test icin bu fonksiyonla degerleri ekrana yazdiriyorum.
			System.out.println("Distance in km:");
			testDistance(orders);

		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testDistance(ArrayList<Order> Orders) {
		double redTemp, greenTemp, blueTemp;
		ArrayList<Double> red = new ArrayList<Double>();
		ArrayList<Double> green = new ArrayList<Double>();
		ArrayList<Double> blue = new ArrayList<Double>();

		for (int i = 0; i < Orders.size(); i++) {
			redTemp = Orders.get(i).getDistanceToRed();
			greenTemp = Orders.get(i).getDistanceToGreen();
			blueTemp = Orders.get(i).getDistanceToBlue();

			// Temel B�lge = K�rm�z�
			if (redTemp < greenTemp && redTemp < blueTemp) {

				System.out.println(i + ". Kay�t En K���k K�rm�z� ");
				red.add(redTemp);
				Orders.get(i).setChoosenStoreId(1);

				// Temel B�lge = Ye�il
			} else if (greenTemp < redTemp && greenTemp < blueTemp) {

				System.out.println(i + ". Kay�t En K���k Ye�il");
				green.add(greenTemp);
				Orders.get(i).setChoosenStoreId(2);

				// Temel B�lge = Mavi
			} else if (blueTemp < redTemp && blueTemp < greenTemp) {

				System.out.println(i + ". Kay�t En K���k Mavi ");
				blue.add(blueTemp);
				Orders.get(i).setChoosenStoreId(3);

			}
			System.out.println("{" + redTemp + " , " + greenTemp + " , " + blueTemp + "}");
		}

		// Hangi �ubede Ka� Sipari� Var?
		System.out.println("\nToplam Sipari� (K�rm�z�)	: " + red.size());
		System.out.println("Toplam Sipari� (Ye�il)   	: " + green.size());
		System.out.println("Toplam Sipari� (Mavi)	 	: " + blue.size());
		System.out.println("\n");

		// 0=�i�ek Bayisi Se�ilmemi� 1=K�rm�z� Bayi 2=Ye�il Bayi 3=Mavi Bayi 
		// Longitude= x ekseni , Latitude = y ekseni
	
		//�uanl�k 
		for (int i = 0; i < Orders.size(); i++) {
			if (Orders.get(i).getChoosenStoreId()==Store.redCompany.getStoreId()) {
				double slope=CalculateSlope.slope(Store.blueCompany.getLongitude(), Store.blueCompany.getLatitude(), Store.greenCompany.getLongitude(), Store.greenCompany.getLatitude());
				boolean check=CheckAboveOfParallelLine.Calculate(slope, Store.redCompany.getLongitude(), Store.redCompany.getLatitude(),Store.blueCompany.getLongitude(), Store.blueCompany.getLatitude(), Store.greenCompany.getLongitude(), Store.greenCompany.getLatitude(),
						Orders.get(i).getLongitude(), Orders.get(i).getLatitude());
				if (check==false) {
					Orders.get(i).setChoosenStoreId(0);
					red.remove(Orders.get(i).getDistanceToRed());
				}

			}
			if (Orders.get(i).getChoosenStoreId()==Store.greenCompany.getStoreId()) {
				double slope=CalculateSlope.slope(Store.redCompany.getLongitude(), Store.redCompany.getLatitude(), Store.blueCompany.getLongitude(), Store.blueCompany.getLatitude());
				boolean check=CheckAboveOfParallelLine.Calculate(slope, Store.greenCompany.getLongitude(), Store.greenCompany.getLatitude(), Store.redCompany.getLongitude(), Store.redCompany.getLatitude(), Store.blueCompany.getLongitude(),
						Store.blueCompany.getLatitude(),
						Orders.get(i).getLongitude(), Orders.get(i).getLatitude());
				if (check==false) {
					Orders.get(i).setChoosenStoreId(0);
					green.remove(Orders.get(i).getDistanceToGreen());
				}
			}
			if (Orders.get(i).getChoosenStoreId()==Store.blueCompany.getStoreId()) {
				double slope=CalculateSlope.slope(Store.greenCompany.getLongitude(), Store.greenCompany.getLatitude(), Store.redCompany.getLongitude(), Store.redCompany.getLatitude());
				boolean check=CheckAboveOfParallelLine.Calculate(slope, Store.blueCompany.getLongitude(), Store.blueCompany.getLatitude() , Store.redCompany.getLongitude(), Store.redCompany.getLatitude(),Store.greenCompany.getLongitude(), Store.greenCompany.getLatitude()
						, Orders.get(i).getLongitude(), Orders.get(i).getLatitude());
				if (check==false) {
					Orders.get(i).setChoosenStoreId(0);
					blue.remove(Orders.get(i).getDistanceToBlue());
				}
			}
			
			
		}

		
		checkMaxCapacityAfterCalculateParalelArea(red,green,blue,Orders);

		System.out.println("\nToplam Sipari� (K�rm�z�)	: " + red.size());
		System.out.println("Toplam Sipari� (Ye�il)   	: " + green.size());
		System.out.println("Toplam Sipari� (Mavi)	 	: " + blue.size());
		System.out.println("\n");

		//Collections.sort(Orders,new DistanceInBlue());
		//Collections.sort(Orders,new DistanceInGreen());
		
//  Sorting of arraylist using Collections.sort*/
//		 Collections.sort(red);
//		 Collections.sort(green);
//		 Collections.sort(blue);

		System.out.println("OId- SId - Distance To Red -- Distance To Green -- Distance To Blue \n");
		for (int i = 0; i < Orders.size(); i++) {
			System.out.println(Orders.get(i).getOrderId() + " - " + Orders.get(i).getChoosenStoreId() + " => "
					+ Orders.get(i).getDistanceToRed() + " - " + Orders.get(i).getDistanceToGreen() + " - "
					+ Orders.get(i).getDistanceToBlue());
		}

		// toplam uzakl�k hesab�
		double tk = 0, ty = 0, tm = 0;
		for (double counter : red) {
			// System.out.println( k++ + ". K�rm�z� : " + counter);
			tk += counter;
		}

		for (double counter : green) {
			// System.out.println( k++ + ". Ye�il : " + counter);
			ty += counter;
		}

		for (double counter : blue) {
			// System.out.println( k++ + ". Mavi : " + counter);
			tm += counter;
		}

		System.out.println("\n Toplam Maliyet (K�rm�z�) : " + tk);
		System.out.println("\n Toplam Maliyet (Ye�il) : " + ty);
		System.out.println("\n Toplam Maliyet (Mavi) : " + tm);

	}
	
	
		
	public static void checkMaxCapacityAfterCalculateParalelArea(ArrayList<Double> red,ArrayList<Double> green,ArrayList<Double> blue,ArrayList<Order> Orders)
	
	{ if (red.size()>Store.redCompany.getMaxOrderCapacity()) {
			int count=0;
			Collections.sort(Orders,new DistanceInRed());
			for (int i = 0; i < Orders.size(); i++) {
				if (Orders.get(i).getChoosenStoreId()==Store.redCompany.getStoreId()) {
					count++;
				}
				if (Orders.get(i).getChoosenStoreId()==Store.redCompany.getStoreId() && count>Store.redCompany.getMaxOrderCapacity()) {
					Orders.get(i).setChoosenStoreId(0);
					red.remove(Orders.get(i).getDistanceToRed());
				}
			}
		}
		if(green.size()>Store.greenCompany.getMaxOrderCapacity()){
			int count=0;
			Collections.sort(Orders,new DistanceInGreen());
			for (int i = 0; i < Orders.size(); i++) {
				if (Orders.get(i).getChoosenStoreId()==Store.greenCompany.getStoreId()) {
					count++;
				}
				if (Orders.get(i).getChoosenStoreId()==Store.greenCompany.getStoreId() && count>Store.greenCompany.getMaxOrderCapacity()) {
					Orders.get(i).setChoosenStoreId(0);
					green.remove(Orders.get(i).getDistanceToGreen());
				}
			}
		}
		if(blue.size()>Store.blueCompany.getMaxOrderCapacity()) {
			int count=0;
			Collections.sort(Orders,new DistanceInBlue());
			for (int i = 0; i < Orders.size(); i++) {
				if (Orders.get(i).getChoosenStoreId()==Store.blueCompany.getStoreId()) {
					count++;
				}
				if (Orders.get(i).getChoosenStoreId()==Store.blueCompany.getStoreId() && count>Store.blueCompany.getMaxOrderCapacity()) {
					Orders.get(i).setChoosenStoreId(0);
					blue.remove(Orders.get(i).getDistanceToBlue());
				}
			}
			
		}
	}
}
