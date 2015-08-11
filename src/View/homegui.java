package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.btnListeners;

public class homegui {
	
	private static ArrayList<JTable> table_array = new ArrayList<JTable>();
	
	 static JTextField tickerString = new JTextField(5);
	 static JTextField amount = new JTextField(2);
	public static JTabbedPane tabs = new JTabbedPane();
	public static JTextField newFolio = new JTextField(20);
	static String[] col_name = {"Ticker", "Quantity", "$/Share","Value"};
	static Object[][] data = {
			{"", "", "",""}
	};		
	static JTable table = new JTable(new DefaultTableModel(data, col_name));
	static JTable table1 = new JTable(new DefaultTableModel(data, col_name));
	static JTable table2 = new JTable(new DefaultTableModel(data, col_name));
	static JTable table3 = new JTable(new DefaultTableModel(data, col_name));
	static DefaultTableModel DTM = (DefaultTableModel)table.getModel();
	static DefaultTableModel DTM1 = (DefaultTableModel)table1.getModel();
	static DefaultTableModel DTM2 = (DefaultTableModel)table2.getModel();
	static DefaultTableModel DTM3 = (DefaultTableModel)table3.getModel();
	public static JFrame newFolioFrame = new JFrame();

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
		JButton newFolio = new JButton("New Portfolio");
		JButton delFolio = new JButton("Delete Portfolio");
		JButton quote 	= new JButton("Quote");
		JButton save	= new JButton("Save");
		JButton open	= new JButton("Open Portfolio");
		JButton refresh = new JButton("Refresh");
		
		newFolio.addActionListener(listen);
		delFolio.addActionListener(listen);
		quote.addActionListener(listen);
		save.addActionListener(listen);
		open.addActionListener(listen);
		refresh.addActionListener(listen);
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
		topPanel.add(refresh);
		newFolio.setPreferredSize(new Dimension (121,35));
		delFolio.setPreferredSize(new Dimension (121,35));
		quote.setPreferredSize(new Dimension (121,35));
		save.setPreferredSize(new Dimension (121,35));
		open.setPreferredSize(new Dimension (121,35));
		refresh.setPreferredSize(new Dimension (121,35));
		
		
		
		
		inputPanel.setBounds(0,50,100,650);
		inputPanel.setBackground(Color.white);
		inputPanel.add(buyBtn);
		inputPanel.add(sellBtn);
		inputPanel.add(quantity);
		inputPanel.add(amount);
		inputPanel.add(Ticker);
		inputPanel.add(tickerString);
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.magenta));
		quantity.setForeground(Color.black);
		

		
		foliosFrame.add(topPanel);
		foliosFrame.add(inputPanel);
		foliosFrame.add(folioPanel);	
		foliosFrame.setVisible(true); 
		folioPanel.setVisible(true);
		table.setVisible(true);
		

	}	
	
	
	//needs to be called from the method which will parse the file if 
	//i have time to create it but looks nice for now
	public static File openFolio() {
		JFileChooser select = new JFileChooser();
		JPanel load = new JPanel();
		if (select.showOpenDialog(load) == JFileChooser.APPROVE_OPTION) {
			return select.getSelectedFile();
		}
		return null;}
	
	
	public static void popupwindow(String type) {
		
		ActionListener listen = new btnListeners();
		
		JPanel panel = new JPanel();
		
		//newfolio components
		JButton newFolioOk = new JButton("ok");
		JLabel enterName = new JLabel();
		newFolioOk.addActionListener(listen);
		//delete components
		JLabel positive = new JLabel("Are you sure you want to delete the current portfolio?");
		JButton yes =	new JButton("yes");
		yes.addActionListener(listen);
		
		//quote components
		JTextField tickStr = new JTextField(5);
		JLabel ticker = new JLabel("Ticker String");
		JTextField valStr = new JTextField(5);
		JLabel value = new JLabel("value");
		JButton quoteOk = new JButton("ok");
		JButton Cancel = new JButton("cancel");
		quoteOk.addActionListener(listen);
		//
		
		
		
		switch (type){
		case "Not Enough Shares":
			newFolioFrame.setTitle("Error");
			newFolioFrame.setSize(300, 200);
			newFolioFrame.add(panel);
			newFolioFrame.setLocationRelativeTo(null);
			newFolioFrame.setResizable(false);
			newFolioFrame.setLayout(null);
			panel.setBounds(0, 0, 300, 200);
			JLabel error = new JLabel("Not Enough Shares to do that");
			
		case "newfolio":
			newFolioFrame.setTitle("New Folio");
			newFolioFrame.setSize(300, 200);
			newFolioFrame.setLocationRelativeTo(null);
			newFolioFrame.setResizable(false);
			newFolioFrame.setLayout(null);
			panel.setBounds(0, 0, 300, 200);
			newFolioFrame.add(panel);
			panel.add(enterName);
			panel.add(newFolio);
			panel.add(newFolioOk);
			panel.add(Cancel);
			break;
		case "delete":
			newFolioFrame.setTitle("Delete Folio");
			newFolioFrame.setLocationRelativeTo(null);
			newFolioFrame.setResizable(false);
			newFolioFrame.setLayout(null);
			newFolioFrame.setSize(300, 200);
			newFolioFrame.add(panel);
			panel.setBounds(0, 0, 300, 200);
			panel.add(positive);
			panel.add(yes);
			panel.add(Cancel);
			break;
		case "save":
			break;
		case "quote":
			newFolioFrame.setTitle("Quote");
			newFolioFrame.setLocationRelativeTo(null);
			newFolioFrame.setResizable(false);
			newFolioFrame.setLayout(null);
			newFolioFrame.setSize(300, 100);
			panel.setBounds(0, 0, 300, 100);
			newFolioFrame.add(panel);
			panel.add(ticker);
			panel.add(tickStr);
			panel.add(value);
			panel.add(valStr);
			panel.add(quoteOk);
			panel.add(Cancel);
			valStr.setEditable(false);
		break;
		}
			newFolioFrame.setVisible(true);
		}

	public static void addFolio(String name){
		JTable newFolioTable = new JTable(DTM);
		//DefaultTableModel D = (DefaultTableModel)table.getModel();
		
		/*table.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(table) );*/
		
		newFolioTable.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(newFolioTable) );
		
		table_array.add(newFolioTable);
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
	
	public static void addFolio1(String name){
		JTable newFolioTable1 = new JTable(DTM1);
		//DefaultTableModel D = (DefaultTableModel)table.getModel();
		
		/*table.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(table) );*/
		
		newFolioTable1.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(newFolioTable1) );
		
		table_array.add(newFolioTable1);
		System.out.println("im different!!!");
	}
	
	public static void addFolio2(String name){
		JTable newFolioTable2 = new JTable(DTM2);
		//DefaultTableModel D = (DefaultTableModel)table.getModel();
		
		/*table.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(table) );*/
		
		newFolioTable2.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(newFolioTable2) );
		
		table_array.add(newFolioTable2);
		System.out.println("im differentish!!!");
	}
	
	

	public static void addRow(Vector row, int selectedIndex) {
		if (selectedIndex==0){
			DTM.addRow(row);
		}
		if (selectedIndex==1){
			DTM1.addRow(row);
		}
		if (selectedIndex==2){
			DTM2.addRow(row);
		}
		if (selectedIndex==3){DTM3.addRow(row);}
	//	if (selectedIndex==4){DTM4.addRow(row);}
		
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
	//	if (selectedIndex==4){
	//		DTM4.setValueAt(quantity, shareLoc, 1);
	//		DTM4.setValueAt(pr, shareLoc, 2);
	//		DTM4.setValueAt(newValue, shareLoc, 3);
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
	}


	public static void errorMessage(String error) {
		// TODO Auto-generated method stub
		
	}
	
	public static void destroyNewFolio(int panelNo){
		newFolioFrame.setVisible(false);

		}
	}

	
