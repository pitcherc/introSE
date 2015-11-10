package pack1;

import java.io.File;
import java.text.DecimalFormat;
import javafx.application.Application;

import javafx.geometry.Pos;

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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**********************************************************************
 * @author ben
 *********************************************************************/
public class MainGUI extends Application{


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

	/**Another useful button**/
	private Button centerButton;

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

	/**A boolean to determine if a player can move at a given moment**/
	private boolean movable;

	/**Label for the player's current position**/
	Label playerLabel;

	ImageMap centerMap;

	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {

		Engine game = new Engine();
		BorderPane centerlayout = new BorderPane();
		centerMap = new ImageMap(game.getFloors());

		movable = true;
		/**This won't be nessecary once we have the game object up
		 * Hence this is just a test of the array list inventory display
		 **/
		//        		game = new ArrayList<String>();
		//        		game.add("Scimitar");
		//        		game.add("Cake");
		//        		game.add("Bannas");
		//        		game.add("Keys");
		//        		game.add("Long Sword");

		BorderPane outmostborder = new BorderPane();
		mnuBar = new MenuBar();
		file = new Menu("file");
		quit = new MenuItem("Quit");
		save = new MenuItem("Save");
		load = new MenuItem("Load");
		quit.setOnAction(action ->QuitOption.quitWindow("Are you sure?"));

		load.setOnAction(action -> {
			loadFileChooser("Choose a File", window, game);
		});

		save.setOnAction(action -> {
			saveFileChooser("Save where?",window, game);
		});

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
		gameStatus = new TextArea("Game Status\n");
		gameStatus.setMaxHeight(250);
		gameStatus.setMaxWidth(300);

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
		upArrow.setOnAction(action ->{
			if(game.getGameStatus() != GmPn.IDLE){
				movable = false;
			}
			if(movable){
				movable = true;
				centerMap.setRooms(game.getFloors());
				gameStatus.appendText(game.move('u'));
				mHealth.setProgress(-1);
				centerlayout.setCenter(centerMap.updateMap(game.getPlayer()));
				playerLabel.setText("Player Location: "+game.getPlayer().getPos().toString());
			}
		});

		downArrow = new Button(""+(char)8595);
		downArrow.setMinSize(50, 50);
		downArrow.setOnAction(action ->{
			if(game.getGameStatus() != GmPn.IDLE){
				movable = false;
			}
			if(movable){
				movable = true;
				centerMap.setRooms(game.getFloors());
				gameStatus.appendText(game.move('d'));
				mHealth.setProgress(-1);
				centerlayout.setCenter(centerMap.updateMap(game.getPlayer()));
				playerLabel.setText("Player Location: "+game.getPlayer().getPos().toString());

			}
		});

		leftArrow = new Button(""+(char)8592);
		leftArrow.setMinSize(50, 50);
		leftArrow.setOnAction(action->{
			if(game.getGameStatus() != GmPn.IDLE){
				movable = false;
			}
			if(movable){
				movable = true;
				centerMap.setRooms(game.getFloors());
				gameStatus.appendText(game.move('l'));
				mHealth.setProgress(-1);
				centerlayout.setCenter(centerMap.updateMap(game.getPlayer()));
				playerLabel.setText("Player Location: "+game.getPlayer().getPos().toString());
			}
		});

		rightArrow = new Button(""+(char)8594);
		rightArrow.setMinSize(50, 50);
		rightArrow.setOnAction( action->{
			if(game.getGameStatus() != GmPn.IDLE){
				movable = false;
			}
			if(movable){
				movable = true;
				centerMap.setRooms(game.getFloors());
				gameStatus.appendText(game.move('r'));
				mHealth.setProgress(-1);
				centerlayout.setCenter(centerMap.updateMap(game.getPlayer()));
				playerLabel.setText("Player Location: "+game.getPlayer().getPos().toString());
			}
		});

		centerButton = new Button(""+(char)8482);
		centerButton.setMaxWidth(Double.MAX_VALUE);
		centerButton.setMaxHeight(Double.MAX_VALUE);
		centerButton.setOnAction(action ->{
			System.out.println("The button works.");
		});

		btnPanel.setAlignment(Pos.CENTER);

		btnPanel.getChildren().addAll(upArrow,leftArrow,rightArrow, downArrow,centerButton);
		GridPane.setConstraints(centerButton, 1, 1);
		GridPane.setConstraints(upArrow, 1, 0);
		GridPane.setConstraints(leftArrow, 0, 1);
		GridPane.setConstraints(rightArrow, 2, 1);
		GridPane.setConstraints(downArrow, 1, 2);

		//Setting up the Center Border Layout
		//Used for enemy image, and Buttons to control the game

		GridPane centerbuttonpanel = new GridPane();
		centerbuttonpanel.setVgap(25);
		centerbuttonpanel.setHgap(25);

		inventory = new Button("Inventory");
		inventory.setMinSize(100, 50);
		//		inventory.setOnAction(action -> Inventory.display("Inventory", game));
		centerbuttonpanel.getChildren().add(inventory);
		GridPane.setConstraints(inventory, 0,0);

		//Later change to the amount of potions remaining for the player
		potion = new Button("Potion(" + game.getPotions() + ")");
		potion.setMinSize(100, 50);
		potion.setOnAction(action -> {
			callPotion(game);
		});
		centerbuttonpanel.getChildren().add(potion);
		GridPane.setConstraints(potion, 1, 0);

		//Setting up the Level up Button
		powerup = new Button("Powa UP");
		powerup.setMinSize(100, 50);
		powerup.setOnAction(action -> System.out.println("LEVEL UP BRUH!"));
		centerbuttonpanel.getChildren().add(powerup);
		GridPane.setConstraints(powerup, 0, 1);

		//The attack Button, for stabbing things...
		attack = new Button("Attack");
		attack.setMinSize(100,50);
		attack.setOnAction(action -> {

			gameStatus.appendText(game.attack());
			pHealth.setProgress(((double)game.getPlayerHealth())/
					((double)game.getPlayerMaxHealth()));
			mHealth.setProgress(((double)game.getEnemy().getHealth())/
					((double)game.getEnemy().getMaxH()));

			if(game.getGameStatus() == GmPn.IDLE){
				movable = true;
			}
		});
		centerbuttonpanel.getChildren().add(attack);
		GridPane.setConstraints(attack, 1, 1);

		//Setting up the right layout for player health
		//Also used for monster health
		VBox leftlayout = new VBox(20);

		playerLabel = new Label("Player Location: "+game.getPlayer().getPos().toString());
		leftlayout.getChildren().add(playerLabel);

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

		centerlayout.setCenter(centerMap.updateMap(game.getPlayer()));

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

		Scene scene = new Scene(outmostborder,1200, 800);
		window.setScene(scene);
		window.show();
	}


	private void callPotion(Engine game){
		gameStatus.appendText(game.usePotion());
		mHealth.setProgress(((double)game.getEnemy().getHealth())/((double)game.getEnemy().getMaxH()));
		pHealth.setProgress(((double)game.getPlayerHealth())/((double)game.getPlayerMaxHealth()));
		DecimalFormat df = new DecimalFormat("##.##");
		pHealthLabel.setText("Player Health: %"+(
				df.format( ( (double)game.getPlayerHealth()*5) ) ) );
		potion.setText("potions(" + game.getPotions()+")");
	}

	/*****************************************************************************
	 * Sets up the file chooser for the user to load their game.
	 * @param pMessage
	 * The message displayed to the user
	 * @param pWindow
	 * The window we're dispalying to
	 * @param pGame
	 * The game object, so we can load the game in.
	 *****************************************************************************/
	private void loadFileChooser(String pMessage, Stage pWindow, Engine pGame){
		//create a file chooser
		FileChooser load = new FileChooser();
		load.setTitle(pMessage);
		//Change the .extension filter to be of type game.
		//when the game is saved it should be *.game
		load.setSelectedExtensionFilter(
				new FileChooser.ExtensionFilter("Game files (*.game)", "*.game"));
		File file = load.showOpenDialog(pWindow);
		//implement the load functionality later.
		if(file != null){
			pGame.loadGame(file.getAbsolutePath());
		}
	}

	/*****************************************************************************
	 * 
	 * @param pMessage
	 * @param pWindow
	 * @param pGame
	 *****************************************************************************/
	private void saveFileChooser(String pMessage, Stage pWindow, Engine pGame){
		FileChooser usrSelected = new FileChooser();
		usrSelected.setTitle(pMessage);
		File file = usrSelected.showSaveDialog(pWindow);

		if(file != null){
			pGame.saveGame(file.getAbsolutePath(), pGame);
		}else{
			//do nothing.
			return;
		}
		//come up with a save option for the game.
	}
}
