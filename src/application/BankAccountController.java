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
	
	//double checkingAmountLoaded = 0;
	double moneyToCompute[] = {0,0,0};  // have to
	//put it back to zero after entering the values
	int choiceEntered=0;

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
    	choiceEntered = choiceBoxDepositWithdraw.getValue();
    	
    	
    	Checking customerIn = new Checking(nameEntered, accountEntered);
    	
    	System.out.println("This is the customer's name: " +customerIn.customerName );
    	System.out.println("This is the customer's id: "+ customerIn.customerId );
    	System.out.println("This is the customer's choice value: "+ choiceEntered);



    }
    
    void loadtheAmountEntered(Scene mainScene, ArrayList<TextField> checkingTextfield)
    {
    	
    	for(int i = 0; i <3; i ++)
    	{
    		moneyToCompute[i] = Double.parseDouble(checkingTextfield.get(i).getText());

    		//checkingTextfield.get(i).getText();
    	}
    		
    	//checkingAmountLoaded = Double.parseDouble(checkingTextfield.getText());
    	
    	//System.out.println("This is the customer's amount entered for the checking account "+ checkingAmountLoaded);

    	for(int i = 0; i <3; i ++)
    	{
        	System.out.println("This is the customer's amount entered for the checking account "+ moneyToCompute[i]);

    	}
    	//System.out.println("This is the customer's amount entered for the checking account "+ moneyToCompute[i]);

    	applicationStage.setScene(mainScene);
    	
    }

    @FXML
    void getTheAmountEntered (ActionEvent AmountEnteredEvent) 
    {
    	String[] output = {"cheking", "saving","investment"};
    	Scene mainScene = applicationStage.getScene();
    	//System.out.println("The button was pressed");
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
