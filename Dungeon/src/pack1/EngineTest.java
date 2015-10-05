package pack1;

import static org.junit.Assert.*;

import org.junit.Test;

public class EngineTest {

	@Test
	public void correctStart() {
		
		Engine e = new Engine();
		
		assertTrue(e.getPlayerHealth() == e.getPlayerMaxHealth());
	
		assertTrue(e.getGameStatus() == GmPn.IDLE);
	}
	
	@Test
	public void playerCanMove(){
		
		Engine e = new Engine();
		
		e.move('d'); //player can exceed bounds.
		assertTrue(e.getPlayer().getPos().getX() == 0);
		assertTrue(e.getPlayer().getPos().getY() == 0);
		
		e.move('l'); //player can exceed bounds.
		assertTrue(e.getPlayer().getPos().getX() == 0);
		assertTrue(e.getPlayer().getPos().getY() == 0);
		
		e.move('u'); //player can move.
		assertTrue(e.getPlayer().getPos().getX() == 1);
		assertTrue(e.getPlayer().getPos().getY() == 0);
		
		if (e.getGameStatus() != GmPn.FIGHT){ 

			e.move('d');  //player can move if not in battle.
			assertTrue(e.getPlayer().getPos().getX() == 0);
			assertTrue(e.getPlayer().getPos().getY() == 0);
			
			e.move('r');  //player should not encounter enemy at start.
			assertTrue(e.getPlayer().getPos().getX() == 0);
			assertTrue(e.getPlayer().getPos().getY() == 1);
		}
		
	}
	 
	@Test
	public void twoGamesAreNotTheSame(){
		
		Engine e1 = new Engine();
		
		Room[][] f1 = e1.getFloor();
		
		Engine e2 = new Engine();
		
		Room[][] f2 = e2.getFloor();
		
		int differences = 0;
		
		//boards are size 10
		for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				if((f1[x][y].getEnemy() != null && f2[x][y].getEnemy() == null) ||
				   (f1[x][y].getEnemy() == null && f2[x][y].getEnemy() != null)){
						differences++;
				}
			}
		}
		assertTrue(differences > 0);
		
	}

}
