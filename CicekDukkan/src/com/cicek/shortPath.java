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
		
		// Þubeler için uzaklýklar  kýrmýzý, yeþil, mavi
		int distance[][] =  new int[][] {
			{10,20,50}, 
			{15,20,25}, 
			{100,90,80},
			{75,50,12},
			{500,100,200},
			{40,10,35}, 
			{3,2,1}
		};
		 

		// Hangi Sipariþ Nerenin ?
		for(int i=0; i < distance.length; i++) { 
			
			int j = 0 ;
			// Temel Bölge = Kýrmýzý
			if( distance[i][j] < distance[i][j+1] && distance[i][j] < distance[i][j+2] ) {
				
				System.out.println( i + ". Kayýt En Küçük Kýrmýzý ");
				
				if ( red.size() <= 30 ) {	
					
					red.add("Sipariþ ");
					
				} else if ( distance[i][j+1] <= distance[i][j+2] && green.size() < 50 ){
					
					green.add("Sipariþ ");
					
				} else if ( blue.size() <= 35 ) {
					
					blue.add("Sipariþ");
					
				} else {
					
					System.out.println("Kayýt Yapýlamadý! - Kýrmýzý Bölge");
				}
				
			// Temel Bölge = Yeþil
			} else if( distance[i][j+1] < distance[i][j] && distance[i][j+1] < distance[i][j+2]) {
				
				System.out.println( i + ". Kayýt En Küçük Yeþil");
				
				if ( green.size() <= 50) {
					
					green.add("Sipariþ ");
					
				} else if ( distance[i][j] <= distance[i][j+2] && red.size() <=30) {
					
					red.add("Sipariþ ");
					
				} else if (blue.size() <= 30 ) {
					
					blue.add("Sipariþ");
					
				} else {					
					System.out.println("Kayýt Yapýlamadý - Yeþil Bölge");	
				}
							
			// Temel Bölge = Mavi
			} else if ( distance[i][j+2] < distance[i][j] && distance[i][j+2] < distance[i][j+1]) {
				
				System.out.println( i + ". Kayýt En Küçük Mavi ");
				
				// max 80 fakat minimum deðerleri saðlamasý icin 45'den fazla olamaz
				if ( blue.size() <= 45 ) { 
					
					blue.add("Sipariþ ");
				
				} else if ( red.size() <= 20 ) {	
					
					red.add("Sipariþ ");
					
				} else if ( green.size() <= 35 ) {
					
					green.add("Sipariþ");
					
				} else {
					System.out.println("Kayýt Yapýlamadý - Mavi Bölge");
				}
								
			} else {
				
				System.out.println(" Hiçbir þubeye aktarýlamadý. Genel Hata ! \n");
			}
			
		}

		
		// Hangi Þubede Kaç Sipariþ Var?
		System.out.println("\nToplam Sipariþ (Kýrmýzý)	: " + red.size());
		System.out.println("Toplam Sipariþ (Yeþil)   	: " + green.size());
		System.out.println("Toplam Sipariþ (Mavi)	 	: " + blue.size());
	
		
		
		
		
		   
		
		
		
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


