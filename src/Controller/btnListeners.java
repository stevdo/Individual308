package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;









import javax.swing.JFileChooser;

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
				homegui.updateValue();
			break;
			case "Sell":
				ticker = homegui.getTicker();
				quantity = homegui.getAmount();
				flag = 1;
				model.buyShare(ticker, quantity,flag);
				homegui.updateValue();
				
			break;
			case "New Portfolios":
				homegui.newFolioEntry();
				break;
			case "Delete Portfolio":
				homegui.deleteFolio();
			break;
			case "Quote":
				homegui.quoteShare();
			break;
			case "quote":
				model.quote(homegui.quoteTicker.getText());
			break;
			case "Save":
				homegui.saveWindow();
			break;
			case "Open Portfolio":
				homegui.openFolio();	
			break;
			case "Refresh":
				System.out.println("in church");
			break;
			case "ok":
				homegui.destroyFrame(0);
				newFolio.newTab(homegui.getFolioName());
			break;
			case "yes":
				homegui.destroyFrame(1);
				homegui.deletion();
				
				break;
			case "cancel":
				int panel = 0; 
				homegui.destroyFrame(panel);
				break;
			case "positive":
				homegui.deletion();
				break;
			case "no":
				homegui.destroyFrame(1);
				break;
		}
		
	}

	public static void Loadhandler(JFileChooser select) {
		System.out.println("loadhandler calling loadfile");
		model.loadFile(select);
		
	}



	
}
