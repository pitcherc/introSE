package pack1;

import java.io.Serializable;

public class Item implements Serializable{
	
	private static final long serialVersionUID = 3200475997504780898L;

	private String name; 
	
	private int health;
	
	private int speed;
	
	private int power;
	
	private int duration;

	Item(String n, int h, int s, int p, int d){
		
		name = n;
		
		health = h;
		
		speed = s;
		
		power = p;
		
		duration = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	
}
