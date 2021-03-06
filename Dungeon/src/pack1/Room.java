package package1;

import java.io.Serializable;

public class Room implements Serializable{

	private static final long serialVersionUID = -6533460215082102895L;

	private Enemy enemy;
	
	private Chest chest;
	
	private boolean opened;
	
	private boolean isVisited;
	
	private boolean isBoss;
	
	Room(){
		opened = false;
		enemy = null;
		chest = null;
		isBoss = false;
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
	
	boolean isFinal(){
		return isBoss;
	}
	void setFinal(){
		isBoss = true;
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
	
	void gereateChest(){
		chest = new Chest();
	}
	
	public boolean hasChest(){
		if(chest == null){
			return false;
		}
		else {
			return true;
		}
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
	
	boolean isOpened()
	{
		return opened;
	}
	
	/******************************************************************
	 * Returns true if the room has been visited before by the 
	 * player object.
	 * @return isVisited
	 * isVisited is an instance variable of the class.
	 *****************************************************************/
	boolean isVisited(){return isVisited;}
}
