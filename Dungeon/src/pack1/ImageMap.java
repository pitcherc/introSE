package package1;

import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**********************************************************************
 * ImageMap class is designed to return a grid object. That represents
 * the game map. Then using other methods within the class update 
 * certain positions within the imgArray. 
 * @author Benjamin J. Benson
 **********************************************************************/
public class ImageMap {

	private Room[][] rooms;

	ImageMap(Room[][] pEng){
		rooms = pEng;
	}

	/******************************************************************
	 * Creates a game map based on the game engine passed in.
	 * @param eng
	 * The game engine it's basing the pictures on .
	 * @return
	 * A g
	 *******************************************************************/
	public Node updateMap(Player player){
		//don't do anything if the game engine is null.
		if(rooms == null){return null;}

		GridPane grid = new GridPane();
		File f = new File("/Users/ben/Desktop/Images/enemy.png");
//		File f = new File("enemy.png");
		File f2 = new File("/Users/ben/Desktop/Images/blank.png");
//		File f2 = new File("blank.png");

//		File f3 = new File("player.png");
		File f3 = new File("/Users/ben/Desktop/Images/player.png");
//		File f4 = new File("visited.jpg");
		File f4 = new File("/Users/ben/Desktop/Images/visited.jpg");
		
		File f5 = new File("/Users/ben/Desktop/Images/chest.png");
		
		File f6 = new File("/Users/ben/Desktop/Images/skull.png");

		for(int i = 0; i<rooms.length; ++i){
			for(int j = 0; j<rooms[0].length; ++j){

				//Jank kinda work around to get an image loaded in from a file.
				Image monster = new Image(f.toURI().toString());
				ImageView mImageView = new ImageView(monster);

				Image blank = new Image(f2.toURI().toString());
				ImageView imgViewBlank = new ImageView(blank);

				Image playerimg = new Image(f3.toURI().toString());
				ImageView imgViewPlayer = new ImageView(playerimg);

				Image visited  = new Image(f4.toURI().toString());
				ImageView imgVisited = new ImageView(visited);
				
				Image chest = new Image(f5.toURI().toString());
				ImageView imgViewChest = new ImageView(chest);
				
				Image boss = new Image(f6.toURI().toString());
				ImageView imgViewBoss = new ImageView(boss);

				//some workings for the images
				imgViewBlank.setFitHeight(50);
				imgViewBlank.setPreserveRatio(true);
				imgViewBlank.setSmooth(true);
				imgViewBlank.setCache(true);        

				mImageView.setFitHeight(50);
				mImageView.setPreserveRatio(true);
				mImageView.setSmooth(true);
				mImageView.setCache(true);

				imgViewPlayer.setFitHeight(50);
				imgViewPlayer.setPreserveRatio(true);
				imgViewPlayer.setSmooth(true);
				imgViewPlayer.setCache(true);

				imgVisited.setFitHeight(50);
				imgVisited.setPreserveRatio(true);
				imgVisited.setSmooth(true);
				imgVisited.setCache(true);
				
				imgViewChest.setFitHeight(50);
				imgViewChest.setPreserveRatio(true);
				imgViewChest.setSmooth(true);
				imgViewChest.setCache(true);
				
				imgViewBoss.setFitHeight(50);
				imgViewBoss.setPreserveRatio(true);
				imgViewBoss.setSmooth(true);
				imgViewBoss.setCache(true);
				
				if(rooms[i][j].isFinal()==true){
					grid.getChildren().add(imgViewBoss);
					GridPane.setConstraints(imgViewBoss, j,i);
				}
				
				if(rooms[i][j].hasChest()){
					grid.getChildren().add(imgViewChest);
					GridPane.setConstraints(imgViewChest, j, i);
				}
				
				//change the image at that location to something not visited.
				else if(rooms[i][j].isVisited() == false ){
					grid.getChildren().add(imgViewBlank);
					GridPane.setConstraints(imgViewBlank, j, i);
				}
				else if(rooms[i][j].isOpened()){
					grid.getChildren().add(imgViewBlank);
					GridPane.setConstraints(imgViewBlank, j, i);
				}
				//for the monster image 
				else if(rooms[i][j].isVisited()==true && rooms[i][j].getEnemy() != null){
					grid.getChildren().add(mImageView);
					GridPane.setConstraints(mImageView, j, i);
				}
				
				//for the player object.
				else if(player.getPos().equals(new Position(i,j)) == 1){
					grid.getChildren().add(imgViewPlayer);
					GridPane.setConstraints(imgViewPlayer,j,i);
				}
				
				//case for the player not being at that position, and he's already visited that position
				else{// if(rooms[i][j].isVisited() && i != player.getPos().getY() && j != player.getPos().getX() ){
					grid.getChildren().add(imgVisited);
					
					GridPane.setConstraints(imgVisited, j, i);
				}
				
				
			}
		}
		
		
		grid.setAlignment(Pos.CENTER);
		return grid;
	}


	void setRooms(Room[][] pRoom){
		rooms = pRoom;
	}
}
