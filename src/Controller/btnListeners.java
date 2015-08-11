package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;






import Model.model;
import Model.newFolio;
import Model.sellShare;
import View.homegui;

public class btnListeners implements ActionListener {




	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
			case "Buy":
				String ticker;
				int quantity;
				int flag=0;
				//needs doing
				ticker = homegui.getTicker();
				quantity = homegui.getAmount();
				flag = 0;
				model.buyShare(ticker, quantity,flag);
			break;
			case "Sell":
				ticker = homegui.getTicker();
				quantity = homegui.getAmount();
				flag = 1;
				model.buyShare(ticker, quantity,flag);
				
			break;
			case "New Portfolio":
				homegui.popupwindow("newfolio");
				//homegui.addFolio("steve");
				break;
			case "Delete Portfolio":
				System.out.println("jesus");
				homegui.popupwindow("delete");
			break;
			case "Quote":
				System.out.println("bitchez");
				homegui.popupwindow("quote");
			break;
			case "Save":
				System.out.println("420");
				homegui.popupwindow("save");
			break;
			case "Open Portfolio":
				homegui.openFolio();	
			break;
			case "Refresh":
				System.out.println("in church");
			break;
			case "ok":
				homegui.destroyNewFolio(0);
				newFolio.newTab(homegui.getFolioName());
			break;
			case "yes":
				homegui.destroyNewFolio(0);
				
				break;
			case "cancel":
				int panel = 0; 
				homegui.destroyNewFolio(panel);
				break;
		}
		
	}
	
}
