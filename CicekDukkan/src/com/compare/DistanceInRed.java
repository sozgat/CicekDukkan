package com.compare;

import java.util.Comparator;

import com.constants.Constants;
import com.model.Order;

public class DistanceInRed implements Comparator<Order> {
	// order 0 ise k���kten b�y��e, 1 ise b�y�kten k����e s�ralama
	private int order;

	public DistanceInRed() {
	}

	public DistanceInRed(int order) {
		this.order = order;
	}

	@Override
	public int compare(Order o1, Order o2) {
		if (order == 0) {
			return Double.compare(o1.getDistanceToStore().get(Constants.RED_STORE_ID),
					o2.getDistanceToStore().get(Constants.RED_STORE_ID));

		}
		return Double.compare(o2.getDistanceToStore().get(Constants.RED_STORE_ID),
				o1.getDistanceToStore().get(Constants.RED_STORE_ID));
	}

}
