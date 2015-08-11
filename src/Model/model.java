package Model;

import Controller.viewUpdate;

public class model {
public static void buyShare(String ticker, int quantity, int flag) {
	float value = 321;
	if (flag == 0){
	viewUpdate.tableFill(ticker,"115.50",quantity,value);
	} 
	if (flag == 1){
		sellShare.determine(ticker, quantity, "115.50", value);
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
}
