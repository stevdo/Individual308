package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

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
		topPanel.setVisible(true);
		inputPanel.setVisible(true);
		quantity.setVisible(true);
		sellBtn.setVisible(true);
		buyBtn.setVisible(true);
		amount.setVisible(true);
		tickerString.setVisible(true);
		newFolio.setVisible(true);
		delFolio.setVisible(true);
		quote.setVisible(true);
		save.setVisible(true);
		open.setVisible(true);
		refresh.setVisible(true);
		
		
		
		
		scrollPane.setVisible(true);
		table.setVisible(true);
		

	}	
	
	
}