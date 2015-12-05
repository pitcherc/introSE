package pack1;

import java.io.Serializable;

public class Room implements Serializable{

	private static final long serialVersionUID = -6533460215082102895L;

	private Enemy enemy;
	
	private Chest chest;
	
	private boolean opened;
	
	private boolean isVisited;
	
	Room(){
		Chest c = null;
		opened = false;
		enemy = null;
		chest = null;
	}
	 
	void empty(){
		enemy = null;
		chest = null;
		
	}
	
	public boolean isEmpty(){
		if(chest == null){
			if(enemy == null){
				return true;
			}
		}
		return false;
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
	
	void gereateChest(){
		chest = new Chest();
	}
	
	Equiptment open(){
		if(!(opened))
		{
			opened = true;
			return chest.open();
		}
		else
		{
		 return null;	
		}
	}
	
	/*****************************************************
	 * If a player has visited this room. Set is Visited
	 * to true.
	 * @param pVisit
	 ***************************************************/
	void setVisited(boolean pVisit){
		this.isVisited = true;
	}
	
	/******************************************************************
	 * Returns true if the room has been visited before by the 
	 * player object.
	 * @return isVisited
	 * isVisited is an instance variable of the class.
	 *****************************************************************/
	boolean isVisited(){return isVisited;}
}
