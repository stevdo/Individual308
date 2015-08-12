package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.btnListeners;
import Controller.viewUpdate;

public class model {
	
	static JTable table = new JTable(new DefaultTableModel(data, col_name));
	static JTable table1 = new JTable(new DefaultTableModel(data, col_name));
	static JTable table2 = new JTable(new DefaultTableModel(data, col_name));
	static JTable table3 = new JTable(new DefaultTableModel(data, col_name));
	static JTable table4 = new JTable(new DefaultTableModel(data, col_name));
	private static ArrayList<JTable> table_array = new ArrayList<JTable>();
	
	static DefaultTableModel DTM = (DefaultTableModel)table.getModel();
	static DefaultTableModel DTM1 = (DefaultTableModel)table1.getModel();
	static DefaultTableModel DTM2 = (DefaultTableModel)table2.getModel();
	static DefaultTableModel DTM3 = (DefaultTableModel)table3.getModel();
	static DefaultTableModel DTM4 = (DefaultTableModel)table4.getModel();
	
	
	static String[] col_name = {"Ticker", "Quantity", "$/Share","Value"};
	public static Object[][] data; 
	
	public static void Initialize(){
		table_array.add(table);
		table_array.add(model.table);
	}
	
	public static void addFolio(String name){
		int numberOfTabs = tabs.getTabCount();
		int errorFlag = 0;
		for (int i = 0; i< numberOfTabs; i++) {
			System.out.println("looping");
			String currentName = tabs.getTitleAt(i);
			if (currentName == name) {
				errorFlag = 1;
				viewUpdate.error("Duplicate Folio Name");
			}
		}
		if (!(errorFlag==1))
		{
		JTable newFolioTable = new JTable(DTM);
		
		newFolioTable.setFillsViewportHeight(true);
		viewUpdate.addFolio(name, new JScrollPane(newFolioTable));
		table_array.add(newFolioTable);
		}
	}
	
	public static void addFolio1(String name){
		JTable newFolioTable1 = new JTable(DTM1);
		//DefaultTableModel D = (DefaultTableModel)table.getModel();
		
		/*table.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(table) );*/
		
		newFolioTable1.setFillsViewportHeight(true);
		viewUpdate.addFolio(name,new JScrollPane(newFolioTable1));
		
		table_array.add(newFolioTable1);
		System.out.println("im different!!!");
	}
	
	public static void addFolio2(String name){
		JTable newFolioTable2 = new JTable(DTM2);
		//DefaultTableModel D = (DefaultTableModel)table.getModel();
		
		/*table.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(table) );*/
		
		newFolioTable2.setFillsViewportHeight(true);
		viewUpdate.addFolio(name,new JScrollPane(newFolioTable2));
		
		table_array.add(newFolioTable2);
		System.out.println("im differentish!!!");
	}
	
	public static void addFolio3(String name){
		JTable newFolioTable3 = new JTable(DTM3);
		//DefaultTableModel D = (DefaultTableModel)table.getModel();
		
		/*table.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(table) );*/
		
		newFolioTable3.setFillsViewportHeight(true);
		viewUpdate.addFolio(name,new JScrollPane(newFolioTable3));
		
		table_array.add(newFolioTable3);
		System.out.println("im differentish!!!");
	}
	
	public static void addFolio4(String name){
		JTable newFolioTable4 = new JTable(DTM4);
		//DefaultTableModel D = (DefaultTableModel)table.getModel();
		
		/*table.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(table) );*/
		
		newFolioTable4.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(newFolioTable4) );
		
		table_array.add(newFolioTable4);
		System.out.println("im differentish!!!");
	}
	
public static void buyShare(String ticker, int quantity, int flag) {
	float value = 321;
	if (flag == 0){
	viewUpdate.tableFill(ticker,"115.50",quantity,value);
	} 
	if (flag == 1){
		sellShare.determine(ticker, quantity, "115.50", value);
	}
}
	
	public String quote(String ticker){
		
		String quoteVal = null;
		try {
			quoteVal = StrathQuoteServer.getLastValue(ticker);
		} catch (WebsiteDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchTickerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quoteVal;
		
	}
	
	public static String[][] getData(int selectedIndex, String title, String path){
		TableModel table= viewUpdate.returnDTM(selectedIndex);
		if (!(table.getRowCount()==0)){System.out.println("not a filled table");
		
		
		int r = table.getRowCount();
		
		String[][] data_array = new String[r][4];
		//(String name, int quantity, String price, Float value)
		for(int i = 0; i < r; i++){
			data_array[i][0] = table.getValueAt(i, 0).toString();
			data_array[i][1] = table.getValueAt(i, 1).toString();
			data_array[i][2] = table.getValueAt(i, 2).toString();
			data_array[i][3] = table.getValueAt(i, 3).toString();
		}
		
		
		File file = new File(path);
		try {
			PrintWriter print = new PrintWriter(file);
			
			for(int i = 0; i < data_array.length; i++){
				for(int j = 0; j < 4; j++){
					print.print(data_array[i][j] + " ");
				}
				print.println("");
			}
			print.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data_array;
		}
		return null;
	}
	
	public static void loadFile(JFileChooser select){
		System.out.println("1");
		int rowRep = 0;
		if (select.getSelectedFile() != null){
		try{
			System.out.println("2");
			Scanner scan = new Scanner(select.getSelectedFile());
			
			while(scan.hasNextLine()){
				System.out.println("23");
				String line = scan.nextLine();
				String[] split_line = line.split("\\s+");
				for (int i =0; i< split_line.length/4; i++){
					System.out.println("forring");
					for(int j = 0;j<4;j++){
						System.out.println("viewupdate calling loadtotable");
						
						viewUpdate.LoadToTable(rowRep,j,split_line[j]);
						if (j==3){rowRep++;}
						System.out.println(i);
						
					}
				}
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
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
