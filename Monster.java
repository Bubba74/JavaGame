package GamePackage;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Monster {
	
	public static String getOpp;
	public static int getOppHp;
	public static int getOppAttack;
	public static int getOppSpeed;
	public static int getOppReward;
	
	
	public static void init(){
		GameMain.print("Checking for monster updates...");
		
		loadMob("mob1");
		loadMob("mob2");
		loadMob("mob3");
		loadMob("mob4");
		
		GameMain.print("Update done!");
		GameMain.space(1);
	}
	
	public static void setOpponent (int ranOpp){
		
		switch (ranOpp){
		
		case 1:
			Monster.getOpp = MonsterConfig.mob1;
			Monster.getOppHp = MonsterConfig.mob1Health;
			Monster.getOppAttack = MonsterConfig.mob1Attack;
			Monster.getOppSpeed = MonsterConfig.mob1Speed;
			Monster.getOppReward = MonsterConfig.mob1Reward;
			break;
		
		case 2:
			Monster.getOpp = MonsterConfig.mob2;
			Monster.getOppHp = MonsterConfig.mob2Health;
			Monster.getOppAttack = MonsterConfig.mob2Attack;
			Monster.getOppSpeed = MonsterConfig.mob2Speed;
			Monster.getOppReward = MonsterConfig.mob2Reward;
			break;
		
		case 3:
			Monster.getOpp = MonsterConfig.mob3;
			Monster.getOppHp = MonsterConfig.mob3Health;
			Monster.getOppAttack = MonsterConfig.mob3Attack;
			Monster.getOppSpeed = MonsterConfig.mob3Speed;
			Monster.getOppReward = MonsterConfig.mob3Reward;
			break;
			
		case 4:
			Monster.getOpp = MonsterConfig.mob4;
			Monster.getOppHp = MonsterConfig.mob4Health;
			Monster.getOppAttack = MonsterConfig.mob4Attack;
			Monster.getOppSpeed = MonsterConfig.mob4Speed;
			Monster.getOppReward = MonsterConfig.mob4Reward;
			break;
			
		}//switch statement
		
	}//setOpponent method
	
	public static void getStats (){
		GameMain.print(Monster.getOpp + ": ");
		GameMain.space(1);
		GameMain.print("Hp = " + Monster.getOppHp);
		GameMain.print("Attack = " + Monster.getOppAttack);
		GameMain.print("Speed = " + Monster.getOppSpeed);
	}
	
	public static void loadMob (String mob){
		Properties monsterSave = new Properties();
		InputStream file = null;
		try{
			File monsters = new File("monsterConfig.properties");
			file = new FileInputStream( monsters );
			monsterSave.load(file);
		} catch (Exception e) { file = null;}
		if (file == null){
			try {
				
				monsterSave.setProperty("mob1Name",      MonsterConfig.mob1);
				monsterSave.setProperty("mob1Health", ""+MonsterConfig.mob1Health);
				monsterSave.setProperty("mob1Attack", ""+MonsterConfig.mob1Attack);
				monsterSave.setProperty("mob1Speed",  ""+MonsterConfig.mob1Speed);
				monsterSave.setProperty("mob1Reward", ""+MonsterConfig.mob1Reward);
				
				monsterSave.setProperty("mob2Name",      MonsterConfig.mob2);
				monsterSave.setProperty("mob2Health", ""+MonsterConfig.mob2Health);
				monsterSave.setProperty("mob2Attack", ""+MonsterConfig.mob2Attack);
				monsterSave.setProperty("mob2Speed",  ""+MonsterConfig.mob2Speed);
				monsterSave.setProperty("mob2Reward", ""+MonsterConfig.mob2Reward);
				
				monsterSave.setProperty("mob3Name",      MonsterConfig.mob3);
				monsterSave.setProperty("mob3Health", ""+MonsterConfig.mob3Health);
				monsterSave.setProperty("mob3Attack", ""+MonsterConfig.mob3Attack);
				monsterSave.setProperty("mob3Speed",  ""+MonsterConfig.mob3Speed);
				monsterSave.setProperty("mob3Reward", ""+MonsterConfig.mob3Reward);
				
				monsterSave.setProperty("mob4Name",      MonsterConfig.mob4);
				monsterSave.setProperty("mob4Health", ""+MonsterConfig.mob4Health);
				monsterSave.setProperty("mob4Attack", ""+MonsterConfig.mob4Attack);
				monsterSave.setProperty("mob4Speed",  ""+MonsterConfig.mob4Speed);
				monsterSave.setProperty("mob4Reward", ""+MonsterConfig.mob4Reward);
				
				File monsters = new File("monsterConfig.properties");
				OutputStream out = new FileOutputStream( monsters );
				monsterSave.store(out, "~~~~~~MonsterStats~~~~~~");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			//save current configs.
		} else {
				if (mob.equals("mob1")){
					MonsterConfig.mob1 = monsterSave.getProperty("mob1Name");		
					MonsterConfig.mob1Health = new Integer(monsterSave.getProperty("mob1Health"));
					MonsterConfig.mob1Attack = new Integer(monsterSave.getProperty("mob1Attack"));
					MonsterConfig.mob1Speed = new Integer(monsterSave.getProperty("mob1Speed"));
					MonsterConfig.mob1Reward = new Integer(monsterSave.getProperty("mob1Reward"));
				}
				if (mob.equals("mob2")){
					MonsterConfig.mob2 = monsterSave.getProperty("mob2Name");		
					MonsterConfig.mob2Health = new Integer(monsterSave.getProperty("mob2Health"));
					MonsterConfig.mob2Attack = new Integer(monsterSave.getProperty("mob2Attack"));
					MonsterConfig.mob2Speed = new Integer(monsterSave.getProperty("mob2Speed"));
					MonsterConfig.mob2Reward = new Integer(monsterSave.getProperty("mob2Reward"));
				}
				if (mob.equals("mob3")){
					MonsterConfig.mob3 = monsterSave.getProperty("mob3Name");		
					MonsterConfig.mob3Health = new Integer(monsterSave.getProperty("mob3Health"));
					MonsterConfig.mob3Attack = new Integer(monsterSave.getProperty("mob3Attack"));
					MonsterConfig.mob3Speed = new Integer(monsterSave.getProperty("mob3Speed"));
					MonsterConfig.mob3Reward = new Integer(monsterSave.getProperty("mob3Reward"));
					}
				if (mob.equals("mob4")){
					MonsterConfig.mob4 = monsterSave.getProperty("mob4Name");		
					MonsterConfig.mob4Health = new Integer(monsterSave.getProperty("mob4Health"));
					MonsterConfig.mob4Attack = new Integer(monsterSave.getProperty("mob4Attack"));
					MonsterConfig.mob4Speed = new Integer(monsterSave.getProperty("mob4Speed"));
					MonsterConfig.mob4Reward = new Integer(monsterSave.getProperty("mob4Reward"));
					}
		}//else statement
	}//loadMob method

}//Monster class