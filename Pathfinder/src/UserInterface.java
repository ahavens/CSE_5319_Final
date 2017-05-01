import java.util.Scanner;
import java.util.*;

/*
 * Aurora Havens
 * Last Edited: 4/3/17
 */

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//make the scanner
		Scanner reader = new Scanner(System.in);
		
		boolean gotGold = false;
		boolean dead = false;
		String userInput;
		boolean checkUserInput = false;
		String userInputTranslated;
		
		//Print introduction
		System.out.println("				Welcome to the wonderful world of Donool			");
		System.out.println();
		System.out.println("     You have come to Donool to face the treacherous dungeon in order to obtain the gold that lies within		");
		System.out.println();
		System.out.println("		You must choose from the following classes: Wizard, Warrior, or Thief");
		System.out.println("		    Each class has it's own ability and health, so choose wisely");
		System.out.println("		     Enter wiz for Wizard, war for Warrior, and thi for thief");
		
		do{
			//get the user input for the class
			userInput = reader.next();
			//have it go to lower case for easier verifiability
			userInput.toLowerCase();
			
			if(!userInput.equals("wiz")){
				if(!userInput.equals("war")){
					if(!userInput.equals("thi")){
						System.out.println("Sorry but that is not a valid class, please enter wiz, war, or thi");
						userInputTranslated = "invalid";
					}
					//if thief set to true
					else{
						checkUserInput = true;
						userInputTranslated = "thief";
					}
				}
				//if warrior set to true
				else{
					checkUserInput = true;
					userInputTranslated = "warrior";
				}
			}
			//if wizard set to true
			else{
				checkUserInput = true;
				userInputTranslated = "wizard";
			}
			
		}while(checkUserInput != true);
		
		//create the dungeon using the user input
		Dungeon dung = new Dungeon(userInput);
		
		System.out.println("Congratulations! You have selected " + userInputTranslated + ". Welcome to the dungeon!");
		System.out.println();
		System.out.println("=========================================================");
		System.out.println();
		System.out.println("A few rules before you get started...");
		System.out.println("This is a 20 x 20 dungeon. Your character is only allowed to move one space "
				+ "at a time. But you are allowed to pick which direction your character will go."
				+ " These are cardinal directions, so N, S, E, or W. This "
				+ "dungeon is considered to be a maze so there will be times when you hit a wall. Do not"
				+ " be discouraged if you do.");
		System.out.println();
		System.out.println("Within this dungeon there are enemies randomly located. You have the option to"
				+ " either attach or escape. Depending on your class selection, your attack will be different "
				+ "but it will still deal damage. The enemy you face will also have the ability to deal damage if"
				+ " it so wishes");
		System.out.println("If you fall in battle, the dungeon will reset and you are allowed to try again if you"
				+ " so wish. However, if you succeed and stumble across the gold in the dungeon then you have"
				+ " won the game");
		System.out.println();
		System.out.println("Enter the Dungeon");
		
		System.out.println();
		
		System.out.println("Please enter N, S, E, or W");
		
		do{
			//get user input
			userInput = reader.next();
			//translate to uppercase
			userInput.toUpperCase();
			//update the characters location and check to see if the user found gold
			gotGold = dung.updateLocation(userInput);
			//check if user character is dead
			dead = dung.isCharDead();
			
		}while(gotGold == false || dead == false);
		
	}

}
