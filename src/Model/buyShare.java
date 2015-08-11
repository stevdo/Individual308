package Model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.viewUpdate;
import View.homegui;

public class buyShare {
public static void determine(String name, int quantity, String price, Float value){
	
	boolean exists = false;
	int selectedIndex = homegui.tabs.getSelectedIndex();
	Vector row = new Vector();
	row.add(name);
	row.add(quantity);
	row.add(price);
	row.add(value);
		 TableModel DTM= viewUpdate.returnDTM(selectedIndex);
		 int shareLoc = 0;
		 int rows = DTM.getRowCount();
		 for(int i = 0; i < rows; i++){
			 System.out.println("Comparing: " + name + " to: " + DTM.getValueAt(i, 0));
			 if(DTM.getValueAt(i, 0).equals(name)){	
				 shareLoc=i;
				 exists = true;
				 break;
			 }				 
		 }
		 if(exists){
			 System.out.println("All ready in table");
			 int qt = (int) DTM.getValueAt(shareLoc, 1);
			 float pr = Float.parseFloat(price);
			 quantity += qt;
			 float newValue = quantity*pr;
			viewUpdate.addMoreShares(quantity,pr, newValue,shareLoc, selectedIndex);
			 System.out.println(qt+ " "+pr+" " + " "+newValue);
			 
		 }
		 if(!exists){
			 System.out.println("Not in table");
			 viewUpdate.addNewRow(row,selectedIndex);
		 }}


	
}

