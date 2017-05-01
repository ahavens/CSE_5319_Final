import java.util.*;
import java.lang.Math;

/*
 * Aurora Havens
 * Last Edited: 4/3/17
 */

//Dice class only has one function in which there is a roll and the roll is then taken and determined within 
//the specific class that called it

public class Dice {
	//this dice class will send in a number range in order to determine the probability of certain things
	public Dice(){
		
	}
	
	int roll(int low, int high){
		int range = (high - low) + 1;
		//return the number
		return (int)(Math.random()*range) + low;
	}
}
