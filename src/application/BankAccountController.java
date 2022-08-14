package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BankAccountController {
	
	double moneyToCompute[] = {0,0,0};  // have to
	//put it back to zero after entering the values
	int choiceEntered=0; // stores the choice entered by the choice box.
	// choice one is deposit, and choice 2 is withdraw
	String nameEntered = ""; //will store the name entered by the user
	String accountEntered = ""; // will store the account number 
	//entered by the user as a string

	Stage applicationStage;
	 @FXML
	 
	 private ChoiceBox<Integer> choiceBoxDepositWithdraw;

    @FXML
    private TextField nameOfCustomer;

    @FXML
    private TextField accountNumber;
    
    @FXML
 // entering the name and the id of the customer
	//System.out.println("Just trying ");
    void computeResult(ActionEvent event) {

    	nameEntered = nameOfCustomer.getText();
    	accountEntered = accountNumber.getText();
    	choiceEntered = choiceBoxDepositWithdraw.getValue();
    	
    	// trying to save it in the class
    	Checking customerIn = new Checking(nameEntered, accountEntered);
    
    }
    

    // this function stores the money entered by the user in a array of double
    	//which is declared globally and goes back to the main scene
    //it works, u can system.out to test
    
    void loadtheAmountEntered(Scene mainScene, ArrayList<TextField> checkingTextfield)
    {
    	for(int i = 0; i <3; i ++)
    	{
    		moneyToCompute[i] = Double.parseDouble(checkingTextfield.get(i).getText());

    	}
    	applicationStage.setScene(mainScene);
    }

    
    
    @FXML
    
    // this function created the user interface for changing the scene
    void getTheAmountEntered (ActionEvent AmountEnteredEvent) 
    {
    	String[] output = {"cheking", "saving","investment"};
    	Scene mainScene = applicationStage.getScene();
    	int threeValuesToEnter = 3;
    	VBox allRows = new VBox();
    	ArrayList<TextField> moneyTextFields = new ArrayList<TextField>();
    	for(int i = 0; i <threeValuesToEnter; i++)
    	{
    		HBox checkingRow = new HBox();
    		
        	Label checkingLabel = new Label("Enter the amount for the " + output[i] + " account");
        	TextField checkingTextfield = new TextField();
        	
        	moneyTextFields.add(checkingTextfield);
        	checkingRow.getChildren().addAll(checkingLabel,checkingTextfield);

        	allRows.getChildren().add(checkingRow);
    	}
    	Button doneButton = new Button("Done");
        doneButton.setOnAction(doneEvent-> loadtheAmountEntered(mainScene,moneyTextFields));
        allRows.getChildren().add(doneButton);
    	
    	
    	Scene valueEntered = new Scene(allRows);
    	applicationStage.setScene(valueEntered);

    }
}
