package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.btnListeners;
import Controller.viewUpdate;

public class model {
	

	
	
public static void buyShare(String ticker, int quantity, int flag) {
	String quoteVal = null;
	try {
		quoteVal = StrathQuoteServer.getLastValue(ticker);
	} catch (WebsiteDataException | NoSuchTickerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if (flag == 0){
	viewUpdate.tableFill(ticker,quoteVal,quantity);
	} 
	if (flag == 1){
		sellShare.determine(ticker, quantity, quoteVal);
	}
}
	
	public static void quote(String ticker){
		System.out.println("lol i got calleed");
		String quoteVal = "0";
		try {
			System.out.println("pls w8 bruv");
			quoteVal = StrathQuoteServer.getLastValue(ticker);
		} catch (WebsiteDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchTickerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewUpdate.quotedValue(quoteVal);
		
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
		viewUpdate.addFolio(select.getSelectedFile().getName());
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
	




	
	
	
	}
}
