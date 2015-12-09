package package1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {

	@Test
	public void roomTest(){
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
	
	@Test
	public void testIsEmpty(){
		Room r = new Room();
		assertTrue(r.isEmpty());
	}
	
	@Test
	public void testSetEnemy(){
		Room r = new Room();
		r.setEnemy(new Enemy());
		assertFalse(r.isEmpty());
	}
	
	@Test 
	public void testSetThenEmpty(){
		Room r = new Room();
		r.setEnemy(new Enemy());
		assertFalse(r.isEmpty());
		r.empty();
		assertTrue(r.isEmpty());
	}
	
	
	@Test
	public void testIsFinal(){
		Room r = new Room();
		assertFalse(r.isFinal());
	}
	
	@Test 
	public void testSetFinal(){
		Room r = new Room();
		r.setFinal();
		assertTrue(r.isFinal());
	}

}
