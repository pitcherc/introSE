package pack1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.*;

public class QuitOption {
	
	public static void quitWindow(String message){
		//The outer Window you're opening
		Stage window = new Stage();
		//window.setTitle(message);
		window.initStyle(StageStyle.UNDECORATED);
		//tells the window that 
		window.initModality(Modality.APPLICATION_MODAL);
		//the layout of the pop-up
		
		Label label = new Label(message);
		Button quit = new Button("Quit");
		Button no = new Button("Continue");
		
		//allows the buttons to grow without bounds
		no.setMaxWidth(Double.MAX_VALUE);
		quit.setMaxWidth(Double.MAX_VALUE);
		BorderPane layout = new BorderPane();
		BorderPane layout2 = new BorderPane();
		layout2.setCenter(quit);
		
		//Lambda expression for the following button press
		quit.setOnAction(action -> System.exit(0));
		no.setOnAction(action ->window.close());
		//Add the Items to the layout
		layout.setTop(label);
		layout.setCenter(no);
		
		//ensures that the bottom layout is aligned the the center layout
		//in a super jank kinda way...
		layout.setBottom(layout2);
		
		//Will allow the scene to adjust to the new length of the window
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		window.show();
	}	
}
