import java.util.*;
import java.io.*;

/*
 * Aurora Havens
 * Last Edited: 4/7/17
 */

//enemy should be able to attack and adjust for damage done to it

public class Enemy {
	int health = 4;
	int x;
	int y;
	boolean defeated = false;
	//call the dice
	Dice die = new Dice();
	
	
	public Enemy(int xLoc, int yLoc){
		x = xLoc;
		y = yLoc;
	}

//********************************************************************************************//		
	
	int returnX(){
		return x;
	}
	int returnY(){
		return y;
	}
	
//********************************************************************************************//		
	
	int attack(){
		//call the dice to determine if they can deal damage
		return die.roll(0, 3);
	}
	
//********************************************************************************************//		
	
	void injured(int dmgByChar){
		health = health - dmgByChar;
		if(health <= 0){
			defeated = true;
		}
	}
	
//********************************************************************************************//		
	
	boolean enemyDefeated(){
		if(health < 0){
			return true;
		}
		return false;
	}

//********************************************************************************************//		
	
	int returnEnHealth(){
		return health;
	}
	
}
