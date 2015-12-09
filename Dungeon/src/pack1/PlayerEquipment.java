package package1;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PlayerEquipment {

	private Player player;

	PlayerEquipment(Player player){
		this.player = player;
	}

	void setPlayer(Player player){
		this.player = player;
	}

	public GridPane setEquipScreen(Player player){
		//update the player before doing anything else.
		this.player = player;

		File swordfile = new File("/Users/ben/Desktop/Images/scimitar.jpg");
		Image swordimage = new Image(swordfile.toURI().toString());
		ImageView swordimgview = new ImageView(swordimage);

		swordimgview.setFitHeight(80);
		swordimgview.setPreserveRatio(true);
		swordimgview.setSmooth(true);
		swordimgview.setCache(true); 

		//Set up a series of blank image files.
		File blankfile = new File("/Users/ben/Desktop/Images/blank.png");
		Image blankimage = new Image(blankfile.toURI().toString());
		ImageView blankimageview = new ImageView(blankimage);

		blankimageview.setFitHeight(80);
		blankimageview.setPreserveRatio(true);
		blankimageview.setSmooth(true);
		blankimageview.setCache(true); 

		//second blank img
		File blankfile1 = new File("/Users/ben/Desktop/Images/blank.png");
		Image blankimage1 = new Image(blankfile1.toURI().toString());
		ImageView blankimageview1 = new ImageView(blankimage1);

		blankimageview1.setFitHeight(80);
		blankimageview1.setPreserveRatio(true);
		blankimageview1.setSmooth(true);
		blankimageview1.setCache(true); 

		//third blank img
		File blankfile2 = new File("/Users/ben/Desktop/Images/blank.png");
		Image blankimage2 = new Image(blankfile2.toURI().toString());
		ImageView blankimageview2 = new ImageView(blankimage2);

		blankimageview2.setFitHeight(80);
		blankimageview2.setPreserveRatio(true);
		blankimageview2.setSmooth(true);
		blankimageview2.setCache(true); 

		//fourth blank img
		File blankfile3 = new File("/Users/ben/Desktop/Images/blank.png");
		Image blankimage3 = new Image(blankfile3.toURI().toString());
		ImageView blankimageview3 = new ImageView(blankimage3);

		blankimageview3.setFitHeight(80);
		blankimageview3.setPreserveRatio(true);
		blankimageview3.setSmooth(true);
		blankimageview3.setCache(true); 

		//fifth blank img
		File blankfile4 = new File("/Users/ben/Desktop/Images/blank.png");
		Image blankimage4 = new Image(blankfile4.toURI().toString());
		ImageView blankimageview4 = new ImageView(blankimage4);

		blankimageview4.setFitHeight(80);
		blankimageview4.setPreserveRatio(true);
		blankimageview4.setSmooth(true);
		blankimageview4.setCache(true); 

		//6th blank img
		File blankfile5 = new File("/Users/ben/Desktop/Images/blank.png");
		Image blankimage5 = new Image(blankfile5.toURI().toString());
		ImageView blankimageview5 = new ImageView(blankimage5);

		blankimageview5.setFitHeight(80);
		blankimageview5.setPreserveRatio(true);
		blankimageview5.setSmooth(true);
		blankimageview5.setCache(true);

		//7th blank img
		File blankfile6 = new File("/Users/ben/Desktop/Images/blank.png");
		Image blankimage6 = new Image(blankfile5.toURI().toString());
		ImageView blankimageview6 = new ImageView(blankimage5);

		blankimageview6.setFitHeight(80);
		blankimageview6.setPreserveRatio(true);
		blankimageview6.setSmooth(true);
		blankimageview6.setCache(true);

		//8th blank img
		File blankfile7 = new File("/Users/ben/Desktop/Images/blank.png");
		Image blankimage7 = new Image(blankfile5.toURI().toString());
		ImageView blankimageview7 = new ImageView(blankimage5);

		blankimageview7.setFitHeight(80);
		blankimageview7.setPreserveRatio(true);
		blankimageview7.setSmooth(true);
		blankimageview7.setCache(true);

		//9th blank img
		File blankfile8 = new File("/Users/ben/Desktop/Images/blank.png");
		Image blankimage8 = new Image(blankfile5.toURI().toString());
		ImageView blankimageview8 = new ImageView(blankimage5);

		blankimageview8.setFitHeight(80);
		blankimageview8.setPreserveRatio(true);
		blankimageview8.setSmooth(true);
		blankimageview8.setCache(true);
		
		
		File helmfile = new File("/Users/ben/Desktop/Images/helmet.png");
		Image helmimg = new Image(helmfile.toURI().toString());
		ImageView helmimgview = new ImageView(helmimg);

		helmimgview.setFitHeight(50);
		helmimgview.setPreserveRatio(true);
		helmimgview.setSmooth(true);
		helmimgview.setCache(true);
		
		File shieldfile =  new File("/Users/ben/Desktop/Images/shield.png");
		Image shieldig = new Image(shieldfile.toURI().toString());
		ImageView shieldimgview = new ImageView(shieldig);
		
		shieldimgview.setFitHeight(50);
		shieldimgview.setPreserveRatio(true);
		shieldimgview.setSmooth(true);
		shieldimgview.setCache(true);

		GridPane panel = new GridPane();

		panel.getChildren().addAll( 
				blankimageview,  
				blankimageview1, 
				blankimageview2, 
				blankimageview4,
				blankimageview5,
				blankimageview6
		);

		//the top right of the equip screen.
		GridPane.setConstraints(blankimageview, 0, 0);

		//the top middle of the equip screen.
		if(player.getArmor() != null){
			panel.getChildren().add(helmimgview);
			GridPane.setConstraints(helmimgview, 1 , 0);
		}else{
			panel.getChildren().add(blankimageview7);
			GridPane.setConstraints(blankimageview7, 1 , 0);
		}

		//the top right of the equip screen.
		GridPane.setConstraints(blankimageview1, 2 ,0);

		//the middle of the equip screen.
		GridPane.setConstraints(blankimageview2,1,1);

		
		//the middle left of the equip screen.
		if(player.getShield() != null){
			panel.getChildren().add(shieldimgview);
			GridPane.setConstraints(shieldimgview, 0,1);
		}else{
			panel.getChildren().add(blankimageview3);
			GridPane.setConstraints(blankimageview3,0,1);
		}

		//the middle right of the equip screen
		if(player.getSword() != null){
			panel.getChildren().add(swordimgview);
			GridPane.setConstraints(swordimgview, 2,1);
		}else{
			panel.getChildren().add(blankimageview8);
			GridPane.setConstraints(blankimageview8, 2,1);
		}
		

		//the bottom left of the equip screen
		GridPane.setConstraints(blankimageview4, 0, 2);

		//the bottom middle of the equip screen.
		GridPane.setConstraints(blankimageview5, 1, 2);

		//the bottom right of the equip screen
		GridPane.setConstraints(blankimageview6, 2,2);
		panel.setAlignment(Pos.CENTER);
		return panel;
	}
}
