package GamePackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frames {
	
	public static JFrame frame;
	public static JButton backButton , button2;
	public static int x, y, y2;
	
	public static void shop(){
		init();
	}
	
	public static void init(){
		
		Frames.x = 500;
		Frames.y = 328;
		Frames.y2 = y / 16;
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		Frames.frame = new JFrame ("Welcome to the shop " + Character.getName + "!!!");
		Frames.frame.getContentPane().setBackground(Color.lightGray);
		Frames.frame.setSize(Frames.x, Frames.y);
		Frames.frame.setLocation(6, 400);
		Frames.frame.setVisible(true);
		Frames.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frames.frame.setResizable(false);
		Frames.frame.getContentPane().setLayout(null);
		Frames.frame.setAlwaysOnTop(true);
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		Frames.backButton = new JButton("Back");
		Frames.backButton.setToolTipText("Click me!");
		Frames.backButton.setEnabled(true);
		Frames.backButton.setBounds( (x/7)*4, Frames.y2 , (x/7)*2, x/2);
		Frames.backButton.setBackground(Color.orange);
		Frames.backButton.setVisible(true);
		Frames.frame.add(Frames.backButton);
		Frames.backButton.addActionListener(new actionExit());
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		Frames.button2 = new JButton("Buy");
		Frames.button2.setToolTipText("Click me!");
		Frames.button2.setEnabled(true);
		Frames.button2.setBounds( x/7 , Frames.y2 , (x/7)*2 , x/2 );
		Frames.button2.setBackground(Color.green);
		Frames.button2.setVisible(true);
		Frames.frame.add(Frames.button2);
		Frames.button2.addActionListener(new actionBuy());
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	}//init method
	public static void buy(){
		JButton cont = new JButton("Continue?");
		cont.setVisible(true);
		cont.setEnabled(true);
		cont.setBounds( (x/7)*2, Frames.y2 , (x/7)*3, x/2);
		
		//Frames.frame.setEnabled(false);
		Frames.frame.setVisible(false);
		
		Frames.frame.remove(Frames.backButton);
		Frames.frame.remove(Frames.button2);
		Frames.frame.add(cont);
		
		//Frames.frame.setEnabled(true);
		Frames.frame.setVisible(true);
	}
}//Blackmarket class

class actionExit implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Frames.frame.setEnabled(false);
		Frames.frame.setVisible(false);
		GameMain.nextAction();
	}//actionPerformed by button1 method
}//class actionExit
class actionBuy implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Frames.buy();
	}//actionPerformed by button1 method
}//class actionOne