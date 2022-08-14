/******
 * 
 * This Project works fine so far.
 * It asks the user to input the name and the id
 * the user needs to select a choice which is depositing of 
 * withdrawing the money from the customers' account
 * 
 * ATTENTION: ONLY THE DEPOSIT WORKS
 *				THE WITHDRAWING  METHOD IN THE CONTROLLER DOES NOT WORK
 *				THE ONE IN THE CLASS WOORKS PROPERLY BECAUSE I HAVE TESTED THE CLASS 
 *				SEPARATLY
 *ASSUMPTION: THE WITHDRAW IN THE CONTROLER IS PROBABLY NOT WORKING BECAUSE 
 *				OUNCE WE HIT THE COMPUTE BUTTON IN THE USER INTERFACE THE 
 *				PROGRAM REFRESHES WHICH MAKES THE BALANCE BACK TO ZERO
 *
 *TO ADD TO THE PROGRAM :
 *			-Validating the user input
 *			-A Tranfer fund method which transfers the money between the accounts
 *			-display the accounts balances ounce the customer is done depositing
 *			withdrawing and transfering.
 *			Basically, once the customer exits the process
 *
 *NOTE: AREEB, PLEASE DOUBLE CHECK ENHERITANCE TO SEE IF IT IS DONE RIGHT
 *
 *
 *NEEEEEEEEEEXXXXXT SSSSSTEEEEEEEPPP: PLEASE DO THE WITHDRAW METHOD FIRST
 * ****/

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
	String[] output = {"cheking", "saving","investment"};
	//to output in the label when changing the scene
	Stage applicationStage;
	 @FXML
	 
	 private ChoiceBox<Integer> choiceBoxDepositWithdraw;

    @FXML
    private TextField nameOfCustomer;

    @FXML
    private TextField accountNumber;
    
   
    void withdrawing(BankAccount customer)
    {
    	if(customer.checkingAccount.getCheckingAmount() <moneyToCompute[0] )
		{
	    	System.out.println("the amount entered is higher then the balance in the checking account" + 
		customer.checkingAccount.getCheckingAmount());
		}
		else
		{
    		customer.checkingAccount.withdraw(moneyToCompute[0]);
		}
		
		
		if(customer.savingsAccount.getSaving() <moneyToCompute[1] )
		{
	    	System.out.println("the amount entered is higher then the balance in the Savings account" + 
		customer.checkingAccount.getCheckingAmount());

		}
		else
		{
			customer.savingsAccount.withdraw(moneyToCompute[1]);
		}
		
		
		if(customer.InvestAccount.getInvestment() <moneyToCompute[2] )
		{
	    	System.out.println("the amount entered is higher then the balance in the Invesment account" + 
	    			customer.InvestAccount.getInvestment());

		}
		else
		{
			customer.savingsAccount.withdraw(moneyToCompute[0]);
		}
    }
    @FXML
    // entering the name and the id of the customer
   	//System.out.println("Just trying ");
       
    void computeResult(ActionEvent event) {

    	nameEntered = nameOfCustomer.getText();
    	accountEntered = accountNumber.getText();
    	choiceEntered = choiceBoxDepositWithdraw.getValue();
    	
    	// trying to save it in the class
    	BankAccount customer = new BankAccount(nameEntered, accountEntered);
    	customer.savingsAccount = new Savings(nameEntered, accountEntered);
    	customer.checkingAccount= new Checking(nameEntered, accountEntered);
    	customer.InvestAccount= new Investment(nameEntered, accountEntered);
    	
    	// if the choice entered is 1 we need to deposit the money
    	
    	if (choiceEntered == 1)
    	{
    		customer.checkingAccount.deposit(moneyToCompute[0]);
    		customer.checkingAccount.setCheckingAmount();
    		customer.savingsAccount.deposit(moneyToCompute[1]);
    		customer.savingsAccount.setSavings();
    		customer.InvestAccount.deposit(moneyToCompute[2]);
    		customer.InvestAccount.setInvestment();
    	}
    	else
    	{
    		withdrawing( customer);
    	}
    	System.out.println("CHECKING AMOUNT ENTERED:  "+customer.checkingAccount.getCheckingAmount());
    	System.out.println("SAVING AMOUNT ENTERED:  "+customer.savingsAccount.getSaving());
    	System.out.println("INVESTMENT AMOUNT ENTERED:  "+customer.InvestAccount.getInvestment());
    
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
