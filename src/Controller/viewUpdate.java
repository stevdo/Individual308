package Controller;

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
		homegui.updateTable(name, quantity, price, value);
		
	}
}
