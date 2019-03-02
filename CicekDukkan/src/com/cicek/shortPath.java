package com.cicek;

import java.util.ArrayList;

public class shortPath {
	
	public static void main(String args[]) {
		
//		int red[][] =  new int[][] {};
//		int green[][] =  new int[][] {};
//		int blue[][] =  new int[][] {};
		
		//Gelen Þube Sipariþlerini Tutmak Ýçin
		ArrayList<String> red	 = new ArrayList<String>();
		ArrayList<String> green	 = new ArrayList<String>();
		ArrayList<String> blue	 = new ArrayList<String>();
		
		// Gidebileceði þubeler için uzaklýklar  kýrmýzý, yeþil, mavi
		int distance[][] =  new int[][] {
			{10,20,30}, 
			{15,20,25}, 
			{100,90,80},
			{75,50,12},
			{500,100,200},
			{40,10,35}
		};
		

		// Hangi Sipariþ Nerenin ?
		for(int i=0; i < distance.length; i++) { 
			
			int j = 0 ;
			if( distance[i][j] < distance[i][j+1] && distance[i][j] < distance[i][j+1] ) {
				
				System.out.println(" En Küçük Kýrmýzý \n");
				
				red.add("Sipariþ ");
		
			} else if( distance[i][j+1] < distance[i][j] && distance[i][j+1] < distance[i][j+2]) {
				
				System.out.println(" En Küçük Yeþil \n");
				green.add("Sipariþ ");
				
			} else if ( distance[i][j+2] < distance[i][j] && distance[i][j+2] < distance[i][j+1]) {
				
				System.out.println(" En Küçük Mavi \n");
				blue.add("Sipariþ ");
				
			} else {
				
				System.out.println(" Hiçbirine yerleþemedi. Hata ! \n");
			}
			
		}

		// Hangi Þubede Kaç Sipariþ Var?
		System.out.println("Toplam Sipariþ (Kýrmýzý) : " + red.size());
		System.out.println("Toplam Sipariþ (Yeþil)   : " + green.size());
		System.out.println("Toplam Sipariþ (Mavi)	 : " + blue.size());
	
		
		
		
		
		   
		
		
		
///////////////////         TEST    /////////////////////////////////		
		
		
	
		// Sýralama
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
		
		// Sýralý Diziyi ekranda göstermek için
//		for(int i=0; i < 4; i++) { // satýr 
//			System.out.println("\n" + ++i + ".  Sipariþ Mesafesi \n");
//			for(int j=0; j < 3; j++) {  // sütun
//				System.out.println("Mesafe distance[" + i + "][" + j + "]" + distance[i][j]);
//			}
//		}
			
		
		
		
		
	
		
		 

		
		
		
		
		
		
		
	} 
	
}


