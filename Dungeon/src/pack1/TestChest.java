package package1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestChest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testConstructor(){
		Chest test = new Chest();
		assertTrue(test.items.size() == 30);
	}
	
	@Test
	public void testItemGenerator(){
		Chest test = new Chest();
		
		for(int i = 0; i<30; ++i){
			assertTrue(test.generateItem(0) instanceof Equiptment);
		}
		
		for(int i = 0; i<30; ++i){
			assertTrue(test.generateItem(1) instanceof Equiptment);
		}
		
		for(int i = 0; i<30; ++i){
			assertTrue(test.generateItem(2) instanceof Equiptment);
		}
	}
	
	@Test
	public void testRandItem(){
		Chest test = new Chest();
		
		for(int i =0; i<100; ++i){
			assertTrue(test.open() instanceof Equiptment);
		}
	}
	
	

}
