package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class BankAccountController {
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

}
