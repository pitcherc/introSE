
package pack1;

import java.util.Random;

public class Player {

	private int health;

	private int power;

	private int speed;

	private Equiptment equip;

	Random r;

	Player(){
		health = 10;
		power = 5;
		speed =2;
		equip = null;
		r = new Random();
	}

	void levelUp(){

		health += 2 + r.nextInt(3);
		power += 1 + r.nextInt(2);
		speed += 2 + r.nextInt(2);
	}

	void equipt(Equiptment e){
		if(equip != null){
			health -= equip.getHealth();
			power -= equip.getPower();
			speed -= equip.getSpeed();
		}
		equip = e;
		health += equip.getHealth();
		power += equip.getPower();
		speed += equip.getSpeed();

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


