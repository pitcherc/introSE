package pack1;

import java.util.ArrayList;
import java.util.Random;

public class Randomizer<E> {
	
	private ArrayList <Position> randomizer;
	
	/******************************************************************
	 * initialize the entire array list with all integer values.
	 * Should accept a paramteter of a 2d array. Does not matter what
	 * type of 2d array it is. It will generate random unique values
	 * from  
	 * @param arr
	 *****************************************************************/
	Randomizer(E[][] arr){
		randomizer = new ArrayList();
		
		if(arr[0][0] instanceof Room){
		   this.randomizer = roomArray((Room[][])arr);
		}
//		if(arr instanceof Stuff){
//			//class another function
//		}
		else{
		//	this.randomizer = intArray((int[][])arr);
		}
	}
	
	/******************************************************************
	 * Initializes the randomizer array list with possible x y values. 
	 * @param arr
	 * The 2d array of possible Room coordinates. 
	 * @return
	 * an array of the x and y coordinates. 
	 ******************************************************************/
	private ArrayList<Position> roomArray(Room[][] arr){
		for(int i = 0; i< arr.length; ++i){
			for(int j = 0; j<arr[0].length; ++j){
				randomizer.add(0, new Position(i, j));
			}
		}
		return randomizer;
	}
	
	/******************************************************************
	 * Initializes the randomizer array list with possible x y values. 
	 * @param arr
	 * An integer 2d array of the possible x and y values.  
	 * @return
	 * an array of the x and y coordinates. 
	 ******************************************************************/
	private ArrayList<Position> intArray(int[][] arr){
		for(int i = 0; i< arr.length; ++i){
			for(int j = 0; j<arr[0].length; ++j){
				randomizer.add(0, new Position(i, j));
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
			randomizer.set(randInt(i), data);
		}
	}
	
	/******************************************************************
	 * Gets the entire arraylist of positions.
	 * @return
	 * The randomized array list. 
	 *****************************************************************/
	public ArrayList<Position> getArray(){
		return randomizer;
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
		Room [][] r = new Room[5][5];
		Randomizer<Room> temp = new Randomizer<Room>(r);
		
		//shuffle the values. 
		temp.shuffle();
		temp.shuffle();
		temp.shuffle();
		//print the values 
		temp.print();
		System.out.println("The size of the arraylist is: "+temp.getArray().size());
	}
}
