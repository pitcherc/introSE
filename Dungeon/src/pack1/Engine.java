package pack1;

import java.util.ArrayList;
import java.util.Random;

public class Engine {

	private Room[][] floor;

	private Player player;

	private GmPn gp;

	Randomizer random;

	Chest chest;

	Enemy enemy;

	Engine(){
		player = new Player();
		floor = new Room[10][10];
		configFloors();
		gp = GmPn.IDLE;
		chest = new Chest();
		//GABRIEL to BEN: i was thinking we could implement this line V
		random = new Randomizer<Room>(floor);
		random.shuffle();
		rand(random.getArray());
	}	

	private void rand(ArrayList<Position> list){
		Random r = new Random();
		for( int i = 0 ; i < list.size()*.7 ; i++) {
			int  j = r.nextInt(10) + 1;
			Position p = list.get(i);
			if((p.getX() != 0 && p.getY() != 0) || (p.getX() != 9 && p.getY() != 9)){
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
			return "You are blocked by a wall";	
		}
	}
	
	private String finalBoss(){
		
		return "an enemy with power unlike any other";
	}

	private String explore(){
		Position p = player.getPos();

		enemy = floor[p.getX()][p.getY()].getEnemy();

		if(enemy != null){
			//enemy.setHealth();
			//enemy.setPower(health);
		}
		//floor[p.getX()][p.getY()].getChest();

		return "nothing!\n";
	}

	//	public void battle(){
	//		Enemy enemy = floor[player.getPos().getx()]
	//				[player.getPos().getY()].getEnemy() 
	//			
	//	}
}
