package pack1;

public class Room {

	private Enemy enemy;
	
	private Chest chest;
	
	Room(){
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
