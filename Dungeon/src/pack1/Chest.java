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
		
		//item instantiation // 30 to start
		r = new Random();
	}
	
	
	public Equiptment open(){
			
			return items.get(r.nextInt(items.size()));
	}

}