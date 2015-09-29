package pack1;

import java.io.Serializable;
import java.util.Random;

public class Chest implements Serializable{

	private static final long serialVersionUID = 2330291883417118995L;

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