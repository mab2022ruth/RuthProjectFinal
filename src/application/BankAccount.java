package application;
//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
abstract public class BankAccount {
	int balance;
	int previousTransaction;
	public static String customerName;
	public static String customerId;
	
	BankAccount(String name, String id)
	 {
		 customerName = name;
		 customerId = id;
	 }
	
	public abstract void deposit(int amount);
	
	
	public abstract void withdraw(int amount);
	
	
	
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
	
	

}

