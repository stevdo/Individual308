package Model;

import Controller.viewUpdate;

public class model {
public static void buyShare(String ticker, int quantity) {
	float value = 321;
	viewUpdate.tableFill(ticker,"115.50",quantity,value);
	
}
/*public static void buyShare(String ticker, int quantity) {
	String price = "-1";
	try {
		price = StrathQuoteServer.getLastValue(ticker);
	} catch (WebsiteDataException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchTickerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(price);

	Float value =	Float.valueOf(price);
	value = value*quantity;
	System.out.println(value);
	viewUpdate.tableFill(ticker, price, quantity, value);	
	}*/


	
	
	
	
	
}
