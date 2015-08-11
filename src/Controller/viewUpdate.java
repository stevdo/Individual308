package Controller;

import java.util.Vector;

import javax.swing.table.TableModel;

import Model.buyShare;
import View.homegui;

public class viewUpdate {
	public static int tabs=0;
		
	public static void createNewFolio(String name){
		
		if( tabs==0) {
		homegui.addFolio(name);
		}
		if( tabs == 1){
		homegui.addFolio1(name);
		}
		if( tabs == 2){
			homegui.addFolio2(name);
			}
		tabs++;
	}
	
	
	public static void tableFill(String name,String price, int quantity, Float value){
		buyShare.determine(name, quantity, price, value);
	}
	
	public static TableModel returnDTM(int index){
		return homegui.sendTable(index);
		
	}


	public static void addNewRow(Vector row, int selectedIndex) {
		homegui.addRow(row,selectedIndex);
		
	}


	public static void addMoreShares(int quantity, float pr, float newValue,
			int shareLoc, int selectedIndex) {
		homegui.addshares(quantity, pr, newValue, shareLoc,selectedIndex);
		
		
	}


	public static void removeRow(int selectedIndex, int shareLoc) {
		homegui.deleteShare(selectedIndex,shareLoc);
		
	}


	public static void invalidInput(String error) {
		homegui.errorMessage(error);
		
	}
}
