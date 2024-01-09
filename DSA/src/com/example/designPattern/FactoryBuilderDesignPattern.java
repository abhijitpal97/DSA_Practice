package com.example.designPattern;
class Account
{
	final int id;
	final String name;
	final int amount;
	final String type;

	public String toString()
	{
		return "Account [ "+id+" , "+name+" , "+amount+" , "+type+" ]";
	}

	Account(AccountBuilder accountBuilder)
	{
		this.id=accountBuilder.id;
		this.name=accountBuilder.name;
		this.amount=accountBuilder.amount;
		this.type=accountBuilder.type;
	}

	static class AccountBuilder
	{
		int id;
		String name;
		int amount;
		String type;

		private AccountBuilder() {}

		public AccountBuilder setId(int id) {
			this.id = id;
			return this;
		}

		public AccountBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public AccountBuilder setAmount(int amount) {
			this.amount = amount;
			return this;
		}

		public AccountBuilder setType(String type) {
			this.type = type;
			return this;
		}

		public Account build() { return new Account(this);}

		public static AccountBuilder newInstance() {
			// TODO Auto-generated method stub
			return new AccountBuilder();
		}


	}
}



interface BankAccount
{
	boolean openAccount(Account account);
}

class PersonalAccount implements BankAccount
{
	public boolean openAccount(Account account)
	{
		System.out.println("This is a personal Account " + account);
		return true;
	}
}

class SalaryAccount implements BankAccount
{
	public boolean openAccount(Account account)
	{
		System.out.println("This is a Salary Account "+account);
		return true;
	}
}

class CreditCardAccount implements BankAccount
{
	public boolean openAccount(Account account)
	{
		System.out.println("This is a Credit Card Account "+account);
		return true;
	}
}

class Factory
{
	public BankAccount getAccountType(String accountType)
	{
		if(accountType.equals("Personal")) return new PersonalAccount();
		else if(accountType.equals("Salary")) return new SalaryAccount();
		else if(accountType.equals("Credit")) return new CreditCardAccount();
		return null;
	}
}


public class FactoryBuilderDesignPattern
{
	public static void main(String[] args)
	{
		Factory factory = new Factory();

		Account personal = Account.AccountBuilder.newInstance()
				.setId(1)
				.setName("Abhijit")
				.setAmount(1000)
				.setType("P")
				.build();

		Account salary = Account.AccountBuilder.newInstance()
				.setId(2)
				.setName("Ashok")
				.setType("S")
				.build();

		Account credit = Account.AccountBuilder.newInstance()
				.setId(3)
				.setName("Ajit")
				.setType("C")
				.build();

		BankAccount personalAccount = factory.getAccountType("Personal");
		personalAccount.openAccount(personal);


		BankAccount salaryAccount = factory.getAccountType("Salary");
		salaryAccount.openAccount(salary);

		BankAccount creditAccount = factory.getAccountType("Credit");
		creditAccount.openAccount(credit);
	}
}