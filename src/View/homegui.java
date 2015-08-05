package View;

import java.awt.Color;
import javax.swing.*;

public class homegui {
	

	public void test() {
		System.out.println("shapnin");
		
	}
	public void initialize() {
		
		// ===========================
		// Initialise the
		// Folio Tracker Form
		// ===========================
		
		JFrame foliosFrame;
		
		foliosFrame = new JFrame();
		foliosFrame.setSize(800, 600);
		foliosFrame.setTitle("Folios");
		foliosFrame.setLocationRelativeTo(null);
		foliosFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		foliosFrame.setResizable(false);
		foliosFrame.setLayout(null);
		
		JPanel folioPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel topPanel   = new JPanel();
		
		JTextField tickerString = new JTextField();
		JTextField amount = new JTextField();
		JLabel quantity = new JLabel("quantity       ");
		JLabel Ticker	= new JLabel("Ticker Symbol");
		folioPanel.setBounds(100, 100, 700, 500);
		folioPanel.setBackground(Color.red);
		folioPanel.setBorder(BorderFactory.createLineBorder(Color.green));
	//	folioPanel.set
		
		topPanel.setBounds(0, 0, 800, 100);
		topPanel.setBackground(Color.yellow);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		inputPanel.setBounds(0,100,100,600);
		inputPanel.setBackground(Color.blue);
		inputPanel.add(quantity);
		inputPanel.add(amount);
		inputPanel.add(Ticker);
		inputPanel.add(tickerString);
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.magenta));
		quantity.setForeground(Color.magenta);
		
		
		amount.setText("one");
		tickerString.setText("Two");
		
		foliosFrame.setVisible(true);
		folioPanel.setVisible(true);
		topPanel.setVisible(true);
		inputPanel.setVisible(true);
		quantity.setVisible(true);
		amount.setText("one");
		tickerString.setText("Two");
	
		
		foliosFrame.add(topPanel);
		foliosFrame.add(inputPanel);
		foliosFrame.add(folioPanel);
		

		amount.setVisible(true);
		tickerString.setVisible(true);
		
	}
}