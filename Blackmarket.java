package GamePackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Blackmarket {
	
	public static JFrame frame;
	
	public static void blackMarket(){
		init();
	}
	public static void init(){
		
		int x = 500;
		int y = 328;
		int y2 = 328 / 16;
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		Blackmarket.frame = new JFrame ("Welcome to the underground. Lets keep this off book...");
		Blackmarket.frame.getContentPane().setBackground(Color.lightGray);
		Blackmarket.frame.setSize(x, y);
		Blackmarket.frame.setLocation(6, 400);
		Blackmarket.frame.setVisible(true);
		Blackmarket.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Blackmarket.frame.setResizable(false);
		Blackmarket.frame.getContentPane().setLayout(null);
		Blackmarket.frame.setAlwaysOnTop(true);
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		JButton backButton = new JButton("Back");
		backButton.setToolTipText("Click me!");
		backButton.setEnabled(true);
		backButton.setBounds( (x/7)*4, y2 , (x/7)*2, x/2);
		backButton.setBackground(Color.orange);
		backButton.setVisible(true);
		Blackmarket.frame.add(backButton);
		backButton.addActionListener(new actionExit());
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		JButton button2 = new JButton("Buy");
		button2.setToolTipText("Click me!");
		button2.setEnabled(true);
		button2.setBounds( x/7 , y2 , (x/7)*2 , x/2 );
		button2.setBackground(Color.green);
		button2.setVisible(true);
		Blackmarket.frame.add(button2);
		button2.addActionListener(new actionBuy());
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	}//init method
}//Blackmarket class

class actionExit implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Blackmarket.frame.setEnabled(false);
		Blackmarket.frame.setVisible(false);
		GameMain.nextAction();
	}//actionPerformed by button1 method
}//class actionExit
class actionBuy implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		GameMain.nextAction();
		
	}//actionPerformed by button1 method
}//class actionOne