package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.btnListeners;
import Controller.viewUpdate;

public class homegui {
	
	private static ArrayList<JTable> table_array = new ArrayList<JTable>();
	
	static JTextField tickerString = new JTextField(5);
	static JTextField amount = new JTextField(2);
	public static JTabbedPane tabs = new JTabbedPane();
	static String[] col_name = {"Ticker", "Quantity", "$/Share","Value"};
	public static Object[][] data; 
	
	
	static JTable table = new JTable(new DefaultTableModel(data, col_name));
	static JTable table1 = new JTable(new DefaultTableModel(data, col_name));
	static JTable table2 = new JTable(new DefaultTableModel(data, col_name));
	static JTable table3 = new JTable(new DefaultTableModel(data, col_name));
	static JTable table4 = new JTable(new DefaultTableModel(data, col_name));
	static JTable table5 = new JTable(new DefaultTableModel(data, col_name));
	
	static DefaultTableModel DTM = (DefaultTableModel)table.getModel();
	static DefaultTableModel DTM1 = (DefaultTableModel)table1.getModel();
	static DefaultTableModel DTM2 = (DefaultTableModel)table2.getModel();
	static DefaultTableModel DTM3 = (DefaultTableModel)table3.getModel();
	static DefaultTableModel DTM4 = (DefaultTableModel)table4.getModel();
	static DefaultTableModel DTM5 = (DefaultTableModel)table5.getModel();
	
	public static JFrame newFolioFrame = new JFrame();
	public static JFrame errorFrame = new JFrame();
	public static JFrame deleteFrame = new JFrame();
	public static JFrame quoteFrame = new JFrame();

	public static JTextField newFolio = new JTextField(20);
	public static JTextField valStr = new JTextField(5);
	public static JTextField Value = new JTextField(5);
	public static JTextField quoteValue = new JTextField(6);
	public static JTextField quoteTicker = new JTextField(5);
	public void test() {
		System.out.println("shapnin");
		
	}
	
	
	public void initialize() {
		//Initialises the home page which contains the 
		
		table_array.add(table);
		
		JFrame foliosFrame;
		
		foliosFrame = new JFrame();
		foliosFrame.setSize(800, 600);
		foliosFrame.setTitle("Folios");
		foliosFrame.setLocationRelativeTo(null);
		foliosFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		foliosFrame.setResizable(false);
		foliosFrame.setLayout(null);
		
		ActionListener listen = new btnListeners();
		
		JPanel folioPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel topPanel   = new JPanel();
		
		
	
		
		
		JLabel quantity = new JLabel("Quantity       ");
		JLabel Ticker	= new JLabel("Ticker Symbol");
		JButton	sellBtn	= new JButton("Sell");
		JButton buyBtn  = new JButton("Buy");
		JButton newFolio = new JButton("New Portfolios");
		JButton delFolio = new JButton("Delete Portfolio");
		JButton quote 	= new JButton("Quote");
		JButton save	= new JButton("Save");
		JButton open	= new JButton("Open Portfolio");

		JLabel thisFolio = new JLabel("This folio value");
		
		newFolio.addActionListener(listen);
		delFolio.addActionListener(listen);
		quote.addActionListener(listen);
		save.addActionListener(listen);
		open.addActionListener(listen);

		buyBtn.addActionListener(listen);
		sellBtn.addActionListener(listen);
		
		folioPanel.setBounds(100, 50, 700, 650);
		folioPanel.setBackground(Color.white);
		folioPanel.setBorder(BorderFactory.createLineBorder(Color.green));

		table.setFillsViewportHeight(true);
		folioPanel.add(tabs);
		tabs.setBounds(0, 0, 700, 600);
		folioPanel.setLayout(new BorderLayout());
//		scrollPane.add(table.getTableHeader(), BorderLayout.PAGE_START);
//		scrollPane.add(table, BorderLayout.CENTER);
		
		
		topPanel.setBounds(0, 0, 800, 50);
		topPanel.setBackground(Color.white);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.add(newFolio);
		topPanel.add(delFolio);
		topPanel.add(quote);
		topPanel.add(save);
		topPanel.add(open);
		newFolio.setPreferredSize(new Dimension (121,35));
		delFolio.setPreferredSize(new Dimension (121,35));
		quote.setPreferredSize(new Dimension (121,35));
		save.setPreferredSize(new Dimension (121,35));
		open.setPreferredSize(new Dimension (121,35));
		
		
		
		
		inputPanel.setBounds(0,50,100,650);
		inputPanel.setBackground(Color.white);
		inputPanel.add(buyBtn);
		inputPanel.add(sellBtn);
		inputPanel.add(quantity);
		inputPanel.add(amount);
		inputPanel.add(Ticker);
		inputPanel.add(tickerString);
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.magenta));
		inputPanel.add(thisFolio);
		inputPanel.add(Value);
		quantity.setForeground(Color.black);
		

		
		foliosFrame.add(topPanel);
		foliosFrame.add(inputPanel);
		foliosFrame.add(folioPanel);	
		foliosFrame.setVisible(true); 
		folioPanel.setVisible(true);
		table.setVisible(true);
		tabs.addChangeListener(new ChangeListener(){
	        public void stateChanged(ChangeEvent e) {
	        	updateValue();
	        }
	    });


			

	}	
	
	
	//needs to be called from the method which will parse the file if 
	//i have time to create it but looks nice for now
	public static void openFolio() {
		JFileChooser select = new JFileChooser();
		JPanel load = new JPanel();
		if (select.showOpenDialog(load) == JFileChooser.APPROVE_OPTION) {
			if(select.getSelectedFile() !=null){
				System.out.println("openfolio submitted, calling loadhandler");
				btnListeners.Loadhandler(select);
				
			}
			
		}}

	
		
		
		
		public static void newFolioEntry(){
			ActionListener listen = new btnListeners();
			JFrame newFolioFrame = new JFrame();
			JButton newFolioOk = new JButton("ok");
			JPanel panel = new JPanel();
			JLabel enterName = new JLabel("Enter the name of your portfolio and press ok");
			JButton Cancel = new JButton("cancel");
			newFolioOk.addActionListener(listen);
			newFolioFrame.setTitle("New Folios");
			newFolioFrame.setSize(300, 80);
			newFolioFrame.setLocationRelativeTo(null);
			newFolioFrame.setResizable(false);
			newFolioFrame.setLayout(null);
			panel.setBounds(0, 0, 300, 200);
			newFolioFrame.add(panel);
			panel.add(enterName);
			panel.add(newFolio);
			newFolio.setText("");
			panel.add(newFolioOk);
			newFolioFrame.setVisible(true);
			}
		
		public static void error(String Error){
			ActionListener listen = new btnListeners();
			
			JButton newFolioOk = new JButton("ok");
			JPanel panel = new JPanel();
			errorFrame.setTitle("Error");
			errorFrame.setSize(300, 200);
			errorFrame.add(panel);
			errorFrame.setLocationRelativeTo(null);
			errorFrame.setResizable(false);
			errorFrame.setLayout(null);
			panel.setBounds(0, 0, 300, 200);
			JLabel error = new JLabel(Error);
			}
		

		public static void deleteFolio(){
			ActionListener listen = new btnListeners(); 
			deleteFrame.setTitle("Delete Folio");
			JPanel panel = new JPanel();
			JLabel youSure = new JLabel("Are you sure you wish to delete the current portfolio?");
			deleteFrame.setLocationRelativeTo(null);
			deleteFrame.setResizable(false);
			deleteFrame.setLayout(null);
			deleteFrame.setSize(300, 80);
			deleteFrame.add(panel);
			JButton positive = new JButton("yes");
			JButton negative = new JButton("no");
			panel.add(youSure);
			panel.setBounds(0, 0, 300, 80);
			panel.add(positive);
			positive.addActionListener(listen);
			negative.addActionListener(listen);
			panel.add(negative);
			deleteFrame.setVisible(true);
		}
		public static void deletion(){
			int current = tabs.getSelectedIndex();
			
			DefaultTableModel CurrDtm = sendTable(current);
			while (CurrDtm.getRowCount() > 0){
				System.out.println("deleting a row");
			CurrDtm.removeRow(CurrDtm.getRowCount()-1);
			}

			tabs.removeTabAt(current);
		}
		
		public static void quoteShare(){
			ActionListener listen = new btnListeners();
			quoteFrame.setTitle("Quote");
			quoteFrame.setLocationRelativeTo(null);
			quoteFrame.setResizable(false);
			quoteFrame.setLayout(null);
			quoteFrame.setSize(300, 100);
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 300, 100);
			JButton quoteOk = new JButton("quote");
			quoteFrame.add(panel);
			panel.add(quoteTicker);
			panel.add(quoteValue);
			panel.add(quoteOk);
			quoteOk.addActionListener(listen);
			quoteValue.setEditable(false);
			quoteFrame.setVisible(true);
		}

	public static void addFolio(String name){
		int numberOfTabs = tabs.getTabCount();
		int errorFlag = 0;
		DefaultTableModel CurrDTM = sendTable(numberOfTabs);
		for (int i = 0; i< numberOfTabs; i++) {
			System.out.println("looping");
			String currentName = tabs.getTitleAt(i);
			if (currentName == name) {
				errorFlag = 1;
				error("Duplicate Folio Name");
			}
		}
		if (!(errorFlag==1))
		{
		JTable newFolioTable = new JTable(CurrDTM);
		
		newFolioTable.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(newFolioTable) );
		
		table_array.add(newFolioTable);
		}
	}
	
	public static String getTicker(){
		String ticker= tickerString.getText();
		return ticker;
		
	}
	
	public static int getAmount(){
		String amnt = amount.getText();
		int i = Integer.valueOf(amnt);
		return i;
	}
	public static String getFolioName(){
		String name = newFolio.getText();
		System.out.println(name);
		return newFolio.getText();
	}
	
	
	

	public static void addRow(Vector row, int selectedIndex) {
		if (selectedIndex==0){	
		DTM.addRow(row);}
		if (selectedIndex==1){
			DTM1.addRow(row);
		}
		if (selectedIndex==2){
			DTM2.addRow(row);
		}
		if (selectedIndex==3){DTM3.addRow(row);}
		
		if (selectedIndex==4){DTM4.addRow(row);}
		if (selectedIndex==5){DTM5.addRow(row);}
	}


	public static void addshares(int quantity, float pr, float newValue,
			int shareLoc, int selectedIndex) {
		if (selectedIndex==0){
			DTM.setValueAt(quantity, shareLoc, 1);
			DTM.setValueAt(pr, shareLoc, 2);
			DTM.setValueAt(newValue, shareLoc, 3);
		}
		if (selectedIndex==1){
			DTM1.setValueAt(quantity, shareLoc, 1);
			DTM1.setValueAt(pr, shareLoc, 2);
			DTM1.setValueAt(newValue, shareLoc, 3);
		}
		if (selectedIndex==2){
			DTM2.setValueAt(quantity, shareLoc, 1);
			DTM2.setValueAt(pr, shareLoc, 2);
			DTM2.setValueAt(newValue, shareLoc, 3);
		if (selectedIndex==3){
			DTM3.setValueAt(quantity, shareLoc, 1);
			DTM3.setValueAt(pr, shareLoc, 2);
			DTM3.setValueAt(newValue, shareLoc, 3);
		}
		if (selectedIndex==4){
			DTM4.setValueAt(quantity, shareLoc, 1);
			DTM4.setValueAt(pr, shareLoc, 2);
			DTM4.setValueAt(newValue, shareLoc, 3);
		}
		if (selectedIndex==5){
			DTM5.setValueAt(quantity, shareLoc, 1);
			DTM5.setValueAt(pr, shareLoc, 2);
			DTM5.setValueAt(newValue, shareLoc, 3);
		}
		
			}
	}


	public static DefaultTableModel sendTable(int index) {
		if (index==0){
			return DTM;}
		if (index==1){
			return DTM1;}
		if (index==2){
			return DTM2;}
		if (index==3){
			return DTM3;}
		if (index==4){
			return DTM4;}
		if (index==5){
			return DTM5;}
		else {return null;}
		
	}


	public static void deleteShare(int index, int rowNum) {
		// TODO Auto-generated method stub
		if (index==0){
			DTM.removeRow(rowNum);}
		if (index==1){
			DTM1.removeRow(rowNum);}
		if (index==2){
			DTM2.removeRow(rowNum);}
		if (index==3){
			DTM3.removeRow(rowNum);}
		if (index==4){
			DTM4.removeRow(rowNum);}
		if (index==5){
			DTM5.removeRow(rowNum);}
	}



	
	public static void destroyFrame(int panelNo){
		if (panelNo==0){
			errorFrame.setVisible(false);
		}
		if (panelNo==1){
			deleteFrame.setVisible(false);
		}
		}
	public static void saveWindow(){
	  String sb = "TEST CONTENT";
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("/home/me/Documents"));
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	            FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
	            fw.write(sb.toString());
	            String title = "\\" + chooser.getSelectedFile().getName();
	            String path = chooser.getSelectedFile().getAbsolutePath() +".txt";
	            //System.out.println(title);
	            viewUpdate.saveHandler(tabs.getSelectedIndex(), path, title);
	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	       
	    
	}


	public static void popQuoteField(String value) {
		valStr.setText(value);
		
	}
	


	public static void loadedDataToTable(int row, int col, String data2) {
		/*(String name, int quantity, String price, Float value)*/
		int tab=  tabs.getTabCount();
		int intData = 0;
		Float floatData = 00.00f;
		DefaultTableModel CurrDTM=sendTable(tab);
		int rowCount=CurrDTM.getRowCount();
		
		if (col==0){ if (row < rowCount){
		CurrDTM.setValueAt(data2, row, col);}
		else{
			CurrDTM.setRowCount(rowCount+1);
			CurrDTM.setValueAt(data2, row, col);}
		}
		
		if (col==1){intData = Integer.valueOf(data2);CurrDTM.setValueAt(intData, row, col);}
		
		if (col==2){
			CurrDTM.setValueAt(data2, row, col);}
		
		if (col==3) {
			floatData = Float.valueOf(data2);
			CurrDTM.setValueAt(floatData, row, col);
			}

		
	}
	 	
	
	public static void updateValue() {
		int current = tabs.getSelectedIndex();
		DefaultTableModel table =sendTable(current);
		if (!(table==null)) {
		int total = table.getRowCount();
		float value = 0;
		for( int i=0; i<total; i++){
			Float currval = (Float) table.getValueAt(i, 3);
		value += currval;
		}
		String valueStr = Float.toString(value);
		Value.setText(valueStr);}}
	}


//attempt mvc
//delete folio
//kill urself

