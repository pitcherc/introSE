package pack1;

public class Engine {
 
	private Room[][] floor;
	
	private Player player;
	 
	private GmPn gp;
	
	Randomizer random;
	
	Engine(){
		floor = new Room[10][10];
		configFloors();
		gp = GmPn.IDLE;
		
		//GABRIEL to BEN: i was thinking we could implement this line V
		//random = new Randomizer(floor); 
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
			return "You move north and encounter " + explore();
		}
		else if(udrl == 'd' && player.getPos().getX() >0){
			player.move(udrl);
			return "You move south and encounter " + explore();
		}
		else if(udrl == 'r' && player.getPos().getY() <9){
			player.move(udrl);
			return "You move east and encounter " + explore();
		}
		else if(udrl == 'l' && player.getPos().getY() >0){
			player.move(udrl);
			return "You move west and encounter " + explore();
		}
		else{
		return "You are blocked by a wall";	
		}
	}
	
	private String explore(){
		Position p = player.getPos();
			return "a message";
	}
	
//	public void battle(){
//		Enemy enemy = floor[player.getPos().getx()]
//				[player.getPos().getY()].getEnemy() 
//			
//	}
	
		
}
