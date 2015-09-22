package package1;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Inventory {
	
	private static String weapon;
	
	public static void display(String message, ArrayList<String> inventory){
		//Set up the window
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.initStyle(StageStyle.UNDECORATED);
		
		ListView<String> items = new ListView<String>();
		//Could be changed to multiple later, and add a method to handle it. 
		items.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		for(int i=0; i <inventory.size();i++){
			//add the inventory to the ListView.
			items.getItems().add(inventory.get(i));
		}
		
		BorderPane layout = new BorderPane();
		BorderPane bottomlayout = new BorderPane();
		Label display = new Label(message);
		Button submit = new Button("Submit");
		Button cancel = new Button("Cancel");
		
		submit.setMaxWidth(Double.MAX_VALUE);
		cancel.setMaxWidth(Double.MAX_VALUE);
		
		submit.setOnAction(action ->{
			weapon = (String)items.getSelectionModel().getSelectedItem();
		});
		cancel.setOnAction(action -> window.close());
		
		layout.setCenter(items);
		layout.setTop(display);
		BorderPane.setAlignment(display,Pos.CENTER);
		bottomlayout.setLeft(submit);
		bottomlayout.setRight(cancel);
		layout.setBottom(bottomlayout);
		
		Scene scene = new Scene(layout, 200, 300);
		window.setScene(scene);
		window.show();
	}
}
