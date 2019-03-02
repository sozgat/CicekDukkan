package com.cicek;

import java.util.ArrayList;

public class shortPath {
	
	public static void main(String args[]) {
		
//		int red[][] =  new int[][] {};
//		int green[][] =  new int[][] {};
//		int blue[][] =  new int[][] {};
		
		//Gelen �ube Sipari�lerini Tutmak ��in
		ArrayList<String> red	 = new ArrayList<String>();
		ArrayList<String> green	 = new ArrayList<String>();
		ArrayList<String> blue	 = new ArrayList<String>();
		
		// Gidebilece�i �ubeler i�in uzakl�klar  k�rm�z�, ye�il, mavi
		int distance[][] =  new int[][] {
			{10,20,30}, 
			{15,20,25}, 
			{100,90,80},
			{75,50,12},
			{500,100,200},
			{40,10,35}
		};
		

		// Hangi Sipari� Nerenin ?
		for(int i=0; i < distance.length; i++) { 
			
			int j = 0 ;
			if( distance[i][j] < distance[i][j+1] && distance[i][j] < distance[i][j+1] ) {
				
				System.out.println(" En K���k K�rm�z� \n");
				
				red.add("Sipari� ");
		
			} else if( distance[i][j+1] < distance[i][j] && distance[i][j+1] < distance[i][j+2]) {
				
				System.out.println(" En K���k Ye�il \n");
				green.add("Sipari� ");
				
			} else if ( distance[i][j+2] < distance[i][j] && distance[i][j+2] < distance[i][j+1]) {
				
				System.out.println(" En K���k Mavi \n");
				blue.add("Sipari� ");
				
			} else {
				
				System.out.println(" Hi�birine yerle�emedi. Hata ! \n");
			}
			
		}

		// Hangi �ubede Ka� Sipari� Var?
		System.out.println("Toplam Sipari� (K�rm�z�) : " + red.size());
		System.out.println("Toplam Sipari� (Ye�il)   : " + green.size());
		System.out.println("Toplam Sipari� (Mavi)	 : " + blue.size());
	
		
		
		
		
		   
		
		
		
///////////////////         TEST    /////////////////////////////////		
		
		
	
		// S�ralama
//		int sayi;
//		 for(int i=0;i< 4;i++) {
//			 for(int j=0;j< 3;j++) {
//				 for (int k = 0; k < 3; k++){
//					 if(dizi[i][j]< dizi[i][k]) {
//				        sayi=dizi[i][j];
//				        dizi[i][j]=dizi[i][k];
//				        dizi[i][k]=sayi;
//					 }
//				 }
//			 }
//		 }
		
		// S�ral� Diziyi ekranda g�stermek i�in
//		for(int i=0; i < 4; i++) { // sat�r 
//			System.out.println("\n" + ++i + ".  Sipari� Mesafesi \n");
//			for(int j=0; j < 3; j++) {  // s�tun
//				System.out.println("Mesafe distance[" + i + "][" + j + "]" + distance[i][j]);
//			}
//		}
			
		
		
		
		
	
		
		 

		
		
		
		
		
		
		
	} 
	
}


