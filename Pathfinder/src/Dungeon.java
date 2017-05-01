import java.util.*;

/*
 * Aurora Havens
 * Last Edited: 4/7/17
 * 
 * The dungeon class is the layer between the character and the enemy class. The user does not have the ability
 * to access to specific of their character except through the dungeon
 * 
 * 
 */

public class Dungeon {
	//global variable
	int x = 0;
	int y = 0;
	int dmg = 0;
	int escape = 0;
	int health = 0;
	boolean goldFound = false;
	boolean charDead = false;
	
	int[][] dungeonWalls = new int[20][13];
	//find commonalities between the ys
	
	
	//make a user character
	Character userCharacter;
	//singular enemy we can reassign as needed
	Enemy en; 
	//make a scanner
	Scanner reader = new Scanner(System.in);
	String userInput;
	
	//the dungeon has walls and enemies
	//dungeon is 20 x 20
	
	
	//two things of gold
	/*
	 * x = 18, y = 0
	 * x = 18, y = 19
	 * x = 19, y = 0
	 * x = 19, y = 19
	 */
	
	//constructor
	public Dungeon(String cName){
		//create a new character
		userCharacter = new Character(cName);
		dungeonWalls[0][0] = 6;
		dungeonWalls[0][1] = 9;
		dungeonWalls[0][2] = 13;
		dungeonWalls[0][3] = -1;
		dungeonWalls[0][4] = -1;
		dungeonWalls[0][5] = -1;
		dungeonWalls[0][6] = -1;
		dungeonWalls[0][7] = -1;
		dungeonWalls[0][8] = -1;
		dungeonWalls[0][9] = -1;
		dungeonWalls[0][10] = -1;
		dungeonWalls[0][11] = -1;
		dungeonWalls[0][12] = -1;
				
		// x = 1, y = 0,1,2,4,5,6,9,10,11,13,15,18,19 
		dungeonWalls[1][0] = 0;
		dungeonWalls[1][1] = 1;
		dungeonWalls[1][2] = 2;
		dungeonWalls[1][3] = 4;
		dungeonWalls[1][4] = 5;
		dungeonWalls[1][5] = 6;
		dungeonWalls[1][6] = 9;
		dungeonWalls[1][7] = 10;
		dungeonWalls[1][8] = 11;
		dungeonWalls[1][9] = 13;
		dungeonWalls[1][10] = 15;
		dungeonWalls[1][11] = 18;
		dungeonWalls[1][12] = 19;
				
		//x = 2, y = 2,5,11,13,15,18
		dungeonWalls[2][0] = 2;
		dungeonWalls[2][1] = 5;
		dungeonWalls[2][2] = 11;
		dungeonWalls[2][3] = 13;
		dungeonWalls[2][4] = 15;
		dungeonWalls[2][5] = 18;
		dungeonWalls[2][6] = -1;
		dungeonWalls[2][7] = -1;
		dungeonWalls[2][8] = -1;
		dungeonWalls[2][9] = -1;
		dungeonWalls[2][10] = -1;
		dungeonWalls[2][11] = -1;
		dungeonWalls[2][12] = -1;
		
		//x = 3, y = 2,5,8,9,10,11,13,15,
		dungeonWalls[3][0] = 2;
		dungeonWalls[3][1] = 5;
		dungeonWalls[3][2] = 8;
		dungeonWalls[3][3] = 9;
		dungeonWalls[3][4] = 10;
		dungeonWalls[3][5] = 11;
		dungeonWalls[3][6] = 13;
		dungeonWalls[3][7] = 15;
		dungeonWalls[3][8] = -1;
		dungeonWalls[3][9] = -1;
		dungeonWalls[3][10] = -1;
		dungeonWalls[3][11] = -1;
		dungeonWalls[3][12] = -1;
			
				
		//x = 4, y = 2,5,8,13,15,16,18
		dungeonWalls[4][0] = 2;
		dungeonWalls[4][1] = 5;
		dungeonWalls[4][2] = 8;
		dungeonWalls[4][3] = 13;
		dungeonWalls[4][4] = 15;
		dungeonWalls[4][5] = 16;
		dungeonWalls[4][6] = 18;
		dungeonWalls[4][7] = -1;
		dungeonWalls[4][8] = -1;
		dungeonWalls[4][9] = -1;
		dungeonWalls[4][10] = -1;
		dungeonWalls[4][11] = -1;
		dungeonWalls[4][12] = -1;
				
		//x = 5, y = 1,2,5,8,10,11,12,13,16,18
		dungeonWalls[5][0] = 1;
		dungeonWalls[5][1] = 2;
		dungeonWalls[5][2] = 5;
		dungeonWalls[5][3] = 8;
		dungeonWalls[5][4] = 10;
		dungeonWalls[5][6] = 11;
		dungeonWalls[5][7] = 12;
		dungeonWalls[5][8] = 13;
		dungeonWalls[5][9] = 16;
		dungeonWalls[5][10] = 18;
		dungeonWalls[5][11] = -1;
		dungeonWalls[5][12] = -1;
				
		//x = 6, y = 8,10,16,18
		dungeonWalls[6][0] = 8;
		dungeonWalls[6][1] = 10;
		dungeonWalls[6][2] = 16;
		dungeonWalls[6][3] = 18;
		dungeonWalls[6][4] = -1;
		dungeonWalls[6][5] = -1;
		dungeonWalls[6][6] = -1;
		dungeonWalls[6][7] = -1;
		dungeonWalls[6][8] = -1;
		dungeonWalls[6][9] = -1;
		dungeonWalls[6][10] = -1;
		dungeonWalls[6][11] = -1;
		dungeonWalls[6][12] = -1;
				
		//x = 7, y = 0,1,2,5,6,7,8,10,16,18
		dungeonWalls[7][0] = 0;
		dungeonWalls[7][1] = 1;
		dungeonWalls[7][2] = 2;
		dungeonWalls[7][3] = 5;
		dungeonWalls[7][4] = 6;
		dungeonWalls[7][5] = 7;
		dungeonWalls[7][6] = 8;
		dungeonWalls[7][7] = 10;
		dungeonWalls[7][8] = 16;
		dungeonWalls[7][9] = 18;
		dungeonWalls[7][10] = -1;
		dungeonWalls[7][11] = -1;
		dungeonWalls[7][12] = -1;
		
		//x = 8, y = 2,10,11,12,13,14,15,16,18
		dungeonWalls[8][0] = 2;
		dungeonWalls[8][1] = 10;
		dungeonWalls[8][2] = 11;
		dungeonWalls[8][3] = 12;
		dungeonWalls[8][4] = 13;
		dungeonWalls[8][5] = 14;
		dungeonWalls[8][6] = 15;
		dungeonWalls[8][7] = 16;
		dungeonWalls[8][8] = 18;
		dungeonWalls[8][9] = -1;
		dungeonWalls[8][10] = -1;
		dungeonWalls[8][11] = -1;
		dungeonWalls[8][12] = -1;
					
					
		//x = 9, y = 2,3,4,5,6,7,18
		dungeonWalls[9][0] = 2;
		dungeonWalls[9][1] = 3;
		dungeonWalls[9][2] = 4;
		dungeonWalls[9][3] = 5;
		dungeonWalls[9][4] = 6;
		dungeonWalls[9][5] = 7;
		dungeonWalls[9][6] = 18;
		dungeonWalls[9][7] = -1;
		dungeonWalls[9][8] = -1;
		dungeonWalls[9][9] = -1;
		dungeonWalls[9][10] = -1;
		dungeonWalls[9][11] = -1;
		dungeonWalls[9][12] = -1;
					
		//x = 10, y = 9,10,11,12,13,14,15,17,18,19
		dungeonWalls[10][0] = 9;
		dungeonWalls[10][1] = 10;
		dungeonWalls[10][2] = 11;
		dungeonWalls[10][3] = 12;
		dungeonWalls[10][4] = 13;
		dungeonWalls[10][5] = 14;
		dungeonWalls[10][6] = 15;
		dungeonWalls[10][7] = 17;
		dungeonWalls[10][8] = 18;
		dungeonWalls[10][9] = 19;
		dungeonWalls[10][10] = -1;
		dungeonWalls[10][11] = -1;
		dungeonWalls[10][12] = -1;
					
		//x = 11, y = 6,7,18
		dungeonWalls[11][0] = 6;
		dungeonWalls[11][1] = 7;
		dungeonWalls[11][2] = 18;
		dungeonWalls[11][3] = -1;
		dungeonWalls[11][4] = -1;
		dungeonWalls[11][5] = -1;
		dungeonWalls[11][6] = -1;
		dungeonWalls[11][7] = -1;
		dungeonWalls[11][8] = -1;
		dungeonWalls[11][9] = -1;
		dungeonWalls[11][10] = -1;
		dungeonWalls[11][11] = -1;
		dungeonWalls[11][12] = -1;
					
		//x = 12, y = 0,2,6
		dungeonWalls[12][0] = 0;
		dungeonWalls[12][1] = 2;
		dungeonWalls[12][2] = 6;
		dungeonWalls[12][3] = -1;
		dungeonWalls[12][4] = -1;
		dungeonWalls[12][5] = -1;
		dungeonWalls[12][6] = -1;
		dungeonWalls[12][7] = -1;
		dungeonWalls[12][8] = -1;
		dungeonWalls[12][9] = -1;
		dungeonWalls[12][10] = -1;
		dungeonWalls[12][11] = -1;
		dungeonWalls[12][12] = -1;
					
		//x = 13, y = 2,6,10,11,12,13,14,15,16,17,18
		dungeonWalls[13][0] = 2;
		dungeonWalls[13][1] = 6;
		dungeonWalls[13][2] = 10;
		dungeonWalls[13][3] = 11;
		dungeonWalls[13][4] = 12;
		dungeonWalls[13][5] = 13;
		dungeonWalls[13][6] = 14;
		dungeonWalls[13][7] = 15;
		dungeonWalls[13][8] = 16;
		dungeonWalls[13][9] = 17;
		dungeonWalls[13][10] = 18;
		dungeonWalls[12][11] = -1;
		dungeonWalls[12][12] = -1;
					
		//x = 14, y = 2,3,4,5,6,7,8,10,18
		dungeonWalls[14][0] = 2;
		dungeonWalls[14][1] = 3;
		dungeonWalls[14][2] = 4;
		dungeonWalls[14][3] = 5;
		dungeonWalls[14][4] = 6;
		dungeonWalls[14][5] = 7;
		dungeonWalls[14][6] = 8;
		dungeonWalls[14][7] = 10;
		dungeonWalls[14][8] = 18;
		dungeonWalls[14][9] = -1;
		dungeonWalls[14][10] = -1;
		dungeonWalls[14][11] = -1;
		dungeonWalls[14][12] = -1;
					
		//x = 15, y = 2,10,18
		dungeonWalls[15][0] = 2;
		dungeonWalls[15][1] = 10;
		dungeonWalls[15][2] = 18;
		dungeonWalls[15][3] = -1;
		dungeonWalls[15][4] = -1;
		dungeonWalls[15][5] = -1;
		dungeonWalls[15][6] = -1;
		dungeonWalls[15][7] = -1;
		dungeonWalls[15][8] = -1;
		dungeonWalls[15][9] = -1;
		dungeonWalls[15][10] = -1;
		dungeonWalls[15][11] = -1;
		dungeonWalls[15][12] = -1;
					
		//x = 16, y = 0,1,2,3,4,10,13,14,15,16,17,18,19
		dungeonWalls[16][0] = 0;
		dungeonWalls[16][1] = 1;
		dungeonWalls[16][2] = 2;
		dungeonWalls[16][3] = 3;
		dungeonWalls[16][4] = 4;
		dungeonWalls[16][5] = 10;
		dungeonWalls[16][6] = 13;
		dungeonWalls[16][7] = 14;
		dungeonWalls[16][8] = 15;
		dungeonWalls[16][9] = 16;
		dungeonWalls[16][10] = 17;
		dungeonWalls[16][11] = 18;
		dungeonWalls[16][12] = 19;
					
		//x = 17, y = 4,5,6,7,9,10,13
		dungeonWalls[17][0] = 4;
		dungeonWalls[17][1] = 5;
		dungeonWalls[17][2] = 6;
		dungeonWalls[17][3] = 7;
		dungeonWalls[17][4] = 9;
		dungeonWalls[17][5] = 10;
		dungeonWalls[17][6] = 13;
		dungeonWalls[17][7] = -1;
		dungeonWalls[17][8] = -1;
		dungeonWalls[17][9] = -1;
		dungeonWalls[17][10] = -1;
		dungeonWalls[17][11] = -1;
		dungeonWalls[17][12] = -1;			
			
		// x = 18, y = 9
		dungeonWalls[18][0] = 9;
		dungeonWalls[18][1] = -1;
		dungeonWalls[18][2] = -1;
		dungeonWalls[18][3] = -1;
		dungeonWalls[18][4] = -1;
		dungeonWalls[18][5] = -1;
		dungeonWalls[18][6] = -1;
		dungeonWalls[18][7] = -1;
		dungeonWalls[18][8] = -1;
		dungeonWalls[18][9] = -1;
		dungeonWalls[18][10] = -1;
		dungeonWalls[18][11] = -1;
		dungeonWalls[18][12] = -1;
		
		//x = 19, y = 4,13
		dungeonWalls[19][0] = 4;
		dungeonWalls[19][1] = 13;
		dungeonWalls[19][2] = -1;
		dungeonWalls[19][3] = -1;
		dungeonWalls[19][4] = -1;
		dungeonWalls[19][5] = -1;
		dungeonWalls[19][6] = -1;
		dungeonWalls[19][7] = -1;
		dungeonWalls[19][8] = -1;
		dungeonWalls[19][9] = -1;
		dungeonWalls[19][10] = -1;
		dungeonWalls[19][11] = -1;
		dungeonWalls[19][12] = -1;
		
	}
	
//********************************************************************************************//	
	
	boolean updateLocation(String loc){
		userCharacter.move(loc);
		
		//check the user location in order to make sure you're not at a wall or at an enemy
		x = userCharacter.returnX();
		y =  userCharacter.returnY();	
		
		//check location of enemy
		if(checkEnemyLocation() == true){
			//battle
	
			//create the new enemy
			en = new Enemy(x,y);
			
			//call the battle function
			battle();
			
		}
		//check wall
		else if(checkWall() == true){
			//user has run into a wall
			userCharacter.resetMove(loc);
			System.out.println("Sorry, but you ran into a wall, your location has been pushed back one from where you came");
			x = userCharacter.returnX();
			y =  userCharacter.returnY();
			System.out.println("Your current location is now " + x + " , " + y);
		}
		//check gold
		else if(x == 18 || x == 19){
			if(y == 0 || y == 19){
				//user found the gold
				return true;
			}
		}
		//lastly
		else{
			//user found nothing and must keep moving
			System.out.println("You have moved " + loc);
			System.out.println("Your current location is " + x + " , " + y);
			System.out.println("Please enter N, S, E, or W");
		}
		
		return false;
		
	}

//********************************************************************************************//		
	
	boolean isCharDead(){
		health =  userCharacter.returnHealth();
		if(health == 0){
			return true;
		}
		return false;
	}
	
//********************************************************************************************//		
	
	void battle(){
		
		while(health > 0 && en.returnEnHealth() > 0){
			System.out.println("You have encountered an enemy! Do you choose to attack or escape?");
			//get the user input
			userInput = reader.next();
			//translate to lower case as a read issue
			userInput.toLowerCase();
			
			if(userInput.equals("attack")){
				//user character attacks
				dmg = userCharacter.attack();
				System.out.println("Your character does " + dmg + " to your enemy");
				//apply damage to enemy
				en.injured(dmg);
				
				System.out.println("Enemy is at " + en.returnEnHealth() + " health");
				
				//enemy attacks
				dmg = en.attack();
				System.out.println("The enemy attacks and does " + dmg + " to you");
				//apply damage to character
				userCharacter.injured(dmg);
				
				//print out characters health
				health = userCharacter.returnHealth();
				System.out.println("Your health is now " + health);
			}
			//user attempts to escape
			else if(userInput.equals("escape")){
				escape = userCharacter.escape();
				if(escape == 0){
					//user does not escape
					System.out.println("You do not escape!");
				}
				else{
					System.out.println("You have escaped from your enemy");
					//set health to 0 so the loop will exit
					health = 0;
				}
			}
			//user does not enter attack or escape
			else{
				System.out.println("Incorrect entry, please try again");
			}
			
			
			
			//repeat the loop until health is 0 or until 
		}
		
		health = userCharacter.health;
		if(en.enemyDefeated() == true){
			System.out.println("You have defeated your enemy, congratulations!");
			System.out.println("Your character has leveled up");
			//level up character
			userCharacter.levelUp();
		}
		else if(health < 0){
			System.out.println("Your character has died in battle. GAME OVER");
			charDead = true;
		}

	}

	
//********************************************************************************************//	
	
	//walls are:
	/*
	* x = 0, y = 6,9,13
	* x = 1, y = 0,1,2,4,5,6,9,10,11,13,15,18,19 
	* x = 2, y = 2,5,11,13,15,18
	* x = 3, y = 2,5,8,9,10,11,13,15,
	* x = 4, y = 2,5,8,13,15,16,18
	* x = 5, y = 1,2,5,8,10,11,12,13,16,18
	* x = 6, y = 8,10,16,18
	* x = 7, y = 0,1,2,5,6,7,8,10,16,18
	* x = 8, y = 2,10,11,12,13,14,15,16,18
	* x = 9, y = 2,3,4,5,6,7,18
	* x = 10, y = 9,10,11,12,13,14,15,17,18,19
	* x = 11, y = 6,7,18
	* x = 12, y = 0,2,6
	* x = 13, y = 2,6,10,11,12,13,14,15,16,17,18
	* x = 14, y = 2,3,4,5,6,7,8,10,18
	* x = 15, y = 2,10,18
	* x = 16, y = 0,1,2,3,4,10,13,14,15,16,17,18,19
	* x = 17, y = 4,5,6,7,9,10,13
	* x = 18, y = 9
	* x = 19, y = 4,13
	*/
	
	boolean checkWall(){
		
		if(x < 0){
			return true;
		}
		else if(x > 19){
			return true;
		}
		else if(y < 0){
			return true;
		}
		else if(y > 19){
			return true;
		}
		else{
			//check
			for(int i = 0; i < 13; i++){
				if(dungeonWalls[x][i] == y){
					return true;
				}
			}
		}
		
		
		return false;
	}
	
//********************************************************************************************//	
	
	//there should be nine enemies
		/*
		 * x = 1, y = 3
		 * x = 1, y = 14
		 * x = 4, y = 10
		 * x = 6, y = 2
		 * x = 10, y = 7
		 * x = 10, y = 16
		 * x = 14, y = 9
		 * x = 18, y = 4
		 * x = 18, y = 13 
		 */
	
	boolean checkEnemyLocation(){
		if(x == 1){
			if(y == 3 || y == 14){
				return true;
			}
		}
		else if(x == 4){
			if(y == 10){
				return true;
			}
		}
		else if(x == 6){
			if(y == 2){
				return true;
			}
		}
		else if(x == 10){
			if(y == 7 || y == 16){
				return true;
			}
		}
		else if(x == 14){
			if(y == 9){
				return true;
			}
		}
		else if(x == 18){
			if(y == 4 || y == 13){
				return true;
			}
		}
		
		//if enemy fails then return false
		return false;
	}
}
