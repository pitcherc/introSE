package pack1;

public class Position {
 int x;
 int y;
 
  Position(int xCoordinate,int yCoordinate){
	  x = xCoordinate;
	  y = yCoordinate;
  }
  public void setX(int newX){
	  x = newX;
  }
  
  public void setY(int newY){
	  y = newY;
  }
  
  public int getx(){
	return x;  
  }
  
  public int getY(){
  return y;
  }
}
