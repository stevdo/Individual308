package Model;

public class model {

public static void buyShare(String ticker, int quantity) {
	String valueStr = "-1";
	try {
		valueStr = StrathQuoteServer.getLastValue(ticker);
	} catch (WebsiteDataException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchTickerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(valueStr);
	
	}
	
	
	
	
	
}
