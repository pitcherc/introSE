package pack1;

public abstract class Enemy {
	private int health;
	private int power;
	private int speed;
	private Boolean isPowered;
	private String message;

	Enemy(int health, int power, int speed){
		this.health = health;
		this.power = power;
		this.speed = speed;
		isPowered = false;
		message = "";
	}
	public abstract void attack();

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