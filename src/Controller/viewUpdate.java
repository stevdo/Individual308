package Controller;

import java.util.Vector;

import javax.swing.table.TableModel;

import Model.buyShare;
import Model.model;
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
	
	public void returnQuote(String value){
		homegui.popQuoteField(value);
	}

	public static void addMoreShares(int quantity, float pr, float newValue,
			int shareLoc, int selectedIndex) {
		homegui.addshares(quantity, pr, newValue, shareLoc,selectedIndex);
		
		
	}


	public static void removeRow(int selectedIndex, int shareLoc) {
		homegui.deleteShare(selectedIndex,shareLoc);
		
	}

	public static void saveHandler(int selectedIndex, String path, String title){
		model.getData(selectedIndex, title, path);
		System.out.println("selected nigger");
	}
	
	public static void invalidInput(String error) {
		homegui.error(error);
		
	}
	
	public static void LoadToTable(int row, int col, String data) {
		System.out.println("calling laodeddatatotable"+ ' '+row+' '+col+' '+data);
		homegui.loadedDataToTable(row,col,data);
		
	}
}
