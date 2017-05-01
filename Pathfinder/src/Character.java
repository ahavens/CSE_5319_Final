import java.util.*;

/*
 * Aurora Havens
 * Last Edited: 4/7/17
 */

public class Character {
	String charName;
	int health;
	String attack;
	int x = 0;
	int y = 0;
	int lowAttack = 1;
	int highAttack;
	
	//dice
	Dice die = new Dice();
	
	//we just want the name of the character the user input
	public Character(String cN){
		if(cN.equals("wiz")){
			charName = "wizard";
			health = 5;
			attack = "spell";
			highAttack = 6;
		}
		else if(cN.equals("war")){
			charName = "warrior";
			health = 7;
			attack = "sword";
			highAttack = 5;
		}
		else if(cN.equals("thi")){
			charName = "theif";
			health = 4;
			attack = "sword";
			highAttack = 3;
		}
		
	}
	
//********************************************************************************************//	
	
	//evaluate how character moves
	//maybe do print lines within the dungeon
	
	void move(String direction){
		switch(direction){
		case "N":
			y = y - 1;
			break;
		case "E":
			x = x + 1;
			break;
		case "S":
			y = y + 1;
			break;
		case "W":
			x = x - 1;
			break;
		default:
			break;
		}
		//we are going to have to return both x and y 
	}

//********************************************************************************************//	
	
	//if the move contradicts with a wall, move back
	void resetMove(String direction){
		switch(direction){
		case "N":
			y = y + 1;
			break;
		case "E":
			x = x - 1;
			break;
		case "S":
			y = y + 1;
			break;
		case "W":
			x = x + 1;
			break;
		default:
			break;
		}
	}

//********************************************************************************************//	
	
	//return the X and Y as a check to make sure that we
	//don't have to reset anything
	int returnX(){
		return x;
	}
	
	int returnY(){
		return y;
	}
	
//********************************************************************************************//	
	
	//how much the user attacks with
	//may have to be edited to prevent character from being killed so often
	int attack(){
		//the die roll returns
		return die.roll(lowAttack, highAttack);
	}
	
//********************************************************************************************//
	
	void levelUp(){
		//increase attack
		highAttack = highAttack + 2;
		//increase health
		health = health + 9;
	}
	
	
//********************************************************************************************//
	
	//say the character has low health and wants to escape, then they can escape but only have a 50%
	//of doing so
	int escape(){
		//returns 50/50 chance of character being able to escape
		return die.roll(0,1);
	}
	
//********************************************************************************************//		
	
	void injured(int dmg){
		health =  health - dmg;
	}
	
//********************************************************************************************//		
	
	int returnHealth(){
		//determine health of character
		return health;
	}
	
	
	
}
