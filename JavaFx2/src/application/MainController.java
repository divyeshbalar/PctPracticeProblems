package application;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
	@FXML
	private Label myText; 
	public void generateRand(ActionEvent event) {
		Random rand = new Random();
		int numrand = rand.nextInt(500)+1;
		myText.setText(Integer.toString(numrand));
		System.out.println(Integer.toString(numrand));
	}
}
