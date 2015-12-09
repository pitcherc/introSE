package pack1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void properConstructions(){
		Player p = new Player();
		assertTrue(p.getHealth() == p.getMax());
		assertTrue(p.getLevel() == 1);
		assertTrue(p.getPotions() == 4);
		assertTrue(p.getPos().getX() == 0);
		assertTrue(p.getPos().getY() == 0);
		assertTrue(p.getPower() > 0);
		assertTrue(p.getPack().size() == 3);
	}
	
	@Test
	public void testGetHealth(){
		Player p = new Player();
		assertTrue(p.getHealth() == p.getMax());
	}
	
	@Test
	public void testGetLevel(){
		Player p = new Player();
		assertTrue(p.getLevel() == 1);
	}
	
	@Test
	public void testGetPotions(){
		Player p = new Player();
		assertTrue(p.getPotions() == 4);
	}
	
	@Test
	public void testGetPosX(){
		Player p = new Player();
		assertTrue(p.getPos().getX() == 0);
	}
	
	@Test
	public void testGetPosY(){
		Player p = new Player();
		assertTrue(p.getPos().getY()==0);
	}
	
	@Test
	public void testGetPower(){
		Player p = new Player();
		assertTrue(p.getPower() > 0);
	}
	
	@Test
	public void testGetPack(){
		Player p = new Player();
		assertTrue(p.getPack().size()==3);
	}
	
	@Test
	public void testMove(){
		Player p = new Player();
		assertTrue(p.getPos().getX() == 0);
		assertTrue(p.getPos().getY() == 0);

		p.move('u');

		assertTrue(p.getPos().getX() == 1);
		assertTrue(p.getPos().getY() == 0);

		p.move('r');

		assertTrue(p.getPos().getX() == 1);
		assertTrue(p.getPos().getY() == 1);

		p.move('d');

		assertTrue(p.getPos().getX() == 0);
		assertTrue(p.getPos().getY() == 1);

		p.move('l');

		assertTrue(p.getPos().getX() == 0);
		assertTrue(p.getPos().getY() == 0);
	}

	@Test
	public void testUsePotion(){
		Player p = new Player();

		assertTrue(p.getPotions() == 4);

		p.usePotion();

		assertTrue(p.getPotions() == 3);

		p.usePotion();

		assertTrue(p.getPotions() == 2);

		p.usePotion();

		assertTrue(p.getPotions() == 1);

		p.usePotion();
		
		for(int i = 0; i < 2000000000; i++){
			p .usePotion();
			assertTrue(p.getPotions() == 0);
		}


	}
	
	@Test
	public void testLevelUp(){
		
		Player p = new Player();
	
		int pasth = p.getHealth();
		int pastp = p.getPower();
		
		for(int i = 0; i < 1000000; i++){
			p.levelUp();
			assertTrue(pasth < p.getHealth());
			assertTrue(pastp < p.getPower());
			pasth = p.getHealth();
			pastp = p.getPower();
			assertTrue( p.getLevel() == i + 2);
		}
		
	}
	
//	@Test
//	public void damageTest(){
//		
//		Player p = new Player();
//		int damage = 1;
//		
//		for(int i = 0 ; i < 20 ; i++){
//			p.take(damage);
//			assertTrue(p.getHealth() == p.getMax() - (i+ 1));
//		}
//		
//		assertTrue(p.getHealth() == 0);
//		
//	}
}
