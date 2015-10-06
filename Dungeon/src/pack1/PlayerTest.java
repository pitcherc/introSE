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
	
	@Test
	public void testEquipt(){
		Player p = new Player();
		Equiptment e = new Equiptment(30,456,11);
		Equiptment e2 = new Equiptment(46545,76543,45654);
		
		int ph = p.getMax();
		int pp = p.getPower();
		int ps = p.getSpeed();
		
		p.equipt(e);
		
		assertTrue(ph == p.getMax() - e.getHealth());
		assertTrue(pp == p.getPower() - e.getPower());
		assertTrue(ps == p.getSpeed() - e.getSpeed());
		
		p.equipt(e2);
		
		assertTrue(ph == p.getMax() - e.getHealth());
		assertTrue(pp == p.getPower() - e.getPower());
		assertTrue(ps == p.getSpeed() - e.getSpeed());
		
	}
	
	@Test
	public void damageTest(){
		
		Player p = new Player();
		int damage = 1;
		
		for(int i = 0 ; i < 20 ; i++){
			p.take(damage);
			assertTrue(p.getHealth() == p.getMax() - (i+ 1));
		}
		
		assertTrue(p.getHealth() == 0);
		
	}
}
