package pack1;

public class Weapon extends Item {
	private int power;
	
	public Weapon(int power){
		this.power = power;
	}
	
	public int getPower(){
		return power;
	}
	
	public void setPower(int power){
		this.power = power;
		return;
	}
}
