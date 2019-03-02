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
		
		for(int i=0; i<distanceArray.size(); i++)
		{
			redTemp = distanceArray.get(i).getRedDistance();
			greenTemp = distanceArray.get(i).getGreenDistance();
			blueTemp = distanceArray.get(i).getBlueDistance();
			
			System.out.println("{" + redTemp + " , " + greenTemp + " , " + blueTemp + "}");
		}
	}
}
