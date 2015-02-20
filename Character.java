package GamePackage;

public class Character {

	public static String getName;
	public static String getFighter;
	public static int getHp;
	public static int getAttack;
	public static int getSpeed;
	public static int getMoney;
	
	
	public static void setType (int type){
		
		switch (type){
		//Updates public variable stats relative to getFighter.
		case 1:	
			Character.getHp = 25;
			Character.getAttack = 4;
			Character.getSpeed = 4;
			Character.getFighter = "archer";
			Character.getMoney += 5;
			
			break;
		case 2:
			Character.getHp = 30;
			Character.getAttack = 5;
			Character.getSpeed = 2;
			Character.getFighter = "warrior";
			Character.getMoney += 5;
			
			break;
		case 3:
			Character.getHp = 20;
			Character.getAttack = 6;
			Character.getSpeed = 3;
			Character.getFighter = "mage";
			Character.getMoney += 5;
			
			if (Character.getName.equals("Hunty")){
				Character.getHp += 1;
				Character.getAttack += 1;
				Character.getSpeed += 1;
				Character.getMoney += 6;
			}
			break;
		}//switch statement
	} //setType method
	
	public static void getStats(){
		GameMain.print("User: " + Character.getName);
		GameMain.print("Description: " + Character.getFighter);
		GameMain.print("Hp: " + Character.getHp);
		GameMain.print("Attack: " + Character.getAttack);
		GameMain.print("Speed: " + Character.getSpeed);
		GameMain.print("Balance: " + Character.getMoney);
	}


}     // Character class