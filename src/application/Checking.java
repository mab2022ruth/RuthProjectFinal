package application;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Checking extends BankAccount
	{
	private double checkingAmount = 0f;

		
		
		
		Checking(String Name, String id) {
		super(Name, id);
		customerName = Name;
		customerId = id;
		
	}
		
		void setCheckingAmount ()
		{
			checkingAmount = balance;
		}
		double getCheckingAmount()
		{
			return checkingAmount;
		}

		@Override
		public void deposit(int amount) {
			// TODO Auto-generated method stub
			
				if (amount != 0)
				{
					balance = balance + amount;
					previousTransaction = amount;
				}
			
			
		}

		public void withdraw(int amount)
		{
			if (amount != 0)
			{
				balance = balance - amount;
				previousTransaction = -amount;
			}
		}
		
		
		
		/*
	/Checking(String Name, String id)
		 {
			 customerName = Name;
			 customerId = id;
		 }
		*/
	/*	void deposit(int amount)
		{
			if (amount != 0)
			{
				balance = balance + amount;
				previousTransaction = amount;
			}
		}
		
		void withdraw(int amount)
		{
			if (amount != 0)
			{
				balance = balance - amount;
				previousTransaction = -amount;
			}
		}
		
		
		
		void getPreviousTransaction()
		{
			if(previousTransaction > 0)
			{
				
				System.out.println("Deposited: " + previousTransaction);

			}
			else if(previousTransaction <0)
			{
				System.out.println("Withdrawn"  + Math.abs(previousTransaction));
			}
			else
			{
				System.out.println("No transaction occured");

			}
			
		}
		
		
		void showMenue()
		{
			char option = '\0';
			Scanner input = new Scanner(System.in);
			
			
			System.out.println("Welcome "+ customerName);
			System.out.println("Your ID is "+ customerId);
			System.out.println("\n");
			System.out.println("A. Check Balance");
			System.out.println("B. Deposit");
			System.out.println("C. Withdraw");
			System.out.println("D. Previous transaction");
			System.out.println("E. Exit");

			
			
			
			do
			{
				System.out.println("=========================================================");
				System.out.println("Enter an option");
				System.out.println("=========================================================");
				System.out.println("=========================================================");
				option = input.next().charAt(0);
				System.out.println("\n");
				
				
				switch(option)
				{
				case 'A':
					System.out.println("---------------------------------------------------");
					System.out.println("Balance = " + balance);
					System.out.println("---------------------------------------------------");
					System.out.println("\n");
					break;
					
					
				case 'B':
					System.out.println("---------------------------------------------------");
					System.out.println("Enter an amount to deposit:");
					System.out.println("---------------------------------------------------");
					int amount = input.nextInt();
					deposit(amount);
					System.out.println("\n");
					break;
					
					
				case 'C':
					System.out.println("---------------------------------------------------");
					System.out.println("Enter an amount to Withdraw");
					System.out.println("---------------------------------------------------");
					int amountWithdraw = input.nextInt();
					withdraw(amountWithdraw);
					System.out.println("\n");
					break;
				case 'D':
					System.out.println("---------------------------------------------------");
					getPreviousTransaction();
					System.out.println("---------------------------------------------------");
					System.out.println("\n");
					break;
				case 'E':
					System.out.println("****************************************************");
					
					break;
					
					
					default:
						System.out.println("Invalid Option!!. Please enter again");
						break;

				}
				
				
				
			}
			while(option != 'E');
			System.out.println("Thank you for using the ATM");
			}
*/
			
			
		
	}
	

	

 
