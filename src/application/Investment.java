package application;

public class Investment extends BankAccount {
	
	private double investmentAmount = 0;

	Investment(String name, String id) {
		super(name, id);
		customerName = name;
		customerId = id;
		
	}
	
	void setInvestment ()
	{
		investmentAmount = balance;
	}
	double getInvestment()
	{
		return investmentAmount;
	}

	@Override
	public void deposit(double amount) {
		if (amount != 0)
		{
			balance = balance + amount;
		}
	}

	@Override
	public void withdraw(double amount) {
		if (amount != 0)
		{
			balance = balance - amount;
		}
		
	}

}
