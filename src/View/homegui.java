package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import Controller.btnListeners;

public class homegui {
	
	 static JTextField tickerString = new JTextField(5);
	 static JTextField amount = new JTextField(2);
	static JTabbedPane tabs = new JTabbedPane();
	public static JTextField newFolio = new JTextField(20);
	static String[] col_name = {"Ticker", "Quantity", "£/Share","Value"};
	static Object[][] data = {
			{"", "", "",""}
	};		

	public void test() {
		System.out.println("shapnin");
		
	}
	
	
	public void initialize() {
		//initializes the home page which contains the 
		
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

		JTable table = new JTable(data, col_name);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		folioPanel.add(tabs);
		tabs.add(scrollPane);
		tabs.setBounds(0, 0, 700, 600);
		scrollPane.setBounds(0, 50, 799, 650);
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
		scrollPane.setVisible(true);
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
		return null;

	}
	
	
	public static void popupwindow(String type) {
		
		ActionListener listen = new btnListeners();
		
		JFrame newFolioFrame = new JFrame();
		newFolioFrame.setLocationRelativeTo(null);
		newFolioFrame.setResizable(false);
		newFolioFrame.setLayout(null);
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
		
		
		newFolioFrame.add(panel);
		
		switch (type){
		case "newfolio":
			newFolioFrame.setTitle("New Folio");
			newFolioFrame.setSize(300, 200);
			panel.setBounds(0, 0, 300, 200);
			panel.add(enterName);
			panel.add(newFolio);
			panel.add(newFolioOk);
			panel.add(Cancel);
			break;
		case "delete":
			newFolioFrame.setTitle("Delete Folio");
			newFolioFrame.setSize(300, 200);
			panel.setBounds(0, 0, 300, 200);
			panel.add(positive);
			panel.add(yes);
			panel.add(Cancel);
			break;
		case "save":
			break;
		case "quote":
			newFolioFrame.setTitle("Quote");
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
		JTable table = new JTable(data, col_name);
		table.setFillsViewportHeight(true);
		tabs.addTab(name, new JScrollPane(table) );

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
	}
	
	