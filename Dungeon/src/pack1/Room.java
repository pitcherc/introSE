package pack1;

import java.io.Serializable;

public class Room implements Serializable{

	private static final long serialVersionUID = -6533460215082102895L;

	private Enemy enemy;
	
	private Chest chest;
	
	Room(){
		enemy = null;
		chest = null;
	}
	 
	void empty(){
		enemy = null;
		chest = null;
		
	}
	
	void setEnemy(Enemy e){
		enemy = e;
	}
	
	void setChest(Chest c){
		chest = c;
	}
	
	Enemy getEnemy(){
		return enemy;
	}
	
	Chest getChest(){
		return chest;
	}
}
