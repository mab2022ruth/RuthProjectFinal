package application;
abstract public class BankAccount {
	double balance;
	public static String customerName;
	public static String customerId;
	
	BankAccount(String name, String id)
	 {
		 customerName = name; 
		 customerId = id;
	 }
	
	public abstract void deposit(double amount);
	
	
	public abstract void withdraw(double amount);
	
	
	
	

}

