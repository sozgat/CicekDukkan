package com.cicek;
import java.io.IOException;
import java.util.ArrayList;
import com.model.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.utility.ExcelRead;

public class OrdersDelivery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// CTRL + SHIFT + O  => installs packages automatically.
		
		Company.init();//Initialize Company Coordinates
		ArrayList<DistanceCompany> distanceArray = new ArrayList<DistanceCompany>();
		
		try 
		{
			ArrayList<Order> listAddress = ExcelRead.getExcelData();
			double latA, lonA, latB, lonB;
			DistanceCompany tempCompany;
			
			for(int i=0; i < listAddress.size(); i++)
			{
				latB = listAddress.get(i).getLatitude();
				lonB = listAddress.get(i).getLongitude();
				
				//System.out.println("Coordinates: " + latB + " , " + lonB);
				
				latA = Company.redCompany.getLatitude();
				lonA = Company.redCompany.getLongitude();
				
				tempCompany = new DistanceCompany();
				
				tempCompany.setRedDistance(DistanceCalculator.getDistance(latA, lonA, latB, lonB)); 
				
				latA = Company.greenCompany.getLatitude();
				lonA = Company.greenCompany.getLongitude();
				
				tempCompany.setGreenDistance(DistanceCalculator.getDistance(latA, lonA, latB, lonB));
				
				latA = Company.blueCompany.getLatitude();
				lonA = Company.blueCompany.getLongitude();
				
				tempCompany.setBlueDistance(DistanceCalculator.getDistance(latA, lonA, latB, lonB));
				
				distanceArray.add(tempCompany);
			}
			
			//Cihan test icin bu fonksiyonla degerleri ekrana yazdiriyorum.
			System.out.println("Distance in km:");
			testDistance(distanceArray);
			
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
	
	
	
	

	
	
	
	
	
	public static void testDistance(ArrayList<DistanceCompany> distanceArray)
	{
		double redTemp, greenTemp, blueTemp;
		ArrayList<String> red	 = new ArrayList<String>();
		ArrayList<String> green	 = new ArrayList<String>();
		ArrayList<String> blue	 = new ArrayList<String>();
		
		
		for(int i=0; i<distanceArray.size(); i++)
		{
			redTemp = distanceArray.get(i).getRedDistance();
			greenTemp = distanceArray.get(i).getGreenDistance();
			blueTemp = distanceArray.get(i).getBlueDistance();

			int j = 0 ;
			// Temel B�lge = K�rm�z�
			if( distanceArray.get(i).getRedDistance() < distanceArray.get(i).getGreenDistance() && distanceArray.get(i).getRedDistance() < distanceArray.get(i).getBlueDistance() ) {
				
				System.out.println( i + ". Kay�t En K���k K�rm�z� ");
				
				if ( red.size() < 30 ) {	
					
					red.add("Sipari� ");
					
				} else if ( distanceArray.get(i).getGreenDistance() < distanceArray.get(i).getBlueDistance() && green.size() < 50 ){
					
					green.add("Sipari� ");
					
				} else if ( blue.size() < 35 ) {
					
					blue.add("Sipari�");
					
				} else {
					
					System.out.println("Kay�t Yap�lamad�! - K�rm�z� B�lge");
				}
				
			// Temel B�lge = Ye�il
			} else if( distanceArray.get(i).getGreenDistance() < distanceArray.get(i).getRedDistance() && distanceArray.get(i).getGreenDistance() < distanceArray.get(i).getBlueDistance()) {
				
				System.out.println( i + ". Kay�t En K���k Ye�il");
				
				if ( green.size() < 50) {
					
					green.add("Sipari� ");
					
				} else if ( distanceArray.get(i).getRedDistance() < distanceArray.get(i).getBlueDistance() && red.size() <30) {
					
					red.add("Sipari� ");
					
				} else if (blue.size() < 30 ) {
					
					blue.add("Sipari�");
					
				} else {					
					System.out.println("Kay�t Yap�lamad� - Ye�il B�lge");	
				}
							
			// Temel B�lge = Mavi
			} else if ( distanceArray.get(i).getBlueDistance() < distanceArray.get(i).getRedDistance() && distanceArray.get(i).getBlueDistance() < distanceArray.get(i).getGreenDistance()) {
				
				System.out.println( i + ". Kay�t En K���k Mavi ");
				
				// max 80 fakat minimum de�erleri sa�lamas� icin 45'den fazla olamaz
				if ( blue.size() < 45 ) { 
					
					blue.add("Sipari� ");
				
				} else if ( red.size() < 20 ) {	
					
					red.add("Sipari� ");
					
				} else if ( green.size() < 35 ) {
					
					green.add("Sipari�");
					
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
	
		
	
		
		
		
	}
}
