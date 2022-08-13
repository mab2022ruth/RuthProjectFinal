package application;

public class Savings extends BankAccount{

	Savings(String Name, String id) {
		super(Name, id);
		customerName = Name;
		customerId = id;
	}

	private double savingsAmount = balance;

	/*void deposit(int amount)
	{
		if (amount != 0)
		{
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	*/
	void setSavings ()
	{
		savingsAmount = balance;
	}
	double getSaving()
	{
		return savingsAmount;
	}
	@Override
	public void deposit(int amount) {
		if (amount != 0)
		{
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	@Override
	public void withdraw(int amount) {
		if (amount != 0)
		{
			balance = balance - amount;
			previousTransaction = -amount;
		}
		
	}

}