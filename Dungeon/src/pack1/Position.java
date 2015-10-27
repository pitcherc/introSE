package pack1;

import java.io.Serializable;

public class Position implements Serializable{
	
	private static final long serialVersionUID = 5735635940789019240L;
	
	int x;
	
	int y;

	Position(int xCoordinate,int yCoordinate){
		x = xCoordinate;
		y = yCoordinate;
	}
	public void setX(int newX){
		x = newX;
	}
	
	public int equals(Position other){
		
		if(other.x == this.x && other.y == this.y)
		return 1;
		else
		return 0;
				
				
	}

	public void setY(int newY){
		y = newY;
	}

	public int getX(){
		return x;  
	}

	public int getY(){
		return y;
	}
	
	public String toString(){
		return "x: "+getX()+" y: "+getY();
	}
}
