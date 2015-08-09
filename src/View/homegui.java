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
		
		String[] col_name = {"Ticker", "Quantity", "£/Share","Value"};
		Object[][] data = {
				{"", "", "",""}
		};		
		
	
		
		
		JTextField tickerString = new JTextField(5);
		JTextField amount = new JTextField(2);
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
		folioPanel.setLayout(new BorderLayout());
		folioPanel.add(table.getTableHeader(), BorderLayout.PAGE_START);
		folioPanel.add(table, BorderLayout.CENTER);
		
		
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
		
		
		
		JFrame newFolioFrame = new JFrame();
		newFolioFrame.setSize(300, 200);
		newFolioFrame.setTitle("New Folio");
		newFolioFrame.setLocationRelativeTo(null);
		newFolioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFolioFrame.setResizable(false);
		newFolioFrame.setLayout(null);
		
		JPanel newFolio = new JPanel();
		newFolio.setBounds(0, 0, 300, 200);
		JTextField tickStr = new JTextField(5);
		JLabel ticker = new JLabel("Ticker String");
		JTextField amntStr = new JTextField(5);
		JLabel amount = new JLabel("quantity");
		JButton newFolioOk = new JButton("ok");
		JButton newFolioCancel = new JButton("cancel");
		
		
		
		
		switch (type){
		case "quote":
		newFolioFrame.add(newFolio);
		newFolio.add(ticker);
		newFolio.add(tickStr);
		newFolio.add(amount);
		newFolio.add(amntStr);
		newFolio.add(newFolioOk);
		newFolio.add(newFolioCancel);
		newFolioFrame.setVisible(true);
		break;
		case "newfolio":
			break;
			
		
		}
	}
	
	
}