package com.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.model.Order;
import com.model.Store;

public class WriteToJS {
	
	private String[] rgb= new String[] {
			"#ff0000",//red
			"#00ff00",//green
			"#0000ff"//blue
			};
	
	public void write(ArrayList<Order> orders, Store[] storeData)
	{
		ArrayList<Order> tempList = new ArrayList<Order>();
		String data = "";
		String ordersId = "";
		
		data += "ymaps.ready(init);\r\n" + 
				"\r\n" + 
				"	function init() {\r\n" + 
				"	    var myMap = new ymaps.Map(\"map\", {\r\n" + 
				"	            center: [41.051883, 29.007060],\r\n" + 
				"	            zoom: 13\r\n" + 
				"	        }, {\r\n" + 
				"	            searchControlProvider: 'yandex#search'\r\n" + 
				"	        }),\r\n" + 
				"\r\n" + 
				"	    // Creating a geo object with the \"Point\" geometry type.\r\n" + 
				"	        myGeoObject = new ymaps.GeoObject({ }, {})\r\n" + 
				"	        myMap.geoObjects\r\n" + 
				"\r\n";
		
		for(int i=0; i<orders.size(); i++)//Order points is adding...
		{
			ordersId = controlSameCoordinate(orders.get(i), tempList);
			data +=
				"	        .add(new ymaps.Placemark(["+orders.get(i).getLatitude()+
													","+orders.get(i).getLongitude() +"], {\r\n" + 
				"	            balloonContent: '"+ordersId+"',\r\n" + 
				"	            iconCaption: '"+ordersId+"'\r\n" + 
				"	        }, {\r\n" + 
				"	        	preset: 'islands#blueCircleDotIconWithCaption',\r\n" + 
				"	            iconColor: '"+
								(orders.get(i).getChoosenStoreId() == 0 ?
								"#000000" : rgb[orders.get(i).getChoosenStoreId()-1])+"'\r\n" + 
				"	        }))\r\n";
			
				System.out.println((i+1)+". placemark was added.");
				tempList.add(orders.get(i));
		}
		
		for(int j=0; j<storeData.length; j++)//Store points is adding...
		{
			data +=
				"	        .add(new ymaps.Placemark(["+storeData[j].getLatitude()+
													","+storeData[j].getLongitude() +"], {\r\n" + 
				"	            balloonContent: '"+"Store:"+(j+1)+"',\r\n" + 
				"	            iconCaption: '"+"Store:"+(j+1)+"'\r\n" + 
				"	        }, {\r\n" + 
				"	        	preset: 'islands#glyphIcon',\r\n" +  
				"				iconGlyph: 'hdd',"+
				"				iconColor: '#000000',"+
				"	            iconGlyphColor: '"+rgb[j]+"'\r\n" +
				"	        }))\r\n";
			
				System.out.println((j+1)+". Store was added.");
		}
		
		data += "	;}";
		
		try//Js file is creating...
		{
			File file = new File("placemark.js");
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	
	        FileWriter fileWriter = new FileWriter(file, false);
	        BufferedWriter bWriter = new BufferedWriter(fileWriter);
	        bWriter.write(data);
	        bWriter.close();
		}
		catch (Exception e) {
			System.out.println("Dosya isleminde bir hata meydana geldi!\n");
			return;
			// TODO: handle exception
		}
		
		System.out.println("Js kodlari basarili bir sekilde dosyaya yazildi.\n");	
	}
	
	public String controlSameCoordinate(Order m_order, ArrayList<Order> list)
	{
		String temp = "";
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getLatitude() == m_order.getLatitude() &&
			   list.get(i).getLongitude() == m_order.getLongitude())
			{
				temp += (list.get(i).getOrderId()+",") ;
			}
		}
		
		temp += m_order.getOrderId();
		
		return temp;
	}
}
