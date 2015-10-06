package pack1;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class EnemyTest {

	@Test
	public void blankConstructorSettersAndGettersTest() {
	Random r = new Random();
	int h;
	int p;
	int s;
		for(int i = 0; i < 2000000; i++){
			Enemy e = new Enemy();
			assertTrue(e.getHealth() == 1);
			assertTrue(e.getPower() == 1);
			assertTrue(e.getSpeed() == 1);
			
			h = r.nextInt();
			p = r.nextInt();
			s = r.nextInt();
			
			e.setHealth(h);
			e.setPower(p);
			e.setSpeed(s);
			
			assertTrue(h == e.getHealth());
			assertTrue(p == e.getPower());
			assertTrue(s == e.getSpeed());
			
		}
	}
	
	@Test
	public void parameterConstructor(){
		
		Random r = new Random();
		int h;
		int p;
		int s;
		for(int i = 0; i < 2000000; i++){

			h = r.nextInt();
			p = r.nextInt();
			s = r.nextInt();
			
			Enemy e = new Enemy(h, p, s);

			assertTrue(h == e.getHealth());
			assertTrue(p == e.getPower());
			assertTrue(s == e.getSpeed());
			
		}
		
	}

}
