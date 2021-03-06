package package1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Engine implements Serializable{

	private static final long serialVersionUID = -6765701323665765528L;

	private Room[][] floor;

	private Player player;

	private GmPn gp;

	Randomizer<Room> random;

	Chest chest;

	Enemy enemy;

	Random r = new Random();

	Engine(){
		player = new Player();
		floor = new Room[10][10];
		configFloors();
		gp = GmPn.IDLE;
		chest = new Chest();
		floor[0][0].setVisited(true);
		random = new Randomizer<Room>(floor);
		random.shuffle();
		random.shuffle();
		rand(random.getArray());
		floor[0][0].empty();
		int bx = r.nextInt(3) + 6;
		int by = r.nextInt(3) + 6;
		floor[bx][by].empty();
		floor[bx][by].setEnemy(new Enemy(1,1,1));
		floor[bx][by].setFinal();

	}	

	private void rand(ArrayList<Position> list){

		for( int i = 0 ; i < list.size()*.7 ; i++) {
			int  j = r.nextInt(10) + 1;
			Position p = list.get(i);
			if(p.getX() != 9 && p.getY() != 9){
				if(j == 1 || j == 2){
					floor[p.getX()][p.getY()].gereateChest();	
					if(floor[p.getX()][p.getY()].getEnemy() != null){
						floor[p.getX()][p.getY()].setEnemy(null);
					}
				}
				else if (j > 2 && j <9){
					if(!(floor[p.getX()][p.getY()].hasChest()))
					{
						floor[p.getX()][p.getY()].setEnemy(new Enemy()); 
					}
				}
			}
		}
	}
	
	
	
	
//	int i = r.nextInt(20);
//
//	if(i == 0){
//		player.take(player.getHealth() / 2);
//		return "The chest turned out to be \n trapped! You were severly damaged!\n";
//	}
//	else if(i > 0 && i < 4){
//		int po = ((r.nextInt()) % 3) + 1; 
//		player.addPotions(po);
//		return "Yout opened the chest \n and found " + po + " potions!\n";
//	}

	private void configFloors(){

		for(int x = 0; x < floor.length ; x++ ){
			for(int y = 0; y < floor[0].length; y++){
				floor[x][y] = new Room();
			}
		}
	}

	public String move(char udrl){

		if(udrl == 'u' && player.getPos().getX() <9){
			player.move(udrl);
			floor[player.getPos().getX()][player.getPos().getY()].setVisited(true);
			if(floor[player.getPos().getX()][player.getPos().getY()].isFinal()){
				return "You move north and encounter\n" + finalBoss();
			}
			else{
				return "You move north and encounter\n" + explore();
			}
		}
		else if(udrl == 'd' && player.getPos().getX() >0){
			player.move(udrl);
			floor[player.getPos().getX()][player.getPos().getY()].setVisited(true);
			if(floor[player.getPos().getX()][player.getPos().getY()].isFinal()){
				return "You move south and encounter\n" + finalBoss();
			}
			else{

				return "You move south and encounter\n" + explore();
			}
		}
		else if(udrl == 'r' && player.getPos().getY() <9){
			player.move(udrl);
			floor[player.getPos().getX()][player.getPos().getY()].setVisited(true);
			if(floor[player.getPos().getX()][player.getPos().getY()].isFinal()){
				return "You move east and encounter\n" + finalBoss();
			}
			else{
				return "You move east and encounter\n" + explore();
			}
		}
		else if(udrl == 'l' && player.getPos().getY() >0){
			player.move(udrl);
			floor[player.getPos().getX()][player.getPos().getY()].setVisited(true);
			if(floor[player.getPos().getX()][player.getPos().getY()].isFinal()){
				return "You move west and encounter\n" + finalBoss();
			}
			else{
				return "You move west and encounter\n" + explore();
			}
		}
		else{
			return "You are blocked by a wall\n";	
		}
	}

	private String finalBoss(){
		Room r =floor[player.getPos().getX()][player.getPos().getY()];
		r.setEnemy(new Enemy());
		enemy = floor[player.getPos().getX()][player.getPos().getY()].getEnemy();
		gp = GmPn.FIGHT;
		enemy.setHealth(500);
		enemy.setMax();
		enemy.setPower(30);
		return "\n An enemy embrasing the essence of pure evil \n";
	}

	Room[][] getFloors(){
		return floor;
	}

	public String openChest(){
		if(floor[player.getPos().getX()][player.getPos().getY()].hasChest())
		{
			
			
				Equiptment found = floor[player.getPos().getX()][player.getPos().getY()].open();
				player.equipt(found);
				return "You found " + found.name + "!";
			
		}
		else{
			return "there is no chest there...\n";
		}
	}

	public String attack(){
		if(gp == GmPn.DEAD){
			return "you're dead\n";
		}
		if(gp == GmPn.IDLE){
			return "attack what?\n";
		}
		if(gp == GmPn.WIN){
			return "you win!\n";
		}
		int delt = player.attack();

		enemy.take(delt);

		if(enemy.getHealth() <= 0){
			gp = GmPn.IDLE;

			if(floor[player.getPos().getX()][player.getPos().getY()].isFinal()){
				return "\n\n\n\n\n\n\nAfter trails and tribulations a plenty \n "
						+ "you deal the final blow to the monster \n"
						+ "walking homebound you bring good new for\n "
						+ "your village\n\n";
			}

			floor[player.getPos().getX()][player.getPos().getY()].empty();

			floor[player.getPos().getX()][player.getPos().getY()].setEnemy(null);

			return "you dealt " + delt + " damage, vanquishing the beast\n" ;

		}

		String message = enemyAttacks();

		if(gp == GmPn.DEAD){
			return message;
		}

		return "you dealt " + delt + " damage, and" + message ;
	}
	
	/******************************************************************
	 * Sets the players selection based on what the user selected
	 * @param selection
	 *****************************************************************/
	public void setPlayerEquipment(int selection){
		if(selection == -1){
			return;
		}
		Equiptment item = 
				floor[player.getPos().getX()][player.getPos().getY()]
						.getChest().generateItem(selection);
		player.equipt(item);
		
		floor[player.getPos().getX()][player.getPos().getY()].setChest(null);
		
		Alert al = new Alert(AlertType.INFORMATION, item.name);
		al.setHeaderText("Your character is now stronger!");
		al.showAndWait();
	}

	public String usePotion(){

		if(gp == GmPn.FIGHT){
			if(player.getPotions() == 0){
				return "you are out of potions! \nYou attack instead!\n" + attack(); 
			}

			player.usePotion();

			String message = enemyAttacks();

			return "you fully recovered but were hit and " + message ;
		}
		else if (gp != GmPn.DEAD){
			if(player.getPotions() == 0){
				return "you're out of potions!\n";
			}
			else {
				player.usePotion();
				return"you have been fully healed!\n";
			}
		}
		else{
			return "you are dead\n";
		}
	}

	/******************************************************************
	 * Saves the game state as is. 
	 * @param filepath
	 * The file path to the object, and is retrieved by the 
	 * game engine itself.
	 * @param Engine game
	 * This object is the game object to be saved off
	 *****************************************************************/
	public void saveGame(String filepath, Engine game){
		try{
			FileOutputStream fos = new FileOutputStream(filepath);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(game);
			os.close();
		}catch(IOException exception){
			System.out.println("Check the save game method.");
			exception.printStackTrace();
		}
	}

	/****************************************************************
	 * This must be done carefully because the user
	 * can read in objects that are not a Game object.
	 * Add type checking in future releases. Also file filters
	 * should be used when 
	 * @param String file path
	 * Is the absolute file path to the game object.
	 ***************************************************************/
	public void loadGame(String filepath){

		try {
			FileInputStream fis = new FileInputStream(filepath);
			@SuppressWarnings("resource")
			ObjectInputStream is = new ObjectInputStream(fis);
			Engine temp = (Engine)is.readObject();
			//should be anything else to do here....
			this.player = temp.player;
			this.floor = temp.floor;
		} catch (Exception ex) {
			System.out.println("Check the load Game method.");
			ex.printStackTrace();
		}

	}

	private String enemyAttacks(){

		int take = enemy.attack();

		player.take(take);

		if(player.getHealth() <= 0){
			gp = GmPn.DEAD;
			return"you were dealt " + take + " damage, and died\n" ;
		}

		return 	" took "+ take + " damage\n";		
	}

	private String explore(){
		Position p = player.getPos();
		enemy = floor[p.getX()][p.getY()].getEnemy();
		
		if(floor[p.getX()][p.getY()].hasChest()){
			return "there is a chest, open at your own risk\n";
		}
		
		if(enemy != null){
			gp = GmPn.FIGHT;
			enemy.setHealth((200 +(r.nextInt(100))) * (player.getLevel()));
			enemy.setPower(10 +  (r.nextInt(10)/2));
			enemy.setMax();
			return "A MONSTER\nHEALTH: " + enemy.getHealth() + "\nPOWER: " + enemy.getPower() + '\n';
		}
		// floor[p.getX()][p.getY()].getChest();

		return "nothing!\n";
	}

	/**Returns the Health of the player**/
	int getPlayerHealth(){
		return player.getHealth();
	}
	

	int getPlayerMaxHealth(){
		return player.getMax();
	}

	int getPotions(){
		return player.getPotions();
	}

	/**Returns the Player object**/
	Player getPlayer(){
		return player;
	}

	public GmPn getGameStatus(){
		return gp;
	}
	public Enemy getEnemy(){
		
		if(this.enemy == null){
			Enemy e = new Enemy(-1 , 0 , 0);
			e.setHealth(1);
			return e;
		}
		return this.enemy;
	}

	public Room[][] getFloor(){
		return floor;
	}

}
