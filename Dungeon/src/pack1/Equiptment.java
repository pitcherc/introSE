package pack1;

import java.io.Serializable;

public class Equiptment implements Serializable{
	
	private static final long serialVersionUID = 7380859524928144366L;
	
	private int health;
	private int power;
	private int speed;
	String name;
	boolean[] type = new boolean[3];
	
	public Equiptment(int h, int p, int ptype, String n){
		health =h;
		power = p;
		name = n;
		
		for(int i = 0 ; i<3; i++){
			type[i] = false;
		}
		
		if(ptype == 0){
			type[0] = true;
		}
		else if(ptype == 1){
			type[1] = true;
		}
		else if(ptype == 2){
			type[0] = true;
		}
		
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