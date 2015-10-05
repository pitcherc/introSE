package pack1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

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
		random = new Randomizer<Room>(floor);
		random.shuffle();
		rand(random.getArray());
		floor[0][0].empty();
	}	

	private void rand(ArrayList<Position> list){

		for( int i = 0 ; i < list.size()*.7 ; i++) {
			int  j = r.nextInt(10) + 1;
			Position p = list.get(i);
			if(p.getX() != 9 && p.getY() != 9){
				if(j == 1){
					//doChest();	
				}
				else if (j > 1 && j <9){
					floor[p.getX()][p.getY()].setEnemy(new Enemy()); 
				}
			}
		}
	}

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
			if(player.getPos().getX() == 9 &&player.getPos().getY() ==9){
				return "You move north and encounter " + finalBoss();
			}
			else{
				return "You move north and encounter " + explore();
			}
		}
		else if(udrl == 'd' && player.getPos().getX() >0){
			player.move(udrl);
			return "You move south and encounter " + explore();
		}
		else if(udrl == 'r' && player.getPos().getY() <9){
			player.move(udrl);
			if(player.getPos().getX() == 9 &&player.getPos().getY() ==9){
				return "You move north and encounter " + finalBoss();
			}
			else{
				return "You move east and encounter " + explore();
			}
		}
		else if(udrl == 'l' && player.getPos().getY() >0){
			player.move(udrl);
			return "You move west and encounter " + explore();
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
		enemy.setHealth(25);
		enemy.setPower(4);
		return "\n an enemy with power unlike any other!!!\n";
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
			floor[player.getPos().getX()][player.getPos().getY()].empty();
			return "you dealt " + delt + " damage, vanquishing the beast\n" ;

		}

		String message = enemyAttacks();

		if(gp == GmPn.DEAD){
			return message;
		}

		return "you dealt " + delt + " damage, and" + message ;
	}

	public String usePotion(){

		if(gp == GmPn.FIGHT){
			if(player.getPotions() == 0){
				return "you are out of potions! \nYou attack instead!\n" + attack(); 
			}

			player.usePotion();

			String message = enemyAttacks();

			if(gp == GmPn.DEAD){
				return message;
			}

			return "you fully recovered but were hit and " + message ;
		}
		else
			if(player.getPotions() == 0){
				return "you're out of potions!\n";
			}
			else{
				player.usePotion();
				return"you have been fully healed!\n";
			}
	}

	private String enemyAttacks(){
		
		int take = enemy.attack();

		player.take(take);

		if(player.getHealth() <= 0){
			gp = GmPn.DEAD;
			return"you were dealt " + take + " damage, and died\n" ;
		}

		return 	" took "+ take + "damage\n";		
	}

	private String explore(){
		Position p = player.getPos();

		enemy = floor[p.getX()][p.getY()].getEnemy();

		if(enemy != null){
			gp = GmPn.FIGHT;
			enemy.setHealth((5 +(r.nextInt(5))) * (player.getLevel()));
			enemy.setPower( r.nextInt(1 + player.getLevel()) + 1);
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

	public Room[][] getFloor(){
		return floor;
	}

}
