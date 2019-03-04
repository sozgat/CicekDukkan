package com.cicek;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.model.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.utility.ExcelRead;

public class OrdersDelivery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// CTRL + SHIFT + O  => installs packages automatically.te
		
		Company.init();//Initialize Company Coordinates
		
		
		try 
		{
			ArrayList<Order> orders = ExcelRead.getExcelData();
			double latA, lonA, latB, lonB;
			
			for(int i=0; i < orders.size(); i++)
			{
				latB = orders.get(i).getLatitude();
				lonB = orders.get(i).getLongitude();
				
				//System.out.println("Coordinates: " + latB + " , " + lonB);
				
				latA = Company.redCompany.getLatitude();
				lonA = Company.redCompany.getLongitude();
				
				
				orders.get(i).setDistanceToRed(DistanceCalculator.getDistance(latA, lonA, latB, lonB)); 
				
				latA = Company.greenCompany.getLatitude();
				lonA = Company.greenCompany.getLongitude();
				
				orders.get(i).setDistanceToGreen(DistanceCalculator.getDistance(latA, lonA, latB, lonB));
				
				latA = Company.blueCompany.getLatitude();
				lonA = Company.blueCompany.getLongitude();
				
				orders.get(i).setDistanceToBlue(DistanceCalculator.getDistance(latA, lonA, latB, lonB));

			}
			
			//Cihan test icin bu fonksiyonla degerleri ekrana yazdiriyorum.
			System.out.println("Distance in km:");
			testDistance(orders);
			
		} 
		catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
	
	
	
	

	
	
	
	
	
	public static void testDistance(ArrayList<Order> Orders)
	{
		double redTemp, greenTemp, blueTemp;
		ArrayList<Double> red	 = new ArrayList<Double>();
		ArrayList<Double> green	 = new ArrayList<Double>();
		ArrayList<Double> blue	 = new ArrayList<Double>();
		
		
		for(int i=0; i<Orders.size(); i++)
		{
			redTemp = Orders.get(i).getDistanceToRed();
			greenTemp = Orders.get(i).getDistanceToGreen();
			blueTemp = Orders.get(i).getDistanceToBlue();


			// Temel B�lge = K�rm�z�
			if( Orders.get(i).getDistanceToRed() < Orders.get(i).getDistanceToGreen() && Orders.get(i).getDistanceToRed() < Orders.get(i).getDistanceToBlue() ) {
				
				System.out.println( i + ". Kay�t En K���k K�rm�z� ");
				
				if ( red.size() < 30 ) {	
					
					red.add(redTemp);
					
				} else if ( Orders.get(i).getDistanceToGreen() < Orders.get(i).getDistanceToBlue() && green.size() < 50 ){
					
					green.add(greenTemp);
					
				} else if ( blue.size() < 35 ) {
					
					blue.add(blueTemp);
					
				} else {
					
					System.out.println("Kay�t Yap�lamad�! - K�rm�z� B�lge");
				}
				
			// Temel B�lge = Ye�il
			} else if( Orders.get(i).getDistanceToGreen() < Orders.get(i).getDistanceToRed() && Orders.get(i).getDistanceToGreen() < Orders.get(i).getDistanceToBlue()) {
				
				System.out.println( i + ". Kay�t En K���k Ye�il");
				
				if ( green.size() < 50) {
					
					green.add(greenTemp);
					
				} else if ( Orders.get(i).getDistanceToRed() < Orders.get(i).getDistanceToBlue() && red.size() <30) {
					
					red.add(redTemp);
					
				} else if (blue.size() < 30 ) {
					
					blue.add(blueTemp);
					
				} else {					
					System.out.println("Kay�t Yap�lamad� - Ye�il B�lge");	
				}
							
			// Temel B�lge = Mavi
			} else if ( Orders.get(i).getDistanceToBlue() < Orders.get(i).getDistanceToRed() && Orders.get(i).getDistanceToBlue() < Orders.get(i).getDistanceToGreen()) {
				
				System.out.println( i + ". Kay�t En K���k Mavi ");
				
				// max 80 fakat minimum de�erleri sa�lamas� icin 45'den fazla olamaz
				if ( blue.size() < 45 ) { 
					
					blue.add(blueTemp);
				
				} else if ( red.size() < 20 ) {	
					
					red.add(redTemp);
					
				} else if ( green.size() < 35 ) {
					
					green.add(greenTemp);
					
				} else {
					System.out.println("Kay�t Yap�lamad� - Mavi B�lge");
				}
								
			} else {
				
				System.out.println(" Hi�bir �ubeye aktar�lamad�. Genel Hata ! \n");
			}
			

			
			
			System.out.println("{" + redTemp + " , " + greenTemp + " , " + blueTemp + "}");
		}
		

		
		// Hangi �ubede Ka� Sipari� Var?
		System.out.println("\nToplam Sipari� (K�rm�z�)	: " + red.size());
		System.out.println("Toplam Sipari� (Ye�il)   	: " + green.size());
		System.out.println("Toplam Sipari� (Mavi)	 	: " + blue.size());
		System.out.println("\n");
		
		//  Sorting of arraylist using Collections.sort*/
		 Collections.sort(red);
		 Collections.sort(green);
		 Collections.sort(blue);
		
		
//		for( int i = 0; i < green.size(); i++  ) {
//			System.out.println( i + ".  Eleman : " + green.get(i));
//		}
		
		System.out.println("\n K�rm�z�lar : \n");
		int k = 0;
		for(double counter: red ) {
			
			System.out.println( k++ + "idli K�rm�z� : " + counter);
		}
		
		System.out.println("\n Ye�iller : \n");
		k = 0;
		for(double counter: green ) {
			System.out.println( k++ + ".  Ye�il : " + counter);
		}
		
		System.out.println("\n Maviler : \n");
		k = 0;
		for(double counter: blue ) {
			System.out.println( k++ + ".  Mavi : " + counter);
		}
		
		
		
	
		
	}
}
