package Model;

import Controller.viewUpdate;

public class newFolio {
	
	
	public static void newTab(String name){
		// need to do something with the name in the model
		
		viewUpdate.createNewFolio(name);
		System.out.println(name);
		
	}

}
