package package1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Player implements Serializable{

	private static final long serialVersionUID = -9121935087680792111L;

	private int level;
		
	private int health;

	private int curMaxHealth;
	
	private int power;

	private int speed;

	private Equiptment equip;
	
	private Position pos;

	private int potions;
	
	private ArrayList<Item> items;
	
	private boolean hasWeapon;
	
	private boolean hasArmor;
	
	Equiptment sword;
	Equiptment shield;
	Equiptment armor;
	
	Random r;

	Player(){
		level = 1;
		potions = 4;
		curMaxHealth = 1000;
		health = curMaxHealth;
		power = 30;
		speed = 2;
		equip = null;
		r = new Random();
		pos = new Position(0,0);
		items = new ArrayList<Item>();
		//modify these values later...
		configItems();
		hasWeapon = false;
		hasArmor = false;
		sword = null;
		shield = null;
		armor = null;
	}



	private void configItems() {
		items.add(new Item("Weak Sword", 1,1,1,11));
		items.add(new Item("Small Potion",1,1,1,5));
		items.add(new Item("Bannanas",1,1,1,11));
	}
	
	
	
	void usePotion(){
		if(potions > 0){
			health = curMaxHealth;
			potions--;		}
	}

	void levelUp(){

		curMaxHealth += 2 + r.nextInt(3);
		power += 1 + r.nextInt(2);
		speed += 2 + r.nextInt(2);
		health = curMaxHealth;
		level++;
	}

	void equipt(Equiptment e){
		boolean[] type = e.type;
		if(type[0] == true){
			if(sword == null){
				sword = e;
				power += e.getPower();
			}
			else{
				power -= sword.getPower();
				sword = e;
				power += e.getPower();	
			}
		}
		else if(type[1] == true){
			if(armor == null){
				armor = e;
				power += e.getPower();
				curMaxHealth += e.getHealth();
				health += e.getHealth();
			}
			else{
				power -= armor.getPower();
				curMaxHealth -= armor.getHealth();
				health -= armor.getHealth();
				armor = e;
				power += e.getPower();
				curMaxHealth += e.getHealth();
				health += e.getHealth();	
			}
		}
		else if(type[2] == true){
			if(shield == null){
				shield = e;
				curMaxHealth += e.getHealth();
				health += e.getHealth();
			}
			else{
				curMaxHealth -= shield.getHealth();
				health -= shield.getHealth();
				sword = e;
				curMaxHealth += e.getHealth();	
				health += e.getHealth();
			}
		}
	}
	
	public Equiptment getSword() {
		return sword;
	}



	public Equiptment getShield() {
		return shield;
	}



	public Equiptment getArmor() {
		return armor;
	}



	public void setSword(Equiptment sword) {
		this.sword = sword;
	}



	public void setShield(Equiptment shield) {
		this.shield = shield;
	}



	public void setArmor(Equiptment armor) {
		this.armor = armor;
	}



	public void take(int damage){
		health -= damage;
	}
	
	public int attack(){
		return (int)(((double)(power)) * (1 + (((double)(r.nextInt(5)+5)) / 10)));
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
	
	public void addPotions(int add){
		potions += add;
	}
	
	public int getPotions(){
		return potions;
	}
	
	public int getMax(){
		return curMaxHealth;
	}
	
	public Position getPos(){
		return pos;	
	}
	
	public void setLevel(int lev){
		level = lev;
	}
	
	public ArrayList<Item> getPack(){
		return items;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void move(char udrl){
		int x = pos.getX();
		int y = pos.getY();
		if (udrl == 'u'){
			pos.setX(x+1);
		}	
		if (udrl == 'd'){
			pos.setX(x-1);
		}
		if (udrl == 'r'){
			pos.setY(y+1);
		}
		if (udrl == 'l'){
			pos.setY(y-1);
		}
	}
}
