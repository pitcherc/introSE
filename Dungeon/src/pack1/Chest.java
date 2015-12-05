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
		//weapons
	 items.add(new Equiptment(0,1,0, "a paper clip from the office down the hallway"));
	 items.add(new Equiptment(0,10,0, "the Ulitmate God Sword"));
	 items.add(new Equiptment(0,3,0, "the Scroog's cane"));
	 items.add(new Equiptment(0,5,0, "an electric batton"));
	 items.add(new Equiptment(0,2,0, "a pencil from \"The Dark Knight Rises\" TaDa"));
	 items.add(new Equiptment(0,2,0, "a bowling pin"));
	 items.add(new Equiptment(0,3,0, "a potted plant"));
	 items.add(new Equiptment(0,4,0, "a simple sword"));
	 items.add(new Equiptment(0,4,0, "a barbwire whip"));
	 items.add(new Equiptment(0,7,0, "a power fist from Fallout"));
	 items.add(new Equiptment(0,0,2, "old lady denchers"));
	 items.add(new Equiptment(0,1,1, "a ceiling fan blade"));
	 //shields
	 items.add(new Equiptment(10,0,2, "a paper plate"));
	 items.add(new Equiptment(1000,0,2, "a Ulitmate God Shield"));
	 items.add(new Equiptment(100,0,2, "a simple shield"));
	 items.add(new Equiptment(160,0,2, "a rusted shield"));
	 items.add(new Equiptment(200,0,2, "a trashcan lid from the back alley"));
	 items.add(new Equiptment(400,0,2, "an overshield"));
	 items.add(new Equiptment(140,0,2, "a woven papyrus shield straight out of Eygpt"));
	 items.add(new Equiptment(120,0,2, "a frisbee"));
	 items.add(new Equiptment(180,0,2, "a pane of glass from your local hardware store"));
	 //armor
	 items.add(new Equiptment(10,1,1, "simple armor"));
	 items.add(new Equiptment(600,7,1, "Completely Ridiculous Ultimate God Power Armor"));
	 items.add(new Equiptment(90,2,1, "a rain coat from Good Will"));
	 items.add(new Equiptment(120,2,1, "chainmail"));
	 items.add(new Equiptment(200,3,1, "iron armor"));
	 items.add(new Equiptment(400,3,1, "diamond armor from Zales"));
	 items.add(new Equiptment(150,2,1, "leather armor from the local dairy farm"));
	 items.add(new Equiptment(70,5,1, "chest hair"));
	 items.add(new Equiptment(100,2,1, "a trashcan chest plate"));
		//item instantiation // 30 to start
		r = new Random();
	}
	
	
	public Equiptment open(int type){

		if(type == 0){
			return items.get(r.nextInt(12));
		}
		else if(type == 0){
			return items.get(r.nextInt(10) + 12);
		}
		else {
			return items.get(r.nextInt(12) + 22);
		}
	}
}