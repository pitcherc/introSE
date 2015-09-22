package package1;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**********************************************************************'
 * 
 * @author ben
 *
 */
public class MainGUI extends Application{
	
	/**The Game object**/
	private ArrayList<String> game;
	
	/**The top MenuBar**/
	private MenuBar mnuBar;
	
	/**The quit Menu Item**/
	private Menu file;
	
	/**Quit option**/
	private MenuItem quit;
	
	/**The save Menu Item**/
	private MenuItem save;
	
	/**The load Menu Item**/
	private MenuItem load;
	
	/**Map Image**/
	private Image map;
	
	/**Text area for Game status**/
	private TextArea gameStatus;
	
	/**Buttons for Navigation**/
	private Button upArrow;
	
	/**down arrow Button**/
	private Button downArrow;
	
	/**Right arrow button**/
	private Button rightArrow;
	
	/**left arrow button**/
	private Button leftArrow;
	
	/**Button for the Invertory Display**/
	private Button inventory;
	
	/**A button to heal up**/
	private Button potion;
	
	/**A button to power up**/
	private Button powerup;
	
	/**A button to attack**/
	private Button attack;
	
	/**Health Bar for the Player**/
	private ProgressBar pHealth;
	
	/**Health Bar for Monster Health**/
	private ProgressBar mHealth;
	
	/**Monster Image PlaceHolder**/
	private Image monsterImage;
	
	/**Status of the players Health**/
	private Label pHealthLabel;
	
	/**Status of the monster's health**/
	private Label mHealthLabel;
	
	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		
		/**This won't be nessecary once we have the game object up
		 * Hence this is just a test of the array list inventory display
		**/
		game = new ArrayList<String>();
		game.add("Scimitar");
		game.add("Cake");
		game.add("Bannas");
		game.add("Keys");
		game.add("Long Sword");
		
		BorderPane outmostborder = new BorderPane();
		mnuBar = new MenuBar();
		file = new Menu("file");
		quit = new MenuItem("Quit");
		save = new MenuItem("Save");
		load = new MenuItem("Load");
		quit.setOnAction(action ->QuitOption.quitWindow("are you sure?"));
		
		//Resets the default close operation of the window itself.
		window.setOnCloseRequest(event -> {
			event.consume();
			//Do something like save the game before you exit if they quit...
			/**Change the return type of quitWindow to boolean later**/
			QuitOption.quitWindow("Are you sure You Want To Quit?");
		});
		
		//Add the File menu option
		file.getItems().addAll(quit,save,load);
		//Add the menus to the menuBar
		mnuBar.getMenus().add(file);
		outmostborder.setTop(mnuBar);
		
		VBox rightLayout = new VBox(20);
		gameStatus = new TextArea("Game Status");
		gameStatus.setMaxHeight(250);
		gameStatus.setMaxWidth(200);
		
		map = new Image("http://www.cis.gvsu.edu/~nandigaj/Jagadeesh_Nandigam.jpg",100,0,false,false);
		ImageView view = new ImageView(map);
		
		rightLayout.getChildren().addAll(view, gameStatus);
		rightLayout.setCenterShape(true);
		rightLayout.setSpacing(50);
		rightLayout.setAlignment(Pos.CENTER);
		
		//The numbers within the Button constructor correspond
		//to ASCII values for up, down, left, right arrows
		GridPane btnPanel = new GridPane();
		upArrow = new Button(""+(char)8593);
		upArrow.setMinSize(50, 50);
		
		downArrow = new Button(""+(char)8595);
		downArrow.setMinSize(50, 50);
		
		leftArrow = new Button(""+(char)8592);
		leftArrow.setMinSize(50, 50);
		
		rightArrow = new Button(""+(char)8594);
		rightArrow.setMinSize(50, 50);
		btnPanel.setAlignment(Pos.CENTER);
		
		btnPanel.getChildren().addAll(upArrow,leftArrow,rightArrow, downArrow);
		GridPane.setConstraints(upArrow, 1, 0);
		GridPane.setConstraints(leftArrow, 0, 1);
		GridPane.setConstraints(rightArrow, 2, 1);
		GridPane.setConstraints(downArrow, 1, 2);
		
		//Setting up the Center Border Layout
		//Used for enemy image, and Buttons to control the game
		BorderPane centerlayout = new BorderPane();
		GridPane centerbuttonpanel = new GridPane();
		centerbuttonpanel.setVgap(25);
		centerbuttonpanel.setHgap(25);
		
		inventory = new Button("Inventory");
		inventory.setMinSize(100, 50);
		inventory.setOnAction(action -> Inventory.display("Inventory", game));
		centerbuttonpanel.getChildren().add(inventory);
		GridPane.setConstraints(inventory, 0,0);
		
		//Later change to the amount of potions remaining for the player
		potion = new Button("Potion");
		potion.setMinSize(100, 50);
		potion.setOnAction(action -> {
			pHealth.setProgress(pHealth.getProgress()+.1);
			DecimalFormat df = new DecimalFormat("##.##");
			pHealthLabel.setText("Player Health: %"+(df.format(pHealth.getProgress()*100)));
		});
		centerbuttonpanel.getChildren().add(potion);
		GridPane.setConstraints(potion, 1, 0);
		
		//Setting up the Level up Button
		powerup = new Button("Novacaine");
		powerup.setMinSize(100, 50);
		powerup.setOnAction(action -> System.out.println("LEVEL UP BRUH!"));
		centerbuttonpanel.getChildren().add(powerup);
		GridPane.setConstraints(powerup, 0, 1);
		
		//The attack Button, for stabbing things...
		attack = new Button("Attack");
		attack.setMinSize(100,50);
		attack.setOnAction(action -> System.out.println("You attacked."));
		centerbuttonpanel.getChildren().add(attack);
		GridPane.setConstraints(attack, 1, 1);
		
		//Setting up the right layout for player health
		//Also used for monster health
		VBox leftlayout = new VBox(20);
		
		pHealth = new ProgressBar(-.1);
		pHealth.setStyle("-fx-accent: green;");
		pHealth.setMinSize(150,50);
		pHealthLabel = new Label("Player Health: ");
		leftlayout.getChildren().addAll(pHealthLabel,pHealth);
		
		mHealth = new ProgressBar(-.1);
		mHealth.setStyle("-fx-accent: red;");
		mHealth.setMinSize(150, 50);
		mHealthLabel = new Label("Monster Health: ");
		leftlayout.getChildren().addAll(mHealthLabel,mHealth);
		leftlayout.setAlignment(Pos.CENTER_LEFT);
		
		monsterImage = new Image("http://paratime.ca/images/fantasy/dungeon-024.jpg",500,500,true,true);
		ImageView ivMonster = new ImageView(monsterImage);
		centerlayout.setCenter(ivMonster);
		
		centerlayout.setLeft(leftlayout);
		
		//center layout is the middle layout of the outermost border
		centerlayout.setBottom(centerbuttonpanel);
		//having an inner button panel is useful for centering the button beneath
		//an image
		centerbuttonpanel.setAlignment(Pos.BOTTOM_CENTER);
		//add the center layout manager to the outermost layout
		outmostborder.setCenter(centerlayout);
		
		rightLayout.getChildren().addAll(btnPanel);
		outmostborder.setRight(rightLayout);
		
		Scene scene = new Scene(outmostborder,900, 600);
		window.setScene(scene);
		window.show();
	}	
}
