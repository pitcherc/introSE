package pack1;

public class Equiptment {
	private int health;
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

	private int power;
	private int speed;

	Equiptment(int h, int p, int s){
		health = h;
		power=p;
		speed = s;
	}
}
