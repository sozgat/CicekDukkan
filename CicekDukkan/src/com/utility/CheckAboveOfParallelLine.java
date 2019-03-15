package com.utility;

//3 nokta elimizde oldu�u i�in ��gen olu�turduk. Ve her bir k��esini se�ip di�er k��elerin olu�turdu�u do�ruya paralel �izdirdik.
//Bu �izilen paralelin hangi b�lgesine bakaca��z? Bunu hesaplamak i�in ��genin di�er k��elerinin paralel olan durumunu kontrol ediyoruz.
//E�er noktalar solda ise sa��, �stte ise alt� kontrol etmemiz gerekiyor.Di�er durum tam tersi... Matematik E�itsizlikler Konusu
//Burada amac�m�z se�ilen noktan�n d���nda kalan yani di�er noktalara en uzaklar� bulmak.

public class CheckAboveOfParallelLine {
	
	//Latitude = y koordinat� , Longitude= x koordinat�
	//slope= e�im
	//storeLongitude,storeLatitude=Kontrol edilecek bayi de�i�kenleri, bu bayinin alt�na veya �st b�lgesine bak�lacak y>=mx+n e�itsizlik form�l�
	//checkOrderLongitude,checkOrderLatitude= Kontrol edilecek sipari�. Sipari�ler se�ilen bayinin hangi b�lgesinde kal�yor
	//otherStoreLongitude,otherStoreLatitude = kontrol edilecek bayinin hangi taraf�n� kontrol etmek i�in ��genin di�er noktalar�ndan birini tutan de�i�ken
	//otherStoreLongitude2,otherStoreLatitude2 = Kontrol edilecek bayinin hangi taraf�n� kontrol etmek i�in ��genin di�er noktalar�ndan birini tutan de�i�ken
	public static boolean Calculate(double slope, double storeLongitude, double storeLatitude,
			double otherStoreLongitude,double otherStoreLatitude,
			double otherStoreLongitude2, double	otherStoreLatitude2,
			double checkOrderLongitude, double checkOrderLatitude) {
		
		// Kontrol edilecek bayinin Y eksenini kesti�i nokta
		double pointCutYAxisOfStore= (slope*(-storeLongitude))+storeLatitude;

		
		if(otherStoreLatitude>= otherStoreLongitude*slope + pointCutYAxisOfStore && otherStoreLatitude2>= otherStoreLongitude2*slope + pointCutYAxisOfStore) {
			//System.out.println("��gen Noktalar �sttedir"); 
			//yani burada ��genin y�nlerini bulduk. Tam tersi istikameti kontrol ettirmemiz gerekiyor. Alt taraflar kontrol edilicek bu eksen i�in
			if (checkOrderLatitude<= checkOrderLongitude*slope + pointCutYAxisOfStore || Double.isInfinite(pointCutYAxisOfStore)) {
				//System.out.println("Kontrol edilen nokta alan�n i�indedir.");
				return true;
			}
			else {
				//System.out.println("Kontrol edilen nokta alan�n d���ndad�r.");
				return false;
			}
			
		}
		else {
			//System.out.println("��gen Noktalar� alttad�r");
			//yani burada ��genin y�nlerini bulduk. Tam tersi istikameti kontrol ettirmemiz gerekiyor. Alt taraflar kontrol edilicek bu eksen i�in
			
			if (checkOrderLatitude>= checkOrderLongitude*slope + pointCutYAxisOfStore || Double.isInfinite(pointCutYAxisOfStore)) {
				//System.out.println("Kontrol edilen nokta alan�n i�indedir.");
				return true;
			}
			else {
				//System.out.println("Kontrol edilen nokta alan�n d���ndad�r.");
				return false;
			}
		}
		
		
	}

}
