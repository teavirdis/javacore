package by.bsuir.houses.client.gui.util;

import java.util.Iterator;
import java.util.List;

import by.bsuir.houses.model.entities.House;

public class HouseParserUtils {

	public static Object[][] parseHousesList(List<House> houses) {
		Object[][] data = new Object[houses.size()][];
		Iterator<House> it = houses.iterator();
		int i = 0;
		while (it.hasNext()) {
			House h = it.next();
			Object[] arrayH = { new Integer(h.getId()), h.getAddress(),
					new Integer(h.getSize()) };
			data[i] = arrayH;
			i++;
		}
		return data;
	}
}
