package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import View.homegui;

public class btnListeners implements ActionListener {




	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
			case "Buy":
				System.out.println("FUCK");
			break;
			case "Sell":
				System.out.println("mogger");
			break;
			case "New Portfolio":
				System.out.println("THE GREEKS");
				homegui.popupwindow("newfolio");
				break;
			case "Delete Portfolio":
				System.out.println("jesus");
			break;
			case "Quote":
				System.out.println("bitchez");
				homegui.popupwindow("quote");
			break;
			case "Save":
				System.out.println("420");
			break;
			case "Open Portfolio":
				homegui.openFolio();
			break;
			case "Refresh":
				System.out.println("in church");
			break;
			case "newFolioOk":
				System.out.println("fuck");
		}
		
	}
	
}