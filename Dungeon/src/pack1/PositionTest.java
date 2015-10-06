package pack1;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class PositionTest {

	@Test
	public void positionTest(){
		Random r = new Random();
		for(int i = 0; i < 10000 ; i++){
			for(int j = 0; j < 10000; j++){
				Position p = new Position(i,j);
				assertTrue( p.getX() == i);
				assertTrue( p.getY() == j);
				assertTrue( p.toString().equals(
						"x: " + i + " y: " + j));
				int z = r.nextInt();
				p.setX(z);
				int y = r.nextInt();
				p.setY(y);
				assertTrue(p.getX() == z);
				assertTrue(p.getY() == y);
				assertTrue( p.toString().equals(
						"x: " + z + " y: " + y));
				
				
			}
		}
	}
	
}
