package package1;

import java.io.Serializable;

public class Equiptment implements Serializable{
	
	private static final long serialVersionUID = 7380859524928144366L;
	
	private int health;
	private int power;
	private int speed;
	String name;
	boolean[] type;
	
	public Equiptment(int h, int p, int ptype, String n){
		health =h;
		power = p;
		name = n;
		type = new boolean[3];
		
		for(int i = 0 ; i<3; i++){
			type[i] = false;
		}
		
		//sword
		if(ptype == 0){
			type[0] = true;
		}
		//amor
		else if(ptype == 1){
			type[1] = true;
		}
		//shield
		else if(ptype == 2){
			type[2] = true;
		}
		
	}
	
	public boolean[] getType(){
		return type;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
