package GamePackage;

import javax.swing.*;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Properties;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class GameMain {
	
	public static String props;
	public static Properties saveFile = new Properties();
	public static InputStream file = null;
	public static Random rn = new Random();
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String Args[]){
		Monster.init();
		print("Enter save file name: ");
		String save = input.nextLine().toString();
		GameMain.props = save;
		reload();
	}//main method
	
	public static void reload(){
		try{
			File properties = new File(GameMain.props + "SAVE.properties");
			file = new FileInputStream( properties );
			saveFile.load(file);
		} catch (Exception e) { file = null;}
		if (file == null){
			firstTime();
		} else {
				Character.getName = saveFile.getProperty("Name");		
				Character.getFighter = saveFile.getProperty("Fighter");
				Character.getHp = new Integer(saveFile.getProperty("Hp"));
				Character.getAttack = new Integer(saveFile.getProperty("Attack"));
				Character.getSpeed = new Integer(saveFile.getProperty("Speed"));
				Character.getMoney = new Integer(saveFile.getProperty("Money"));
				System.out.println("Welcome back, " + Character.getName);
				
				nextAction();
		}
	}//reload method
	
	public static void firstTime(){
		
		int type;

		/////////////////Typical Greeting////////////////////
		print("What is your name?");
		Character.getName = GameMain.input.nextLine().toString();
		print("Why hello there " + Character.getName + ".");
		////////////////////////////////////////////////////
		
		print("Would you like to be a");
		print("[1] Archer");
		print("[2] Warrior");
		print("[3] Mage");
		
		type = GameMain.input.nextInt();
		Character.setType(type);

		print("Here are your stats, " + Character.getName + "...");
		print("Hp = " + Character.getHp);
		print("Attack = " + Character.getAttack);
		print("Speed = " + Character.getSpeed);
		
		space(3);
		nextAction();
	}//main method	
	
	public static void nextAction (){
		print("What do you want to do now?");
		print("[1] Fight - [2] Shop - [3] Check Stats - [4] Exit");
		int action = GameMain.input.nextInt();
		
		if (action == 1){
			space(3);
			fight();
		}if (action == 2){
			space(3);
			shop();
		}if (action == 3){
			space(2);
			Character.getStats();
			space(2);
			nextAction();
		}if (action == 4){
			exit();
		}if (action == 17){
			space(2);
			Blackmarket.blackMarket();
		}
		
	}//nextAction method
	
	public static void fight(){
		int delay = GameMain.rn.nextInt(7) + 3;
		
		print("Welcome to the fighting arena " + Character.getName + "!");
		print("Please wait while we search for a prepared opponent for you.");
		
		for (int i=0 ; i<(delay - 1) ; i++ ) {
			System.out.print(".");
			try{
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e){
			}
		}
		
		System.out.println(".");
		print("Lucky you!!! We found the PERFECT opponent");
		space(2);
		battle();
		
	}//fight method
	
	public static void battle(){
		Boolean win;
		//win = true when player wins, win = false when player loses.
		int rm; //The random int that will determine the random mob.
		rm = GameMain.rn.nextInt(4) + 1;
		Monster.setOpponent(rm); //Calls the setOpp. method to set the mob.
		
		Monster.getStats(); //Prints the mob's stats to the console.
		space(2);
		Character.getStats(); //Prints the user's stats to the console.
		
		win = true; // Until an actual fight is possible.
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch(InterruptedException e){}
		
		if (win){
			space(3);
			print("Congratulations!!!");
			print("YOU WON!!!");
			space(1);
			print("You get " + Monster.getOppReward + " money!");
			Character.getMoney += Monster.getOppReward;
			print("Money: " + Character.getMoney);
		}
		else{
			space(3);
			print("YOU LOSE!!!");
			space(1);
			print("You lose " + Monster.getOppReward + " money!");
			Character.getMoney -= Monster.getOppReward;
			print("Money: " + Character.getMoney);
		}
		nextAction();
	}//battle method
	
	public static void shop(){
		int delay = GameMain.rn.nextInt(2) + 2;
		print("Welcome to the shop, " + Character.getName);
		print("Balance: " + Character.getMoney);
		
		space(1);
		
		print("Thank you for coming! Take 3 dollars for free!");
		print("\" Money UP 3 \"");
		Character.getMoney += 3;
		print("Balance: " + Character.getMoney);
		
		space(2);
		
		print("Shop currently under maintenance, redirecting ");
		for (int i=0 ; i<(delay - 1) ; i++ ) {
			System.out.print(".");
			try{
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e){
			}
		}
		System.out.println(".");
		nextAction();
		
	}//shop method
	
	public static void space(int numOfLines){
		//prints # of empty lines equal to numOfLines
		int x = 0;
		String space = "";
		while (x < numOfLines - 1){
			space = space + "\n";
			x++;
		}
		print(space);
	}//space method
	
	public static void exit(){
		print("Saving progress...");
		try {
			saveFile.setProperty("Name", Character.getName);
			saveFile.setProperty("Fighter", Character.getFighter);
			saveFile.setProperty("Hp", ""+Character.getHp);
			saveFile.setProperty("Attack", ""+Character.getAttack);
			saveFile.setProperty("Speed", ""+Character.getSpeed);
			saveFile.setProperty("Money", ""+Character.getMoney);
			File properties = new File(GameMain.props + "SAVE.properties");
			OutputStream save = new FileOutputStream( properties );
			saveFile.store(save, "Optional String");
		} catch (Exception e) {
			e.printStackTrace();
		}
		print("PROGRAM TERMINATED");
		System.exit(0);
	}//exit method
	
	public static void print(String print){
		System.out.println(print);
	}//print method
}//GameMain class