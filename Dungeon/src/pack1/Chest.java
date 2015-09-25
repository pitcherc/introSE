package pack1;

import java.util.Random;

public class Chest {

	Equiptment[][] items;

	Random r;

	Chest(){

		items = new Equiptment[10][3];
		//item instantiation // 30 to start
		r = new Random();
	}

	public Equiptment open(int floor){

		return items[floor - 1][ r.nextInt(3)];

	}

}