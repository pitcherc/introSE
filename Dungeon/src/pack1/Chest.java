package pack1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Chest implements Serializable{

	private static final long serialVersionUID = 2330291883417118995L;
	
	ArrayList<Equiptment> items = new ArrayList();

	Random r;

	Chest(){

		items = new ArrayList<Equiptment>();
		//0 health //1 power // 0 = sword // desc
		                     // 1 = armor
							 // 2 = shield
	 items.add(new Equiptment(0,1,0, "a simeple sowrd "));
		//item instantiation // 30 to start
		r = new Random();
	}
	
	
	public Equiptment open(){
			
			return items.get(r.nextInt(items.size()));
	}

}