package com.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import com.compare.DistanceInBlue;
import com.compare.DistanceInGreen;
import com.compare.DistanceInRed;
import com.constants.Constants;
import com.model.Counter;
import com.model.Order;
import com.model.Store;

public class BoundaryUtil {

	public static int boundaryCheck(ArrayList<Order> orders, Store red, Store green, Store blue) {
		int result = 1, redCount = 0, greenCount = 0, blueCount = 0, notChoosen = 0;

		redCount = red.getCurrentOrderCount();
		greenCount = green.getCurrentOrderCount();
		blueCount = blue.getCurrentOrderCount();
		notChoosen = orders.size() - (redCount + greenCount + blueCount);

		if (redCount < red.getMinOrderCapacity() || redCount > red.getMaxOrderCapacity()) {
			result = 0;
		}
		if (greenCount < green.getMinOrderCapacity() || greenCount > green.getMaxOrderCapacity()) {
			result = 0;
		}
		if (blueCount < blue.getMinOrderCapacity() || blueCount > blue.getMaxOrderCapacity()) {
			result = 0;
		}
		if (notChoosen > 0) {
			result = 0;
		}

		return result;
	}

	// Bayiye en yakýn olan sipariþleri o bayiye atar.
	public static void assignCloseOrderToStore(ArrayList<Order> orders, Store red, Store green, Store blue) {
		for (int i = 0; i < orders.size(); i++) {
			Order order = orders.get(i);
			if (order.getChoosenStoreId() == Constants.NOT_CHOOSEN_STORE_ID) {

				double redTemp = order.getDistanceToStore().get(Constants.RED_STORE_ID);
				double greenTemp = order.getDistanceToStore().get(Constants.GREEN_STORE_ID);
				double blueTemp = order.getDistanceToStore().get(Constants.BLUE_STORE_ID);

				// Temel Bölge = Kýrmýzý
				if (redTemp < greenTemp && redTemp < blueTemp) {

					// System.out.println(i + ". Kayýt En Küçük Kýrmýzý ");

					order.setChoosenStoreId(red.getStoreId());
					red.incrementCurrentOrderCount();

					// Temel Bölge = Yeþil
				} else if (greenTemp < redTemp && greenTemp < blueTemp) {

					// System.out.println(i + ". Kayýt En Küçük Yeþil");
					order.setChoosenStoreId(green.getStoreId());
					green.incrementCurrentOrderCount();
					// Temel Bölge = Mavi
				} else if (blueTemp < redTemp && blueTemp < greenTemp) {

					// System.out.println(i + ". Kayýt En Küçük Mavi ");
					order.setChoosenStoreId(blue.getStoreId());
					blue.incrementCurrentOrderCount();
				} else {
					System.err.println("ERROR... assignCloseOrderToStore" + order);
				}
				// System.out.println("{" + redTemp + " , " + greenTemp + " , " + blueTemp +
				// "}");
			}
		}

	}

	public static Store getAvailableStore(Order order, Store store1, Store store2) {
		double temp1 = order.getDistanceToStore().get(store1.getStoreId());
		double temp2 = order.getDistanceToStore().get(store2.getStoreId());

		if (temp1 < temp2 && store1.getCurrentOrderCount() < store1.getMaxOrderCapacity()) {
			return store1;
		}

		return store2;

	}

	public static void assignCloseOrderToStoreCheck(ArrayList<Order> orders, Store red, Store green, Store blue) {
		for (int i = 0; i < orders.size(); i++) {
			Order order = orders.get(i);
			if (order.getChoosenStoreId() == Constants.NOT_CHOOSEN_STORE_ID) {

				double redTemp = order.getDistanceToStore().get(Constants.RED_STORE_ID);
				double greenTemp = order.getDistanceToStore().get(Constants.GREEN_STORE_ID);
				double blueTemp = order.getDistanceToStore().get(Constants.BLUE_STORE_ID);

				// Temel Bölge = Kýrmýzý
				if (red.getCurrentOrderCount() < red.getMaxOrderCapacity()) {
					if (redTemp < greenTemp && redTemp < blueTemp) {
						order.setChoosenStoreId(red.getStoreId());
						red.incrementCurrentOrderCount();
						return;
					} 
					else if (green.getCurrentOrderCount() == green.getMaxOrderCapacity() &&
							redTemp < blueTemp) {
						
							order.setChoosenStoreId(red.getStoreId());
							red.incrementCurrentOrderCount();
							return;
						

					}
					else if(blue.getCurrentOrderCount() == blue.getMaxOrderCapacity() && redTemp < greenTemp) {
						
							order.setChoosenStoreId(red.getStoreId());
							red.incrementCurrentOrderCount();
							return;
						
					}
					
					else if (green.getCurrentOrderCount() == green.getMaxOrderCapacity()
							&& blue.getCurrentOrderCount() == blue.getMaxOrderCapacity() ) {
							order.setChoosenStoreId(red.getStoreId());
							red.incrementCurrentOrderCount();
							return;
						

					}

				}

				// Temel Bölge = Yeþil
				if (green.getCurrentOrderCount() < green.getMaxOrderCapacity()) {
					if (greenTemp < redTemp && greenTemp < blueTemp) {
						order.setChoosenStoreId(green.getStoreId());
						green.incrementCurrentOrderCount();
						return;
					}
					else if(red.getCurrentOrderCount() == red.getMaxOrderCapacity() && greenTemp < blueTemp) {
						
							order.setChoosenStoreId(green.getStoreId());
							green.incrementCurrentOrderCount();
							return;
						
					}
					else if(blue.getCurrentOrderCount() == blue.getMaxOrderCapacity() && greenTemp < redTemp) {
						
							order.setChoosenStoreId(green.getStoreId());
							green.incrementCurrentOrderCount();
							return;
						
						
					}
					else if(red.getCurrentOrderCount() == red.getMaxOrderCapacity()&&blue.getCurrentOrderCount() == blue.getMaxOrderCapacity()) {
						order.setChoosenStoreId(green.getStoreId());
						green.incrementCurrentOrderCount();
						return;
					}

				}

				// Temel Bölge = Mavi

				if (blue.getCurrentOrderCount() < blue.getMaxOrderCapacity()) {
					if (blueTemp < redTemp && blueTemp < greenTemp) {
						order.setChoosenStoreId(blue.getStoreId());
						blue.incrementCurrentOrderCount();
						return;
					}
					else if(green.getCurrentOrderCount() == green.getMaxOrderCapacity()
							&& blueTemp<redTemp) {
						
							order.setChoosenStoreId(blue.getStoreId());
							blue.incrementCurrentOrderCount();
							return;
						
					}
					else if(red.getCurrentOrderCount() == red.getMaxOrderCapacity() && blueTemp<greenTemp) {
						
							order.setChoosenStoreId(blue.getStoreId());
							blue.incrementCurrentOrderCount();
							return;
						
					}
					else if(green.getCurrentOrderCount() == green.getMaxOrderCapacity()&&
							red.getCurrentOrderCount() == red.getMaxOrderCapacity()) {
						order.setChoosenStoreId(blue.getStoreId());
						blue.incrementCurrentOrderCount();
						return;
					}

				}

				// System.out.println("{" + redTemp + " , " + greenTemp + " , " + blueTemp +
				// "}");
			}
		}

	}

	// Büyük ÜÇGENDE içeride kalanlan noktalarýn bayilere uzaklýðýnýn sayacý
	public static void test(ArrayList<Order> orders, Store red, Store green, Store blue) {

		// int tempGreen = 0, tempBlue = 0, tempRed = 0;

		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		count.put(1, 0);
		count.put(2, 0);
		count.put(3, 0);

		for (int i = 0; i < orders.size(); i++) {
			Order order = orders.get(i);
			if (order.getChoosenStoreId() == Constants.NOT_CHOOSEN_STORE_ID) {

				double redTemp = order.getDistanceToStore().get(Constants.RED_STORE_ID);
				double greenTemp = order.getDistanceToStore().get(Constants.GREEN_STORE_ID);
				double blueTemp = order.getDistanceToStore().get(Constants.BLUE_STORE_ID);

				// Temel Bölge = Kýrmýzý
				if (redTemp < greenTemp && redTemp < blueTemp) {
					if (red.getCurrentOrderCount() < red.getMaxOrderCapacity()) {
						// tempRed++;
						count.put(red.getStoreId(), count.get(red.getStoreId()) + 1);
					} else {
						Store availableStore = getAvailableStore(order, green, blue);
						count.put(availableStore.getStoreId(), count.get(availableStore.getStoreId()) + 1);
					}
					// Temel Bölge = Yeþil
				} else if (greenTemp < redTemp && greenTemp < blueTemp) {
					if (green.getCurrentOrderCount() < green.getMaxOrderCapacity()) {
						// tempRed++;
						count.put(green.getStoreId(), count.get(green.getStoreId()) + 1);
					} else {
						Store availableStore = getAvailableStore(order, red, blue);
						count.put(availableStore.getStoreId(), count.get(availableStore.getStoreId()) + 1);
					}

					// System.out.println(i + ". Kayýt En Küçük Yeþil");
					// tempGreen++;
					// Temel Bölge = Mavi
				} else if (blueTemp < redTemp && blueTemp < greenTemp) {

					if (blue.getCurrentOrderCount() < blue.getMaxOrderCapacity()) {
						// tempRed++;
						count.put(blue.getStoreId(), count.get(blue.getStoreId()) + 1);
					} else {
						Store availableStore = getAvailableStore(order, green, red);
						count.put(availableStore.getStoreId(), count.get(availableStore.getStoreId()) + 1);
					}

					// System.out.println(i + ". Kayýt En Küçük Mavi ");
//					count.put(Constants.BLUE_STORE_ID, count.get(Constants.BLUE_STORE_ID) + 1);
					// tempBlue++;
				} else {
					System.err.println("ERROR..." + order);
				}

			}
		}

		if (count.get(blue.getStoreId()) > count.get(green.getStoreId())
				&& count.get(blue.getStoreId()) > count.get(red.getStoreId())
				&& blue.getCurrentOrderCount() < blue.getMaxOrderCapacity()) {
			Collections.sort(orders, new DistanceInBlue());
		} else if (count.get(green.getStoreId()) > count.get(blue.getStoreId())
				&& count.get(green.getStoreId()) > count.get(red.getStoreId())
				&& green.getCurrentOrderCount() < green.getMaxOrderCapacity()) {
			Collections.sort(orders, new DistanceInGreen());
		} else if (red.getCurrentOrderCount() < red.getMaxOrderCapacity()) {
			Collections.sort(orders, new DistanceInRed());
		}

	}
}
