package pack1;

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
 *
 *********************************************************************/
public class ImageMap {

	/**This is for the image array of object.**/
	private ImageView[][] imgArray;

	private Engine eng;


	ImageMap(Engine pEng){
		this.eng = pEng;
		imgArray = new ImageView[8][8];
	}

	/******************************************************************
	 * Creates a game map based on the game engine passed in.
	 * @param eng
	 * The game engine it's basing the pictures on .
	 * @return
	 * A g
	 *******************************************************************/
	public Node updateMap(){
		//don't do anything if the game engine is null.
		if(eng == null){return null;}

		GridPane grid = new GridPane();
		File f = new File("/Users/ben/Desktop/Images/enemy.png");
		File f2 = new File("/Users/ben/Desktop/Images/blank.png");

		for(int i = 0; i<eng.getFloors().length; ++i){
			for(int j = 0; j<eng.getFloors()[0].length; ++j){

				//Jank kinda work around to get an image loaded in from a file.
				Image monster = new Image(f.toURI().toString());
				ImageView mImageView = new ImageView(monster);

				Image blank = new Image(f2.toURI().toString());
				ImageView imgViewBlank = new ImageView(blank);

				//some workings for the images
				imgViewBlank.setFitHeight(50);
				imgViewBlank.setPreserveRatio(true);
				imgViewBlank.setSmooth(true);
				imgViewBlank.setCache(true);        

				mImageView.setFitHeight(50);
				mImageView.setPreserveRatio(true);
				mImageView.setSmooth(true);
				mImageView.setCache(true);

				//add the appropriate image onto that position.
				if(eng.getFloors()[i][j].isVisited() == false ){
					grid.getChildren().add(imgViewBlank);
					GridPane.setConstraints(imgViewBlank, j, i);
				}
				else if(eng.getFloors()[i][j].isVisited() == true && eng.getFloors()[i][j].getEnemy() != null){
					grid.getChildren().add(mImageView);
					GridPane.setConstraints(mImageView, j, i);
				}
			}
		}
		grid.setAlignment(Pos.CENTER);
		return grid;
	}
}
