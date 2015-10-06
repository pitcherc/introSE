package pack1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {

	@Test
	public void roomTest(){
		for(int i = 0; i< 100000000 ; i++){
			Room r = new Room();
			assertTrue(r.isEmpty());
			r.setEnemy(new Enemy());
			assertFalse(r.isEmpty());
			r.empty();
			assertTrue(r.isEmpty());
			r.setChest(new Chest());
			assertFalse(r.isEmpty());
			r.empty();
			assertTrue(r.isEmpty());
		}		
	}

}
