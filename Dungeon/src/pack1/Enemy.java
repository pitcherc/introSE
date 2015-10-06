package pack1;

import java.io.Serializable;
import java.util.Random;

public class Enemy implements Serializable{

	private static final long serialVersionUID = -4698677585314996195L;

	private int health;
	private int power;
	private int speed;
	private Boolean isPowered;
	private String message;
	private Random r;
	
	Enemy(){
		this.health = 1;
		this.power = 1;
		this.speed = 1;
		isPowered = false;
		message = "";
		r = new Random();
	}
	
	Enemy(int h, int p, int s){
		this.health = h;
		this.power = p;
		this.speed = s;
		isPowered = false;
		message = "";
		r = new Random();
	}
	
	public int attack(){
		return power + r.nextInt(3);		
	}
	
	public void take(int damage){
		health -= damage;
	}

	public String getMessage(){
		return message;
	}	
	
	public Boolean getIsPowered() {
		return isPowered;
	}
	public void setIsPowered(Boolean isPowered) {
		this.isPowered = isPowered;
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