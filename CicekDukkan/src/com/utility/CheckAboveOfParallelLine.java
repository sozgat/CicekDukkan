package com.utility;

//3 nokta elimizde olduðu için üçgen oluþturduk. Ve her bir köþesini seçip diðer köþelerin oluþturduðu doðruya paralel çizdirdik.
//Bu çizilen paralelin hangi bölgesine bakacaðýz? Bunu hesaplamak için üçgenin diðer köþelerinin paralel olan durumunu kontrol ediyoruz.
//Eðer noktalar solda ise saðý, üstte ise altý kontrol etmemiz gerekiyor.Diðer durum tam tersi...
//Burada amacýmýz seçilen noktanýn dýþýnda kalan yani diðer noktalara en uzaklarý bulmak.

public class CheckAboveOfParallelLine {
	
	//Latitude = y ekseni , Longitude= x ekseni
	//slope= eðim
	//storeLongitude,storeLatitude=Kontrol edilecek bayi deðiþkenleri, bu bayinin altýna veya üst bölgesine bakýlacak y>=mx+n eþitsizlik formülü
	//checkOrderLongitude,checkOrderLatitude= Kontrol edilecek sipariþ. Sipariþler seçilen bayinin hangi bölgesinde kalýyor
	//otherStoreLongitude,otherStoreLatitude = kontrol edilecek bayinin hangi tarafýný kontrol etmek için üçgenin diðer noktalarýndan birini tutan deðiþken
	//otherStoreLongitude2,otherStoreLatitude2 = Kontrol edilecek bayinin hangi tarafýný kontrol etmek için üçgenin diðer noktalarýndan birini tutan deðiþken
	public static boolean Calculate(double slope, double storeLongitude, double storeLatitude,
			double otherStoreLongitude,double otherStoreLatitude,
			double otherStoreLongitude2, double	otherStoreLatitude2,
			double checkOrderLongitude, double checkOrderLatitude) {

		
		double xEkseniniKestigiNokta= ((-storeLatitude)/slope)+storeLongitude;
		
		double yEkseniniKestigiNokta= (slope*(-storeLongitude))+storeLatitude;

		
		
		if(otherStoreLatitude>= otherStoreLongitude*slope + yEkseniniKestigiNokta && otherStoreLatitude2>= otherStoreLongitude2*slope + yEkseniniKestigiNokta) {
			//System.out.println("Üçgen Noktalar üsttedir"); 
			//yani burada üçgenin yönlerini bulduk. Tam tersi istikameti kontrol ettirmemiz gerekiyor. Alt taraflar kontrol edilicek bu eksen için
			if (checkOrderLatitude<= checkOrderLongitude*slope + yEkseniniKestigiNokta || Double.isInfinite(yEkseniniKestigiNokta)) {
				//System.out.println("Kontrol edilen nokta alanýn içindedir.");
				return true;
			}
			else {
				//System.out.println("Kontrol edilen nokta alanýn dýþýndadýr.");
				return false;
			}
			
		}
		else {
			//System.out.println("Üçgen Noktalarý alttadýr");
			//yani burada üçgenin yönlerini bulduk. Tam tersi istikameti kontrol ettirmemiz gerekiyor. Alt taraflar kontrol edilicek bu eksen için
			
			if (checkOrderLatitude>= checkOrderLongitude*slope + yEkseniniKestigiNokta || Double.isInfinite(yEkseniniKestigiNokta)) {
				//System.out.println("Kontrol edilen nokta alanýn içindedir.");
				return true;
			}
			else {
				//System.out.println("Kontrol edilen nokta alanýn dýþýndadýr.");
				return false;
			}
		}
		
		
	}

}
