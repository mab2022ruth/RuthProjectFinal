package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BankAccountController {
	
	double checkingAmountLoaded = 0;
	Stage applicationStage;
	 @FXML
	 private ChoiceBox<Integer> choiceBoxDepositWithdraw;

    @FXML
    private TextField nameOfCustomer;

    @FXML
    private TextField accountNumber;
    
    @FXML
    void computeResult(ActionEvent event) {

    	//System.out.println("Just trying ");
    	String nameEntered = nameOfCustomer.getText();
    	String accountEntered = accountNumber.getText();
    	//System.out.println(nameEntered );
    	//System.out.println(accountEntered);
    	int choiceEntered = choiceBoxDepositWithdraw.getValue();
    	
    	
    	Checking customerIn = new Checking(nameEntered, accountEntered);
    	
    	System.out.println("This is the customer's name: " +customerIn.customerName );
    	System.out.println("This is the customer's id: "+ customerIn.customerId );
    	System.out.println("This is the customer's choice value: "+ choiceEntered);



    }
    
    void loadtheAmountEntered(Scene mainScene, TextField checkingTextfield)
    {
    	checkingAmountLoaded = Double.parseDouble(checkingTextfield.getText());
    	
    	
    	
    	applicationStage.setScene(mainScene);
    	
    }

    @FXML
    void getTheAmountEntered (ActionEvent AmountEnteredEvent) 
    {
    	Scene mainScene = applicationStage.getScene();
    	//System.out.println("The button was pressed");
    	HBox checkingRow = new HBox();
    	Label checkingLabel = new Label("Enter the amount for the checking account");
    	TextField checkingTextfield = new TextField();
    	Button doneButton = new Button("Done");
    	
    	checkingRow.getChildren().addAll(checkingLabel,checkingTextfield,doneButton);
    	doneButton.setOnAction(doneEvent-> loadtheAmountEntered(mainScene,checkingTextfield));

    	
    	Scene valueEntered = new Scene(checkingRow);
    	applicationStage.setScene(valueEntered);

    }
}
