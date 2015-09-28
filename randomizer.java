package package1;

import java.util.ArrayList;
import java.util.Random;

public class randomizer {
	
	private ArrayList <Position> randomizer;
	
	randomizer(int pArray[][]){
		randomizer = new ArrayList();
		this.randomizer = initArray(pArray);
	}
	
	/******************************************************************
	 * Initializes the randomizer array list with possible x y values. 
	 * @param pArray
	 * The game 2d game board. 
	 * @return
	 * an array of the x and y coordinates. 
	 ******************************************************************/
	private ArrayList<Position> initArray(int pArray[][]){
		for(int i = 0; i< pArray.length; ++i){
			for(int j = 0; j<pArray[0].length; ++j){
				randomizer.add(0, new Position(i, j));
//				System.out.println(randomizer.get(0).toString());
			}
		}
		return randomizer;
	}
	
	/******************************************************************
	 * Prints the arralist of values
	 *****************************************************************/
	public void print(){
		for(int i = 0; i< randomizer.size(); i++){
			System.out.println(randomizer.get(i).toString());
		}
		
	}
	
	/******************************************************************
	 * Shuffles the entire list of possible x and y coordinates. 
	 ******************************************************************/
	public void shuffle(){
		for(int i =1; i<randomizer.size(); i++){
			//save off the data to swap
			Position data = randomizer.get(i);
			//now swap i with a random position.
			int temp = randInt(i);
			//swap the two values. aka shake up the box of possible x y coordinates. 
			randomizer.set(i,  randomizer.get(temp)) ;
			randomizer.set(temp, data);
		}
	}

	/******************************************************************
	 * Returns a random number from 0 to Ceiling
	 * @param ceiling
	 * The upper bounds of the random number
	 * @return
	 * The random number generated. 
	 *****************************************************************/
	private int randInt(int ceiling){
		Random rand = new Random();
		//generates a random number from 0 to ceiling exclusive.
		//Since we want to generate a number from 0 to 64 inclusive
		//I'll add one to exclude the 65th position and include 0 to 64 as a range. 
		int temp = rand.nextInt(ceiling+1);
	    return temp; 
	}
	
	public static void main(String args[]){
		int[][] arr = new int[9][9];
		
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j<arr[0].length; j++){
				//initialize the game simulator 1 = room.
				arr[i][j] = 1;
			}
		}
		randomizer temp = new randomizer(arr);
//		temp.print();
		//shuffle the values. 
		temp.shuffle();
		//print the values 
		temp.print();
	}
}
