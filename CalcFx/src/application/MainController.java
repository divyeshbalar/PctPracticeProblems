package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
	@FXML
	private Label result;
	private long num1 = 0;	
	private long num2 = 0;
	private String op = "";
	private boolean start = true;
	private Model model = new Model();
	@FXML
	public void processNumbers(ActionEvent event) {
		if(start) {
			result.setText("");
			start = false;
		}
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText()+value);
		
	}
	@FXML
	public void processClear(ActionEvent event) {
		result.setText("");
		op = "";
		start = true;
		num1 = 0;
		num2 = 0;
	}
	@FXML
	public void processOperators(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		
		if(!value.equals("=")) {
			if(!op.isEmpty())
				return;
			op = value;
			num1 = Long.parseLong(result.getText());
			System.out.println(num1+ " num1");
			System.out.println(op+ " operatoe");
			result.setText("");
			}
		else {
			if(op.isEmpty())
				return;
			num2 = Long.parseLong(result.getText());
			System.out.println(num2+ " num2");
			float outcome = model.calculate(num1, num2, op);
			result.setText(String.valueOf(outcome));
			op = "";
			start = true;
		}
	}
	

}
