package by.bsuir.houses.client.gui;

import by.bsuir.houses.client.builder.RequestBuilderImpl;
import by.bsuir.houses.client.gui.util.HouseParserUtils;
import by.bsuir.houses.client.tcp.TCPClient;
import by.bsuir.houses.model.covers.Request;
import by.bsuir.houses.model.covers.Response;
import by.bsuir.houses.model.entities.House;

import java.util.List;

public class HousesTableData {
	
	
	private static final RequestBuilderImpl builder = new  RequestBuilderImpl(); 

	public static Object[][] prepareHousesdata() {
		builder.setAction(Request.Action.ALLHOUSES);
		Response resp = TCPClient.send(builder.buildRequest());
		List<House> houses = resp.getHouses();
		return HouseParserUtils.parseHousesList(houses);
	}

}
